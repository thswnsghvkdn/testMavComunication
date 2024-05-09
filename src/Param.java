import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class Param {

    private static final int MAGIC = 0x671b;
    private static final int MAGIC_WITH_DEFAULTS = 0x671c;

    private static final int[] MAP_KEYS = { 1, 2, 3, 4 };
    private static final int[] MAP_VALUES_TYPE_LEN = { 1, 2, 4, 4 };
    private static final char[] MAP_VALUES_TYPE_FORMAT = { 'b', 'h', 'i', 'f' };

    public static MAVLinkParamList unpack(byte[] data) {
        MAVLinkParamList list = new MAVLinkParamList();

        if (data.length < 6)
            return null;

        ByteBuffer buffer = ByteBuffer.wrap(data);
        int magic2 = buffer.getShort();
        int numParams = buffer.getShort();
        int totalParams = buffer.getShort();

        if (magic2 != MAGIC && magic2 != MAGIC_WITH_DEFAULTS)
            return null;

        boolean withDefaults = magic2 == MAGIC_WITH_DEFAULTS;

        byte padByte = 0;
        int count = 0;
        String lastName = "";
        while (buffer.remaining() > 0) {
            while (buffer.remaining() > 0 && buffer.get() == padByte);

            if (buffer.remaining() == 0)
                break;

            byte ptype = buffer.get();
            byte plen = buffer.get();
            byte flags = (byte) ((ptype >> 4) & 0x0F);
            ptype &= 0x0F;

            int nameLen = ((plen >> 4) & 0x0F) + 1;
            int commonLen = plen & 0x0F;

            StringBuilder nameBuilder = new StringBuilder(lastName.substring(0, commonLen));
            for (int i = 0; i < nameLen; i++)
                nameBuilder.append((char) buffer.get());

            String name = nameBuilder.toString();

            lastName = name;
            Object v = decodeValue(MAP_VALUES_TYPE_FORMAT[ptype - 1], buffer);

            count += 1;
            System.out.printf("%-16s %-16s %-16s %-16s%n", name, v, MAP_VALUES_TYPE_LEN[ptype - 1],
                    MAP_VALUES_TYPE_FORMAT[ptype - 1]);
            byte[] vdata = new byte[4];
            buffer.get(vdata, 0, MAP_VALUES_TYPE_LEN[ptype - 1]);

            Double defaultValue = null;
            if (withDefaults) {
                if ((flags & 1) == 0) {
                    defaultValue = (Double) v;
                } else {
                    defaultValue = (Double) decodeValue(MAP_VALUES_TYPE_FORMAT[ptype - 1], buffer);
                }
            }

            list.add(new MAVLinkParam(name, vdata,
                    (ptype == 1 ? MAVLink.MAV_PARAM_TYPE.INT8
                            : ptype == 2 ? MAVLink.MAV_PARAM_TYPE.INT16
                            : ptype == 3 ? MAVLink.MAV_PARAM_TYPE.INT32
                            : ptype == 4 ? MAVLink.MAV_PARAM_TYPE.REAL32 : null),
                    (ptype == 1 ? MAVLink.MAV_PARAM_TYPE.INT8
                            : ptype == 2 ? MAVLink.MAV_PARAM_TYPE.INT16
                            : ptype == 3 ? MAVLink.MAV_PARAM_TYPE.INT32
                            : ptype == 4 ? MAVLink.MAV_PARAM_TYPE.REAL32 : null),
                    defaultValue));
        }

        if (count != numParams || count > totalParams)
            return null;

        return list;
    }

    private static Object decodeValue(char typeFormat, ByteBuffer buffer) {
        switch (typeFormat) {
            case 'b':
                return buffer.get();
            case 'h':
                return buffer.getShort();
            case 'i':
                return buffer.getInt();
            case 'f':
                return buffer.getFloat();
            default:
                throw new IllegalArgumentException("Unexpected type format: " + typeFormat);
        }
    }
}

class MAVLinkParamList extends ArrayList<MAVLinkParam> {
    private static final long serialVersionUID = 1L;
}

class MAVLinkParam {
    private String name;
    private byte[] data;
    private MAVLink.MAV_PARAM_TYPE type;
    private Double defaultValue;

    public MAVLinkParam(String name, byte[] data, MAVLink.MAV_PARAM_TYPE type, MAVLink.MAV_PARAM_TYPE type2,
                        Double defaultValue) {
        super();
        this.name = name;
        this.data = data;
        this.type = type;
        this.defaultValue = defaultValue;
    }
}

class MAVLink {
    enum MAV_PARAM_TYPE {
        INT8, INT16, INT32, REAL32
    }
}
