/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GIMBAL_CONTROL PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Control message for rate gimbal.
 */
public class msg_gimbal_control extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GIMBAL_CONTROL = 201;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GIMBAL_CONTROL;

    
    /**
     * Demanded angular rate X.
     */
    @Description("Demanded angular rate X.")
    @Units("rad/s")
    public float demanded_rate_x;
    
    /**
     * Demanded angular rate Y.
     */
    @Description("Demanded angular rate Y.")
    @Units("rad/s")
    public float demanded_rate_y;
    
    /**
     * Demanded angular rate Z.
     */
    @Description("Demanded angular rate Z.")
    @Units("rad/s")
    public float demanded_rate_z;
    
    /**
     * System ID.
     */
    @Description("System ID.")
    @Units("")
    public short target_system;
    
    /**
     * Component ID.
     */
    @Description("Component ID.")
    @Units("")
    public short target_component;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GIMBAL_CONTROL;

        packet.payload.putFloat(demanded_rate_x);
        packet.payload.putFloat(demanded_rate_y);
        packet.payload.putFloat(demanded_rate_z);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a gimbal_control message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.demanded_rate_x = payload.getFloat();
        this.demanded_rate_y = payload.getFloat();
        this.demanded_rate_z = payload.getFloat();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_gimbal_control() {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_CONTROL;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_gimbal_control( float demanded_rate_x, float demanded_rate_y, float demanded_rate_z, short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_CONTROL;

        this.demanded_rate_x = demanded_rate_x;
        this.demanded_rate_y = demanded_rate_y;
        this.demanded_rate_z = demanded_rate_z;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_gimbal_control( float demanded_rate_x, float demanded_rate_y, float demanded_rate_z, short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_CONTROL;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.demanded_rate_x = demanded_rate_x;
        this.demanded_rate_y = demanded_rate_y;
        this.demanded_rate_z = demanded_rate_z;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_gimbal_control(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_CONTROL;

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
        return "MAVLINK_MSG_ID_GIMBAL_CONTROL - sysid:"+sysid+" compid:"+compid+" demanded_rate_x:"+demanded_rate_x+" demanded_rate_y:"+demanded_rate_y+" demanded_rate_z:"+demanded_rate_z+" target_system:"+target_system+" target_component:"+target_component+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GIMBAL_CONTROL";
    }
}
        