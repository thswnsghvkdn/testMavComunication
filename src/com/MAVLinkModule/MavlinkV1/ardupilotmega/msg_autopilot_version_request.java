/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AUTOPILOT_VERSION_REQUEST PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Request the autopilot version from the system/component.
 */
public class msg_autopilot_version_request extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST = 183;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;

    
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
        packet.msgid = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;

        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a autopilot_version_request message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_autopilot_version_request() {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_autopilot_version_request( short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;

        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_autopilot_version_request( short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_autopilot_version_request(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;

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
        return "MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST - sysid:"+sysid+" compid:"+compid+" target_system:"+target_system+" target_component:"+target_component+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST";
    }
}
        