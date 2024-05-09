/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AP_ADC PACKING
package com.MAVLinkModule.MavlinkV1.ardupilotmega;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Raw ADC output.
 */
public class msg_ap_adc extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AP_ADC = 153;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AP_ADC;

    
    /**
     * ADC output 1.
     */
    @Description("ADC output 1.")
    @Units("")
    public int adc1;
    
    /**
     * ADC output 2.
     */
    @Description("ADC output 2.")
    @Units("")
    public int adc2;
    
    /**
     * ADC output 3.
     */
    @Description("ADC output 3.")
    @Units("")
    public int adc3;
    
    /**
     * ADC output 4.
     */
    @Description("ADC output 4.")
    @Units("")
    public int adc4;
    
    /**
     * ADC output 5.
     */
    @Description("ADC output 5.")
    @Units("")
    public int adc5;
    
    /**
     * ADC output 6.
     */
    @Description("ADC output 6.")
    @Units("")
    public int adc6;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AP_ADC;

        packet.payload.putUnsignedShort(adc1);
        packet.payload.putUnsignedShort(adc2);
        packet.payload.putUnsignedShort(adc3);
        packet.payload.putUnsignedShort(adc4);
        packet.payload.putUnsignedShort(adc5);
        packet.payload.putUnsignedShort(adc6);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a ap_adc message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.adc1 = payload.getUnsignedShort();
        this.adc2 = payload.getUnsignedShort();
        this.adc3 = payload.getUnsignedShort();
        this.adc4 = payload.getUnsignedShort();
        this.adc5 = payload.getUnsignedShort();
        this.adc6 = payload.getUnsignedShort();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_ap_adc() {
        this.msgid = MAVLINK_MSG_ID_AP_ADC;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_ap_adc( int adc1, int adc2, int adc3, int adc4, int adc5, int adc6) {
        this.msgid = MAVLINK_MSG_ID_AP_ADC;

        this.adc1 = adc1;
        this.adc2 = adc2;
        this.adc3 = adc3;
        this.adc4 = adc4;
        this.adc5 = adc5;
        this.adc6 = adc6;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_ap_adc( int adc1, int adc2, int adc3, int adc4, int adc5, int adc6, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AP_ADC;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.adc1 = adc1;
        this.adc2 = adc2;
        this.adc3 = adc3;
        this.adc4 = adc4;
        this.adc5 = adc5;
        this.adc6 = adc6;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_ap_adc(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AP_ADC;

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
        return "MAVLINK_MSG_ID_AP_ADC - sysid:"+sysid+" compid:"+compid+" adc1:"+adc1+" adc2:"+adc2+" adc3:"+adc3+" adc4:"+adc4+" adc5:"+adc5+" adc6:"+adc6+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AP_ADC";
    }
}
        