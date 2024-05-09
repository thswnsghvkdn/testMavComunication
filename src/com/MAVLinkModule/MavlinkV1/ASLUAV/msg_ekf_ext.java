/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE EKF_EXT PACKING
package com.MAVLinkModule.MavlinkV1.ASLUAV;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Extended EKF state estimates for ASLUAVs
 */
public class msg_ekf_ext extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_EKF_EXT = 8007;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = MAVLINK_MSG_ID_EKF_EXT;

    
    /**
     *  Time since system start
     */
    @Description(" Time since system start")
    @Units("us")
    public long timestamp;
    
    /**
     *  Magnitude of wind velocity (in lateral inertial plane)
     */
    @Description(" Magnitude of wind velocity (in lateral inertial plane)")
    @Units("m/s")
    public float Windspeed;
    
    /**
     *  Wind heading angle from North
     */
    @Description(" Wind heading angle from North")
    @Units("rad")
    public float WindDir;
    
    /**
     *  Z (Down) component of inertial wind velocity
     */
    @Description(" Z (Down) component of inertial wind velocity")
    @Units("m/s")
    public float WindZ;
    
    /**
     *  Magnitude of air velocity
     */
    @Description(" Magnitude of air velocity")
    @Units("m/s")
    public float Airspeed;
    
    /**
     *  Sideslip angle
     */
    @Description(" Sideslip angle")
    @Units("rad")
    public float beta;
    
    /**
     *  Angle of attack
     */
    @Description(" Angle of attack")
    @Units("rad")
    public float alpha;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_EKF_EXT;

        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putFloat(Windspeed);
        packet.payload.putFloat(WindDir);
        packet.payload.putFloat(WindZ);
        packet.payload.putFloat(Airspeed);
        packet.payload.putFloat(beta);
        packet.payload.putFloat(alpha);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a ekf_ext message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.timestamp = payload.getUnsignedLong();
        this.Windspeed = payload.getFloat();
        this.WindDir = payload.getFloat();
        this.WindZ = payload.getFloat();
        this.Airspeed = payload.getFloat();
        this.beta = payload.getFloat();
        this.alpha = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_ekf_ext() {
        this.msgid = MAVLINK_MSG_ID_EKF_EXT;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_ekf_ext( long timestamp, float Windspeed, float WindDir, float WindZ, float Airspeed, float beta, float alpha) {
        this.msgid = MAVLINK_MSG_ID_EKF_EXT;

        this.timestamp = timestamp;
        this.Windspeed = Windspeed;
        this.WindDir = WindDir;
        this.WindZ = WindZ;
        this.Airspeed = Airspeed;
        this.beta = beta;
        this.alpha = alpha;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_ekf_ext( long timestamp, float Windspeed, float WindDir, float WindZ, float Airspeed, float beta, float alpha, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_EKF_EXT;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.Windspeed = Windspeed;
        this.WindDir = WindDir;
        this.WindZ = WindZ;
        this.Airspeed = Airspeed;
        this.beta = beta;
        this.alpha = alpha;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_ekf_ext(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_EKF_EXT;

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
        return "MAVLINK_MSG_ID_EKF_EXT - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" Windspeed:"+Windspeed+" WindDir:"+WindDir+" WindZ:"+WindZ+" Airspeed:"+Airspeed+" beta:"+beta+" alpha:"+alpha+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_EKF_EXT";
    }
}
        