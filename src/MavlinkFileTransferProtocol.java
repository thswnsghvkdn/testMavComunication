/*
public class MavlinkFileTransferProtocol {
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL = 110;
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_LEN = 254;
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_CRC = 84;
    public static final int MAVLINK_MSG_FILE_TRANSFER_PROTOCOL_FIELD_PAYLOAD_LEN = 251;



    public static int mavlink_msg_file_transfer_protocol_pack(byte system_id, byte component_id, mavlink_message_t msg,
                                                              byte target_network, byte target_system, byte target_component, byte[] payload) {
        if (payload.length != MAVLINK_MSG_FILE_TRANSFER_PROTOCOL_FIELD_PAYLOAD_LEN)
            return -1;

        MavlinkFileTransferProtocol_t packet = new MavlinkFileTransferProtocol_t();
        packet.target_network = target_network;
        packet.target_system = target_system;
        packet.target_component = target_component;
        System.arraycopy(payload, 0, packet.payload, 0, MAVLINK_MSG_FILE_TRANSFER_PROTOCOL_FIELD_PAYLOAD_LEN);

        msg.msgid = MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL;
        return mavlink_finalize_message(msg, system_id, component_id, MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_LEN, MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_CRC);
    }

    public static int mavlink_msg_file_transfer_protocol_pack_chan(byte system_id, byte component_id, byte chan, mavlink_message_t msg,
                                                                   byte target_network, byte target_system, byte target_component, byte[] payload) {
        if (payload.length != MAVLINK_MSG_FILE_TRANSFER_PROTOCOL_FIELD_PAYLOAD_LEN)
            return -1;

        MavlinkFileTransferProtocol_t packet = new MavlinkFileTransferProtocol_t();
        packet.target_network = target_network;
        packet.target_system = target_system;
        packet.target_component = target_component;
        System.arraycopy(payload, 0, packet.payload, 0, MAVLINK_MSG_FILE_TRANSFER_PROTOCOL_FIELD_PAYLOAD_LEN);

        msg.msgid = MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL;
        return mavlink_finalize_message_chan(msg, system_id, component_id, chan, MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_LEN, MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_CRC);
    }

    public static int mavlink_msg_file_transfer_protocol_encode(byte system_id, byte component_id, mavlink_message_t msg, mavlink_file_transfer_protocol_t file_transfer_protocol) {
        return mavlink_msg_file_transfer_protocol_pack(system_id, component_id, msg, file_transfer_protocol.target_network, file_transfer_protocol.target_system, file_transfer_protocol.target_component, file_transfer_protocol.payload);
    }

    public static int mavlink_msg_file_transfer_protocol_encode_chan(byte system_id, byte component_id, byte chan, mavlink_message_t msg, mavlink_file_transfer_protocol_t file_transfer_protocol) {
        return mavlink_msg_file_transfer_protocol_pack_chan(system_id, component_id, chan, msg, file_transfer_protocol.target_network, file_transfer_protocol.target_system, file_transfer_protocol.target_component, file_transfer_protocol.payload);
    }

    public static byte mavlink_msg_file_transfer_protocol_get_target_network(mavlink_message_t msg) {
        return _MAV_RETURN_uint8_t(msg, 0);
    }

    public static byte mavlink_msg_file_transfer_protocol_get_target_system(mavlink_message_t msg) {
        return _MAV_RETURN_uint8_t(msg, 1);
    }

    public static byte mavlink_msg_file_transfer_protocol_get_target_component(mavlink_message_t msg) {
        return _MAV_RETURN_uint8_t(msg, 2);
    }

    public static int mavlink_msg_file_transfer_protocol_get_payload(mavlink_message_t msg, byte[] payload) {
        return _MAV_RETURN_uint8_t_array(msg, payload, MAVLINK_MSG_FILE_TRANSFER_PROTOCOL_FIELD_PAYLOAD_LEN, 3);
    }

    public static void mavlink_msg_file_transfer_protocol_decode(mavlink_message_t msg, mavlink_file_transfer_protocol_t file_transfer_protocol) {
        file_transfer_protocol.target_network = mavlink_msg_file_transfer_protocol_get_target_network(msg);
        file_transfer_protocol.target_system = mavlink_msg_file_transfer_protocol_get_target_system(msg);
        file_transfer_protocol.target_component = mavlink_msg_file_transfer_protocol_get_target_component(msg);
        mavlink_msg_file_transfer_protocol_get_payload(msg, file_transfer_protocol.payload);

        MavlinkFTP.Request request = (MavlinkFTP.Request) data.payload[0];

// Ignore old/reordered packets (handle wrap-around properly)
        int actualIncomingSeqNumber = request.hdr.seqNumber & 0xFFFF;
        if ((short) ((_expectedIncomingSeqNumber - 1) - actualIncomingSeqNumber) < (Short.MAX_VALUE / 2)) {
            System.out.println("_mavlinkMessageReceived: Received old packet seqNum expected:actual " + _expectedIncomingSeqNumber + " " + actualIncomingSeqNumber +
                    " hdr.opcode:hdr.req_opcode " + MavlinkFTP.opCodeToString((MavlinkFTP.OpCode_t) request.hdr.opcode) + " " + MavlinkFTP.opCodeToString((MavlinkFTP.OpCode_t) request.hdr.req_opcode));
            return;
        }

        System.out.println("_mavlinkMessageReceived: hdr.opcode:hdr.req_opcode:seqNumber " +
                MavlinkFTP.opCodeToString((MavlinkFTP.OpCode_t) request.hdr.opcode) + " " + MavlinkFTP.opCodeToString((MavlinkFTP.OpCode_t) request.hdr.req_opcode) +
                " " + request.hdr.seqNumber);

        _rgStateMachine[_currentStateMachineIndex].ackNakFn(request);
    }


}
*/
