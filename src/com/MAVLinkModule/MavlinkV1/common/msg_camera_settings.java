/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE CAMERA_SETTINGS PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 */
public class msg_camera_settings extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_CAMERA_SETTINGS = 260;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = MAVLINK_MSG_ID_CAMERA_SETTINGS;

    
    /**
     * Timestamp (time since system boot).
     */
    @Description("Timestamp (time since system boot).")
    @Units("ms")
    public long time_boot_ms;
    
    /**
     * Camera mode
     */
    @Description("Camera mode")
    @Units("")
    public short mode_id;
    
    /**
     * Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known)
     */
    @Description("Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known)")
    @Units("")
    public float zoomLevel;
    
    /**
     * Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known)
     */
    @Description("Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known)")
    @Units("")
    public float focusLevel;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_CAMERA_SETTINGS;

        packet.payload.putUnsignedInt(time_boot_ms);
        packet.payload.putUnsignedByte(mode_id);
        
        if (isMavlink2) {
             packet.payload.putFloat(zoomLevel);
             packet.payload.putFloat(focusLevel);
            
        }
        return packet;
    }

    /**
     * Decode a camera_settings message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_boot_ms = payload.getUnsignedInt();
        this.mode_id = payload.getUnsignedByte();
        
        if (isMavlink2) {
             this.zoomLevel = payload.getFloat();
             this.focusLevel = payload.getFloat();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_camera_settings() {
        this.msgid = MAVLINK_MSG_ID_CAMERA_SETTINGS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_camera_settings( long time_boot_ms, short mode_id, float zoomLevel, float focusLevel) {
        this.msgid = MAVLINK_MSG_ID_CAMERA_SETTINGS;

        this.time_boot_ms = time_boot_ms;
        this.mode_id = mode_id;
        this.zoomLevel = zoomLevel;
        this.focusLevel = focusLevel;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_camera_settings( long time_boot_ms, short mode_id, float zoomLevel, float focusLevel, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_CAMERA_SETTINGS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_boot_ms = time_boot_ms;
        this.mode_id = mode_id;
        this.zoomLevel = zoomLevel;
        this.focusLevel = focusLevel;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_camera_settings(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_CAMERA_SETTINGS;

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
        return "MAVLINK_MSG_ID_CAMERA_SETTINGS - sysid:"+sysid+" compid:"+compid+" time_boot_ms:"+time_boot_ms+" mode_id:"+mode_id+" zoomLevel:"+zoomLevel+" focusLevel:"+focusLevel+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_CAMERA_SETTINGS";
    }
}
        