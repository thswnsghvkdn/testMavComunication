/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE MAG_CAL_REPORT PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Reports results of completed compass calibration. Sent until MAG_CAL_ACK received.
 */
public class msg_mag_cal_report extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_MAG_CAL_REPORT = 192;
    public static final int MAVLINK_MSG_LENGTH = 54;
    private static final long serialVersionUID = MAVLINK_MSG_ID_MAG_CAL_REPORT;

    
    /**
     * RMS milligauss residuals.
     */
    @Description("RMS milligauss residuals.")
    @Units("mgauss")
    public float fitness;
    
    /**
     * X offset.
     */
    @Description("X offset.")
    @Units("")
    public float ofs_x;
    
    /**
     * Y offset.
     */
    @Description("Y offset.")
    @Units("")
    public float ofs_y;
    
    /**
     * Z offset.
     */
    @Description("Z offset.")
    @Units("")
    public float ofs_z;
    
    /**
     * X diagonal (matrix 11).
     */
    @Description("X diagonal (matrix 11).")
    @Units("")
    public float diag_x;
    
    /**
     * Y diagonal (matrix 22).
     */
    @Description("Y diagonal (matrix 22).")
    @Units("")
    public float diag_y;
    
    /**
     * Z diagonal (matrix 33).
     */
    @Description("Z diagonal (matrix 33).")
    @Units("")
    public float diag_z;
    
    /**
     * X off-diagonal (matrix 12 and 21).
     */
    @Description("X off-diagonal (matrix 12 and 21).")
    @Units("")
    public float offdiag_x;
    
    /**
     * Y off-diagonal (matrix 13 and 31).
     */
    @Description("Y off-diagonal (matrix 13 and 31).")
    @Units("")
    public float offdiag_y;
    
    /**
     * Z off-diagonal (matrix 32 and 23).
     */
    @Description("Z off-diagonal (matrix 32 and 23).")
    @Units("")
    public float offdiag_z;
    
    /**
     * Compass being calibrated.
     */
    @Description("Compass being calibrated.")
    @Units("")
    public short compass_id;
    
    /**
     * Bitmask of compasses being calibrated.
     */
    @Description("Bitmask of compasses being calibrated.")
    @Units("")
    public short cal_mask;
    
    /**
     * Calibration Status.
     */
    @Description("Calibration Status.")
    @Units("")
    public short cal_status;
    
    /**
     * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters.
     */
    @Description("0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters.")
    @Units("")
    public short autosaved;
    
    /**
     * Confidence in orientation (higher is better).
     */
    @Description("Confidence in orientation (higher is better).")
    @Units("")
    public float orientation_confidence;
    
    /**
     * orientation before calibration.
     */
    @Description("orientation before calibration.")
    @Units("")
    public short old_orientation;
    
    /**
     * orientation after calibration.
     */
    @Description("orientation after calibration.")
    @Units("")
    public short new_orientation;
    
    /**
     * field radius correction factor
     */
    @Description("field radius correction factor")
    @Units("")
    public float scale_factor;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_MAG_CAL_REPORT;

        packet.payload.putFloat(fitness);
        packet.payload.putFloat(ofs_x);
        packet.payload.putFloat(ofs_y);
        packet.payload.putFloat(ofs_z);
        packet.payload.putFloat(diag_x);
        packet.payload.putFloat(diag_y);
        packet.payload.putFloat(diag_z);
        packet.payload.putFloat(offdiag_x);
        packet.payload.putFloat(offdiag_y);
        packet.payload.putFloat(offdiag_z);
        packet.payload.putUnsignedByte(compass_id);
        packet.payload.putUnsignedByte(cal_mask);
        packet.payload.putUnsignedByte(cal_status);
        packet.payload.putUnsignedByte(autosaved);
        
        if (isMavlink2) {
             packet.payload.putFloat(orientation_confidence);
             packet.payload.putUnsignedByte(old_orientation);
             packet.payload.putUnsignedByte(new_orientation);
             packet.payload.putFloat(scale_factor);
            
        }
        return packet;
    }

    /**
     * Decode a mag_cal_report message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.fitness = payload.getFloat();
        this.ofs_x = payload.getFloat();
        this.ofs_y = payload.getFloat();
        this.ofs_z = payload.getFloat();
        this.diag_x = payload.getFloat();
        this.diag_y = payload.getFloat();
        this.diag_z = payload.getFloat();
        this.offdiag_x = payload.getFloat();
        this.offdiag_y = payload.getFloat();
        this.offdiag_z = payload.getFloat();
        this.compass_id = payload.getUnsignedByte();
        this.cal_mask = payload.getUnsignedByte();
        this.cal_status = payload.getUnsignedByte();
        this.autosaved = payload.getUnsignedByte();
        
        if (isMavlink2) {
             this.orientation_confidence = payload.getFloat();
             this.old_orientation = payload.getUnsignedByte();
             this.new_orientation = payload.getUnsignedByte();
             this.scale_factor = payload.getFloat();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_mag_cal_report() {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_REPORT;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_mag_cal_report( float fitness, float ofs_x, float ofs_y, float ofs_z, float diag_x, float diag_y, float diag_z, float offdiag_x, float offdiag_y, float offdiag_z, short compass_id, short cal_mask, short cal_status, short autosaved, float orientation_confidence, short old_orientation, short new_orientation, float scale_factor) {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_REPORT;

        this.fitness = fitness;
        this.ofs_x = ofs_x;
        this.ofs_y = ofs_y;
        this.ofs_z = ofs_z;
        this.diag_x = diag_x;
        this.diag_y = diag_y;
        this.diag_z = diag_z;
        this.offdiag_x = offdiag_x;
        this.offdiag_y = offdiag_y;
        this.offdiag_z = offdiag_z;
        this.compass_id = compass_id;
        this.cal_mask = cal_mask;
        this.cal_status = cal_status;
        this.autosaved = autosaved;
        this.orientation_confidence = orientation_confidence;
        this.old_orientation = old_orientation;
        this.new_orientation = new_orientation;
        this.scale_factor = scale_factor;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_mag_cal_report( float fitness, float ofs_x, float ofs_y, float ofs_z, float diag_x, float diag_y, float diag_z, float offdiag_x, float offdiag_y, float offdiag_z, short compass_id, short cal_mask, short cal_status, short autosaved, float orientation_confidence, short old_orientation, short new_orientation, float scale_factor, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_REPORT;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.fitness = fitness;
        this.ofs_x = ofs_x;
        this.ofs_y = ofs_y;
        this.ofs_z = ofs_z;
        this.diag_x = diag_x;
        this.diag_y = diag_y;
        this.diag_z = diag_z;
        this.offdiag_x = offdiag_x;
        this.offdiag_y = offdiag_y;
        this.offdiag_z = offdiag_z;
        this.compass_id = compass_id;
        this.cal_mask = cal_mask;
        this.cal_status = cal_status;
        this.autosaved = autosaved;
        this.orientation_confidence = orientation_confidence;
        this.old_orientation = old_orientation;
        this.new_orientation = new_orientation;
        this.scale_factor = scale_factor;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_mag_cal_report(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_REPORT;

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
        return "MAVLINK_MSG_ID_MAG_CAL_REPORT - sysid:"+sysid+" compid:"+compid+" fitness:"+fitness+" ofs_x:"+ofs_x+" ofs_y:"+ofs_y+" ofs_z:"+ofs_z+" diag_x:"+diag_x+" diag_y:"+diag_y+" diag_z:"+diag_z+" offdiag_x:"+offdiag_x+" offdiag_y:"+offdiag_y+" offdiag_z:"+offdiag_z+" compass_id:"+compass_id+" cal_mask:"+cal_mask+" cal_status:"+cal_status+" autosaved:"+autosaved+" orientation_confidence:"+orientation_confidence+" old_orientation:"+old_orientation+" new_orientation:"+new_orientation+" scale_factor:"+scale_factor+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_MAG_CAL_REPORT";
    }
}
        