/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AVSS_DRONE_OPERATION_MODE PACKING
package com.MAVLinkModule.MavlinkV1.AVSSUAS;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 *  Drone operation mode.
 */
public class msg_avss_drone_operation_mode extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE = 60053;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE;

    
    /**
     * Timestamp (time since FC boot).
     */
    @Description("Timestamp (time since FC boot).")
    @Units("ms")
    public long time_boot_ms;
    
    /**
     * DJI M300 operation mode
     */
    @Description("DJI M300 operation mode")
    @Units("")
    public short M300_operation_mode;
    
    /**
     * horsefly operation mode
     */
    @Description("horsefly operation mode")
    @Units("")
    public short horsefly_operation_mode;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE;

        packet.payload.putUnsignedInt(time_boot_ms);
        packet.payload.putUnsignedByte(M300_operation_mode);
        packet.payload.putUnsignedByte(horsefly_operation_mode);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a avss_drone_operation_mode message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_boot_ms = payload.getUnsignedInt();
        this.M300_operation_mode = payload.getUnsignedByte();
        this.horsefly_operation_mode = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_avss_drone_operation_mode() {
        this.msgid = MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_avss_drone_operation_mode( long time_boot_ms, short M300_operation_mode, short horsefly_operation_mode) {
        this.msgid = MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE;

        this.time_boot_ms = time_boot_ms;
        this.M300_operation_mode = M300_operation_mode;
        this.horsefly_operation_mode = horsefly_operation_mode;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_avss_drone_operation_mode( long time_boot_ms, short M300_operation_mode, short horsefly_operation_mode, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_boot_ms = time_boot_ms;
        this.M300_operation_mode = M300_operation_mode;
        this.horsefly_operation_mode = horsefly_operation_mode;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_avss_drone_operation_mode(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE;

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
        return "MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE - sysid:"+sysid+" compid:"+compid+" time_boot_ms:"+time_boot_ms+" M300_operation_mode:"+M300_operation_mode+" horsefly_operation_mode:"+horsefly_operation_mode+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AVSS_DRONE_OPERATION_MODE";
    }
}
        