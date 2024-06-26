/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ISBD_LINK_STATUS PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Status of the Iridium SBD link.
 */
public class msg_isbd_link_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_ISBD_LINK_STATUS = 335;
    public static final int MAVLINK_MSG_LENGTH = 24;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ISBD_LINK_STATUS;

    
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    @Description("Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.")
    @Units("us")
    public long timestamp;
    
    /**
     * Timestamp of the last successful sbd session. The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    @Description("Timestamp of the last successful sbd session. The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.")
    @Units("us")
    public long last_heartbeat;
    
    /**
     * Number of failed SBD sessions.
     */
    @Description("Number of failed SBD sessions.")
    @Units("")
    public int failed_sessions;
    
    /**
     * Number of successful SBD sessions.
     */
    @Description("Number of successful SBD sessions.")
    @Units("")
    public int successful_sessions;
    
    /**
     * Signal quality equal to the number of bars displayed on the ISU signal strength indicator. Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength.
     */
    @Description("Signal quality equal to the number of bars displayed on the ISU signal strength indicator. Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength.")
    @Units("")
    public short signal_quality;
    
    /**
     * 1: Ring call pending, 0: No call pending.
     */
    @Description("1: Ring call pending, 0: No call pending.")
    @Units("")
    public short ring_pending;
    
    /**
     * 1: Transmission session pending, 0: No transmission session pending.
     */
    @Description("1: Transmission session pending, 0: No transmission session pending.")
    @Units("")
    public short tx_session_pending;
    
    /**
     * 1: Receiving session pending, 0: No receiving session pending.
     */
    @Description("1: Receiving session pending, 0: No receiving session pending.")
    @Units("")
    public short rx_session_pending;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_ISBD_LINK_STATUS;

        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putUnsignedLong(last_heartbeat);
        packet.payload.putUnsignedShort(failed_sessions);
        packet.payload.putUnsignedShort(successful_sessions);
        packet.payload.putUnsignedByte(signal_quality);
        packet.payload.putUnsignedByte(ring_pending);
        packet.payload.putUnsignedByte(tx_session_pending);
        packet.payload.putUnsignedByte(rx_session_pending);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a isbd_link_status message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.timestamp = payload.getUnsignedLong();
        this.last_heartbeat = payload.getUnsignedLong();
        this.failed_sessions = payload.getUnsignedShort();
        this.successful_sessions = payload.getUnsignedShort();
        this.signal_quality = payload.getUnsignedByte();
        this.ring_pending = payload.getUnsignedByte();
        this.tx_session_pending = payload.getUnsignedByte();
        this.rx_session_pending = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_isbd_link_status() {
        this.msgid = MAVLINK_MSG_ID_ISBD_LINK_STATUS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_isbd_link_status( long timestamp, long last_heartbeat, int failed_sessions, int successful_sessions, short signal_quality, short ring_pending, short tx_session_pending, short rx_session_pending) {
        this.msgid = MAVLINK_MSG_ID_ISBD_LINK_STATUS;

        this.timestamp = timestamp;
        this.last_heartbeat = last_heartbeat;
        this.failed_sessions = failed_sessions;
        this.successful_sessions = successful_sessions;
        this.signal_quality = signal_quality;
        this.ring_pending = ring_pending;
        this.tx_session_pending = tx_session_pending;
        this.rx_session_pending = rx_session_pending;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_isbd_link_status( long timestamp, long last_heartbeat, int failed_sessions, int successful_sessions, short signal_quality, short ring_pending, short tx_session_pending, short rx_session_pending, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_ISBD_LINK_STATUS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.last_heartbeat = last_heartbeat;
        this.failed_sessions = failed_sessions;
        this.successful_sessions = successful_sessions;
        this.signal_quality = signal_quality;
        this.ring_pending = ring_pending;
        this.tx_session_pending = tx_session_pending;
        this.rx_session_pending = rx_session_pending;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_isbd_link_status(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_ISBD_LINK_STATUS;

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
        return "MAVLINK_MSG_ID_ISBD_LINK_STATUS - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" last_heartbeat:"+last_heartbeat+" failed_sessions:"+failed_sessions+" successful_sessions:"+successful_sessions+" signal_quality:"+signal_quality+" ring_pending:"+ring_pending+" tx_session_pending:"+tx_session_pending+" rx_session_pending:"+rx_session_pending+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_ISBD_LINK_STATUS";
    }
}
        