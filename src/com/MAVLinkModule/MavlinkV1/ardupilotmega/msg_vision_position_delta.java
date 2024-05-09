/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE VISION_POSITION_DELTA PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Camera vision based attitude and position deltas.
 */
public class msg_vision_position_delta extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_VISION_POSITION_DELTA = 11011;
    public static final int MAVLINK_MSG_LENGTH = 44;
    private static final long serialVersionUID = MAVLINK_MSG_ID_VISION_POSITION_DELTA;

    
    /**
     * Timestamp (synced to UNIX time or since system boot).
     */
    @Description("Timestamp (synced to UNIX time or since system boot).")
    @Units("us")
    public long time_usec;
    
    /**
     * Time since the last reported camera frame.
     */
    @Description("Time since the last reported camera frame.")
    @Units("us")
    public long time_delta_usec;
    
    /**
     * Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the previous MAV_FRAME_BODY_FRD.
     */
    @Description("Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the previous MAV_FRAME_BODY_FRD.")
    @Units("rad")
    public float angle_delta[] = new float[3];
    
    /**
     * Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated to the current MAV_FRAME_BODY_FRD.
     */
    @Description("Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated to the current MAV_FRAME_BODY_FRD.")
    @Units("m")
    public float position_delta[] = new float[3];
    
    /**
     * Normalised confidence value from 0 to 100.
     */
    @Description("Normalised confidence value from 0 to 100.")
    @Units("%")
    public float confidence;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_VISION_POSITION_DELTA;

        packet.payload.putUnsignedLong(time_usec);
        packet.payload.putUnsignedLong(time_delta_usec);
        
        for (int i = 0; i < angle_delta.length; i++) {
            packet.payload.putFloat(angle_delta[i]);
        }
                    
        
        for (int i = 0; i < position_delta.length; i++) {
            packet.payload.putFloat(position_delta[i]);
        }
                    
        packet.payload.putFloat(confidence);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a vision_position_delta message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_usec = payload.getUnsignedLong();
        this.time_delta_usec = payload.getUnsignedLong();
        
        for (int i = 0; i < this.angle_delta.length; i++) {
            this.angle_delta[i] = payload.getFloat();
        }
                
        
        for (int i = 0; i < this.position_delta.length; i++) {
            this.position_delta[i] = payload.getFloat();
        }
                
        this.confidence = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_vision_position_delta() {
        this.msgid = MAVLINK_MSG_ID_VISION_POSITION_DELTA;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_vision_position_delta( long time_usec, long time_delta_usec, float[] angle_delta, float[] position_delta, float confidence) {
        this.msgid = MAVLINK_MSG_ID_VISION_POSITION_DELTA;

        this.time_usec = time_usec;
        this.time_delta_usec = time_delta_usec;
        this.angle_delta = angle_delta;
        this.position_delta = position_delta;
        this.confidence = confidence;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_vision_position_delta( long time_usec, long time_delta_usec, float[] angle_delta, float[] position_delta, float confidence, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_VISION_POSITION_DELTA;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.time_delta_usec = time_delta_usec;
        this.angle_delta = angle_delta;
        this.position_delta = position_delta;
        this.confidence = confidence;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_vision_position_delta(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_VISION_POSITION_DELTA;

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
        return "MAVLINK_MSG_ID_VISION_POSITION_DELTA - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" time_delta_usec:"+time_delta_usec+" angle_delta:"+angle_delta+" position_delta:"+position_delta+" confidence:"+confidence+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_VISION_POSITION_DELTA";
    }
}
        