/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SENS_POWER_BOARD PACKING
package com.MAVLinkModule.MavlinkV1.ASLUAV;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Monitoring of power board status
 */
public class msg_sens_power_board extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SENS_POWER_BOARD = 8013;
    public static final int MAVLINK_MSG_LENGTH = 46;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SENS_POWER_BOARD;

    
    /**
     * Timestamp
     */
    @Description("Timestamp")
    @Units("us")
    public long timestamp;
    
    /**
     * Power board system voltage
     */
    @Description("Power board system voltage")
    @Units("V")
    public float pwr_brd_system_volt;
    
    /**
     * Power board servo voltage
     */
    @Description("Power board servo voltage")
    @Units("V")
    public float pwr_brd_servo_volt;
    
    /**
     * Power board digital voltage
     */
    @Description("Power board digital voltage")
    @Units("V")
    public float pwr_brd_digital_volt;
    
    /**
     * Power board left motor current sensor
     */
    @Description("Power board left motor current sensor")
    @Units("A")
    public float pwr_brd_mot_l_amp;
    
    /**
     * Power board right motor current sensor
     */
    @Description("Power board right motor current sensor")
    @Units("A")
    public float pwr_brd_mot_r_amp;
    
    /**
     * Power board analog current sensor
     */
    @Description("Power board analog current sensor")
    @Units("A")
    public float pwr_brd_analog_amp;
    
    /**
     * Power board digital current sensor
     */
    @Description("Power board digital current sensor")
    @Units("A")
    public float pwr_brd_digital_amp;
    
    /**
     * Power board extension current sensor
     */
    @Description("Power board extension current sensor")
    @Units("A")
    public float pwr_brd_ext_amp;
    
    /**
     * Power board aux current sensor
     */
    @Description("Power board aux current sensor")
    @Units("A")
    public float pwr_brd_aux_amp;
    
    /**
     * Power board status register
     */
    @Description("Power board status register")
    @Units("")
    public short pwr_brd_status;
    
    /**
     * Power board leds status
     */
    @Description("Power board leds status")
    @Units("")
    public short pwr_brd_led_status;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_SENS_POWER_BOARD;

        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putFloat(pwr_brd_system_volt);
        packet.payload.putFloat(pwr_brd_servo_volt);
        packet.payload.putFloat(pwr_brd_digital_volt);
        packet.payload.putFloat(pwr_brd_mot_l_amp);
        packet.payload.putFloat(pwr_brd_mot_r_amp);
        packet.payload.putFloat(pwr_brd_analog_amp);
        packet.payload.putFloat(pwr_brd_digital_amp);
        packet.payload.putFloat(pwr_brd_ext_amp);
        packet.payload.putFloat(pwr_brd_aux_amp);
        packet.payload.putUnsignedByte(pwr_brd_status);
        packet.payload.putUnsignedByte(pwr_brd_led_status);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a sens_power_board message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.timestamp = payload.getUnsignedLong();
        this.pwr_brd_system_volt = payload.getFloat();
        this.pwr_brd_servo_volt = payload.getFloat();
        this.pwr_brd_digital_volt = payload.getFloat();
        this.pwr_brd_mot_l_amp = payload.getFloat();
        this.pwr_brd_mot_r_amp = payload.getFloat();
        this.pwr_brd_analog_amp = payload.getFloat();
        this.pwr_brd_digital_amp = payload.getFloat();
        this.pwr_brd_ext_amp = payload.getFloat();
        this.pwr_brd_aux_amp = payload.getFloat();
        this.pwr_brd_status = payload.getUnsignedByte();
        this.pwr_brd_led_status = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_sens_power_board() {
        this.msgid = MAVLINK_MSG_ID_SENS_POWER_BOARD;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_sens_power_board( long timestamp, float pwr_brd_system_volt, float pwr_brd_servo_volt, float pwr_brd_digital_volt, float pwr_brd_mot_l_amp, float pwr_brd_mot_r_amp, float pwr_brd_analog_amp, float pwr_brd_digital_amp, float pwr_brd_ext_amp, float pwr_brd_aux_amp, short pwr_brd_status, short pwr_brd_led_status) {
        this.msgid = MAVLINK_MSG_ID_SENS_POWER_BOARD;

        this.timestamp = timestamp;
        this.pwr_brd_system_volt = pwr_brd_system_volt;
        this.pwr_brd_servo_volt = pwr_brd_servo_volt;
        this.pwr_brd_digital_volt = pwr_brd_digital_volt;
        this.pwr_brd_mot_l_amp = pwr_brd_mot_l_amp;
        this.pwr_brd_mot_r_amp = pwr_brd_mot_r_amp;
        this.pwr_brd_analog_amp = pwr_brd_analog_amp;
        this.pwr_brd_digital_amp = pwr_brd_digital_amp;
        this.pwr_brd_ext_amp = pwr_brd_ext_amp;
        this.pwr_brd_aux_amp = pwr_brd_aux_amp;
        this.pwr_brd_status = pwr_brd_status;
        this.pwr_brd_led_status = pwr_brd_led_status;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_sens_power_board( long timestamp, float pwr_brd_system_volt, float pwr_brd_servo_volt, float pwr_brd_digital_volt, float pwr_brd_mot_l_amp, float pwr_brd_mot_r_amp, float pwr_brd_analog_amp, float pwr_brd_digital_amp, float pwr_brd_ext_amp, float pwr_brd_aux_amp, short pwr_brd_status, short pwr_brd_led_status, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_SENS_POWER_BOARD;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.pwr_brd_system_volt = pwr_brd_system_volt;
        this.pwr_brd_servo_volt = pwr_brd_servo_volt;
        this.pwr_brd_digital_volt = pwr_brd_digital_volt;
        this.pwr_brd_mot_l_amp = pwr_brd_mot_l_amp;
        this.pwr_brd_mot_r_amp = pwr_brd_mot_r_amp;
        this.pwr_brd_analog_amp = pwr_brd_analog_amp;
        this.pwr_brd_digital_amp = pwr_brd_digital_amp;
        this.pwr_brd_ext_amp = pwr_brd_ext_amp;
        this.pwr_brd_aux_amp = pwr_brd_aux_amp;
        this.pwr_brd_status = pwr_brd_status;
        this.pwr_brd_led_status = pwr_brd_led_status;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_sens_power_board(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_SENS_POWER_BOARD;

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
        return "MAVLINK_MSG_ID_SENS_POWER_BOARD - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" pwr_brd_system_volt:"+pwr_brd_system_volt+" pwr_brd_servo_volt:"+pwr_brd_servo_volt+" pwr_brd_digital_volt:"+pwr_brd_digital_volt+" pwr_brd_mot_l_amp:"+pwr_brd_mot_l_amp+" pwr_brd_mot_r_amp:"+pwr_brd_mot_r_amp+" pwr_brd_analog_amp:"+pwr_brd_analog_amp+" pwr_brd_digital_amp:"+pwr_brd_digital_amp+" pwr_brd_ext_amp:"+pwr_brd_ext_amp+" pwr_brd_aux_amp:"+pwr_brd_aux_amp+" pwr_brd_status:"+pwr_brd_status+" pwr_brd_led_status:"+pwr_brd_led_status+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_SENS_POWER_BOARD";
    }
}
        