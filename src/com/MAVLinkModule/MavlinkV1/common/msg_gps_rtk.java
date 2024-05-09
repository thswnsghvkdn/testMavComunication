/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GPS_RTK PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting
 */
public class msg_gps_rtk extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GPS_RTK = 127;
    public static final int MAVLINK_MSG_LENGTH = 35;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GPS_RTK;

    
    /**
     * Time since boot of last baseline message received.
     */
    @Description("Time since boot of last baseline message received.")
    @Units("ms")
    public long time_last_baseline_ms;
    
    /**
     * GPS Time of Week of last baseline
     */
    @Description("GPS Time of Week of last baseline")
    @Units("ms")
    public long tow;
    
    /**
     * Current baseline in ECEF x or NED north component.
     */
    @Description("Current baseline in ECEF x or NED north component.")
    @Units("mm")
    public int baseline_a_mm;
    
    /**
     * Current baseline in ECEF y or NED east component.
     */
    @Description("Current baseline in ECEF y or NED east component.")
    @Units("mm")
    public int baseline_b_mm;
    
    /**
     * Current baseline in ECEF z or NED down component.
     */
    @Description("Current baseline in ECEF z or NED down component.")
    @Units("mm")
    public int baseline_c_mm;
    
    /**
     * Current estimate of baseline accuracy.
     */
    @Description("Current estimate of baseline accuracy.")
    @Units("")
    public long accuracy;
    
    /**
     * Current number of integer ambiguity hypotheses.
     */
    @Description("Current number of integer ambiguity hypotheses.")
    @Units("")
    public int iar_num_hypotheses;
    
    /**
     * GPS Week Number of last baseline
     */
    @Description("GPS Week Number of last baseline")
    @Units("")
    public int wn;
    
    /**
     * Identification of connected RTK receiver.
     */
    @Description("Identification of connected RTK receiver.")
    @Units("")
    public short rtk_receiver_id;
    
    /**
     * GPS-specific health report for RTK data.
     */
    @Description("GPS-specific health report for RTK data.")
    @Units("")
    public short rtk_health;
    
    /**
     * Rate of baseline messages being received by GPS
     */
    @Description("Rate of baseline messages being received by GPS")
    @Units("Hz")
    public short rtk_rate;
    
    /**
     * Current number of sats used for RTK calculation.
     */
    @Description("Current number of sats used for RTK calculation.")
    @Units("")
    public short nsats;
    
    /**
     * Coordinate system of baseline
     */
    @Description("Coordinate system of baseline")
    @Units("")
    public short baseline_coords_type;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GPS_RTK;

        packet.payload.putUnsignedInt(time_last_baseline_ms);
        packet.payload.putUnsignedInt(tow);
        packet.payload.putInt(baseline_a_mm);
        packet.payload.putInt(baseline_b_mm);
        packet.payload.putInt(baseline_c_mm);
        packet.payload.putUnsignedInt(accuracy);
        packet.payload.putInt(iar_num_hypotheses);
        packet.payload.putUnsignedShort(wn);
        packet.payload.putUnsignedByte(rtk_receiver_id);
        packet.payload.putUnsignedByte(rtk_health);
        packet.payload.putUnsignedByte(rtk_rate);
        packet.payload.putUnsignedByte(nsats);
        packet.payload.putUnsignedByte(baseline_coords_type);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a gps_rtk message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_last_baseline_ms = payload.getUnsignedInt();
        this.tow = payload.getUnsignedInt();
        this.baseline_a_mm = payload.getInt();
        this.baseline_b_mm = payload.getInt();
        this.baseline_c_mm = payload.getInt();
        this.accuracy = payload.getUnsignedInt();
        this.iar_num_hypotheses = payload.getInt();
        this.wn = payload.getUnsignedShort();
        this.rtk_receiver_id = payload.getUnsignedByte();
        this.rtk_health = payload.getUnsignedByte();
        this.rtk_rate = payload.getUnsignedByte();
        this.nsats = payload.getUnsignedByte();
        this.baseline_coords_type = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_gps_rtk() {
        this.msgid = MAVLINK_MSG_ID_GPS_RTK;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_gps_rtk( long time_last_baseline_ms, long tow, int baseline_a_mm, int baseline_b_mm, int baseline_c_mm, long accuracy, int iar_num_hypotheses, int wn, short rtk_receiver_id, short rtk_health, short rtk_rate, short nsats, short baseline_coords_type) {
        this.msgid = MAVLINK_MSG_ID_GPS_RTK;

        this.time_last_baseline_ms = time_last_baseline_ms;
        this.tow = tow;
        this.baseline_a_mm = baseline_a_mm;
        this.baseline_b_mm = baseline_b_mm;
        this.baseline_c_mm = baseline_c_mm;
        this.accuracy = accuracy;
        this.iar_num_hypotheses = iar_num_hypotheses;
        this.wn = wn;
        this.rtk_receiver_id = rtk_receiver_id;
        this.rtk_health = rtk_health;
        this.rtk_rate = rtk_rate;
        this.nsats = nsats;
        this.baseline_coords_type = baseline_coords_type;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_gps_rtk( long time_last_baseline_ms, long tow, int baseline_a_mm, int baseline_b_mm, int baseline_c_mm, long accuracy, int iar_num_hypotheses, int wn, short rtk_receiver_id, short rtk_health, short rtk_rate, short nsats, short baseline_coords_type, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GPS_RTK;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_last_baseline_ms = time_last_baseline_ms;
        this.tow = tow;
        this.baseline_a_mm = baseline_a_mm;
        this.baseline_b_mm = baseline_b_mm;
        this.baseline_c_mm = baseline_c_mm;
        this.accuracy = accuracy;
        this.iar_num_hypotheses = iar_num_hypotheses;
        this.wn = wn;
        this.rtk_receiver_id = rtk_receiver_id;
        this.rtk_health = rtk_health;
        this.rtk_rate = rtk_rate;
        this.nsats = nsats;
        this.baseline_coords_type = baseline_coords_type;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_gps_rtk(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GPS_RTK;

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
        return "MAVLINK_MSG_ID_GPS_RTK - sysid:"+sysid+" compid:"+compid+" time_last_baseline_ms:"+time_last_baseline_ms+" tow:"+tow+" baseline_a_mm:"+baseline_a_mm+" baseline_b_mm:"+baseline_b_mm+" baseline_c_mm:"+baseline_c_mm+" accuracy:"+accuracy+" iar_num_hypotheses:"+iar_num_hypotheses+" wn:"+wn+" rtk_receiver_id:"+rtk_receiver_id+" rtk_health:"+rtk_health+" rtk_rate:"+rtk_rate+" nsats:"+nsats+" baseline_coords_type:"+baseline_coords_type+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GPS_RTK";
    }
}
        