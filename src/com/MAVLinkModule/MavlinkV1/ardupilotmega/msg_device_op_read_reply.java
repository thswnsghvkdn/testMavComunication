/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE DEVICE_OP_READ_REPLY PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Read registers reply.
 */
public class msg_device_op_read_reply extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY = 11001;
    public static final int MAVLINK_MSG_LENGTH = 136;
    private static final long serialVersionUID = MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY;

    
    /**
     * Request ID - copied from request.
     */
    @Description("Request ID - copied from request.")
    @Units("")
    public long request_id;
    
    /**
     * 0 for success, anything else is failure code.
     */
    @Description("0 for success, anything else is failure code.")
    @Units("")
    public short result;
    
    /**
     * Starting register.
     */
    @Description("Starting register.")
    @Units("")
    public short regstart;
    
    /**
     * Count of bytes read.
     */
    @Description("Count of bytes read.")
    @Units("")
    public short count;
    
    /**
     * Reply data.
     */
    @Description("Reply data.")
    @Units("")
    public short data[] = new short[128];
    
    /**
     * Bank number.
     */
    @Description("Bank number.")
    @Units("")
    public short bank;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY;

        packet.payload.putUnsignedInt(request_id);
        packet.payload.putUnsignedByte(result);
        packet.payload.putUnsignedByte(regstart);
        packet.payload.putUnsignedByte(count);
        
        for (int i = 0; i < data.length; i++) {
            packet.payload.putUnsignedByte(data[i]);
        }
                    
        
        if (isMavlink2) {
             packet.payload.putUnsignedByte(bank);
            
        }
        return packet;
    }

    /**
     * Decode a device_op_read_reply message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.request_id = payload.getUnsignedInt();
        this.result = payload.getUnsignedByte();
        this.regstart = payload.getUnsignedByte();
        this.count = payload.getUnsignedByte();
        
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = payload.getUnsignedByte();
        }
                
        
        if (isMavlink2) {
             this.bank = payload.getUnsignedByte();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_device_op_read_reply() {
        this.msgid = MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_device_op_read_reply( long request_id, short result, short regstart, short count, short[] data, short bank) {
        this.msgid = MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY;

        this.request_id = request_id;
        this.result = result;
        this.regstart = regstart;
        this.count = count;
        this.data = data;
        this.bank = bank;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_device_op_read_reply( long request_id, short result, short regstart, short count, short[] data, short bank, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.request_id = request_id;
        this.result = result;
        this.regstart = regstart;
        this.count = count;
        this.data = data;
        this.bank = bank;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_device_op_read_reply(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY;

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
        return "MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY - sysid:"+sysid+" compid:"+compid+" request_id:"+request_id+" result:"+result+" regstart:"+regstart+" count:"+count+" data:"+data+" bank:"+bank+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_DEVICE_OP_READ_REPLY";
    }
}
        