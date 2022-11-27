package specialties;

import devices.Device;
import items.LunarCrystal;

public interface Researchers {
    public void research(LunarCrystal lunarCrystal);

    public void setCrystal(LunarCrystal lunarCrystal, Device device);

    public void detectCrystalDependence(LunarCrystal lunarCrystal);
}
