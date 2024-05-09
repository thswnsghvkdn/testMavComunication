/*
import java.util.ArrayList;
import java.util.List;

public class APMSensorsComponent {
    private Vehicle _vehicle;

    public boolean compassSetupNeeded() {
        final int cCompass = 3;
        final int cOffset = 3;
        List<String> rgDevicesIds = new ArrayList<>();
        List<String> rgCompassUse = new ArrayList<>();
        List<List<String>> rgOffsets = new ArrayList<>();

        rgDevicesIds.add("COMPASS_DEV_ID");
        rgDevicesIds.add("COMPASS_DEV_ID2");
        rgDevicesIds.add("COMPASS_DEV_ID3");

        rgCompassUse.add("COMPASS_USE");
        rgCompassUse.add("COMPASS_USE2");
        rgCompassUse.add("COMPASS_USE3");

        List<String> offsets1 = new ArrayList<>();
        offsets1.add("COMPASS_OFS_X");
        offsets1.add("COMPASS_OFS_Y");
        offsets1.add("COMPASS_OFS_Z");
        rgOffsets.add(offsets1);

        List<String> offsets2 = new ArrayList<>();
        offsets2.add("COMPASS_OFS2_X");
        offsets2.add("COMPASS_OFS2_Y");
        offsets2.add("COMPASS_OFS2_Z");
        rgOffsets.add(offsets2);

        List<String> offsets3 = new ArrayList<>();
        offsets3.add("COMPASS_OFS3_X");
        offsets3.add("COMPASS_OFS3_Y");
        offsets3.add("COMPASS_OFS3_Z");
        rgOffsets.add(offsets3);

        for (int i = 0; i < cCompass; i++) {
            if (_vehicle.parameterManager().getParameter(FactSystem.defaultComponentId, rgDevicesIds.get(i)).rawValue().toInt() != 0 &&
                    _vehicle.parameterManager().getParameter(FactSystem.defaultComponentId, rgCompassUse.get(i)).rawValue().toInt() != 0) {
                for (int j = 0; j < cOffset; j++) {
                    if (_vehicle.parameterManager().getParameter(FactSystem.defaultComponentId, rgOffsets.get(i).get(j)).rawValue().toFloat() == 0.0f) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean accelSetupNeeded() {
        List<String> rgOffsets = new ArrayList<>();
        rgOffsets.add("INS_ACCOFFS_X");
        rgOffsets.add("INS_ACCOFFS_Y");
        rgOffsets.add("INS_ACCOFFS_Z");

        int zeroCount = 0;
        for (String offset : rgOffsets) {
            if (_vehicle.parameterManager().getParameter(FactSystem.defaultComponentId, offset).rawValue().toFloat() == 0.0f) {
                zeroCount++;
            }
        }

        return zeroCount == rgOffsets.size();
    }
}
*/
