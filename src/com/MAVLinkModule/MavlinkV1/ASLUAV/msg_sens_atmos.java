/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SENS_ATMOS PACKING
package com.MAVLinkModule.MavlinkV1.ASLUAV;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
public class msg_sens_atmos extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SENS_ATMOS = 8009;
    public static final int MAVLINK_MSG_LENGTH = 16;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SENS_ATMOS;

    
    /**
     * Time since system boot
     */
    @Description("Time since system boot")
    @Units("us")
    public long timestamp;
    
    /**
     *  Ambient temperature
     */
    @Description(" Ambient temperature")
    @Units("degC")
    public float TempAmbient;
    
    /**
     *  Relative humidity
     */
    @Description(" Relative humidity")
    @Units("%")
    public float Humidity;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_SENS_ATMOS;

        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putFloat(TempAmbient);
        packet.payload.putFloat(Humidity);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a sens_atmos message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.timestamp = payload.getUnsignedLong();
        this.TempAmbient = payload.getFloat();
        this.Humidity = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_sens_atmos() {
        this.msgid = MAVLINK_MSG_ID_SENS_ATMOS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_sens_atmos( long timestamp, float TempAmbient, float Humidity) {
        this.msgid = MAVLINK_MSG_ID_SENS_ATMOS;

        this.timestamp = timestamp;
        this.TempAmbient = TempAmbient;
        this.Humidity = Humidity;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_sens_atmos( long timestamp, float TempAmbient, float Humidity, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_SENS_ATMOS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.TempAmbient = TempAmbient;
        this.Humidity = Humidity;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_sens_atmos(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_SENS_ATMOS;

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
        return "MAVLINK_MSG_ID_SENS_ATMOS - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" TempAmbient:"+TempAmbient+" Humidity:"+Humidity+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_SENS_ATMOS";
    }
}
        