package devices;

import items.crystals.LunarCrystal;
import items.crystals.Lunit;

public class WeightlessDevice extends Device {


    public WeightlessDevice(int serialNumber) {
        super(serialNumber);
    }

    public void setCrystal(LunarCrystal lunarCrystal) {
        this.lunarCrystal = lunarCrystal;
        if (serviceability) {
            this.lunarCrystal = lunarCrystal;
            if (lunarCrystal instanceof Lunit) {
                ((Lunit) lunarCrystal).setWeightlessZone();
            }
        }
    }

}

