package devices;

import devices.exceptions.DeviceIsBrokenException;
import items.crystals.LunarCrystal;
import items.crystals.Lunit;

public class Magnet extends Device {

    public Magnet(int serialNumber) {
        super(serialNumber);
    }

    public void setCrystal(LunarCrystal lunarCrystal) {
        try {
            this.lunarCrystal = lunarCrystal;
            if (serviceability) {
                if (lunarCrystal instanceof Lunit) {
                    ((Lunit) lunarCrystal).setWeightlessRay();
                }
            } else {
                throw new DeviceIsBrokenException();
            }
        } catch (DeviceIsBrokenException e) {
            e.printStackTrace();
        }
    }
}
