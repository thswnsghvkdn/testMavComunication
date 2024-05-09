/*
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class MavlinkFTP {

    public ByteArrayOutputStream kCmdBurstReadFile(String file, int size, CancellationTokenSource cancel, byte readsize) throws IOException {
        RetryTimeout timeout = new RetryTimeout();
        fileTransferProtocol.target_system = _sysid;
        fileTransferProtocol.target_component = _compid;
        fileTransferProtocol.target_network = 0;
        FTPPayloadHeader payload = new FTPPayloadHeader();
        payload.opcode = FTPOpcode.kCmdBurstReadFile;
        payload.seq_number = (short) (seq_no++);
        payload.session = 0;
        payload.offset = 0;
        payload.size = readsize;
        fileTransferProtocol.payload = payload;
        log.Info("get " + payload.opcode + " " + file + " " + size);
        if (Progress != null) Progress.invoke(file, 0);
        Exception ex = null;
        SortedMap<Integer, Integer> chunkSortedList = new TreeMap<>();
        ByteArrayOutputStream answer = new ByteArrayOutputStream(size);
        PacketSubscription sub = _mavint.SubscribeToPacketType(MAVLink.MAVLINK_MSG_ID.FILE_TRANSFER_PROTOCOL, message -> {
            if (cancel != null && cancel.IsCancellationRequested()) {
                timeout.RetriesCurrent = 999;
                log.Info("cancel " + payload.opcode);
                return true;
            }

            MAVLink.mavlink_file_transfer_protocol_t msg = (MAVLink.mavlink_file_transfer_protocol_t) message.data;
            FTPPayloadHeader ftphead = msg.payload;


            if (ftphead.size < readsize)
                size = (int) (ftphead.offset + ftphead.size);


            timeout.RetriesCurrent = 0;
            timeout.ResetTimeout();

            chunkSortedList.put(ftphead.offset, ftphead.offset + ftphead.size);

            int currentsize = chunkSortedList.values().stream().mapToInt(Integer::intValue).sum();


            answer.reset();
            answer.write(ftphead.data, 0, ftphead.size);
            timeout.ResetTimeout();

            seq_no = (short) (ftphead.seq_number + 1);
            payload.offset = (short) (ftphead.offset + ftphead.size);
            payload.seq_number = seq_no;
            fileTransferProtocol.payload = payload;

            if (ftphead.size > 0 && Progress != null)
                Progress.invoke(file, (int) ((float) currentsize / size * 100.0));

            if (currentsize >= size) {
                timeout.Complete = true;
                return true;
            }

            if (ftphead.offset + ftphead.size >= size || payload.opcode == FTPOpcode.kCmdReadFile) {
                int missing = FindMissing(chunkSortedList);
                log.InfoFormat("Missing Part {0}", missing);
                payload.opcode = FTPOpcode.kCmdReadFile;
                payload.offset = missing;
                seq_no = (short) (ftphead.seq_number + 1);
                payload.seq_number = seq_no;
                fileTransferProtocol.payload = payload;
                timeout.RetriesCurrent = 0;

                _mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
                return true;
            }

            if (ftphead.burst_complete == 1) {
                log.InfoFormat("next burst {0} {1} ", ftphead.burst_complete, ftphead.offset + ftphead.size);
                _mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
            }

            return true;
        }, _sysid, _compid);

        timeout.WorkToDo = () -> {
            if (cancel != null && cancel.IsCancellationRequested()) {
                timeout.RetriesCurrent = 999;
                log.Info("cancel " + payload.opcode);
                return;
            }
            _mavint.sendPacket(fileTransferProtocol, _sysid, _compid);
        };

        timeout.DoWork();
        if (Progress != null) Progress.invoke(file, 100);
        _mavint.UnSubscribeToPacketType(sub);
        answer.reset();
        if (ex != null) throw ex;
        return answer;
    }
}
*/
