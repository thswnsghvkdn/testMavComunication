import java.io.IOException;
import java.net.DatagramSocket;
import java.time.Instant;
import java.time.Duration;

public class JoystickSender implements Runnable {
    private static final int RATE = 50; // 1000 / 50 = 20 Hz
    private boolean joystickThreadRun = true;
    private boolean joySendThreadExited = false;
    private boolean MONO = false; // Assuming this is a flag for some condition
    private Joystick joystick = new Joystick(); // Placeholder for the actual Joystick class
    private ComPort comPort = new ComPort(); // Placeholder for the actual ComPort class
    private boolean sitl = false; // Assuming this is a flag for some condition
    private Instant lastJoystick = Instant.now();

    @Override
    public void run() {
        int count = 0;
        Instant lastRateChange = Instant.now();

        while (joystickThreadRun) {
            joySendThreadExited = false; // So we know this thread is still alive

            try {
                if (MONO) {
                    System.err.println("Mono: closing joystick thread");
                    break;
                }

                if (!MONO && joystick != null && joystick.isEnabled()) {
                    if (!joystick.isManualControl()) {
                        MAVLinkRCChannelsOverride rc = new MAVLinkRCChannelsOverride();
                        rc.targetComponent = comPort.MAV.compid;
                        rc.targetSystem = comPort.MAV.sysid;

                        setChannelValues(rc);

                        if (Duration.between(lastJoystick, Instant.now()).toMillis() > RATE) {
                            //if (!comPort.getBaseStream().isOpen()) continue;
                            //if (comPort.getBaseStream().getBytesToWrite() < 50) {
                                if (sitl) {
                                    SITL.rcInput();
                                } else {
                                    comPort.sendPacket(rc, rc.targetSystem, rc.targetComponent);
                                }

                                count++;
                                lastJoystick = Instant.now();
                            //}
                        }
                    } else {
                        MAVLinkManualControl rc = new MAVLinkManualControl();
                        rc.target = comPort.MAV.compid;

                        setManualControlValues(rc);

                        if (Duration.between(lastJoystick, Instant.now()).toMillis() > RATE) {
                           // if (!comPort.getBaseStream().isOpen()) continue;
                           // if (comPort.getBaseStream().getBytesToWrite() < 50) {
                                if (sitl) {
                                    SITL.rcInput();
                                } else {
                                    comPort.sendPacket(rc, comPort.MAV.sysid, comPort.MAV.compid);
                                }

                                count++;
                                lastJoystick = Instant.now();
                           // }
                        }
                    }
                }

                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace(); // Can't fall out
            }
        }

        joySendThreadExited = true; // So we know this thread exited
    }

    private void setChannelValues(MAVLinkRCChannelsOverride rc) {
        for (int i = 1; i <= 18; i++) {
            if (joystick.getJoystickAxis(i) == Joystick.JoystickAxis.NONE) {
                rc.setChannelValue(i, (short) (i <= 8 ? 0xFFFF : 0));
            } else {
                rc.setChannelValue(i, (short) comPort.MAV.cs.getRcOverrideChannelValue(i));
            }
        }
    }

    private void setManualControlValues(MAVLinkManualControl rc) {
        for (int i = 1; i <= 4; i++) {
            if (joystick.getJoystickAxis(i) != Joystick.JoystickAxis.NONE) {
                rc.setControlValue(i, comPort.MAV.cs.getRcOverrideChannelValue(i));
            }
        }
    }

    // Placeholder classes for MAVLink message types
    static class MAVLinkRCChannelsOverride {
        int targetComponent;
        int targetSystem;

        void setChannelValue(int channel, short value) {
            // Set channel value logic
        }
    }

    static class MAVLinkManualControl {
        int target;

        void setControlValue(int control, int value) {
            // Set control value logic
        }
    }

    // Placeholder classes for other dependencies
    static class Joystick {
        boolean enabled;

        enum JoystickAxis {
            NONE
        }

        boolean isEnabled() {
            return enabled;
        }

        boolean isManualControl() {
            return false;
        }

        JoystickAxis getJoystickAxis(int axis) {
            return JoystickAxis.NONE;
        }
    }

    static class ComPort {
        MAV MAV = new MAV();
        BaseStream baseStream = new BaseStream();

        class MAV {
            int sysid;
            int compid;
            ControlState cs = new ControlState();

            class ControlState {
                int getRcOverrideChannelValue(int channel) {
                    return 0;
                }
            }
        }

        class BaseStream {
            boolean isOpen() {
                return true;
            }

            int getBytesToWrite() {
                return 0;
            }
        }

        void sendPacket(Object rc, int targetSystem, int targetComponent) {
            // Send packet logic
        }
    }

    static class SITL {
        static void rcInput() {
            // SITL rcInput logic
        }
    }
}
