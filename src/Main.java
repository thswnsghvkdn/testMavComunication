import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Parser;
import com.MAVLinkModule.MavlinkV1.enums.MAV_COMPONENT;
import com.MAVLinkModule.MavlinkV1.minimal.msg_heartbeat;

import com.fazecast.jSerialComm.SerialPort;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Arrays;

import com.MAVLinkModule.MavlinkV1.ardupilotmega.*;
import com.MAVLinkModule.MavlinkV1.common.*;

import static com.MAVLinkModule.MavlinkV1.common.msg_attitude.MAVLINK_MSG_ID_ATTITUDE;
import static com.MAVLinkModule.MavlinkV1.common.msg_attitude_quaternion.MAVLINK_MSG_ID_ATTITUDE_QUATERNION;
import static com.MAVLinkModule.MavlinkV1.common.msg_attitude_target.MAVLINK_MSG_ID_ATTITUDE_TARGET;
import static com.MAVLinkModule.MavlinkV1.common.msg_battery_status.MAVLINK_MSG_ID_BATTERY_STATUS;
import static com.MAVLinkModule.MavlinkV1.common.msg_estimator_status.MAVLINK_MSG_ID_ESTIMATOR_STATUS;
import static com.MAVLinkModule.MavlinkV1.common.msg_extended_sys_state.MAVLINK_MSG_ID_EXTENDED_SYS_STATE;
import static com.MAVLinkModule.MavlinkV1.common.msg_global_position_int.MAVLINK_MSG_ID_GLOBAL_POSITION_INT;
import static com.MAVLinkModule.MavlinkV1.common.msg_gps_raw_int.MAVLINK_MSG_ID_GPS_RAW_INT;
import static com.MAVLinkModule.MavlinkV1.common.msg_home_position.MAVLINK_MSG_ID_HOME_POSITION;
import static com.MAVLinkModule.MavlinkV1.common.msg_link_node_status.MAVLINK_MSG_ID_LINK_NODE_STATUS;
import static com.MAVLinkModule.MavlinkV1.common.msg_local_position_ned.MAVLINK_MSG_ID_LOCAL_POSITION_NED;
import static com.MAVLinkModule.MavlinkV1.common.msg_ping.MAVLINK_MSG_ID_PING;
import static com.MAVLinkModule.MavlinkV1.common.msg_position_target_local_ned.MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED;
import static com.MAVLinkModule.MavlinkV1.common.msg_scaled_pressure.MAVLINK_MSG_ID_SCALED_PRESSURE;
import static com.MAVLinkModule.MavlinkV1.common.msg_servo_output_raw.MAVLINK_MSG_ID_SERVO_OUTPUT_RAW;
import static com.MAVLinkModule.MavlinkV1.common.msg_sys_status.MAVLINK_MSG_ID_SYS_STATUS;
import static com.MAVLinkModule.MavlinkV1.common.msg_vfr_hud.MAVLINK_MSG_ID_VFR_HUD;
import static com.MAVLinkModule.MavlinkV1.common.msg_vibration.MAVLINK_MSG_ID_VIBRATION;
import static com.MAVLinkModule.MavlinkV1.enums.MAV_CMD.*;
import static com.MAVLinkModule.MavlinkV1.enums.MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1;
import static com.MAVLinkModule.MavlinkV1.enums.MAV_FRAME.MAV_FRAME_GLOBAL_RELATIVE_ALT;
import static com.MAVLinkModule.MavlinkV1.enums.MAV_FTP_OPCODE.*;
import static com.MAVLinkModule.MavlinkV1.minimal.msg_heartbeat.MAVLINK_MSG_ID_HEARTBEAT;


public class Main {
    msg_heartbeat mHeartbeat = null;
    static int chunkSize = 200;
    public static void main(String[] args) throws IOException {
        // parseParamFile("output.bin");
        // ParamUnpacker.unpack("output.bin");
        // connectViaSerial("040507.txt");
        connectViaUDP();
        // Parampck.unpackFromFile("040507.txt");
    }

