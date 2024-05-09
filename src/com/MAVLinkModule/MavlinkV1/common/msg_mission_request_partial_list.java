/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE MISSION_REQUEST_PARTIAL_LIST PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Request a partial list of mission items from the system/component. https://mavlink.io/en/services/mission.html. If start and end index are the same, just send one waypoint.
 */
public class msg_mission_request_partial_list extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST = 37;
    public static final int MAVLINK_MSG_LENGTH = 7;
    private static final long serialVersionUID = MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST;

    
    /**
     * Start index
     */
    @Description("Start index")
    @Units("")
    public short start_index;
    
    /**
     * End index, -1 by default (-1: send list to end). Else a valid index of the list
     */
    @Description("End index, -1 by default (-1: send list to end). Else a valid index of the list")
    @Units("")
    public short end_index;
    
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
     * Mission type.
     */
    @Description("Mission type.")
    @Units("")
    public short mission_type;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST;

        packet.payload.putShort(start_index);
        packet.payload.putShort(end_index);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
             packet.payload.putUnsignedByte(mission_type);
            
        }
        return packet;
    }

    /**
     * Decode a mission_request_partial_list message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.start_index = payload.getShort();
        this.end_index = payload.getShort();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
             this.mission_type = payload.getUnsignedByte();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_mission_request_partial_list() {
        this.msgid = MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_mission_request_partial_list( short start_index, short end_index, short target_system, short target_component, short mission_type) {
        this.msgid = MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST;

        this.start_index = start_index;
        this.end_index = end_index;
        this.target_system = target_system;
        this.target_component = target_component;
        this.mission_type = mission_type;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_mission_request_partial_list( short start_index, short end_index, short target_system, short target_component, short mission_type, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.start_index = start_index;
        this.end_index = end_index;
        this.target_system = target_system;
        this.target_component = target_component;
        this.mission_type = mission_type;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_mission_request_partial_list(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST;

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
        return "MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST - sysid:"+sysid+" compid:"+compid+" start_index:"+start_index+" end_index:"+end_index+" target_system:"+target_system+" target_component:"+target_component+" mission_type:"+mission_type+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST";
    }
}
        