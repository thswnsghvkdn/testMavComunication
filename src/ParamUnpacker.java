import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ParamUnpacker {

    public static void unpack(String filename) {

        try (InputStream inputStream = new FileInputStream(filename)) {
            byte[] data = inputStream.readAllBytes();
            String lastName = "";

            int magic = 0x671b;

            int dataPointer = 0;
            // header of 6 bytes
            int magic2 = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
            dataPointer += 2;
            int numParams = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
            dataPointer += 2;
            int totalParams = ByteBuffer.wrap(data, dataPointer, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();

            if (magic != magic2) {
                System.out.printf("Bad magic 0x%x expected 0x%x%n", magic2, magic);
                System.exit(1);
            }

            data = spliceArray(data, 6);

            // mapping of data type to type length
            int[][] dataTypes = {
                    {1, 1}, // AP_PARAM_INT8
                    {2, 2}, // AP_PARAM_INT16
                    {3, 4}, // AP_PARAM_INT32
                    {4, 4}  // AP_PARAM_FLOAT
            };

            int count = 0;

            while (true) {
                // skip pad bytes
                while (data.length > 0 && data[0] == 0) {
                    data = spliceArray(data, 1);
                }

                if (data.length == 0) {
                    break;
                }

                int ptype = data[0] & 0x0F;
                int plen = data[1] & 0x0F;
                int flags = (ptype >> 4) & 0x0F;
                ptype &= 0x0F;

                int nameLen = ((plen >> 4) & 0x0F) + 1;
                int commonLen = plen & 0x0F;

                String name = lastName.substring(0, commonLen) +
                        new String(spliceArray(data, 2, 2 + nameLen), "UTF-8");
                byte[] vdata = spliceArray(data, 2 + nameLen, 2 + nameLen + dataTypes[ptype - 1][1]);
                lastName = name;
                data = spliceArray(data, 2 + nameLen + dataTypes[ptype - 1][1]);

                int v = 0;
                if (dataTypes[ptype - 1][1] == 1) {
                    v = vdata[0];
                } else if (dataTypes[ptype - 1][1] == 2) {
                    v = ((vdata[0] & 0xFF) << 8) | (vdata[1] & 0xFF);
                } else if (dataTypes[ptype - 1][1] == 4) {
                    v = ((vdata[0] & 0xFF) << 24) | ((vdata[1] & 0xFF) << 16) |
                            ((vdata[2] & 0xFF) << 8) | (vdata[3] & 0xFF);
                }

                count++;
                System.out.printf("%-16s %f%n", name, (float) v);
            }

            if (count != numParams || count > totalParams) {
                System.out.printf("Error: Got %d params expected %d/%d%n", count, numParams, totalParams);
                System.exit(1);
            }

            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static byte[] spliceArray(byte[] source, int from, int to) {
        byte[] destination = new byte[to - from];
        System.arraycopy(source, from, destination, 0, to - from);
        return destination;
    }

    private static byte[] spliceArray(byte[] source, int from) {
        return spliceArray(source, from, source.length);
    }
    private static int readLittleEndianShort(DataInputStream in) throws IOException {
        int lowByte = in.readUnsignedByte();
        int highByte = in.readUnsignedByte();
        return (highByte << 8) | lowByte;
    }
}