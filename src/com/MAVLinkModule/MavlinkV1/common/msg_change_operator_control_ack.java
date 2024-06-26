/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE CHANGE_OPERATOR_CONTROL_ACK PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Accept / deny control of this MAV
 */
public class msg_change_operator_control_ack extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK = 6;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;

    
    /**
     * ID of the GCS this message 
     */
    @Description("ID of the GCS this message ")
    @Units("")
    public short gcs_system_id;
    
    /**
     * 0: request control of this MAV, 1: Release control of this MAV
     */
    @Description("0: request control of this MAV, 1: Release control of this MAV")
    @Units("")
    public short control_request;
    
    /**
     * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: Already under control
     */
    @Description("0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: Already under control")
    @Units("")
    public short ack;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;

        packet.payload.putUnsignedByte(gcs_system_id);
        packet.payload.putUnsignedByte(control_request);
        packet.payload.putUnsignedByte(ack);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a change_operator_control_ack message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.gcs_system_id = payload.getUnsignedByte();
        this.control_request = payload.getUnsignedByte();
        this.ack = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_change_operator_control_ack() {
        this.msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_change_operator_control_ack( short gcs_system_id, short control_request, short ack) {
        this.msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;

        this.gcs_system_id = gcs_system_id;
        this.control_request = control_request;
        this.ack = ack;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_change_operator_control_ack( short gcs_system_id, short control_request, short ack, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.gcs_system_id = gcs_system_id;
        this.control_request = control_request;
        this.ack = ack;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_change_operator_control_ack(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;

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
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK - sysid:"+sysid+" compid:"+compid+" gcs_system_id:"+gcs_system_id+" control_request:"+control_request+" ack:"+ack+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK";
    }
}
        