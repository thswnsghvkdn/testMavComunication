/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE OSD_PARAM_CONFIG PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Configure an OSD parameter slot.
 */
public class msg_osd_param_config extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_OSD_PARAM_CONFIG = 11033;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = MAVLINK_MSG_ID_OSD_PARAM_CONFIG;

    
    /**
     * Request ID - copied to reply.
     */
    @Description("Request ID - copied to reply.")
    @Units("")
    public long request_id;
    
    /**
     * OSD parameter minimum value.
     */
    @Description("OSD parameter minimum value.")
    @Units("")
    public float min_value;
    
    /**
     * OSD parameter maximum value.
     */
    @Description("OSD parameter maximum value.")
    @Units("")
    public float max_value;
    
    /**
     * OSD parameter increment.
     */
    @Description("OSD parameter increment.")
    @Units("")
    public float increment;
    
    /**
     * System ID.
     */
    @Description("System ID.")
    @Units("")
    public short target_system;
    
    /**
     * Component ID.
     */
    @Description("Component ID.")
    @Units("")
    public short target_component;
    
    /**
     * OSD parameter screen index.
     */
    @Description("OSD parameter screen index.")
    @Units("")
    public short osd_screen;
    
    /**
     * OSD parameter display index.
     */
    @Description("OSD parameter display index.")
    @Units("")
    public short osd_index;
    
    /**
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string
     */
    @Description("Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
    @Units("")
    public byte param_id[] = new byte[16];
    
    /**
     * Config type.
     */
    @Description("Config type.")
    @Units("")
    public short config_type;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_OSD_PARAM_CONFIG;

        packet.payload.putUnsignedInt(request_id);
        packet.payload.putFloat(min_value);
        packet.payload.putFloat(max_value);
        packet.payload.putFloat(increment);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(osd_screen);
        packet.payload.putUnsignedByte(osd_index);
        
        for (int i = 0; i < param_id.length; i++) {
            packet.payload.putByte(param_id[i]);
        }
                    
        packet.payload.putUnsignedByte(config_type);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a osd_param_config message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.request_id = payload.getUnsignedInt();
        this.min_value = payload.getFloat();
        this.max_value = payload.getFloat();
        this.increment = payload.getFloat();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.osd_screen = payload.getUnsignedByte();
        this.osd_index = payload.getUnsignedByte();
        
        for (int i = 0; i < this.param_id.length; i++) {
            this.param_id[i] = payload.getByte();
        }
                
        this.config_type = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_osd_param_config() {
        this.msgid = MAVLINK_MSG_ID_OSD_PARAM_CONFIG;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_osd_param_config( long request_id, float min_value, float max_value, float increment, short target_system, short target_component, short osd_screen, short osd_index, byte[] param_id, short config_type) {
        this.msgid = MAVLINK_MSG_ID_OSD_PARAM_CONFIG;

        this.request_id = request_id;
        this.min_value = min_value;
        this.max_value = max_value;
        this.increment = increment;
        this.target_system = target_system;
        this.target_component = target_component;
        this.osd_screen = osd_screen;
        this.osd_index = osd_index;
        this.param_id = param_id;
        this.config_type = config_type;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_osd_param_config( long request_id, float min_value, float max_value, float increment, short target_system, short target_component, short osd_screen, short osd_index, byte[] param_id, short config_type, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_OSD_PARAM_CONFIG;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.request_id = request_id;
        this.min_value = min_value;
        this.max_value = max_value;
        this.increment = increment;
        this.target_system = target_system;
        this.target_component = target_component;
        this.osd_screen = osd_screen;
        this.osd_index = osd_index;
        this.param_id = param_id;
        this.config_type = config_type;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_osd_param_config(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_OSD_PARAM_CONFIG;

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
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_OSD_PARAM_CONFIG - sysid:"+sysid+" compid:"+compid+" request_id:"+request_id+" min_value:"+min_value+" max_value:"+max_value+" increment:"+increment+" target_system:"+target_system+" target_component:"+target_component+" osd_screen:"+osd_screen+" osd_index:"+osd_index+" param_id:"+param_id+" config_type:"+config_type+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_OSD_PARAM_CONFIG";
    }
}
        