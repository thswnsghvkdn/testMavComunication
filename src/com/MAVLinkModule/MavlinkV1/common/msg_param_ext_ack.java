/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE PARAM_EXT_ACK PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Response from a PARAM_EXT_SET message.
 */
public class msg_param_ext_ack extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_PARAM_EXT_ACK = 324;
    public static final int MAVLINK_MSG_LENGTH = 146;
    private static final long serialVersionUID = MAVLINK_MSG_ID_PARAM_EXT_ACK;

    
    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string
     */
    @Description("Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
    @Units("")
    public byte param_id[] = new byte[16];
    
    /**
     * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)
     */
    @Description("Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)")
    @Units("")
    public byte param_value[] = new byte[128];
    
    /**
     * Parameter type.
     */
    @Description("Parameter type.")
    @Units("")
    public short param_type;
    
    /**
     * Result code.
     */
    @Description("Result code.")
    @Units("")
    public short param_result;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_PARAM_EXT_ACK;

        
        for (int i = 0; i < param_id.length; i++) {
            packet.payload.putByte(param_id[i]);
        }
                    
        
        for (int i = 0; i < param_value.length; i++) {
            packet.payload.putByte(param_value[i]);
        }
                    
        packet.payload.putUnsignedByte(param_type);
        packet.payload.putUnsignedByte(param_result);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a param_ext_ack message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        
        for (int i = 0; i < this.param_id.length; i++) {
            this.param_id[i] = payload.getByte();
        }
                
        
        for (int i = 0; i < this.param_value.length; i++) {
            this.param_value[i] = payload.getByte();
        }
                
        this.param_type = payload.getUnsignedByte();
        this.param_result = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_param_ext_ack() {
        this.msgid = MAVLINK_MSG_ID_PARAM_EXT_ACK;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_param_ext_ack( byte[] param_id, byte[] param_value, short param_type, short param_result) {
        this.msgid = MAVLINK_MSG_ID_PARAM_EXT_ACK;

        this.param_id = param_id;
        this.param_value = param_value;
        this.param_type = param_type;
        this.param_result = param_result;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_param_ext_ack( byte[] param_id, byte[] param_value, short param_type, short param_result, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_PARAM_EXT_ACK;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.param_id = param_id;
        this.param_value = param_value;
        this.param_type = param_type;
        this.param_result = param_result;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_param_ext_ack(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_PARAM_EXT_ACK;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

     
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setParam_Id(String str) {
        int len = Math.min(str.length(), 16);
        for (int i=0; i<len; i++) {
            param_id[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<16; i++) {            // padding for the rest of the buffer
            param_id[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getParam_Id() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            if (param_id[i] != 0)
                buf.append((char) param_id[i]);
            else
                break;
        }
        return buf.toString();

    }
                          
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setParam_Value(String str) {
        int len = Math.min(str.length(), 128);
        for (int i=0; i<len; i++) {
            param_value[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<128; i++) {            // padding for the rest of the buffer
            param_value[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getParam_Value() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 128; i++) {
            if (param_value[i] != 0)
                buf.append((char) param_value[i]);
            else
                break;
        }
        return buf.toString();

    }
                             
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_EXT_ACK - sysid:"+sysid+" compid:"+compid+" param_id:"+param_id+" param_value:"+param_value+" param_type:"+param_type+" param_result:"+param_result+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_PARAM_EXT_ACK";
    }
}
        