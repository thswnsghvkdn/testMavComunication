/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE TIMESYNC PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * 
        Time synchronization message.
        The message is used for both timesync requests and responses.
        The request is sent with `ts1=syncing component timestamp` and `tc1=0`, and may be broadcast or targeted to a specific system/component.
        The response is sent with `ts1=syncing component timestamp` (mirror back unchanged), and `tc1=responding component timestamp`, with the `target_system` and `target_component` set to ids of the original request.
        Systems can determine if they are receiving a request or response based on the value of `tc`.
        If the response has `target_system==target_component==0` the remote system has not been updated to use the component IDs and cannot reliably timesync; the requestor may report an error.
        Timestamps are UNIX Epoch time or time since system boot in nanoseconds (the timestamp format can be inferred by checking for the magnitude of the number; generally it doesn't matter as only the offset is used).
        The message sequence is repeated numerous times with results being filtered/averaged to estimate the offset.
      
 */
public class msg_timesync extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_TIMESYNC = 111;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = MAVLINK_MSG_ID_TIMESYNC;

    
    /**
     * Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component.
     */
    @Description("Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component.")
    @Units("ns")
    public long tc1;
    
    /**
     * Time sync timestamp 2. Timestamp of syncing component (mirrored in response).
     */
    @Description("Time sync timestamp 2. Timestamp of syncing component (mirrored in response).")
    @Units("ns")
    public long ts1;
    
    /**
     * Target system id. Request: 0 (broadcast) or id of specific system. Response must contain system id of the requesting component.
     */
    @Description("Target system id. Request: 0 (broadcast) or id of specific system. Response must contain system id of the requesting component.")
    @Units("")
    public short target_system;
    
    /**
     * Target component id. Request: 0 (broadcast) or id of specific component. Response must contain component id of the requesting component.
     */
    @Description("Target component id. Request: 0 (broadcast) or id of specific component. Response must contain component id of the requesting component.")
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
        packet.msgid = MAVLINK_MSG_ID_TIMESYNC;

        packet.payload.putLong(tc1);
        packet.payload.putLong(ts1);
        
        if (isMavlink2) {
             packet.payload.putUnsignedByte(target_system);
             packet.payload.putUnsignedByte(target_component);
            
        }
        return packet;
    }

    /**
     * Decode a timesync message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.tc1 = payload.getLong();
        this.ts1 = payload.getLong();
        
        if (isMavlink2) {
             this.target_system = payload.getUnsignedByte();
             this.target_component = payload.getUnsignedByte();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_timesync() {
        this.msgid = MAVLINK_MSG_ID_TIMESYNC;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_timesync( long tc1, long ts1, short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_TIMESYNC;

        this.tc1 = tc1;
        this.ts1 = ts1;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_timesync( long tc1, long ts1, short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_TIMESYNC;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.tc1 = tc1;
        this.ts1 = ts1;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_timesync(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_TIMESYNC;

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
        return "MAVLINK_MSG_ID_TIMESYNC - sysid:"+sysid+" compid:"+compid+" tc1:"+tc1+" ts1:"+ts1+" target_system:"+target_system+" target_component:"+target_component+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_TIMESYNC";
    }
}
        