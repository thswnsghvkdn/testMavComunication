/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE TERRAIN_REPORT PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Streamed from drone to report progress of terrain map download (initiated by TERRAIN_REQUEST), or sent as a response to a TERRAIN_CHECK request. See terrain protocol docs: https://mavlink.io/en/services/terrain.html
 */
public class msg_terrain_report extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_TERRAIN_REPORT = 136;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = MAVLINK_MSG_ID_TERRAIN_REPORT;

    
    /**
     * Latitude
     */
    @Description("Latitude")
    @Units("degE7")
    public int lat;
    
    /**
     * Longitude
     */
    @Description("Longitude")
    @Units("degE7")
    public int lon;
    
    /**
     * Terrain height MSL
     */
    @Description("Terrain height MSL")
    @Units("m")
    public float terrain_height;
    
    /**
     * Current vehicle height above lat/lon terrain height
     */
    @Description("Current vehicle height above lat/lon terrain height")
    @Units("m")
    public float current_height;
    
    /**
     * grid spacing (zero if terrain at this location unavailable)
     */
    @Description("grid spacing (zero if terrain at this location unavailable)")
    @Units("")
    public int spacing;
    
    /**
     * Number of 4x4 terrain blocks waiting to be received or read from disk
     */
    @Description("Number of 4x4 terrain blocks waiting to be received or read from disk")
    @Units("")
    public int pending;
    
    /**
     * Number of 4x4 terrain blocks in memory
     */
    @Description("Number of 4x4 terrain blocks in memory")
    @Units("")
    public int loaded;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_TERRAIN_REPORT;

        packet.payload.putInt(lat);
        packet.payload.putInt(lon);
        packet.payload.putFloat(terrain_height);
        packet.payload.putFloat(current_height);
        packet.payload.putUnsignedShort(spacing);
        packet.payload.putUnsignedShort(pending);
        packet.payload.putUnsignedShort(loaded);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a terrain_report message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.lat = payload.getInt();
        this.lon = payload.getInt();
        this.terrain_height = payload.getFloat();
        this.current_height = payload.getFloat();
        this.spacing = payload.getUnsignedShort();
        this.pending = payload.getUnsignedShort();
        this.loaded = payload.getUnsignedShort();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_terrain_report() {
        this.msgid = MAVLINK_MSG_ID_TERRAIN_REPORT;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_terrain_report( int lat, int lon, float terrain_height, float current_height, int spacing, int pending, int loaded) {
        this.msgid = MAVLINK_MSG_ID_TERRAIN_REPORT;

        this.lat = lat;
        this.lon = lon;
        this.terrain_height = terrain_height;
        this.current_height = current_height;
        this.spacing = spacing;
        this.pending = pending;
        this.loaded = loaded;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_terrain_report( int lat, int lon, float terrain_height, float current_height, int spacing, int pending, int loaded, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_TERRAIN_REPORT;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.lat = lat;
        this.lon = lon;
        this.terrain_height = terrain_height;
        this.current_height = current_height;
        this.spacing = spacing;
        this.pending = pending;
        this.loaded = loaded;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_terrain_report(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_TERRAIN_REPORT;

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
        return "MAVLINK_MSG_ID_TERRAIN_REPORT - sysid:"+sysid+" compid:"+compid+" lat:"+lat+" lon:"+lon+" terrain_height:"+terrain_height+" current_height:"+current_height+" spacing:"+spacing+" pending:"+pending+" loaded:"+loaded+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_TERRAIN_REPORT";
    }
}
        