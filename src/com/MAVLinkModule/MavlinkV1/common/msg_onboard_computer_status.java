/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ONBOARD_COMPUTER_STATUS PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * Hardware status sent by an onboard computer.
 */
public class msg_onboard_computer_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS = 390;
    public static final int MAVLINK_MSG_LENGTH = 238;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS;

    
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    @Description("Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.")
    @Units("us")
    public long time_usec;
    
    /**
     * Time since system boot.
     */
    @Description("Time since system boot.")
    @Units("ms")
    public long uptime;
    
    /**
     * Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("MiB")
    public long ram_usage;
    
    /**
     * Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("MiB")
    public long ram_total;
    
    /**
     * Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A value of UINT32_MAX implies the field is unused.
     */
    @Description("Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A value of UINT32_MAX implies the field is unused.")
    @Units("")
    public long storage_type[] = new long[4];
    
    /**
     * Amount of used storage space on the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Amount of used storage space on the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("MiB")
    public long storage_usage[] = new long[4];
    
    /**
     * Total amount of storage space on the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Total amount of storage space on the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("MiB")
    public long storage_total[] = new long[4];
    
    /**
     * Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 40-49: Mesh proprietary
     */
    @Description("Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 40-49: Mesh proprietary")
    @Units("")
    public long link_type[] = new long[6];
    
    /**
     * Network traffic from the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Network traffic from the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("KiB/s")
    public long link_tx_rate[] = new long[6];
    
    /**
     * Network traffic to the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Network traffic to the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("KiB/s")
    public long link_rx_rate[] = new long[6];
    
    /**
     * Network capacity from the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Network capacity from the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("KiB/s")
    public long link_tx_max[] = new long[6];
    
    /**
     * Network capacity to the component system. A value of UINT32_MAX implies the field is unused.
     */
    @Description("Network capacity to the component system. A value of UINT32_MAX implies the field is unused.")
    @Units("KiB/s")
    public long link_rx_max[] = new long[6];
    
    /**
     * Fan speeds. A value of INT16_MAX implies the field is unused.
     */
    @Description("Fan speeds. A value of INT16_MAX implies the field is unused.")
    @Units("rpm")
    public short fan_speed[] = new short[4];
    
    /**
     * Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers.
     */
    @Description("Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers.")
    @Units("")
    public short type;
    
    /**
     * CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused.
     */
    @Description("CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused.")
    @Units("")
    public short cpu_cores[] = new short[8];
    
    /**
     * Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused.
     */
    @Description("Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused.")
    @Units("")
    public short cpu_combined[] = new short[10];
    
    /**
     * GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused.
     */
    @Description("GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused.")
    @Units("")
    public short gpu_cores[] = new short[4];
    
    /**
     * Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused.
     */
    @Description("Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused.")
    @Units("")
    public short gpu_combined[] = new short[10];
    
    /**
     * Temperature of the board. A value of INT8_MAX implies the field is unused.
     */
    @Description("Temperature of the board. A value of INT8_MAX implies the field is unused.")
    @Units("degC")
    public byte temperature_board;
    
    /**
     * Temperature of the CPU core. A value of INT8_MAX implies the field is unused.
     */
    @Description("Temperature of the CPU core. A value of INT8_MAX implies the field is unused.")
    @Units("degC")
    public byte temperature_core[] = new byte[8];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS;

        packet.payload.putUnsignedLong(time_usec);
        packet.payload.putUnsignedInt(uptime);
        packet.payload.putUnsignedInt(ram_usage);
        packet.payload.putUnsignedInt(ram_total);
        
        for (int i = 0; i < storage_type.length; i++) {
            packet.payload.putUnsignedInt(storage_type[i]);
        }
                    
        
        for (int i = 0; i < storage_usage.length; i++) {
            packet.payload.putUnsignedInt(storage_usage[i]);
        }
                    
        
        for (int i = 0; i < storage_total.length; i++) {
            packet.payload.putUnsignedInt(storage_total[i]);
        }
                    
        
        for (int i = 0; i < link_type.length; i++) {
            packet.payload.putUnsignedInt(link_type[i]);
        }
                    
        
        for (int i = 0; i < link_tx_rate.length; i++) {
            packet.payload.putUnsignedInt(link_tx_rate[i]);
        }
                    
        
        for (int i = 0; i < link_rx_rate.length; i++) {
            packet.payload.putUnsignedInt(link_rx_rate[i]);
        }
                    
        
        for (int i = 0; i < link_tx_max.length; i++) {
            packet.payload.putUnsignedInt(link_tx_max[i]);
        }
                    
        
        for (int i = 0; i < link_rx_max.length; i++) {
            packet.payload.putUnsignedInt(link_rx_max[i]);
        }
                    
        
        for (int i = 0; i < fan_speed.length; i++) {
            packet.payload.putShort(fan_speed[i]);
        }
                    
        packet.payload.putUnsignedByte(type);
        
        for (int i = 0; i < cpu_cores.length; i++) {
            packet.payload.putUnsignedByte(cpu_cores[i]);
        }
                    
        
        for (int i = 0; i < cpu_combined.length; i++) {
            packet.payload.putUnsignedByte(cpu_combined[i]);
        }
                    
        
        for (int i = 0; i < gpu_cores.length; i++) {
            packet.payload.putUnsignedByte(gpu_cores[i]);
        }
                    
        
        for (int i = 0; i < gpu_combined.length; i++) {
            packet.payload.putUnsignedByte(gpu_combined[i]);
        }
                    
        packet.payload.putByte(temperature_board);
        
        for (int i = 0; i < temperature_core.length; i++) {
            packet.payload.putByte(temperature_core[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a onboard_computer_status message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_usec = payload.getUnsignedLong();
        this.uptime = payload.getUnsignedInt();
        this.ram_usage = payload.getUnsignedInt();
        this.ram_total = payload.getUnsignedInt();
        
        for (int i = 0; i < this.storage_type.length; i++) {
            this.storage_type[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.storage_usage.length; i++) {
            this.storage_usage[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.storage_total.length; i++) {
            this.storage_total[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.link_type.length; i++) {
            this.link_type[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.link_tx_rate.length; i++) {
            this.link_tx_rate[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.link_rx_rate.length; i++) {
            this.link_rx_rate[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.link_tx_max.length; i++) {
            this.link_tx_max[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.link_rx_max.length; i++) {
            this.link_rx_max[i] = payload.getUnsignedInt();
        }
                
        
        for (int i = 0; i < this.fan_speed.length; i++) {
            this.fan_speed[i] = payload.getShort();
        }
                
        this.type = payload.getUnsignedByte();
        
        for (int i = 0; i < this.cpu_cores.length; i++) {
            this.cpu_cores[i] = payload.getUnsignedByte();
        }
                
        
        for (int i = 0; i < this.cpu_combined.length; i++) {
            this.cpu_combined[i] = payload.getUnsignedByte();
        }
                
        
        for (int i = 0; i < this.gpu_cores.length; i++) {
            this.gpu_cores[i] = payload.getUnsignedByte();
        }
                
        
        for (int i = 0; i < this.gpu_combined.length; i++) {
            this.gpu_combined[i] = payload.getUnsignedByte();
        }
                
        this.temperature_board = payload.getByte();
        
        for (int i = 0; i < this.temperature_core.length; i++) {
            this.temperature_core[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_onboard_computer_status() {
        this.msgid = MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_onboard_computer_status( long time_usec, long uptime, long ram_usage, long ram_total, long[] storage_type, long[] storage_usage, long[] storage_total, long[] link_type, long[] link_tx_rate, long[] link_rx_rate, long[] link_tx_max, long[] link_rx_max, short[] fan_speed, short type, short[] cpu_cores, short[] cpu_combined, short[] gpu_cores, short[] gpu_combined, byte temperature_board, byte[] temperature_core) {
        this.msgid = MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS;

        this.time_usec = time_usec;
        this.uptime = uptime;
        this.ram_usage = ram_usage;
        this.ram_total = ram_total;
        this.storage_type = storage_type;
        this.storage_usage = storage_usage;
        this.storage_total = storage_total;
        this.link_type = link_type;
        this.link_tx_rate = link_tx_rate;
        this.link_rx_rate = link_rx_rate;
        this.link_tx_max = link_tx_max;
        this.link_rx_max = link_rx_max;
        this.fan_speed = fan_speed;
        this.type = type;
        this.cpu_cores = cpu_cores;
        this.cpu_combined = cpu_combined;
        this.gpu_cores = gpu_cores;
        this.gpu_combined = gpu_combined;
        this.temperature_board = temperature_board;
        this.temperature_core = temperature_core;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_onboard_computer_status( long time_usec, long uptime, long ram_usage, long ram_total, long[] storage_type, long[] storage_usage, long[] storage_total, long[] link_type, long[] link_tx_rate, long[] link_rx_rate, long[] link_tx_max, long[] link_rx_max, short[] fan_speed, short type, short[] cpu_cores, short[] cpu_combined, short[] gpu_cores, short[] gpu_combined, byte temperature_board, byte[] temperature_core, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.uptime = uptime;
        this.ram_usage = ram_usage;
        this.ram_total = ram_total;
        this.storage_type = storage_type;
        this.storage_usage = storage_usage;
        this.storage_total = storage_total;
        this.link_type = link_type;
        this.link_tx_rate = link_tx_rate;
        this.link_rx_rate = link_rx_rate;
        this.link_tx_max = link_tx_max;
        this.link_rx_max = link_rx_max;
        this.fan_speed = fan_speed;
        this.type = type;
        this.cpu_cores = cpu_cores;
        this.cpu_combined = cpu_combined;
        this.gpu_cores = gpu_cores;
        this.gpu_combined = gpu_combined;
        this.temperature_board = temperature_board;
        this.temperature_core = temperature_core;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_onboard_computer_status(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS;

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
        return "MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" uptime:"+uptime+" ram_usage:"+ram_usage+" ram_total:"+ram_total+" storage_type:"+storage_type+" storage_usage:"+storage_usage+" storage_total:"+storage_total+" link_type:"+link_type+" link_tx_rate:"+link_tx_rate+" link_rx_rate:"+link_rx_rate+" link_tx_max:"+link_tx_max+" link_rx_max:"+link_rx_max+" fan_speed:"+fan_speed+" type:"+type+" cpu_cores:"+cpu_cores+" cpu_combined:"+cpu_combined+" gpu_cores:"+gpu_cores+" gpu_combined:"+gpu_combined+" temperature_board:"+temperature_board+" temperature_core:"+temperature_core+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_ONBOARD_COMPUTER_STATUS";
    }
}
        