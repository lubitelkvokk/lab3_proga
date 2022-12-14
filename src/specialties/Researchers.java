package specialties;

import devices.Device;
import items.crystals.LunarCrystal;

public interface Researchers {
    void research(LunarCrystal lunarCrystal);

    void setCrystal(LunarCrystal lunarCrystal, Device device);

    void detectCrystalDependence(LunarCrystal lunarCrystal);

    void replaceCrystal(LunarCrystal lunarCrystal, Device device);
}
