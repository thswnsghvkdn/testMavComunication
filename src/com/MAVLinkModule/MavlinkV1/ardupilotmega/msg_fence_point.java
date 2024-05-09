/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE FENCE_POINT PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS.
 */
public class msg_fence_point extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_FENCE_POINT = 160;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = MAVLINK_MSG_ID_FENCE_POINT;

    
    /**
     * Latitude of point.
     */
    @Description("Latitude of point.")
    @Units("deg")
    public float lat;
    
    /**
     * Longitude of point.
     */
    @Description("Longitude of point.")
    @Units("deg")
    public float lng;
    
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
     * Point index (first point is 1, 0 is for return point).
     */
    @Description("Point index (first point is 1, 0 is for return point).")
    @Units("")
    public short idx;
    
    /**
     * Total number of points (for sanity checking).
     */
    @Description("Total number of points (for sanity checking).")
    @Units("")
    public short count;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_FENCE_POINT;

        packet.payload.putFloat(lat);
        packet.payload.putFloat(lng);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(idx);
        packet.payload.putUnsignedByte(count);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a fence_point message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.lat = payload.getFloat();
        this.lng = payload.getFloat();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.idx = payload.getUnsignedByte();
        this.count = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_fence_point() {
        this.msgid = MAVLINK_MSG_ID_FENCE_POINT;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_fence_point( float lat, float lng, short target_system, short target_component, short idx, short count) {
        this.msgid = MAVLINK_MSG_ID_FENCE_POINT;

        this.lat = lat;
        this.lng = lng;
        this.target_system = target_system;
        this.target_component = target_component;
        this.idx = idx;
        this.count = count;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_fence_point( float lat, float lng, short target_system, short target_component, short idx, short count, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_FENCE_POINT;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.lat = lat;
        this.lng = lng;
        this.target_system = target_system;
        this.target_component = target_component;
        this.idx = idx;
        this.count = count;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_fence_point(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_FENCE_POINT;

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
        return "MAVLINK_MSG_ID_FENCE_POINT - sysid:"+sysid+" compid:"+compid+" lat:"+lat+" lng:"+lng+" target_system:"+target_system+" target_component:"+target_component+" idx:"+idx+" count:"+count+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_FENCE_POINT";
    }
}
        