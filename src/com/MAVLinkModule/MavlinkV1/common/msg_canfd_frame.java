/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE CANFD_FRAME PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * A forwarded CANFD frame as requested by MAV_CMD_CAN_FORWARD. These are separated from CAN_FRAME as they need different handling (eg. TAO handling)
 */
public class msg_canfd_frame extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_CANFD_FRAME = 387;
    public static final int MAVLINK_MSG_LENGTH = 72;
    private static final long serialVersionUID = MAVLINK_MSG_ID_CANFD_FRAME;

    
    /**
     * Frame ID
     */
    @Description("Frame ID")
    @Units("")
    public long id;
    
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
     * bus number
     */
    @Description("bus number")
    @Units("")
    public short bus;
    
    /**
     * Frame length
     */
    @Description("Frame length")
    @Units("")
    public short len;
    
    /**
     * Frame data
     */
    @Description("Frame data")
    @Units("")
    public short data[] = new short[64];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_CANFD_FRAME;

        packet.payload.putUnsignedInt(id);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(bus);
        packet.payload.putUnsignedByte(len);
        
        for (int i = 0; i < data.length; i++) {
            packet.payload.putUnsignedByte(data[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a canfd_frame message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.id = payload.getUnsignedInt();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.bus = payload.getUnsignedByte();
        this.len = payload.getUnsignedByte();
        
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = payload.getUnsignedByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_canfd_frame() {
        this.msgid = MAVLINK_MSG_ID_CANFD_FRAME;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_canfd_frame( long id, short target_system, short target_component, short bus, short len, short[] data) {
        this.msgid = MAVLINK_MSG_ID_CANFD_FRAME;

        this.id = id;
        this.target_system = target_system;
        this.target_component = target_component;
        this.bus = bus;
        this.len = len;
        this.data = data;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_canfd_frame( long id, short target_system, short target_component, short bus, short len, short[] data, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_CANFD_FRAME;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.id = id;
        this.target_system = target_system;
        this.target_component = target_component;
        this.bus = bus;
        this.len = len;
        this.data = data;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_canfd_frame(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_CANFD_FRAME;

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
        return "MAVLINK_MSG_ID_CANFD_FRAME - sysid:"+sysid+" compid:"+compid+" id:"+id+" target_system:"+target_system+" target_component:"+target_component+" bus:"+bus+" len:"+len+" data:"+data+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_CANFD_FRAME";
    }
}
        