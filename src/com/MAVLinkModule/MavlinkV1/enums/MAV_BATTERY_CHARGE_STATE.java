/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package com.MAVLinkModule.MavlinkV1.enums;

/**
 * Enumeration for battery charge states.
 */
public class MAV_BATTERY_CHARGE_STATE {
   public static final int MAV_BATTERY_CHARGE_STATE_UNDEFINED = 0; /* Low battery state is not provided | */
   public static final int MAV_BATTERY_CHARGE_STATE_OK = 1; /* Battery is not in low state. Normal operation. | */
   public static final int MAV_BATTERY_CHARGE_STATE_LOW = 2; /* Battery state is low, warn and monitor close. | */
   public static final int MAV_BATTERY_CHARGE_STATE_CRITICAL = 3; /* Battery state is critical, return or abort immediately. | */
   public static final int MAV_BATTERY_CHARGE_STATE_EMERGENCY = 4; /* Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop to prevent damage. | */
   public static final int MAV_BATTERY_CHARGE_STATE_FAILED = 5; /* Battery failed, damage unavoidable. Possible causes (faults) are listed in MAV_BATTERY_FAULT. | */
   public static final int MAV_BATTERY_CHARGE_STATE_UNHEALTHY = 6; /* Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited. Possible causes (faults) are listed in MAV_BATTERY_FAULT. | */
   public static final int MAV_BATTERY_CHARGE_STATE_CHARGING = 7; /* Battery is charging. | */
   public static final int MAV_BATTERY_CHARGE_STATE_ENUM_END = 8; /*  | */
}
            