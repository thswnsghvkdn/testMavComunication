/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE OPEN_DRONE_ID_SELF_ID PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the operator to (optionally) declare their identity and purpose of the flight. This message can provide additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a particular area or manner. This message can also be used to provide optional additional clarification in an emergency/remote ID system failure situation.
 */
public class msg_open_drone_id_self_id extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID = 12903;
    public static final int MAVLINK_MSG_LENGTH = 46;
    private static final long serialVersionUID = MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID;

    
    /**
     * System ID (0 for broadcast).
     */
    @Description("System ID (0 for broadcast).")
    @Units("")
    public short target_system;
    
    /**
     * Component ID (0 for broadcast).
     */
    @Description("Component ID (0 for broadcast).")
    @Units("")
    public short target_component;
    
    /**
     * Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html. 
     */
    @Description("Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html. ")
    @Units("")
    public short id_or_mac[] = new short[20];
    
    /**
     * Indicates the type of the description field.
     */
    @Description("Indicates the type of the description field.")
    @Units("")
    public short description_type;
    
    /**
     * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field.
     */
    @Description("Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field.")
    @Units("")
    public byte description[] = new byte[23];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID;

        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        for (int i = 0; i < id_or_mac.length; i++) {
            packet.payload.putUnsignedByte(id_or_mac[i]);
        }
                    
        packet.payload.putUnsignedByte(description_type);
        
        for (int i = 0; i < description.length; i++) {
            packet.payload.putByte(description[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a open_drone_id_self_id message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        for (int i = 0; i < this.id_or_mac.length; i++) {
            this.id_or_mac[i] = payload.getUnsignedByte();
        }
                
        this.description_type = payload.getUnsignedByte();
        
        for (int i = 0; i < this.description.length; i++) {
            this.description[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_open_drone_id_self_id() {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_open_drone_id_self_id( short target_system, short target_component, short[] id_or_mac, short description_type, byte[] description) {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID;

        this.target_system = target_system;
        this.target_component = target_component;
        this.id_or_mac = id_or_mac;
        this.description_type = description_type;
        this.description = description;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_open_drone_id_self_id( short target_system, short target_component, short[] id_or_mac, short description_type, byte[] description, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.target_system = target_system;
        this.target_component = target_component;
        this.id_or_mac = id_or_mac;
        this.description_type = description_type;
        this.description = description;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_open_drone_id_self_id(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

             
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setDescription(String str) {
        int len = Math.min(str.length(), 23);
        for (int i=0; i<len; i++) {
            description[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<23; i++) {            // padding for the rest of the buffer
            description[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getDescription() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 23; i++) {
            if (description[i] != 0)
                buf.append((char) description[i]);
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
        return "MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID - sysid:"+sysid+" compid:"+compid+" target_system:"+target_system+" target_component:"+target_component+" id_or_mac:"+id_or_mac+" description_type:"+description_type+" description:"+description+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_OPEN_DRONE_ID_SELF_ID";
    }
}
        