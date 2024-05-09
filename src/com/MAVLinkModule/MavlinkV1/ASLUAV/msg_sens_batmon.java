/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SENS_BATMON PACKING
package com.MAVLinkModule.MavlinkV1.ASLUAV;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Battery pack monitoring data for Li-Ion batteries
 */
public class msg_sens_batmon extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SENS_BATMON = 8010;
    public static final int MAVLINK_MSG_LENGTH = 41;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SENS_BATMON;

    
    /**
     * Time since system start
     */
    @Description("Time since system start")
    @Units("us")
    public long batmon_timestamp;
    
    /**
     * Battery pack temperature
     */
    @Description("Battery pack temperature")
    @Units("degC")
    public float temperature;
    
    /**
     * Battery monitor safetystatus report bits in Hex
     */
    @Description("Battery monitor safetystatus report bits in Hex")
    @Units("")
    public long safetystatus;
    
    /**
     * Battery monitor operation status report bits in Hex
     */
    @Description("Battery monitor operation status report bits in Hex")
    @Units("")
    public long operationstatus;
    
    /**
     * Battery pack voltage
     */
    @Description("Battery pack voltage")
    @Units("mV")
    public int voltage;
    
    /**
     * Battery pack current
     */
    @Description("Battery pack current")
    @Units("mA")
    public short current;
    
    /**
     * Battery monitor status report bits in Hex
     */
    @Description("Battery monitor status report bits in Hex")
    @Units("")
    public int batterystatus;
    
    /**
     * Battery monitor serial number in Hex
     */
    @Description("Battery monitor serial number in Hex")
    @Units("")
    public int serialnumber;
    
    /**
     * Battery pack cell 1 voltage
     */
    @Description("Battery pack cell 1 voltage")
    @Units("mV")
    public int cellvoltage1;
    
    /**
     * Battery pack cell 2 voltage
     */
    @Description("Battery pack cell 2 voltage")
    @Units("mV")
    public int cellvoltage2;
    
    /**
     * Battery pack cell 3 voltage
     */
    @Description("Battery pack cell 3 voltage")
    @Units("mV")
    public int cellvoltage3;
    
    /**
     * Battery pack cell 4 voltage
     */
    @Description("Battery pack cell 4 voltage")
    @Units("mV")
    public int cellvoltage4;
    
    /**
     * Battery pack cell 5 voltage
     */
    @Description("Battery pack cell 5 voltage")
    @Units("mV")
    public int cellvoltage5;
    
    /**
     * Battery pack cell 6 voltage
     */
    @Description("Battery pack cell 6 voltage")
    @Units("mV")
    public int cellvoltage6;
    
    /**
     * Battery pack state-of-charge
     */
    @Description("Battery pack state-of-charge")
    @Units("")
    public short SoC;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_SENS_BATMON;

        packet.payload.putUnsignedLong(batmon_timestamp);
        packet.payload.putFloat(temperature);
        packet.payload.putUnsignedInt(safetystatus);
        packet.payload.putUnsignedInt(operationstatus);
        packet.payload.putUnsignedShort(voltage);
        packet.payload.putShort(current);
        packet.payload.putUnsignedShort(batterystatus);
        packet.payload.putUnsignedShort(serialnumber);
        packet.payload.putUnsignedShort(cellvoltage1);
        packet.payload.putUnsignedShort(cellvoltage2);
        packet.payload.putUnsignedShort(cellvoltage3);
        packet.payload.putUnsignedShort(cellvoltage4);
        packet.payload.putUnsignedShort(cellvoltage5);
        packet.payload.putUnsignedShort(cellvoltage6);
        packet.payload.putUnsignedByte(SoC);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a sens_batmon message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.batmon_timestamp = payload.getUnsignedLong();
        this.temperature = payload.getFloat();
        this.safetystatus = payload.getUnsignedInt();
        this.operationstatus = payload.getUnsignedInt();
        this.voltage = payload.getUnsignedShort();
        this.current = payload.getShort();
        this.batterystatus = payload.getUnsignedShort();
        this.serialnumber = payload.getUnsignedShort();
        this.cellvoltage1 = payload.getUnsignedShort();
        this.cellvoltage2 = payload.getUnsignedShort();
        this.cellvoltage3 = payload.getUnsignedShort();
        this.cellvoltage4 = payload.getUnsignedShort();
        this.cellvoltage5 = payload.getUnsignedShort();
        this.cellvoltage6 = payload.getUnsignedShort();
        this.SoC = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_sens_batmon() {
        this.msgid = MAVLINK_MSG_ID_SENS_BATMON;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_sens_batmon( long batmon_timestamp, float temperature, long safetystatus, long operationstatus, int voltage, short current, int batterystatus, int serialnumber, int cellvoltage1, int cellvoltage2, int cellvoltage3, int cellvoltage4, int cellvoltage5, int cellvoltage6, short SoC) {
        this.msgid = MAVLINK_MSG_ID_SENS_BATMON;

        this.batmon_timestamp = batmon_timestamp;
        this.temperature = temperature;
        this.safetystatus = safetystatus;
        this.operationstatus = operationstatus;
        this.voltage = voltage;
        this.current = current;
        this.batterystatus = batterystatus;
        this.serialnumber = serialnumber;
        this.cellvoltage1 = cellvoltage1;
        this.cellvoltage2 = cellvoltage2;
        this.cellvoltage3 = cellvoltage3;
        this.cellvoltage4 = cellvoltage4;
        this.cellvoltage5 = cellvoltage5;
        this.cellvoltage6 = cellvoltage6;
        this.SoC = SoC;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_sens_batmon( long batmon_timestamp, float temperature, long safetystatus, long operationstatus, int voltage, short current, int batterystatus, int serialnumber, int cellvoltage1, int cellvoltage2, int cellvoltage3, int cellvoltage4, int cellvoltage5, int cellvoltage6, short SoC, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_SENS_BATMON;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.batmon_timestamp = batmon_timestamp;
        this.temperature = temperature;
        this.safetystatus = safetystatus;
        this.operationstatus = operationstatus;
        this.voltage = voltage;
        this.current = current;
        this.batterystatus = batterystatus;
        this.serialnumber = serialnumber;
        this.cellvoltage1 = cellvoltage1;
        this.cellvoltage2 = cellvoltage2;
        this.cellvoltage3 = cellvoltage3;
        this.cellvoltage4 = cellvoltage4;
        this.cellvoltage5 = cellvoltage5;
        this.cellvoltage6 = cellvoltage6;
        this.SoC = SoC;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_sens_batmon(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_SENS_BATMON;

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
        return "MAVLINK_MSG_ID_SENS_BATMON - sysid:"+sysid+" compid:"+compid+" batmon_timestamp:"+batmon_timestamp+" temperature:"+temperature+" safetystatus:"+safetystatus+" operationstatus:"+operationstatus+" voltage:"+voltage+" current:"+current+" batterystatus:"+batterystatus+" serialnumber:"+serialnumber+" cellvoltage1:"+cellvoltage1+" cellvoltage2:"+cellvoltage2+" cellvoltage3:"+cellvoltage3+" cellvoltage4:"+cellvoltage4+" cellvoltage5:"+cellvoltage5+" cellvoltage6:"+cellvoltage6+" SoC:"+SoC+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_SENS_BATMON";
    }
}
        