    private static void setInterval() throws IOException {
        DatagramSocket socket;
        InetAddress address;


        socket = new DatagramSocket();
        address = InetAddress.getByName("172.25.38.247");


// PixhawkParameterController.ardupilotParamsMap["FS_THR_VALUE"]


        int[] commands = new int[] {
                MAVLINK_MSG_ID_LOCAL_POSITION_NED,
                MAVLINK_MSG_ID_ATTITUDE,
                MAVLINK_MSG_ID_ATTITUDE_QUATERNION,
                MAVLINK_MSG_ID_GLOBAL_POSITION_INT,
                MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED,
                MAVLINK_MSG_ID_SERVO_OUTPUT_RAW,
                MAVLINK_MSG_ID_ATTITUDE_TARGET,
                MAVLINK_MSG_ID_VFR_HUD,
                MAVLINK_MSG_ID_GPS_RAW_INT,
                MAVLINK_MSG_ID_HEARTBEAT,
                MAVLINK_MSG_ID_SYS_STATUS,
                MAVLINK_MSG_ID_EXTENDED_SYS_STATE,
                MAVLINK_MSG_ID_SCALED_PRESSURE,
                MAVLINK_MSG_ID_LINK_NODE_STATUS,
                MAVLINK_MSG_ID_HOME_POSITION,
                MAVLINK_MSG_ID_ESTIMATOR_STATUS,
                MAVLINK_MSG_ID_PING,
                MAVLINK_MSG_ID_VIBRATION,
                MAVLINK_MSG_ID_BATTERY_STATUS,



        };
        for(int cmd : commands) {
            byte[] buf = executeLongCommand((short) 1, (short) 1, MAV_CMD_SET_MESSAGE_INTERVAL, (short) 0, cmd, 1, 0, 0, 0, 0, 0);

            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length, address, 18570);
            socket.send(packet);

        }
    }
    private static void connect() throws IOException {
        MAVLinkPacket mavPkt = null;
        MAVLinkMessage mavMessage = null;
        Parser mavParser = new Parser();
        byte[] buffer = new byte[2500];
        Socket sp = new Socket("172.25.38.247", 5763);
        InputStream in = sp.getInputStream();
        while(true) {
            int len = in.read(buffer);
            if(len == -1 || len == 0) continue;
            byte[] copy = Arrays.copyOf(buffer,len);
            for (byte byteValue : copy) {
                mavPkt = mavParser.mavlink_parse_char(byteValue);
                if (mavPkt != null) {
                    mavMessage = mavPkt.unpack();
                    if (mavMessage != null ) {
                        System.out.println("mavMessage = " + mavMessage);
                    }
                }
            }
        }
    }


    private static void connectViaTCP() throws IOException {
        MAVLinkPacket mavPkt = null;
        MAVLinkMessage mavMessage = null;
        Parser mavParser = new Parser();
        byte[] buffer = new byte[2500];


        Socket sp = new Socket("172.25.38.247", 5760);

        InputStream in = sp.getInputStream();
        OutputStream out = sp.getOutputStream();


        short[] payload = new short[251];
        byte[] byteArray5  = packFtpPacket((short)0, (short) 0, (short) 0, 255,190,(short)0, (short) MAV_FTP_OPCODE_RESETSESSION,"", (short) 0);
        out.write(byteArray5);
        out.flush();

        payload = new short[251];
        byteArray5  = packFtpPacket((short)0, (short) 1, (short) 1, 255,190,(short)1, (short) MAV_FTP_OPCODE_OPENFILERO,"@PARAM/param.pck?withdefaults=1", (short) 0);
        out.write(byteArray5);
        out.flush();

        payload = new short[251];
        byteArray5  = packFtpPacket((short)0, (short) 1, (short) 1, 255,190,(short)2, (short) MAV_FTP_OPCODE_BURSTREADFILE,"",(short)10);
        out.write(byteArray5);
        out.flush();


        while(true) {

            int len = in.read(buffer);
            if(len == -1 || len == 0) continue;
            byte[] copy = Arrays.copyOf(buffer,len);

            for (byte byteValue : copy) {
                mavPkt = mavParser.mavlink_parse_char(byteValue);

                if (mavPkt != null) {
                    mavMessage = mavPkt.unpack();
                    if (mavMessage != null && mavMessage instanceof msg_file_transfer_protocol) {
                        // handleBurstReadByteResponse((msg_file_transfer_protocol) mavMessage);
                        byte[] array = new byte[((msg_file_transfer_protocol) mavMessage).payload.length];
                        for(int i =12 ; i <array.length;i++) {
                            array[i] = (byte) ( ((msg_file_transfer_protocol) mavMessage).payload[i] & 0xFF);
                        }
                        Param.unpack ( array );

                    }
                }
            }
    }
    }

    private static void getParamList(OutputStream out) throws IOException {
        short[] payload = new short[251];
        byte[] byteArray5  = packFtpPacket((short)0, (short) 0, (short) 0, 255,190,(short)0, (short) 2,"", (short)0);
        out.write(byteArray5);
        out.flush();

        payload = new short[251];
        byteArray5  = packFtpPacket((short)0, (short) 1, (short) 1, 255,190,(short)1, (short) 4,"@PARAM/param.pck?withdefaults=1",(short)0);
        out.write(byteArray5);
        out.flush();

        payload = new short[251];
        byteArray5  = packFtpPacket((short)0, (short) 1, (short) 1, 255,190,(short)2, (short) 15,"",(short)10);
        out.write(byteArray5);
        out.flush();
    }

    private static void connectViaSerial(String filepath) throws IOException {
        MAVLinkPacket mavPkt = null;
        MAVLinkMessage mavMessage = null;
        Parser mavParser = new Parser();
        SerialPort sp = SerialPort.getCommPorts()[0];
        sp.setComPortParameters(57600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        sp.openPort();
        OutputStream out = sp.getOutputStream();
        // doCalibrate(out);

 /*       byte[] byteArray5  = packFtpPacket((short)0, (short) 1, (short) MAV_COMPONENT.MAV_COMP_ID_ALL, 0,0,(short)0, (short) MAV_FTP_OPCODE_RESETSESSION,"",(short)0);
        out.write(byteArray5);
        out.flush();

        byteArray5  = packFtpPacket((short)0, (short) 1, (short) MAV_COMPONENT.MAV_COMP_ID_ALL, 0,0,(short)1, (short) MAV_FTP_OPCODE_OPENFILERO,"@PARAM/param.pck?withdefaults=1",(short)0);
        out.write(byteArray5);
        out.flush();

        byteArray5  = packFtpPacket((short)0, (short) 1, (short) MAV_COMPONENT.MAV_COMP_ID_ALL, 0,0,(short)2, (short) MAV_FTP_OPCODE_BURSTREADFILE,"",(short)chunkSize);
        out.write(byteArray5);
        out.flush();*/

        InputStream in = sp.getInputStream();
        byte[] buffer = new byte[128];

        boolean fileWriteStart = false, fileCheckNeeded = true;
        try (FileOutputStream fos = new FileOutputStream(filepath)) {

            while (true) {
                int len = in.read(buffer);
                if (len == -1 || len == 0) continue;
                byte[] copy = Arrays.copyOf(buffer, len);

                for (byte byteValue : copy) {
                    mavPkt = mavParser.mavlink_parse_char(byteValue);

                    if (mavPkt != null) {
                        mavMessage = mavPkt.unpack();
                        if (mavMessage != null) {
                            if (mavMessage instanceof msg_file_transfer_protocol) {
                                chunkSize = Math.min(chunkSize , 237);
                                byte[] array = new byte[chunkSize];
                                for(int i = 0 ; i <array.length;i++) {
                                    array[i] = (byte) ( ((msg_file_transfer_protocol) mavMessage).payload[i+12] );
                                }
                                if ( fileCheckNeeded && Parampck.checkMagic(array)) {
                                    fileWriteStart = true;
                                    fileCheckNeeded = false;
                                }
                                if(fileWriteStart) fos.write(array);
                            }
                            else System.out.println("mavMessage = " + mavMessage);
                        }
                    }

                }


            }
        }

    }

    private static void doCalibrate(OutputStream out) throws IOException {
        byte[] byteArray4 = executeLongCommand((short) 1, (short) 1, MAV_CMD_REQUEST_MESSAGE , (short) 0, 148, 0, 0, 0, 0, 0, 0);
        out.write(byteArray4);
        out.flush();

        byte[] byteArray5 = executeLongCommand((short) 1, (short) 1, MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES , (short) 0, 0, 0, 0, 0, 0, 0, 0);
        out.write(byteArray5);
        out.flush();
    }

    private static void connectViaUDPforPort() throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt("14550"));
        System.out.println("Server Started. Listening for Clients on port 18570" + "...");
        // Assume messages are not over 1024 bytes
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket;
        while (true) {
            // Server waiting for clients message
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            // Get the client's IP address and port
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            // Convert Byte Data to String
            String clientMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
            // Print the message with log header
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("[" + timestamp.toString() + " ,IP: " + IPAddress + " ,Port: " + port +"]  " + clientMessage);
        }
    }

    private static void connectViaUDP() throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(14550); // Listening port for UDP
        Parser mavParser = new Parser();
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket;

        boolean isFirst = false;

        while (true) {
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            System.out.println("seq# = " + receivePacket.getData()[4]);

            if(isFirst) {
                isFirst = false;
                getAllParameters(serverSocket, receivePacket.getAddress(),receivePacket.getPort());
            }
            MAVLinkPacket mavPacket = null;
            for (byte byteValue : receivePacket.getData()) {
                mavPacket = mavParser.mavlink_parse_char(byteValue);
                if (mavPacket != null) {
                    MAVLinkMessage mavMessage = mavPacket.unpack();
                    if (mavMessage != null) {
                        System.out.println("mavMessage = " + mavMessage);
                        if (mavMessage instanceof msg_mission_request_int) {
                        }
                    }
                }
            }
        }
    }
    private static byte[] packMissionCount() {
        msg_param_request_list msg = new msg_param_request_list();
        msg.target_component = 0;
        msg.target_system = 1;
        return msg.pack().encodePacket();
    }
    private static void getAllParameters(DatagramSocket socket, InetAddress addr, int port) throws IOException {
        byte[] byteArray = packMissionCount();
        socket.send(new DatagramPacket(byteArray, byteArray.length, addr, port));
    }


    private static void setMissionWithoutAck(DatagramSocket socket, InetAddress addr, int port) throws IOException {
        byte[] byteArray = null;
        byteArray = packMissionCount(4);
        socket.send(new DatagramPacket(byteArray, byteArray.length, addr, port));
        // need to receive MISSION_REQUEST_INT
        byteArray = packmMissionPacket(MAV_CMD_NAV_TAKEOFF, 473977500, 85456071, 50, (short) 1, (short) 0);
        socket.send(new DatagramPacket(byteArray, byteArray.length, addr, port));
        // need to receive MISSION_REQUEST_INT
        byteArray = packmMissionPacket(MAV_CMD_NAV_WAYPOINT, 473978770, 85458155, 50, (short) 0, (short) 1);
        socket.send(new DatagramPacket(byteArray, byteArray.length, addr, port));
        // need to receive MISSION_REQUEST_INT
        byteArray = packmMissionPacket(MAV_CMD_NAV_WAYPOINT, 473978762, 85456258, 50, (short) 0, (short) 2);
        socket.send(new DatagramPacket(byteArray, byteArray.length, addr, port));
        // need to receive MISSION_REQUEST_INT
        byteArray = packmMissionPacket(MAV_CMD_NAV_WAYPOINT, 473978762, 85466258, 0, (short) 0, (short) 3);
        socket.send(new DatagramPacket(byteArray, byteArray.length, addr, port));

    }
    private static void startMission(DatagramSocket socket, InetAddress addr, int port) throws IOException {
        byte[] byteArray  = packMissionCount(4);
        socket.send(new DatagramPacket(byteArray,byteArray.length,addr,port));
        byteArray = packmMissionPacket(MAV_CMD_NAV_TAKEOFF, 473977500, 85456071,50,(short) 1, (short) 0);
        socket.send(new DatagramPacket(byteArray,byteArray.length,addr,port));
        byteArray = packmMissionPacket(MAV_CMD_NAV_WAYPOINT, 473978770, 85458155,50,(short) 0,(short) 1);
        socket.send(new DatagramPacket(byteArray,byteArray.length,addr,port));
        byteArray = packmMissionPacket(MAV_CMD_NAV_WAYPOINT, 473978762, 85456258,50,(short) 0,(short) 2);
        socket.send(new DatagramPacket(byteArray,byteArray.length,addr,port));
        byteArray = packmMissionPacket(MAV_CMD_NAV_RETURN_TO_LAUNCH, 0, 0,0,(short) 0, (short) 3);
        socket.send(new DatagramPacket(byteArray,byteArray.length,addr,port));
    }
    private static byte[] packMissionCount(int count) {
        msg_mission_count msg = new msg_mission_count();
        msg.count = count;
        msg.target_component = 1;
        msg.target_system = 1;
        return msg.pack().encodePacket();
    }
    private static byte[] packmMissionPacket(int cmd, int x, int y, float z, short current, short seq) {
        msg_mission_item_int msg = new msg_mission_item_int();
        msg.target_system = 1;
        msg.target_component = 1;
        msg.sysid = 255;
        msg.compid = 1;
        msg.command = cmd;
        msg.frame = MAV_FRAME_GLOBAL_RELATIVE_ALT;
        msg.autocontinue = 1;
        msg.current = current;
        msg.seq = seq;
        msg.x = x;
        msg.y = y;
        msg.z = z;
        return msg.pack().encodePacket();
    }
    private static byte[] packFtpPacket(short target_network ,short target_system, short target_component,int sysid, int compid, short seq, short opcode, String data, short chunkSize) {
        short[] payload = new short[251];
        msg_file_transfer_protocol msg = new msg_file_transfer_protocol();
        msg.target_network = target_network;
        msg.target_system = target_system;
        msg.target_component = target_component;
        msg.isMavlink2 = false;
        msg.sysid = sysid;
        msg.compid = compid;
        payload[0] = seq;
        payload[3] = opcode;
        byte[] datas = data.getBytes();
        if(data.equals("@PARAM/param.pck?withdefaults=1")) {
            payload[4] = (short) datas.length;
        } else {
            payload[4] = chunkSize;
        }
        for (int i = 0; i < datas.length; i++) {
            payload[i + 12] = (short) (datas[i] & 0xFF);
        }
        msg.payload = payload;
        return msg.pack().encodePacket();
    }

    private static byte[] getGPSParameters(short target_system, short target_component) {
        msg_data_stream msg = new msg_data_stream();
        msg.sysid = target_system;
        msg.compid = target_component;
        msg.message_rate = 1;
        msg.on_off = 1;
        msg.stream_id = 6;
        return msg.pack().encodePacket();

    }

    private static byte[] geGPSParameters(short target_system, short target_component) {
        msg_gps_raw_int msg = new msg_gps_raw_int();
        msg.sysid = target_system;
        msg.compid = target_component;
        return msg.pack().encodePacket();

    }

    private static byte[] executeLongCommand(short target_system, short target_component,int command,short confirmation, float param1, float param2, float param3, float param4, float param5, float param6, float param7) {
        msg_command_long msg = new msg_command_long();
        msg.target_system = target_system;
        msg.target_component = target_component;
        msg.command = command;
        msg.confirmation = confirmation;
        msg.param1 = param1;
        msg.param2 = param2;
        msg.param3 = param3;
        msg.param4 = param4;
        msg.param5 = param5;
        msg.param6 = param6;
        msg.param7 = param7;
        return msg.pack().encodePacket();

    }
    private static byte[] executeIntCommand(short target_system, short target_component,int command, Float param1, Float param2, Float param3, Float param4, int lat, int lon, Float alt) {
        msg_command_int msg = new msg_command_int();
        msg.target_system = target_system;
        msg.target_component = target_component;
        msg.command = command;
        msg.param1 = param1;
        msg.param2 = param2;
        msg.param3 = param3;
        msg.param4 = param4;
        msg.x = lat;
        msg.y = lon;
        msg.z = alt;
        return msg.pack().encodePacket();

    }
    private void mavMessageTrans(MAVLinkMessage mavMessage) {
        if (mavMessage == null) return;
        String mavName = mavMessage.name();

        if (mavMessage instanceof msg_mcu_status) {
            System.out.println( "MavMessage(" + mavName + ")" + "" + mavMessage);
        } else if (mavMessage instanceof msg_component_metadata) {
            System.out.println("MavMessage(" + mavName + ")"+ "" + mavMessage);
        } else if (mavMessage instanceof msg_heartbeat) {
            System.out.println("MavMessage(" + mavName + ")" + "" + mavMessage);
            mHeartbeat = (msg_heartbeat) mavMessage;
        } else if (mavMessage instanceof msg_gps_raw_int) {

        }
    }

    private static void sendFTP() {
        byte[] datas = "@PARAM/param.pck?withdefaults=1".getBytes();

    }
    public void fillRequestDataWithString(Request request, String str) throws UnsupportedEncodingException {
        byte[] strBytes = str.getBytes("UTF-8");
        int length = Math.min(strBytes.length, request.data.length);
        System.arraycopy(strBytes, 0, request.data, 0, length);
        request.hdr.size = (byte) length;
    }

    // Define the Request class
    static class Request {
        byte[] data = new byte[256]; // Assuming the size of data array
        Header hdr; // Assuming the existence of the Header class
    }

    // Define the Header class
    static class Header {
        byte size; // Assuming the size field type
    }

    private static FileOutputStream fos;
    private static int byteLength = 0;
    // Method to handle the response packet after sending a BurstReadFile request

    public static void handleBurstReadByteResponse(msg_file_transfer_protocol response) {
        // Extract file data from the payload
        byte[] fileData = new byte[response.payload.length * 2]; // Each short occupies 2 bytes
        for (int i = 12; i < response.payload.length; i++) {
            fileData[i * 2] = (byte) ((response.payload[i] >> 8) & 0xFF); // High byte
            fileData[i * 2 + 1] = (byte) (response.payload[i] & 0xFF); // Low byte
        }

        // Append the file data to the file
        appendByteDataToFile(fileData);
    }


    public static void handleBurstReadFileResponse(msg_file_transfer_protocol response) {
        byteLength += response.payload[4];



        // Extract string data from the payload starting from index 12
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 12; i < response.payload.length; i++) {
                stringBuilder.append((char) response.payload[i]);
        }
        String fileData = stringBuilder.toString();

        // Append the file data to the file
        appendFileDataToFile(fileData);

        System.out.println("bytelength : " + byteLength);
        System.out.println("fileDataLength : " + checkFileSize());

    }

    private static int checkFileSize(){
        String filePath = "received_file.txt";
        // Read all bytes from the file into a byte array
        Path path = Paths.get(filePath);
        byte[] fileBytes;
        try {
            fileBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return 0; // Exit if an exception occurs
        }

        // Get the byte length of the file
        int byteLength = fileBytes.length;
        return byteLength;

    }
    // Method to append file data to a file
    public static void appendByteDataToFile(byte[] fileData) {
        try {
            if (fos == null) {
                // Create a new FileOutputStream if it doesn't exist
                fos = new FileOutputStream("received_file.txt");
            }
            // Append the file data to the file
            fos.write(fileData);
            System.out.println("File data appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending file data: " + e.getMessage());
        }
    }
    // Method to append file data to a file
    public static void appendFileDataToFile(String fileData) {
        try {
            if (fos == null) {
                // Create a new FileOutputStream if it doesn't exist
                fos = new FileOutputStream("received_file.txt");
            }
            // Append the string data to the file
            fos.write(fileData.getBytes());
            System.out.println("String data appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending string data to file: " + e.getMessage());
        }
    }

    // Method to close the FileOutputStream
    public void closeFileOutputStream() {
        try {
            if (fos != null) {
                // Close the FileOutputStream
                fos.close();
                System.out.println("FileOutputStream closed successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error closing FileOutputStream: " + e.getMessage());
        }
    }

    public static boolean parseParamFile(String filename) {
        final int magic_standard = 0x671B;
        final int magic_withdefaults = 0x671C;
        int no_of_parameters_found = 0;
        final int componentId = MAV_COMP_ID_AUTOPILOT1; /* Only main autopilot for the moment */

        enum ap_var_type {
            AP_PARAM_NONE,
            AP_PARAM_INT8,
            AP_PARAM_INT16,
            AP_PARAM_INT32,
            AP_PARAM_FLOAT,
            AP_PARAM_VECTOR3F,
            AP_PARAM_GROUP
        }

        System.out.println("_parseParamFile: " + filename);
        File file = new File(filename);
        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            int magic = readLittleEndianShort(in);
            int num_params = readLittleEndianShort(in);
            int total_params = readLittleEndianShort(in);

            if (magic != magic_standard && magic != magic_withdefaults) {
                System.out.println("_parseParamFile: Error: File does not start with Magic");
                return false;
            }
            if (num_params > total_params || num_params != total_params) {
                System.out.println("_parseParamFile: Error: Incorrect number of parameters");
                return false;
            }

            while (in.available() > 0) {
                int byteVal = 0;
                int flags = 0;
                int ptype = 0;
                int name_len = 0;
                int common_len = 0;
                boolean withdefault = false;

                while (byteVal == 0x0) { // Eat padding bytes
                    byteVal = in.readUnsignedByte();
                    if (in.available() == 0) {
                        return no_of_parameters_found == num_params;
                    }
                }
                ptype = byteVal & 0x0F;
                flags = (byteVal >> 4) & 0x0F;
                withdefault = (flags & 0x01) == 0x01;
                byteVal = in.readUnsignedByte();
                name_len = ((byteVal >> 4) & 0x0F) + 1;
                common_len = byteVal & 0x0F;

                if ((name_len + common_len) > 16) {
                    System.out.println("_parseParamFile: Error: common_len + name_len > 16");
                    return false;
                }

                byte[] nameBuffer = new byte[common_len + name_len];
                in.readFully(nameBuffer);
                String parameterName = new String(nameBuffer, common_len, name_len);
                no_of_parameters_found++;

                Object parameterValue = null;
                switch (ptype) {
                    case 1: // AP_PARAM_INT8
                        parameterValue = in.readByte();
                        if (withdefault) in.readByte();
                        break;
                    case 2: // AP_PARAM_INT16
                        parameterValue = in.readShort();
                        if (withdefault) in.readShort();
                        break;
                    case 3: // AP_PARAM_INT32
                        parameterValue = in.readInt();
                        if (withdefault) in.readInt();
                        break;
                    case 4: // AP_PARAM_FLOAT
                        parameterValue = in.readFloat();
                        if (withdefault) in.readInt();
                        break;
                    default:
                        System.out.println("_parseParamFile: Error: type is out of range " + ptype);
                        return false;
                }
                System.out.println("parameterValue: " + parameterValue);

                // Process the parameter...
            }
            // Successfully parsed all parameters
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private static int readLittleEndianShort(DataInputStream in) throws IOException {
        int lowByte = in.readUnsignedByte();
        int highByte = in.readUnsignedByte();
        return (highByte << 8) | lowByte;
    }
}