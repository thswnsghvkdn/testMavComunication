/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AIRSPEED PACKING
package com.MAVLinkModule.MavlinkV1.development;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Airspeed information from a sensor.
 */
public class msg_airspeed extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AIRSPEED = 295;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AIRSPEED;

    
    /**
     * Calibrated airspeed (CAS).
     */
    @Description("Calibrated airspeed (CAS).")
    @Units("m/s")
    public float airspeed;
    
    /**
     * Raw differential pressure. NaN for value unknown/not supplied.
     */
    @Description("Raw differential pressure. NaN for value unknown/not supplied.")
    @Units("hPa")
    public float raw_press;
    
    /**
     * Temperature. INT16_MAX for value unknown/not supplied.
     */
    @Description("Temperature. INT16_MAX for value unknown/not supplied.")
    @Units("cdegC")
    public short temperature;
    
    /**
     * Sensor ID.
     */
    @Description("Sensor ID.")
    @Units("")
    public short id;
    
    /**
     * Airspeed sensor flags.
     */
    @Description("Airspeed sensor flags.")
    @Units("")
    public short flags;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AIRSPEED;

        packet.payload.putFloat(airspeed);
        packet.payload.putFloat(raw_press);
        packet.payload.putShort(temperature);
        packet.payload.putUnsignedByte(id);
        packet.payload.putUnsignedByte(flags);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a airspeed message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.airspeed = payload.getFloat();
        this.raw_press = payload.getFloat();
        this.temperature = payload.getShort();
        this.id = payload.getUnsignedByte();
        this.flags = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_airspeed() {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_airspeed( float airspeed, float raw_press, short temperature, short id, short flags) {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED;

        this.airspeed = airspeed;
        this.raw_press = raw_press;
        this.temperature = temperature;
        this.id = id;
        this.flags = flags;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_airspeed( float airspeed, float raw_press, short temperature, short id, short flags, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.airspeed = airspeed;
        this.raw_press = raw_press;
        this.temperature = temperature;
        this.id = id;
        this.flags = flags;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_airspeed(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AIRSPEED;

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
        return "MAVLINK_MSG_ID_AIRSPEED - sysid:"+sysid+" compid:"+compid+" airspeed:"+airspeed+" raw_press:"+raw_press+" temperature:"+temperature+" id:"+id+" flags:"+flags+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AIRSPEED";
    }
}
        