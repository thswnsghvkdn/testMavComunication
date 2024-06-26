/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AHRS3 PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Status of third AHRS filter if available. This is for ANU research group (Ali and Sean).
 */
public class msg_ahrs3 extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AHRS3 = 182;
    public static final int MAVLINK_MSG_LENGTH = 40;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AHRS3;

    
    /**
     * Roll angle.
     */
    @Description("Roll angle.")
    @Units("rad")
    public float roll;
    
    /**
     * Pitch angle.
     */
    @Description("Pitch angle.")
    @Units("rad")
    public float pitch;
    
    /**
     * Yaw angle.
     */
    @Description("Yaw angle.")
    @Units("rad")
    public float yaw;
    
    /**
     * Altitude (MSL).
     */
    @Description("Altitude (MSL).")
    @Units("m")
    public float altitude;
    
    /**
     * Latitude.
     */
    @Description("Latitude.")
    @Units("degE7")
    public int lat;
    
    /**
     * Longitude.
     */
    @Description("Longitude.")
    @Units("degE7")
    public int lng;
    
    /**
     * Test variable1.
     */
    @Description("Test variable1.")
    @Units("")
    public float v1;
    
    /**
     * Test variable2.
     */
    @Description("Test variable2.")
    @Units("")
    public float v2;
    
    /**
     * Test variable3.
     */
    @Description("Test variable3.")
    @Units("")
    public float v3;
    
    /**
     * Test variable4.
     */
    @Description("Test variable4.")
    @Units("")
    public float v4;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AHRS3;

        packet.payload.putFloat(roll);
        packet.payload.putFloat(pitch);
        packet.payload.putFloat(yaw);
        packet.payload.putFloat(altitude);
        packet.payload.putInt(lat);
        packet.payload.putInt(lng);
        packet.payload.putFloat(v1);
        packet.payload.putFloat(v2);
        packet.payload.putFloat(v3);
        packet.payload.putFloat(v4);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a ahrs3 message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.roll = payload.getFloat();
        this.pitch = payload.getFloat();
        this.yaw = payload.getFloat();
        this.altitude = payload.getFloat();
        this.lat = payload.getInt();
        this.lng = payload.getInt();
        this.v1 = payload.getFloat();
        this.v2 = payload.getFloat();
        this.v3 = payload.getFloat();
        this.v4 = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_ahrs3() {
        this.msgid = MAVLINK_MSG_ID_AHRS3;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_ahrs3( float roll, float pitch, float yaw, float altitude, int lat, int lng, float v1, float v2, float v3, float v4) {
        this.msgid = MAVLINK_MSG_ID_AHRS3;

        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.altitude = altitude;
        this.lat = lat;
        this.lng = lng;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_ahrs3( float roll, float pitch, float yaw, float altitude, int lat, int lng, float v1, float v2, float v3, float v4, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AHRS3;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.altitude = altitude;
        this.lat = lat;
        this.lng = lng;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_ahrs3(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AHRS3;

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
        return "MAVLINK_MSG_ID_AHRS3 - sysid:"+sysid+" compid:"+compid+" roll:"+roll+" pitch:"+pitch+" yaw:"+yaw+" altitude:"+altitude+" lat:"+lat+" lng:"+lng+" v1:"+v1+" v2:"+v2+" v3:"+v3+" v4:"+v4+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AHRS3";
    }
}
        