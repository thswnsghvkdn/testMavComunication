/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE EXTENDED_SYS_STATE PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Provides state for additional features
 */
public class msg_extended_sys_state extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_EXTENDED_SYS_STATE = 245;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;

    
    /**
     * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL configuration.
     */
    @Description("The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL configuration.")
    @Units("")
    public short vtol_state;
    
    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
     */
    @Description("The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.")
    @Units("")
    public short landed_state;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;

        packet.payload.putUnsignedByte(vtol_state);
        packet.payload.putUnsignedByte(landed_state);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a extended_sys_state message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.vtol_state = payload.getUnsignedByte();
        this.landed_state = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_extended_sys_state() {
        this.msgid = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_extended_sys_state( short vtol_state, short landed_state) {
        this.msgid = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;

        this.vtol_state = vtol_state;
        this.landed_state = landed_state;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_extended_sys_state( short vtol_state, short landed_state, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.vtol_state = vtol_state;
        this.landed_state = landed_state;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_extended_sys_state(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;

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
        return "MAVLINK_MSG_ID_EXTENDED_SYS_STATE - sysid:"+sysid+" compid:"+compid+" vtol_state:"+vtol_state+" landed_state:"+landed_state+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_EXTENDED_SYS_STATE";
    }
}
        