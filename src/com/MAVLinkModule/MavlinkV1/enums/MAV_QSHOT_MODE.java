/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package com.MAVLinkModule.MavlinkV1.enums;

/**
 * Enumeration of possible shot modes.
 */
public class MAV_QSHOT_MODE {
   public static final int MAV_QSHOT_MODE_UNDEFINED = 0; /* Undefined shot mode. Can be used to determine if qshots should be used or not. | */
   public static final int MAV_QSHOT_MODE_DEFAULT = 1; /* Start normal gimbal operation. Is usually used to return back from a shot. | */
   public static final int MAV_QSHOT_MODE_GIMBAL_RETRACT = 2; /* Load and keep safe gimbal position and stop stabilization. | */
   public static final int MAV_QSHOT_MODE_GIMBAL_NEUTRAL = 3; /* Load neutral gimbal position and keep it while stabilizing. | */
   public static final int MAV_QSHOT_MODE_GIMBAL_MISSION = 4; /* Start mission with gimbal control. | */
   public static final int MAV_QSHOT_MODE_GIMBAL_RC_CONTROL = 5; /* Start RC gimbal control. | */
   public static final int MAV_QSHOT_MODE_POI_TARGETING = 6; /* Start gimbal tracking the point specified by Lat, Lon, Alt. | */
   public static final int MAV_QSHOT_MODE_SYSID_TARGETING = 7; /* Start gimbal tracking the system with specified system ID. | */
   public static final int MAV_QSHOT_MODE_CABLECAM_2POINT = 8; /* Start 2-point cable cam quick shot. | */
   public static final int MAV_QSHOT_MODE_HOME_TARGETING = 9; /* Start gimbal tracking the home location. | */
   public static final int MAV_QSHOT_MODE_ENUM_END = 10; /*  | */
}
            