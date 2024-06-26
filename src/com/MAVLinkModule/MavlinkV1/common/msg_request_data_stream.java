/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE REQUEST_DATA_STREAM PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Request a data stream.
 */
public class msg_request_data_stream extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_REQUEST_DATA_STREAM = 66;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;

    
    /**
     * The requested message rate
     */
    @Description("The requested message rate")
    @Units("Hz")
    public int req_message_rate;
    
    /**
     * The target requested to send the message stream.
     */
    @Description("The target requested to send the message stream.")
    @Units("")
    public short target_system;
    
    /**
     * The target requested to send the message stream.
     */
    @Description("The target requested to send the message stream.")
    @Units("")
    public short target_component;
    
    /**
     * The ID of the requested data stream
     */
    @Description("The ID of the requested data stream")
    @Units("")
    public short req_stream_id;
    
    /**
     * 1 to start sending, 0 to stop sending.
     */
    @Description("1 to start sending, 0 to stop sending.")
    @Units("")
    public short start_stop;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;

        packet.payload.putUnsignedShort(req_message_rate);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(req_stream_id);
        packet.payload.putUnsignedByte(start_stop);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a request_data_stream message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.req_message_rate = payload.getUnsignedShort();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.req_stream_id = payload.getUnsignedByte();
        this.start_stop = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_request_data_stream() {
        this.msgid = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_request_data_stream( int req_message_rate, short target_system, short target_component, short req_stream_id, short start_stop) {
        this.msgid = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;

        this.req_message_rate = req_message_rate;
        this.target_system = target_system;
        this.target_component = target_component;
        this.req_stream_id = req_stream_id;
        this.start_stop = start_stop;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_request_data_stream( int req_message_rate, short target_system, short target_component, short req_stream_id, short start_stop, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.req_message_rate = req_message_rate;
        this.target_system = target_system;
        this.target_component = target_component;
        this.req_stream_id = req_stream_id;
        this.start_stop = start_stop;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_request_data_stream(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

              
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_REQUEST_DATA_STREAM - sysid:"+sysid+" compid:"+compid+" req_message_rate:"+req_message_rate+" target_system:"+target_system+" target_component:"+target_component+" req_stream_id:"+req_stream_id+" start_stop:"+start_stop+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_REQUEST_DATA_STREAM";
    }
}
        