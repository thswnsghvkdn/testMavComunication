/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE NAMED_VALUE_FLOAT PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Send a key-value pair as float. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.
 */
public class msg_named_value_float extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT = 251;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;

    
    /**
     * Timestamp (time since system boot).
     */
    @Description("Timestamp (time since system boot).")
    @Units("ms")
    public long time_boot_ms;
    
    /**
     * Floating point value
     */
    @Description("Floating point value")
    @Units("")
    public float value;
    
    /**
     * Name of the debug variable
     */
    @Description("Name of the debug variable")
    @Units("")
    public byte name[] = new byte[10];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;

        packet.payload.putUnsignedInt(time_boot_ms);
        packet.payload.putFloat(value);
        
        for (int i = 0; i < name.length; i++) {
            packet.payload.putByte(name[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a named_value_float message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_boot_ms = payload.getUnsignedInt();
        this.value = payload.getFloat();
        
        for (int i = 0; i < this.name.length; i++) {
            this.name[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_named_value_float() {
        this.msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_named_value_float( long time_boot_ms, float value, byte[] name) {
        this.msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;

        this.time_boot_ms = time_boot_ms;
        this.value = value;
        this.name = name;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_named_value_float( long time_boot_ms, float value, byte[] name, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_boot_ms = time_boot_ms;
        this.value = value;
        this.name = name;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_named_value_float(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

         
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setName(String str) {
        int len = Math.min(str.length(), 10);
        for (int i=0; i<len; i++) {
            name[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<10; i++) {            // padding for the rest of the buffer
            name[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getName() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (name[i] != 0)
                buf.append((char) name[i]);
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
        return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT - sysid:"+sysid+" compid:"+compid+" time_boot_ms:"+time_boot_ms+" value:"+value+" name:"+name+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT";
    }
}
        