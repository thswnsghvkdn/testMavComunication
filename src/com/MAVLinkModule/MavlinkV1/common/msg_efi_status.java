/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE EFI_STATUS PACKING
package com.MAVLinkModule.MavlinkV1.common;
import com.MAVLinkModule.MavlinkV1.MAVLinkPacket;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkMessage;
import com.MAVLinkModule.MavlinkV1.Messages.MAVLinkPayload;
import com.MAVLinkModule.MavlinkV1.Messages.Units;
import com.MAVLinkModule.MavlinkV1.Messages.Description;

/**
 * EFI status output
 */
public class msg_efi_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_EFI_STATUS = 225;
    public static final int MAVLINK_MSG_LENGTH = 73;
    private static final long serialVersionUID = MAVLINK_MSG_ID_EFI_STATUS;

    
    /**
     * ECU index
     */
    @Description("ECU index")
    @Units("")
    public float ecu_index;
    
    /**
     * RPM
     */
    @Description("RPM")
    @Units("")
    public float rpm;
    
    /**
     * Fuel consumed
     */
    @Description("Fuel consumed")
    @Units("cm^3")
    public float fuel_consumed;
    
    /**
     * Fuel flow rate
     */
    @Description("Fuel flow rate")
    @Units("cm^3/min")
    public float fuel_flow;
    
    /**
     * Engine load
     */
    @Description("Engine load")
    @Units("%")
    public float engine_load;
    
    /**
     * Throttle position
     */
    @Description("Throttle position")
    @Units("%")
    public float throttle_position;
    
    /**
     * Spark dwell time
     */
    @Description("Spark dwell time")
    @Units("ms")
    public float spark_dwell_time;
    
    /**
     * Barometric pressure
     */
    @Description("Barometric pressure")
    @Units("kPa")
    public float barometric_pressure;
    
    /**
     * Intake manifold pressure(
     */
    @Description("Intake manifold pressure(")
    @Units("kPa")
    public float intake_manifold_pressure;
    
    /**
     * Intake manifold temperature
     */
    @Description("Intake manifold temperature")
    @Units("degC")
    public float intake_manifold_temperature;
    
    /**
     * Cylinder head temperature
     */
    @Description("Cylinder head temperature")
    @Units("degC")
    public float cylinder_head_temperature;
    
    /**
     * Ignition timing (Crank angle degrees)
     */
    @Description("Ignition timing (Crank angle degrees)")
    @Units("deg")
    public float ignition_timing;
    
    /**
     * Injection time
     */
    @Description("Injection time")
    @Units("ms")
    public float injection_time;
    
    /**
     * Exhaust gas temperature
     */
    @Description("Exhaust gas temperature")
    @Units("degC")
    public float exhaust_gas_temperature;
    
    /**
     * Output throttle
     */
    @Description("Output throttle")
    @Units("%")
    public float throttle_out;
    
    /**
     * Pressure/temperature compensation
     */
    @Description("Pressure/temperature compensation")
    @Units("")
    public float pt_compensation;
    
    /**
     * EFI health status
     */
    @Description("EFI health status")
    @Units("")
    public short health;
    
    /**
     * Supply voltage to EFI sparking system.  Zero in this value means 'unknown', so if the supply voltage really is zero volts use 0.0001 instead.
     */
    @Description("Supply voltage to EFI sparking system.  Zero in this value means 'unknown', so if the supply voltage really is zero volts use 0.0001 instead.")
    @Units("V")
    public float ignition_voltage;
    
    /**
     * Fuel pressure. Zero in this value means 'unknown', so if the fuel pressure really is zero kPa use 0.0001 instead.
     */
    @Description("Fuel pressure. Zero in this value means 'unknown', so if the fuel pressure really is zero kPa use 0.0001 instead.")
    @Units("kPa")
    public float fuel_pressure;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_EFI_STATUS;

        packet.payload.putFloat(ecu_index);
        packet.payload.putFloat(rpm);
        packet.payload.putFloat(fuel_consumed);
        packet.payload.putFloat(fuel_flow);
        packet.payload.putFloat(engine_load);
        packet.payload.putFloat(throttle_position);
        packet.payload.putFloat(spark_dwell_time);
        packet.payload.putFloat(barometric_pressure);
        packet.payload.putFloat(intake_manifold_pressure);
        packet.payload.putFloat(intake_manifold_temperature);
        packet.payload.putFloat(cylinder_head_temperature);
        packet.payload.putFloat(ignition_timing);
        packet.payload.putFloat(injection_time);
        packet.payload.putFloat(exhaust_gas_temperature);
        packet.payload.putFloat(throttle_out);
        packet.payload.putFloat(pt_compensation);
        packet.payload.putUnsignedByte(health);
        
        if (isMavlink2) {
             packet.payload.putFloat(ignition_voltage);
             packet.payload.putFloat(fuel_pressure);
            
        }
        return packet;
    }

    /**
     * Decode a efi_status message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.ecu_index = payload.getFloat();
        this.rpm = payload.getFloat();
        this.fuel_consumed = payload.getFloat();
        this.fuel_flow = payload.getFloat();
        this.engine_load = payload.getFloat();
        this.throttle_position = payload.getFloat();
        this.spark_dwell_time = payload.getFloat();
        this.barometric_pressure = payload.getFloat();
        this.intake_manifold_pressure = payload.getFloat();
        this.intake_manifold_temperature = payload.getFloat();
        this.cylinder_head_temperature = payload.getFloat();
        this.ignition_timing = payload.getFloat();
        this.injection_time = payload.getFloat();
        this.exhaust_gas_temperature = payload.getFloat();
        this.throttle_out = payload.getFloat();
        this.pt_compensation = payload.getFloat();
        this.health = payload.getUnsignedByte();
        
        if (isMavlink2) {
             this.ignition_voltage = payload.getFloat();
             this.fuel_pressure = payload.getFloat();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_efi_status() {
        this.msgid = MAVLINK_MSG_ID_EFI_STATUS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_efi_status( float ecu_index, float rpm, float fuel_consumed, float fuel_flow, float engine_load, float throttle_position, float spark_dwell_time, float barometric_pressure, float intake_manifold_pressure, float intake_manifold_temperature, float cylinder_head_temperature, float ignition_timing, float injection_time, float exhaust_gas_temperature, float throttle_out, float pt_compensation, short health, float ignition_voltage, float fuel_pressure) {
        this.msgid = MAVLINK_MSG_ID_EFI_STATUS;

        this.ecu_index = ecu_index;
        this.rpm = rpm;
        this.fuel_consumed = fuel_consumed;
        this.fuel_flow = fuel_flow;
        this.engine_load = engine_load;
        this.throttle_position = throttle_position;
        this.spark_dwell_time = spark_dwell_time;
        this.barometric_pressure = barometric_pressure;
        this.intake_manifold_pressure = intake_manifold_pressure;
        this.intake_manifold_temperature = intake_manifold_temperature;
        this.cylinder_head_temperature = cylinder_head_temperature;
        this.ignition_timing = ignition_timing;
        this.injection_time = injection_time;
        this.exhaust_gas_temperature = exhaust_gas_temperature;
        this.throttle_out = throttle_out;
        this.pt_compensation = pt_compensation;
        this.health = health;
        this.ignition_voltage = ignition_voltage;
        this.fuel_pressure = fuel_pressure;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_efi_status( float ecu_index, float rpm, float fuel_consumed, float fuel_flow, float engine_load, float throttle_position, float spark_dwell_time, float barometric_pressure, float intake_manifold_pressure, float intake_manifold_temperature, float cylinder_head_temperature, float ignition_timing, float injection_time, float exhaust_gas_temperature, float throttle_out, float pt_compensation, short health, float ignition_voltage, float fuel_pressure, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_EFI_STATUS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.ecu_index = ecu_index;
        this.rpm = rpm;
        this.fuel_consumed = fuel_consumed;
        this.fuel_flow = fuel_flow;
        this.engine_load = engine_load;
        this.throttle_position = throttle_position;
        this.spark_dwell_time = spark_dwell_time;
        this.barometric_pressure = barometric_pressure;
        this.intake_manifold_pressure = intake_manifold_pressure;
        this.intake_manifold_temperature = intake_manifold_temperature;
        this.cylinder_head_temperature = cylinder_head_temperature;
        this.ignition_timing = ignition_timing;
        this.injection_time = injection_time;
        this.exhaust_gas_temperature = exhaust_gas_temperature;
        this.throttle_out = throttle_out;
        this.pt_compensation = pt_compensation;
        this.health = health;
        this.ignition_voltage = ignition_voltage;
        this.fuel_pressure = fuel_pressure;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_efi_status(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_EFI_STATUS;

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
        return "MAVLINK_MSG_ID_EFI_STATUS - sysid:"+sysid+" compid:"+compid+" ecu_index:"+ecu_index+" rpm:"+rpm+" fuel_consumed:"+fuel_consumed+" fuel_flow:"+fuel_flow+" engine_load:"+engine_load+" throttle_position:"+throttle_position+" spark_dwell_time:"+spark_dwell_time+" barometric_pressure:"+barometric_pressure+" intake_manifold_pressure:"+intake_manifold_pressure+" intake_manifold_temperature:"+intake_manifold_temperature+" cylinder_head_temperature:"+cylinder_head_temperature+" ignition_timing:"+ignition_timing+" injection_time:"+injection_time+" exhaust_gas_temperature:"+exhaust_gas_temperature+" throttle_out:"+throttle_out+" pt_compensation:"+pt_compensation+" health:"+health+" ignition_voltage:"+ignition_voltage+" fuel_pressure:"+fuel_pressure+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_EFI_STATUS";
    }
}
        