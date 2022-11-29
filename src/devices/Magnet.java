package devices;

import items.LunarCrystal;
import items.Lunit;

public class Magnet extends Device {
    LunarCrystal lunarCrystal;

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
