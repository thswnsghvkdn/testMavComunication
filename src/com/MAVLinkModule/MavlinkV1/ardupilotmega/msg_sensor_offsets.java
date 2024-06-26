/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SENSOR_OFFSETS PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Offsets and calibrations values for hardware sensors. This makes it easier to debug the calibration process.
 */
public class msg_sensor_offsets extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SENSOR_OFFSETS = 150;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SENSOR_OFFSETS;

    
    /**
     * Magnetic declination.
     */
    @Description("Magnetic declination.")
    @Units("rad")
    public float mag_declination;
    
    /**
     * Raw pressure from barometer.
     */
    @Description("Raw pressure from barometer.")
    @Units("")
    public int raw_press;
    
    /**
     * Raw temperature from barometer.
     */
    @Description("Raw temperature from barometer.")
    @Units("")
    public int raw_temp;
    
    /**
     * Gyro X calibration.
     */
    @Description("Gyro X calibration.")
    @Units("")
    public float gyro_cal_x;
    
    /**
     * Gyro Y calibration.
     */
    @Description("Gyro Y calibration.")
    @Units("")
    public float gyro_cal_y;
    
    /**
     * Gyro Z calibration.
     */
    @Description("Gyro Z calibration.")
    @Units("")
    public float gyro_cal_z;
    
    /**
     * Accel X calibration.
     */
    @Description("Accel X calibration.")
    @Units("")
    public float accel_cal_x;
    
    /**
     * Accel Y calibration.
     */
    @Description("Accel Y calibration.")
    @Units("")
    public float accel_cal_y;
    
    /**
     * Accel Z calibration.
     */
    @Description("Accel Z calibration.")
    @Units("")
    public float accel_cal_z;
    
    /**
     * Magnetometer X offset.
     */
    @Description("Magnetometer X offset.")
    @Units("")
    public short mag_ofs_x;
    
    /**
     * Magnetometer Y offset.
     */
    @Description("Magnetometer Y offset.")
    @Units("")
    public short mag_ofs_y;
    
    /**
     * Magnetometer Z offset.
     */
    @Description("Magnetometer Z offset.")
    @Units("")
    public short mag_ofs_z;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_SENSOR_OFFSETS;

        packet.payload.putFloat(mag_declination);
        packet.payload.putInt(raw_press);
        packet.payload.putInt(raw_temp);
        packet.payload.putFloat(gyro_cal_x);
        packet.payload.putFloat(gyro_cal_y);
        packet.payload.putFloat(gyro_cal_z);
        packet.payload.putFloat(accel_cal_x);
        packet.payload.putFloat(accel_cal_y);
        packet.payload.putFloat(accel_cal_z);
        packet.payload.putShort(mag_ofs_x);
        packet.payload.putShort(mag_ofs_y);
        packet.payload.putShort(mag_ofs_z);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a sensor_offsets message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.mag_declination = payload.getFloat();
        this.raw_press = payload.getInt();
        this.raw_temp = payload.getInt();
        this.gyro_cal_x = payload.getFloat();
        this.gyro_cal_y = payload.getFloat();
        this.gyro_cal_z = payload.getFloat();
        this.accel_cal_x = payload.getFloat();
        this.accel_cal_y = payload.getFloat();
        this.accel_cal_z = payload.getFloat();
        this.mag_ofs_x = payload.getShort();
        this.mag_ofs_y = payload.getShort();
        this.mag_ofs_z = payload.getShort();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_sensor_offsets() {
        this.msgid = MAVLINK_MSG_ID_SENSOR_OFFSETS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_sensor_offsets( float mag_declination, int raw_press, int raw_temp, float gyro_cal_x, float gyro_cal_y, float gyro_cal_z, float accel_cal_x, float accel_cal_y, float accel_cal_z, short mag_ofs_x, short mag_ofs_y, short mag_ofs_z) {
        this.msgid = MAVLINK_MSG_ID_SENSOR_OFFSETS;

        this.mag_declination = mag_declination;
        this.raw_press = raw_press;
        this.raw_temp = raw_temp;
        this.gyro_cal_x = gyro_cal_x;
        this.gyro_cal_y = gyro_cal_y;
        this.gyro_cal_z = gyro_cal_z;
        this.accel_cal_x = accel_cal_x;
        this.accel_cal_y = accel_cal_y;
        this.accel_cal_z = accel_cal_z;
        this.mag_ofs_x = mag_ofs_x;
        this.mag_ofs_y = mag_ofs_y;
        this.mag_ofs_z = mag_ofs_z;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_sensor_offsets( float mag_declination, int raw_press, int raw_temp, float gyro_cal_x, float gyro_cal_y, float gyro_cal_z, float accel_cal_x, float accel_cal_y, float accel_cal_z, short mag_ofs_x, short mag_ofs_y, short mag_ofs_z, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_SENSOR_OFFSETS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.mag_declination = mag_declination;
        this.raw_press = raw_press;
        this.raw_temp = raw_temp;
        this.gyro_cal_x = gyro_cal_x;
        this.gyro_cal_y = gyro_cal_y;
        this.gyro_cal_z = gyro_cal_z;
        this.accel_cal_x = accel_cal_x;
        this.accel_cal_y = accel_cal_y;
        this.accel_cal_z = accel_cal_z;
        this.mag_ofs_x = mag_ofs_x;
        this.mag_ofs_y = mag_ofs_y;
        this.mag_ofs_z = mag_ofs_z;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_sensor_offsets(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_SENSOR_OFFSETS;

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
        return "MAVLINK_MSG_ID_SENSOR_OFFSETS - sysid:"+sysid+" compid:"+compid+" mag_declination:"+mag_declination+" raw_press:"+raw_press+" raw_temp:"+raw_temp+" gyro_cal_x:"+gyro_cal_x+" gyro_cal_y:"+gyro_cal_y+" gyro_cal_z:"+gyro_cal_z+" accel_cal_x:"+accel_cal_x+" accel_cal_y:"+accel_cal_y+" accel_cal_z:"+accel_cal_z+" mag_ofs_x:"+mag_ofs_x+" mag_ofs_y:"+mag_ofs_y+" mag_ofs_z:"+mag_ofs_z+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_SENSOR_OFFSETS";
    }
}
        