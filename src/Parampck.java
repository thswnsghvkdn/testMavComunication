import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parampck {

    private static final int MAGIC = 0x671b;

    private static final int MAGIC_WITH_DEFAULTS = 0x671c;
    static byte ptype = 0;
    static byte plen  = 0;
    static int num_params = 0;
    static int total_params = 0;
    static boolean with_defaults = false;
    private static final Map<Integer, Map<String, Object>> map = new HashMap<>();
    static {
        Map<String, Object> type1 = new HashMap<>();
        type1.put("type_len", 1);
        type1.put("type_format", 'b');
        map.put(1, type1);

        Map<String, Object> type2 = new HashMap<>();
        type2.put("type_len", 2);
        type2.put("type_format", 'h');
        map.put(2, type2);

        Map<String, Object> type3 = new HashMap<>();
        type3.put("type_len", 4);
        type3.put("type_format", 'i');
        map.put(3, type3);

        Map<String, Object> type4 = new HashMap<>();
        type4.put("type_len", 4);
        type4.put("type_format", 'f');
        map.put(4, type4);
    }
    public static boolean checkMagic(byte[] data) {
        int dataPointer = 0;

        int magic2 = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;
        num_params = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;
        total_params = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;

        if ((magic2 != MAGIC) && (magic2 != MAGIC_WITH_DEFAULTS))
            return false;
        else return true;
    }
    public static boolean unpack(byte[] data) {
        // MAVLinkParamList list = new MAVLinkParamList();

        if (data.length < 6)
            return false;

        int dataPointer = 0;

        int magic2 = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;
        num_params = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;
        total_params = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;

        if ((magic2 != MAGIC) && (magic2 != MAGIC_WITH_DEFAULTS))
            return false;

        with_defaults = magic2 == MAGIC_WITH_DEFAULTS;

        byte pad_byte = 0;
        int count = 0;
        String lastName = "";
        while (true) {
            while (data.length - dataPointer > 0 && data[dataPointer] == pad_byte)
                dataPointer++;

            if (data.length - dataPointer == 1)
                break;

            int ptype = data[dataPointer++]& 0xFF;
            int plen = data[dataPointer++]& 0xFF;
            byte flags = (byte) ((ptype >> 4) & 0x0F);
            ptype &= 0x0F;

            Map<String, Object> mapped = map.get((int) ptype);
            if (mapped == null)
                return true;

            int name_len = ((plen >> 4) & 0x0F) + 1;
            int common_len = plen & 0x0F;

            StringBuilder nameBuilder = new StringBuilder().append(lastName, 0, common_len);

            for (int i = dataPointer; i < dataPointer + name_len; i++)
                nameBuilder.append((char) data[i]);

            dataPointer += name_len;

            String name = nameBuilder.toString();

            lastName = name;
            Object v = decodeValue((char) mapped.get("type_format"), data, dataPointer);

            count += 1;
            System.out.println(String.format("%-16s %-16s %-16s %-16s", name, v, mapped.get("type_len"), mapped.get("type_format")));

            byte[] vdata = new byte[4];
            System.arraycopy(data, dataPointer, vdata, 0, (int) mapped.get("type_len"));
            dataPointer += (int) mapped.get("type_len");

            Double defaultValue = null;
            if (with_defaults) {
                if ((flags & 1) == 0) {
                    defaultValue = ((Number) v).doubleValue();
                } else {
                    defaultValue = ((Number) decodeValue((char) mapped.get("type_format"), data, dataPointer)).doubleValue();
                    dataPointer += (int) mapped.get("type_len");
                }
            }

/*            list.add(new MAVLinkParam(name, vdata,
                    (byte) (ptype == 1 ? 0 : ptype == 2 ? 1 : ptype == 3 ? 2 : ptype == 4 ? 9 : 0),
                    (byte) (ptype == 1 ? 0 : ptype == 2 ? 1 : ptype == 3 ? 2 : ptype == 4 ? 9 : 0),
                    defaultValue));*/
        }

        if (count != num_params || count > total_params)
            return false;

        return false;
    }
    public static boolean unpackFromFile(String filePath) throws IOException {
        File file = new File(filePath);

        // Create a byte array to store the file data
        byte[] data = new byte[(int) file.length()];

        // Create a FileInputStream to read the file
        FileInputStream fis = new FileInputStream(file);

        // Read the file data into the byte array
        fis.read(data);

        // Close the input stream
        fis.close();
        // MAVLinkParamList list = new MAVLinkParamList();

        if (data.length < 6)
            return false;

        int dataPointer = 0;

        int magic2 = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;
        num_params = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;
        total_params = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
        dataPointer += 2;

        if ((magic2 != MAGIC) && (magic2 != MAGIC_WITH_DEFAULTS))
            return false;

        with_defaults = magic2 == MAGIC_WITH_DEFAULTS;

        byte pad_byte = 0;
        int count = 0;
        String lastName = "";
        while (true) {
            while (data.length - dataPointer > 0 && data[dataPointer] == pad_byte)
                dataPointer++;

            if (data.length - dataPointer == 1)
                break;

            int ptype = data[dataPointer++] & 0xFF;
            int plen = data[dataPointer++] & 0xFF;
            byte flags = (byte) ((ptype >> 4) & 0x0F);
            ptype &= 0x0F;

            Map<String, Object> mapped = map.get((int) ptype);
            if (mapped == null)
                return true;

            int name_len = ((plen >> 4) & 0x0F) + 1;
            int common_len = plen & 0x0F;

            StringBuilder nameBuilder = new StringBuilder().append(lastName, 0, common_len);

            for (int i = dataPointer; i < dataPointer + name_len; i++)
                nameBuilder.append((char) data[i]);

            dataPointer += name_len;

            String name = nameBuilder.toString();

            lastName = name;
            Object v = decodeValue((char) mapped.get("type_format"), data, dataPointer);

            count += 1;
            System.out.println(String.format("%-16s %-16s %-16s %-16s", name, v, mapped.get("type_len"), mapped.get("type_format")));

            byte[] vdata = new byte[4];
            System.arraycopy(data, dataPointer, vdata, 0, (int) mapped.get("type_len"));
            dataPointer += (int) mapped.get("type_len");

            Double defaultValue = null;
            if (with_defaults) {
                if ((flags & 1) == 0) {
                    defaultValue = ((Number) v).doubleValue();
                } else {
                    defaultValue = ((Number) decodeValue((char) mapped.get("type_format"), data, dataPointer)).doubleValue();
                    dataPointer += (int) mapped.get("type_len");
                }
            }

/*            list.add(new MAVLinkParam(name, vdata,
                    (byte) (ptype == 1 ? 0 : ptype == 2 ? 1 : ptype == 3 ? 2 : ptype == 4 ? 9 : 0),
                    (byte) (ptype == 1 ? 0 : ptype == 2 ? 1 : ptype == 3 ? 2 : ptype == 4 ? 9 : 0),
                    defaultValue));*/
        }

        if (count != num_params || count > total_params)
            return false;

        return false;
    }
    public static boolean unpackAfterFirstPacket(byte[] data) {
        // MAVLinkParamList list = new MAVLinkParamList();
        int dataPointer = 0;


        byte pad_byte = 0;
        int count = 0;
        String lastName = "";
        while (true) {
            while (data.length - dataPointer > 0 && data[dataPointer] == pad_byte)
                dataPointer++;

            if (data.length - dataPointer == 1)
                break;

            byte ptype = data[dataPointer++];
            byte plen = data[dataPointer++];
            byte flags = (byte) ((ptype >> 4) & 0x0F);
            ptype &= 0x0F;

            Map<String, Object> mapped = map.get((int) ptype);
            if (mapped == null)
                return true;

            int name_len = ((plen >> 4) & 0x0F) + 1;
            int common_len = plen & 0x0F;

            StringBuilder nameBuilder = new StringBuilder().append(lastName, 0, common_len);

            for (int i = dataPointer; i < dataPointer + name_len; i++)
                nameBuilder.append((char) data[i]);

            dataPointer += name_len;

            String name = nameBuilder.toString();

            lastName = name;
            Object v = decodeValue((char) mapped.get("type_format"), data, dataPointer);

            count += 1;
            System.out.println(String.format("%-16s %-16s %-16s %-16s", name, v, mapped.get("type_len"), mapped.get("type_format")));

            byte[] vdata = new byte[4];
            System.arraycopy(data, dataPointer, vdata, 0, (int) mapped.get("type_len"));
            dataPointer += (int) mapped.get("type_len");

            Double defaultValue = null;
            if (with_defaults) {
                if ((flags & 1) == 0) {
                    defaultValue = ((Number) v).doubleValue();
                } else {
                    defaultValue = ((Number) decodeValue((char) mapped.get("type_format"), data, dataPointer)).doubleValue();
                    dataPointer += (int) mapped.get("type_len");
                }
            }

/*            list.add(new MAVLinkParam(name, vdata,
                    (byte) (ptype == 1 ? 0 : ptype == 2 ? 1 : ptype == 3 ? 2 : ptype == 4 ? 9 : 0),
                    (byte) (ptype == 1 ? 0 : ptype == 2 ? 1 : ptype == 3 ? 2 : ptype == 4 ? 9 : 0),
                    defaultValue));*/
        }

        if (count != num_params || count > total_params)
            return false;

        return false;
    }

    private static Object decodeValue(char typeFormat, byte[] data, int startIndex) {
        switch (typeFormat) {
            case 'b':
                return data[startIndex];
            case 'h':
                return ByteBuffer.wrap(data, startIndex, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
            case 'i':
                return ByteBuffer.wrap(data, startIndex, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
            case 'f':
                return ByteBuffer.wrap(data, startIndex, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
            default:
                throw new RuntimeException("Unexpected typeFormat: " + typeFormat);
        }
    }
}

/*
public class MAVLinkParamList extends ArrayList<MAVLinkParam> {
}

class MAVLinkParam {
    private final String name;
    private final byte[] value;
    private final byte type;
    private final byte len;
    private final Double defaultValue;

    public MAVLinkParam(String name, byte[] value, byte type, byte len, Double defaultValue) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.len = len;
        this.defaultValue = defaultValue;
    }
}*/
