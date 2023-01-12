package devices;

import devices.exceptions.DeviceIsBrokenException;
import devices.exceptions.NoCrystalInDeviceException;
import items.crystals.LunarCrystal;
import items.crystals.Lunit;

public class WeightlessDevice extends Device {

    public WeightlessDevice(int serialNumber) {
        super(serialNumber);
    }

    public void setCrystal(LunarCrystal lunarCrystal) {
        try {
            this.lunarCrystal = lunarCrystal;
            if (serviceability) {
                if (lunarCrystal instanceof Lunit) {
                    ((Lunit) lunarCrystal).setWeightlessZone();
                }
            } else {
                throw new DeviceIsBrokenException(getClass().getSimpleName() + " сломан, изменений в гравитации не произошло");
            }
        } catch (DeviceIsBrokenException e) {
            e.printStackTrace();
        }
    }


}

