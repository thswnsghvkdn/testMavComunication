/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GIMBAL_DEVICE_SET_ATTITUDE PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Low level message to control a gimbal device's attitude. 
	  This message is to be sent from the gimbal manager to the gimbal device component. 
	  The quaternion and angular velocities can be set to NaN according to use case. 
	  For the angles encoded in the quaternion and the angular velocities holds: 
	  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is set, then they are relative to the vehicle heading (vehicle frame). 
	  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute North (earth frame). 
	  If neither of these flags are set, then (for backwards compatibility) it holds: 
	  If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North (earth frame), 
	  else they are relative to the vehicle heading (vehicle frame). 
	  Setting both GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME and GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is not allowed. 
	  These rules are to ensure backwards compatibility. 
	  New implementations should always set either GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME.
 */
public class msg_gimbal_device_set_attitude extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE = 284;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE;

    
    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the message description. Set fields to NaN to be ignored.
     */
    @Description("Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the message description. Set fields to NaN to be ignored.")
    @Units("")
    public float q[] = new float[4];
    
    /**
     * X component of angular velocity (positive: rolling to the right). The frame is described in the message description. NaN to be ignored.
     */
    @Description("X component of angular velocity (positive: rolling to the right). The frame is described in the message description. NaN to be ignored.")
    @Units("rad/s")
    public float angular_velocity_x;
    
    /**
     * Y component of angular velocity (positive: pitching up). The frame is described in the message description. NaN to be ignored.
     */
    @Description("Y component of angular velocity (positive: pitching up). The frame is described in the message description. NaN to be ignored.")
    @Units("rad/s")
    public float angular_velocity_y;
    
    /**
     * Z component of angular velocity (positive: yawing to the right). The frame is described in the message description. NaN to be ignored.
     */
    @Description("Z component of angular velocity (positive: yawing to the right). The frame is described in the message description. NaN to be ignored.")
    @Units("rad/s")
    public float angular_velocity_z;
    
    /**
     * Low level gimbal flags.
     */
    @Description("Low level gimbal flags.")
    @Units("")
    public int flags;
    
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
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE;

        
        for (int i = 0; i < q.length; i++) {
            packet.payload.putFloat(q[i]);
        }
                    
        packet.payload.putFloat(angular_velocity_x);
        packet.payload.putFloat(angular_velocity_y);
        packet.payload.putFloat(angular_velocity_z);
        packet.payload.putUnsignedShort(flags);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a gimbal_device_set_attitude message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        
        for (int i = 0; i < this.q.length; i++) {
            this.q[i] = payload.getFloat();
        }
                
        this.angular_velocity_x = payload.getFloat();
        this.angular_velocity_y = payload.getFloat();
        this.angular_velocity_z = payload.getFloat();
        this.flags = payload.getUnsignedShort();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_gimbal_device_set_attitude() {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_gimbal_device_set_attitude( float[] q, float angular_velocity_x, float angular_velocity_y, float angular_velocity_z, int flags, short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE;

        this.q = q;
        this.angular_velocity_x = angular_velocity_x;
        this.angular_velocity_y = angular_velocity_y;
        this.angular_velocity_z = angular_velocity_z;
        this.flags = flags;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_gimbal_device_set_attitude( float[] q, float angular_velocity_x, float angular_velocity_y, float angular_velocity_z, int flags, short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.q = q;
        this.angular_velocity_x = angular_velocity_x;
        this.angular_velocity_y = angular_velocity_y;
        this.angular_velocity_z = angular_velocity_z;
        this.flags = flags;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_gimbal_device_set_attitude(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE;

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
        return "MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE - sysid:"+sysid+" compid:"+compid+" q:"+q+" angular_velocity_x:"+angular_velocity_x+" angular_velocity_y:"+angular_velocity_y+" angular_velocity_z:"+angular_velocity_z+" flags:"+flags+" target_system:"+target_system+" target_component:"+target_component+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GIMBAL_DEVICE_SET_ATTITUDE";
    }
}
        