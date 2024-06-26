/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE WIND PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Wind estimation.
 */
public class msg_wind extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_WIND = 168;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = MAVLINK_MSG_ID_WIND;

    
    /**
     * Wind direction (that wind is coming from).
     */
    @Description("Wind direction (that wind is coming from).")
    @Units("deg")
    public float direction;
    
    /**
     * Wind speed in ground plane.
     */
    @Description("Wind speed in ground plane.")
    @Units("m/s")
    public float speed;
    
    /**
     * Vertical wind speed.
     */
    @Description("Vertical wind speed.")
    @Units("m/s")
    public float speed_z;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_WIND;

        packet.payload.putFloat(direction);
        packet.payload.putFloat(speed);
        packet.payload.putFloat(speed_z);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a wind message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.direction = payload.getFloat();
        this.speed = payload.getFloat();
        this.speed_z = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_wind() {
        this.msgid = MAVLINK_MSG_ID_WIND;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_wind( float direction, float speed, float speed_z) {
        this.msgid = MAVLINK_MSG_ID_WIND;

        this.direction = direction;
        this.speed = speed;
        this.speed_z = speed_z;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_wind( float direction, float speed, float speed_z, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_WIND;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.direction = direction;
        this.speed = speed;
        this.speed_z = speed_z;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_wind(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_WIND;

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
        return "MAVLINK_MSG_ID_WIND - sysid:"+sysid+" compid:"+compid+" direction:"+direction+" speed:"+speed+" speed_z:"+speed_z+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_WIND";
    }
}
        