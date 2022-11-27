package devices;

import items.LunarCrystal;

public class Device {
    protected LunarCrystal lunarCrystal;
    boolean serviceability = true;

    public LunarCrystal getCrystal() {
        return this.lunarCrystal;
    }

    public void setCrystal(LunarCrystal lunarCrystal) {
        this.lunarCrystal = lunarCrystal;
    }

    public void breakDevice() {
        serviceability = false;
    }

    public void fixDevice() {
        serviceability = true;
    }

    public boolean isServiceability() {
        return serviceability;
    }
}
