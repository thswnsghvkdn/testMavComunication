/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AVAILABLE_MODES PACKING
package com.MAVLinkModule.MavlinkV1.development;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Get information about a particular flight modes.
        The message can be enumerated or requested for a particular mode using MAV_CMD_REQUEST_MESSAGE.
        Specify 0 in param2 to request that the message is emitted for all available modes or the specific index for just one mode.
        The modes must be available/settable for the current vehicle/frame type.
        Each modes should only be emitted once (even if it is both standard and custom).
      
 */
public class msg_available_modes extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AVAILABLE_MODES = 435;
    public static final int MAVLINK_MSG_LENGTH = 58;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AVAILABLE_MODES;

    
    /**
     * A bitfield for use for autopilot-specific flags
     */
    @Description("A bitfield for use for autopilot-specific flags")
    @Units("")
    public long custom_mode;
    
    /**
     * The total number of available modes for the current vehicle type.
     */
    @Description("The total number of available modes for the current vehicle type.")
    @Units("")
    public short number_modes;
    
    /**
     * The current mode index within number_modes, indexed from 1.
     */
    @Description("The current mode index within number_modes, indexed from 1.")
    @Units("")
    public short mode_index;
    
    /**
     * Standard mode.
     */
    @Description("Standard mode.")
    @Units("")
    public short standard_mode;
    
    /**
     * System mode bitmap.
     */
    @Description("System mode bitmap.")
    @Units("")
    public short base_mode;
    
    /**
     * Name of custom mode, with null termination character. Should be omitted for standard modes.
     */
    @Description("Name of custom mode, with null termination character. Should be omitted for standard modes.")
    @Units("")
    public byte mode_name[] = new byte[50];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AVAILABLE_MODES;

        packet.payload.putUnsignedInt(custom_mode);
        packet.payload.putUnsignedByte(number_modes);
        packet.payload.putUnsignedByte(mode_index);
        packet.payload.putUnsignedByte(standard_mode);
        packet.payload.putUnsignedByte(base_mode);
        
        for (int i = 0; i < mode_name.length; i++) {
            packet.payload.putByte(mode_name[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a available_modes message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.custom_mode = payload.getUnsignedInt();
        this.number_modes = payload.getUnsignedByte();
        this.mode_index = payload.getUnsignedByte();
        this.standard_mode = payload.getUnsignedByte();
        this.base_mode = payload.getUnsignedByte();
        
        for (int i = 0; i < this.mode_name.length; i++) {
            this.mode_name[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_available_modes() {
        this.msgid = MAVLINK_MSG_ID_AVAILABLE_MODES;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_available_modes( long custom_mode, short number_modes, short mode_index, short standard_mode, short base_mode, byte[] mode_name) {
        this.msgid = MAVLINK_MSG_ID_AVAILABLE_MODES;

        this.custom_mode = custom_mode;
        this.number_modes = number_modes;
        this.mode_index = mode_index;
        this.standard_mode = standard_mode;
        this.base_mode = base_mode;
        this.mode_name = mode_name;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_available_modes( long custom_mode, short number_modes, short mode_index, short standard_mode, short base_mode, byte[] mode_name, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AVAILABLE_MODES;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.custom_mode = custom_mode;
        this.number_modes = number_modes;
        this.mode_index = mode_index;
        this.standard_mode = standard_mode;
        this.base_mode = base_mode;
        this.mode_name = mode_name;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_available_modes(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AVAILABLE_MODES;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

               
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setMode_Name(String str) {
        int len = Math.min(str.length(), 50);
        for (int i=0; i<len; i++) {
            mode_name[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<50; i++) {            // padding for the rest of the buffer
            mode_name[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getMode_Name() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 50; i++) {
            if (mode_name[i] != 0)
                buf.append((char) mode_name[i]);
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
        return "MAVLINK_MSG_ID_AVAILABLE_MODES - sysid:"+sysid+" compid:"+compid+" custom_mode:"+custom_mode+" number_modes:"+number_modes+" mode_index:"+mode_index+" standard_mode:"+standard_mode+" base_mode:"+base_mode+" mode_name:"+mode_name+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AVAILABLE_MODES";
    }
}
        