package devices;

import items.crystals.LunarCrystal;
import items.crystals.Lunit;

public class Magnet extends Device {

    public Magnet(int serialNumber) {
        super(serialNumber);
    }

    public void setCrystal(LunarCrystal lunarCrystal) {
        if (serviceability) {
            this.lunarCrystal = lunarCrystal;
            if (lunarCrystal instanceof Lunit) {
                ((Lunit) lunarCrystal).setWeightlessRay();
            }

        }
    }
}
