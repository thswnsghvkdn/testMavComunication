/*
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CancellationToken;
import java.util.function.Consumer;
import java.util.function.Function;

public class FileTransfer {

    private MAVLinkIntegrator mavint;
    private byte _sysid;
    private byte _compid;
    private int seq_no = 0;
    private final byte rwSize = 0;

    public FileTransfer(MAVLinkIntegrator mavint, byte sysid, byte compid) {
        this.mavint = mavint;
        this._sysid = sysid;
        this._compid = compid;
    }

    public ByteArrayOutputStream kCmdBurstReadFile(String file, int size, CancellationToken cancel) throws IOException {
        RetryTimeout timeout = new RetryTimeout();
        FTPProtocol fileTransferProtocol = new FTPProtocol();
        fileTransferProtocol.target_system = _sysid;
        fileTransferProtocol.target_component = _compid;
        fileTransferProtocol.target_network = 0;
        FTPPayloadHeader payload = new FTPPayloadHeader();
        payload.opcode = FTPOpcode.kCmdBurstReadFile;
        payload.seq_number = seq_no++;
        payload.session = 0;
        payload.offset = 0;
        payload.size = rwSize;
        fileTransferProtocol.payload = payload;
        System.out.println("get " + payload.opcode + " " + file + " " + size);
        SortedMap<Integer, Integer> chunkSortedList = new TreeMap<>();
        ByteArrayOutputStream answer = new ByteArrayOutputStream(size);
        Consumer<String> progressCallback = (f) -> {};
        Exception ex = null;

        Runnable workToDo = () -> {
            if (cancel != null && cancel.isCancellationRequested()) {
                timeout.setRetriesCurrent(999);
                System.out.println("cancel " + payload.opcode);
                return;
            }
            try {
                mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
            } catch (IOException e) {
                // Handle IO exception
            }
        };

        Function<MAVLinkMessage, Boolean> subscriber = message -> {
            if (cancel != null && cancel.isCancellationRequested()) {
                timeout.setRetriesCurrent(999);
                System.out.println("cancel " + payload.opcode);
                return true;
            }

            mavlink_file_transfer_protocol_t msg = (mavlink_file_transfer_protocol_t) message.getData();
            FTPPayloadHeader ftphead = msg.payload;

            if (ftphead.opcode == FTPOpcode.kRspNak) {
                seq_no = (short) (ftphead.seq_number + 1);
                FTPErrorCode errorcode = FTPErrorCode.values()[ftphead.data[0]];
                if (errorcode == FTPErrorCode.kErrFailErrno) {
                    errno ftpErrno = errno.values()[ftphead.data[1]];
                    System.err.println(ftphead.req_opcode + " " + errorcode + " " + ftpErrno);
                    timeout.setRetries(0);
                    ex = new Exception("Mavftp responded - " + ftphead.req_opcode + " " + errorcode + " " + ftpErrno);
                } else {
                    System.err.println(ftphead.req_opcode + " " + errorcode);
                }

                if (errorcode == FTPErrorCode.kErrEOF) {
                    if (chunkSortedList.values().stream().mapToInt(Integer::intValue).sum() >= size) {
                        timeout.setComplete(true);
                    } else {
                        int missing = findMissing(chunkSortedList);
                        if (missing == Integer.MAX_VALUE) {
                            timeout.setComplete(true);
                            return true;
                        }
                        System.out.println("Missing Part " + missing);
                        // switch to part read
                        payload.opcode = FTPOpcode.kCmdReadFile;
                        payload.offset = missing;
                        seq_no = (short) (ftphead.seq_number + 1);
                        payload.seq_number = seq_no;
                        fileTransferProtocol.payload = payload;
                        timeout.setRetriesCurrent(0);

                        try {
                            mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
                        } catch (IOException e) {
                            // Handle IO exception
                        }
                    }
                }
                return true;
            }

            if (payload.opcode != ftphead.req_opcode) {
                return true;
            }
            if (ftphead.opcode != FTPOpcode.kRspAck) {
                return true;
            }
            if (ftphead.offset > size || ftphead.size > size || ftphead.offset + ftphead.size > size
                    || answer.size() == 0 && ftphead.offset > 0 && size < rwSize) {
                return true;
            }
            if (ftphead.size < rwSize) {
                size = (int) (ftphead.offset + ftphead.size);
            }
            if (answer.size() != ftphead.offset) {
                // we have lost data
            }

            timeout.setRetriesCurrent(0);
            timeout.resetTimeout();

            chunkSortedList.put(ftphead.offset, ftphead.offset + ftphead.size);

            int currentsize = chunkSortedList.values().stream().mapToInt(Integer::intValue).sum();

            System.out.println("got data " + file + " at " + ftphead.offset + " got " + currentsize + " of " + size);

            try {
                answer.write(ftphead.data, 0, ftphead.size);
            } catch (IOException e) {
                // Handle IO exception
            }
            timeout.resetTimeout();
            seq_no = (short) (ftphead.seq_number + 1);
            // if rerequest needed
            payload.offset = (short) (ftphead.offset + ftphead.size);
            payload.seq_number = seq_no;
            fileTransferProtocol.payload = payload;
            // ignore the burst read first response
            if (ftphead.size > 0) {
                progressCallback.accept(file, (int) ((float) currentsize / size * 100.0));
            }
            if (currentsize >= size) {
                System.out.println("Done " + ftphead.burst_complete + " " + (ftphead.offset + ftphead.size));
                timeout.setComplete(true);
                return true;
            }
            // we see the end, but didnt exit above on valid size, get missing parts || we are in single read mode
            if (ftphead.offset + ftphead.size >= size || payload.opcode == FTPOpcode.kCmdReadFile) {
                int missing = findMissing(chunkSortedList);
                System.out.println("Missing Part " + missing);
                // switch to part read
                payload.opcode = FTPOpcode.kCmdReadFile;
                payload.offset = (short) missing;
                seq_no = (short) (ftphead.seq_number + 1);
                payload.seq_number = seq_no;
                fileTransferProtocol.payload = payload;
                timeout.setRetriesCurrent(0);

                try {
                    mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
                } catch (IOException e) {
                    // Handle IO exception
                }
                return true;
            }

            if (ftphead.burst_complete == 1) {
                System.out.println("next burst " + ftphead.burst_complete + " " + (ftphead.offset + ftphead.size));
                try {
                    mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
                } catch (IOException e) {
                    // Handle IO exception
                }
            }

            return true;
        };

        timeout.setWorkToDo(workToDo);
        timeout.doWork();
        progressCallback.accept(file, 100);
        _mavint.UnSubscribeToPacketType(sub);
        if (ex != null) {
            throw new IOException(ex);
        }
        return answer;
    }

    private int findMissing(SortedMap<Integer, Integer> chunkSortedList) {
        int missing = Integer.MAX_VALUE;
        for (int key : chunkSortedList.keySet()) {
            int value = chunkSortedList.get(key);
            if (missing == key) {
                missing = value;
            } else {
                break;
            }
        }
        return missing;
    }

    private enum FTPOpcode {
        kCmdBurstReadFile, kRspAck, kRspNak, kCmdReadFile
    }

    private enum FTPErrorCode {
        kErrFailErrno, kErrEOF
    }

    private enum errno {
        // define errno values
    }

    private class RetryTimeout {
        private int retries = 0;
        private int retriesCurrent = 0;
        private boolean complete = false;
        private Runnable workToDo;

        public int getRetries() {
            return retries;
        }

        public void setRetries(int retries) {
            this.retries = retries;
        }

        public int getRetriesCurrent() {
            return retriesCurrent;
        }

        public void setRetriesCurrent(int retriesCurrent) {
            this.retriesCurrent = retriesCurrent;
        }

        public boolean isComplete() {
            return complete;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public Runnable getWorkToDo() {
            return workToDo;
        }

        public void setWorkToDo(Runnable workToDo) {
            this.workToDo = workToDo;
        }

        public void resetTimeout() {
            // reset timeout logic
        }

        public void doWork() {
            while (!complete && retriesCurrent < retries) {
                workToDo.run();
                retriesCurrent++;
            }
        }
    }

    private class FTPProtocol {
        private byte target_system;
        private byte target_component;
        private int target_network;
        private FTPPayloadHeader payload;

        // constructor, getters, and setters
    }

    private class FTPPayloadHeader {
        private FTPOpcode opcode;
        private short seq_number;
        private short session;
        private short offset;
        private byte size;

        // constructor, getters, and setters
    }

    private class MAVLinkMessage {
        // define MAVLinkMessage attributes and methods
    }

    private class mavlink_file_transfer_protocol_t {
        private FTPPayloadHeader payload;

        // constructor, getters, and setters
    }
}*/
