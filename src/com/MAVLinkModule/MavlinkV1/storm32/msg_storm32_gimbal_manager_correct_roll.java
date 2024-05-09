/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE STORM32_GIMBAL_MANAGER_CORRECT_ROLL PACKING
package com.MAVLinkModule.MavlinkV1.storm32;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Message to a gimbal manager to correct the gimbal roll angle. This message is typically used to manually correct for a tilted horizon in operation. A gimbal device is never to react to this message.
 */
public class msg_storm32_gimbal_manager_correct_roll extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL = 60014;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL;

    
    /**
     * Roll angle (positive to roll to the right).
     */
    @Description("Roll angle (positive to roll to the right).")
    @Units("rad")
    public float roll;
    
    /**
     * System ID
     */
    @Description("System ID")
    @Units("")
    public short target_system;
    
    /**
     * Component ID
     */
    @Description("Component ID")
    @Units("")
    public short target_component;
    
    /**
     * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals.
     */
    @Description("Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals.")
    @Units("")
    public short gimbal_id;
    
    /**
     * Client which is contacting the gimbal manager (must be set).
     */
    @Description("Client which is contacting the gimbal manager (must be set).")
    @Units("")
    public short client;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL;

        packet.payload.putFloat(roll);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(gimbal_id);
        packet.payload.putUnsignedByte(client);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a storm32_gimbal_manager_correct_roll message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.roll = payload.getFloat();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.gimbal_id = payload.getUnsignedByte();
        this.client = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_storm32_gimbal_manager_correct_roll() {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_storm32_gimbal_manager_correct_roll( float roll, short target_system, short target_component, short gimbal_id, short client) {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL;

        this.roll = roll;
        this.target_system = target_system;
        this.target_component = target_component;
        this.gimbal_id = gimbal_id;
        this.client = client;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_storm32_gimbal_manager_correct_roll( float roll, short target_system, short target_component, short gimbal_id, short client, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.roll = roll;
        this.target_system = target_system;
        this.target_component = target_component;
        this.gimbal_id = gimbal_id;
        this.client = client;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_storm32_gimbal_manager_correct_roll(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL;

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
        return "MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL - sysid:"+sysid+" compid:"+compid+" roll:"+roll+" target_system:"+target_system+" target_component:"+target_component+" gimbal_id:"+gimbal_id+" client:"+client+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_CORRECT_ROLL";
    }
}
        