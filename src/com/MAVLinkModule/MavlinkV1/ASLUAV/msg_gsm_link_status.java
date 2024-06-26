/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GSM_LINK_STATUS PACKING
package com.MAVLinkModule.MavlinkV1.ASLUAV;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Status of GSM modem (connected to onboard computer)
 */
public class msg_gsm_link_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GSM_LINK_STATUS = 8014;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GSM_LINK_STATUS;

    
    /**
     * Timestamp (of OBC)
     */
    @Description("Timestamp (of OBC)")
    @Units("us")
    public long timestamp;
    
    /**
     * GSM modem used
     */
    @Description("GSM modem used")
    @Units("")
    public short gsm_modem_type;
    
    /**
     * GSM link type
     */
    @Description("GSM link type")
    @Units("")
    public short gsm_link_type;
    
    /**
     * RSSI as reported by modem (unconverted)
     */
    @Description("RSSI as reported by modem (unconverted)")
    @Units("")
    public short rssi;
    
    /**
     * RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)
     */
    @Description("RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)")
    @Units("")
    public short rsrp_rscp;
    
    /**
     * SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)
     */
    @Description("SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)")
    @Units("")
    public short sinr_ecio;
    
    /**
     * RSRQ (LTE only) as reported by modem (unconverted)
     */
    @Description("RSRQ (LTE only) as reported by modem (unconverted)")
    @Units("")
    public short rsrq;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GSM_LINK_STATUS;

        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putUnsignedByte(gsm_modem_type);
        packet.payload.putUnsignedByte(gsm_link_type);
        packet.payload.putUnsignedByte(rssi);
        packet.payload.putUnsignedByte(rsrp_rscp);
        packet.payload.putUnsignedByte(sinr_ecio);
        packet.payload.putUnsignedByte(rsrq);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a gsm_link_status message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.timestamp = payload.getUnsignedLong();
        this.gsm_modem_type = payload.getUnsignedByte();
        this.gsm_link_type = payload.getUnsignedByte();
        this.rssi = payload.getUnsignedByte();
        this.rsrp_rscp = payload.getUnsignedByte();
        this.sinr_ecio = payload.getUnsignedByte();
        this.rsrq = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_gsm_link_status() {
        this.msgid = MAVLINK_MSG_ID_GSM_LINK_STATUS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_gsm_link_status( long timestamp, short gsm_modem_type, short gsm_link_type, short rssi, short rsrp_rscp, short sinr_ecio, short rsrq) {
        this.msgid = MAVLINK_MSG_ID_GSM_LINK_STATUS;

        this.timestamp = timestamp;
        this.gsm_modem_type = gsm_modem_type;
        this.gsm_link_type = gsm_link_type;
        this.rssi = rssi;
        this.rsrp_rscp = rsrp_rscp;
        this.sinr_ecio = sinr_ecio;
        this.rsrq = rsrq;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_gsm_link_status( long timestamp, short gsm_modem_type, short gsm_link_type, short rssi, short rsrp_rscp, short sinr_ecio, short rsrq, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GSM_LINK_STATUS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.gsm_modem_type = gsm_modem_type;
        this.gsm_link_type = gsm_link_type;
        this.rssi = rssi;
        this.rsrp_rscp = rsrp_rscp;
        this.sinr_ecio = sinr_ecio;
        this.rsrq = rsrq;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_gsm_link_status(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GSM_LINK_STATUS;

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
        return "MAVLINK_MSG_ID_GSM_LINK_STATUS - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" gsm_modem_type:"+gsm_modem_type+" gsm_link_type:"+gsm_link_type+" rssi:"+rssi+" rsrp_rscp:"+rsrp_rscp+" sinr_ecio:"+sinr_ecio+" rsrq:"+rsrq+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GSM_LINK_STATUS";
    }
}
        