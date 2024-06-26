/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ARRAY_TEST_4 PACKING
package com.MAVLinkModule.MavlinkV1.python_array_test;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Array test #4.
 */
public class msg_array_test_4 extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_ARRAY_TEST_4 = 17154;
    public static final int MAVLINK_MSG_LENGTH = 17;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ARRAY_TEST_4;

    
    /**
     * Value array
     */
    @Description("Value array")
    @Units("")
    public long ar_u32[] = new long[4];
    
    /**
     * Stub field
     */
    @Description("Stub field")
    @Units("")
    public short v;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_ARRAY_TEST_4;

        
        for (int i = 0; i < ar_u32.length; i++) {
            packet.payload.putUnsignedInt(ar_u32[i]);
        }
                    
        packet.payload.putUnsignedByte(v);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a array_test_4 message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        
        for (int i = 0; i < this.ar_u32.length; i++) {
            this.ar_u32[i] = payload.getUnsignedInt();
        }
                
        this.v = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_array_test_4() {
        this.msgid = MAVLINK_MSG_ID_ARRAY_TEST_4;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_array_test_4( long[] ar_u32, short v) {
        this.msgid = MAVLINK_MSG_ID_ARRAY_TEST_4;

        this.ar_u32 = ar_u32;
        this.v = v;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_array_test_4( long[] ar_u32, short v, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_ARRAY_TEST_4;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.ar_u32 = ar_u32;
        this.v = v;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_array_test_4(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_ARRAY_TEST_4;

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
        return "MAVLINK_MSG_ID_ARRAY_TEST_4 - sysid:"+sysid+" compid:"+compid+" ar_u32:"+ar_u32+" v:"+v+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_ARRAY_TEST_4";
    }
}
        