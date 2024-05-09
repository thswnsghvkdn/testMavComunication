/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AIRSPEED_AUTOCAL PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Airspeed auto-calibration.
 */
public class msg_airspeed_autocal extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AIRSPEED_AUTOCAL = 174;
    public static final int MAVLINK_MSG_LENGTH = 48;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AIRSPEED_AUTOCAL;

    
    /**
     * GPS velocity north.
     */
    @Description("GPS velocity north.")
    @Units("m/s")
    public float vx;
    
    /**
     * GPS velocity east.
     */
    @Description("GPS velocity east.")
    @Units("m/s")
    public float vy;
    
    /**
     * GPS velocity down.
     */
    @Description("GPS velocity down.")
    @Units("m/s")
    public float vz;
    
    /**
     * Differential pressure.
     */
    @Description("Differential pressure.")
    @Units("Pa")
    public float diff_pressure;
    
    /**
     * Estimated to true airspeed ratio.
     */
    @Description("Estimated to true airspeed ratio.")
    @Units("")
    public float EAS2TAS;
    
    /**
     * Airspeed ratio.
     */
    @Description("Airspeed ratio.")
    @Units("")
    public float ratio;
    
    /**
     * EKF state x.
     */
    @Description("EKF state x.")
    @Units("")
    public float state_x;
    
    /**
     * EKF state y.
     */
    @Description("EKF state y.")
    @Units("")
    public float state_y;
    
    /**
     * EKF state z.
     */
    @Description("EKF state z.")
    @Units("")
    public float state_z;
    
    /**
     * EKF Pax.
     */
    @Description("EKF Pax.")
    @Units("")
    public float Pax;
    
    /**
     * EKF Pby.
     */
    @Description("EKF Pby.")
    @Units("")
    public float Pby;
    
    /**
     * EKF Pcz.
     */
    @Description("EKF Pcz.")
    @Units("")
    public float Pcz;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AIRSPEED_AUTOCAL;

        packet.payload.putFloat(vx);
        packet.payload.putFloat(vy);
        packet.payload.putFloat(vz);
        packet.payload.putFloat(diff_pressure);
        packet.payload.putFloat(EAS2TAS);
        packet.payload.putFloat(ratio);
        packet.payload.putFloat(state_x);
        packet.payload.putFloat(state_y);
        packet.payload.putFloat(state_z);
        packet.payload.putFloat(Pax);
        packet.payload.putFloat(Pby);
        packet.payload.putFloat(Pcz);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a airspeed_autocal message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.vx = payload.getFloat();
        this.vy = payload.getFloat();
        this.vz = payload.getFloat();
        this.diff_pressure = payload.getFloat();
        this.EAS2TAS = payload.getFloat();
        this.ratio = payload.getFloat();
        this.state_x = payload.getFloat();
        this.state_y = payload.getFloat();
        this.state_z = payload.getFloat();
        this.Pax = payload.getFloat();
        this.Pby = payload.getFloat();
        this.Pcz = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_airspeed_autocal() {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED_AUTOCAL;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_airspeed_autocal( float vx, float vy, float vz, float diff_pressure, float EAS2TAS, float ratio, float state_x, float state_y, float state_z, float Pax, float Pby, float Pcz) {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED_AUTOCAL;

        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.diff_pressure = diff_pressure;
        this.EAS2TAS = EAS2TAS;
        this.ratio = ratio;
        this.state_x = state_x;
        this.state_y = state_y;
        this.state_z = state_z;
        this.Pax = Pax;
        this.Pby = Pby;
        this.Pcz = Pcz;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_airspeed_autocal( float vx, float vy, float vz, float diff_pressure, float EAS2TAS, float ratio, float state_x, float state_y, float state_z, float Pax, float Pby, float Pcz, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED_AUTOCAL;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.diff_pressure = diff_pressure;
        this.EAS2TAS = EAS2TAS;
        this.ratio = ratio;
        this.state_x = state_x;
        this.state_y = state_y;
        this.state_z = state_z;
        this.Pax = Pax;
        this.Pby = Pby;
        this.Pcz = Pcz;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_airspeed_autocal(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED_AUTOCAL;

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
        return "MAVLINK_MSG_ID_AIRSPEED_AUTOCAL - sysid:"+sysid+" compid:"+compid+" vx:"+vx+" vy:"+vy+" vz:"+vz+" diff_pressure:"+diff_pressure+" EAS2TAS:"+EAS2TAS+" ratio:"+ratio+" state_x:"+state_x+" state_y:"+state_y+" state_z:"+state_z+" Pax:"+Pax+" Pby:"+Pby+" Pcz:"+Pcz+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AIRSPEED_AUTOCAL";
    }
}
        