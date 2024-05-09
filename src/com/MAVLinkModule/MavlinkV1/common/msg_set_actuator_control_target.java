/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SET_ACTUATOR_CONTROL_TARGET PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Set the vehicle attitude and body angular rates.
 */
public class msg_set_actuator_control_target extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET = 139;
    public static final int MAVLINK_MSG_LENGTH = 43;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;

    
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    @Description("Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.")
    @Units("us")
    public long time_usec;
    
    /**
     * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs.
     */
    @Description("Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs.")
    @Units("")
    public float controls[] = new float[8];
    
    /**
     * Actuator group. The '_mlx' indicates this is a multi-instance message and a MAVLink parser should use this field to difference between instances.
     */
    @Description("Actuator group. The '_mlx' indicates this is a multi-instance message and a MAVLink parser should use this field to difference between instances.")
    @Units("")
    public short group_mlx;
    
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
        packet.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;

        packet.payload.putUnsignedLong(time_usec);
        
        for (int i = 0; i < controls.length; i++) {
            packet.payload.putFloat(controls[i]);
        }
                    
        packet.payload.putUnsignedByte(group_mlx);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a set_actuator_control_target message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_usec = payload.getUnsignedLong();
        
        for (int i = 0; i < this.controls.length; i++) {
            this.controls[i] = payload.getFloat();
        }
                
        this.group_mlx = payload.getUnsignedByte();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_set_actuator_control_target() {
        this.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_set_actuator_control_target( long time_usec, float[] controls, short group_mlx, short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;

        this.time_usec = time_usec;
        this.controls = controls;
        this.group_mlx = group_mlx;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_set_actuator_control_target( long time_usec, float[] controls, short group_mlx, short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.controls = controls;
        this.group_mlx = group_mlx;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_set_actuator_control_target(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;

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
        return "MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" controls:"+controls+" group_mlx:"+group_mlx+" target_system:"+target_system+" target_component:"+target_component+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET";
    }
}
        