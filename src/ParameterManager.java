import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ParameterManager {
    private static final int MAV_COMP_ID_AUTOPILOT1 = 1;

    enum ap_var_type {
        AP_PARAM_NONE,
        AP_PARAM_INT8,
        AP_PARAM_INT16,
        AP_PARAM_INT32,
        AP_PARAM_FLOAT,
        AP_PARAM_VECTOR3F,
        AP_PARAM_GROUP
    }

    public boolean parseParamFile(String filename) {
        final int magic_standard = 0x671B;
        final int magic_withdefaults = 0x671C;
        int no_of_parameters_found = 0;
        int componentId = MAV_COMP_ID_AUTOPILOT1; /* Only main autopilot for the moment */

        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            int magic = in.readUnsignedShort();
            int num_params = in.readUnsignedShort();
            int total_params = in.readUnsignedShort();

            if (magic != magic_standard && magic != magic_withdefaults) {
                return false;
            }
            if (num_params > total_params || num_params != total_params) {
                return false;
            }

            while (in.available() > 0) {
                int byteVal = 0;
                int flags = 0;
                int ptype = 0;
                int name_len = 0;
                int common_len = 0;
                boolean withdefault = false;
                int no_read = 0;
                byte[] name_buffer = new byte[17];

                while (byteVal == 0x0) { // Eat padding bytes
                    byteVal = in.readUnsignedByte();
                    if (in.available() == 0) {
                        if (no_of_parameters_found == num_params) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                ptype = byteVal & 0x0F;
                flags = (byteVal >> 4) & 0x0F;
                withdefault = (flags & 0x01) == 0x01;
                byteVal = in.readUnsignedByte();
                if (byteVal == -1) {
                    return false;
                }
                name_len = ((byteVal >> 4) & 0x0F) + 1;
                common_len = byteVal & 0x0F;
                if ((name_len + common_len) > 16) {
                    return false;
                }
                no_read = in.read(name_buffer, common_len, name_len);
                if (no_read != name_len) {
                    return false;
                }
                name_buffer[common_len + name_len] = '\0';
                String parameterName = new String(name_buffer, 0, common_len + name_len);
                int parameterValue = 0;
                switch (ap_var_type.values()[ptype]) {
                    case AP_PARAM_INT8:
                        parameterValue = in.readByte();
                        if (withdefault) {
                            in.readByte();
                        }
                        break;
                    case AP_PARAM_INT16:
                        parameterValue = in.readShort();
                        if (withdefault) {
                            in.readShort();
                        }
                        break;
                    case AP_PARAM_INT32:
                        parameterValue = in.readInt();
                        if (withdefault) {
                            in.readInt();
                        }
                        break;
                    case AP_PARAM_FLOAT:
                        int data32 = in.readInt();
                        float dfloat = Float.intBitsToFloat(data32);
                        parameterValue = (int) dfloat;
                        if (withdefault) {
                            in.readInt();
                        }
                        break;
                    default:
                        return false;
                }
                no_of_parameters_found++;
                // Handle parameter value
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
