package specialties;

import devices.Device;
import items.crystals.LunarCrystal;

public interface Researchers {
    public void research(LunarCrystal lunarCrystal);

    public void setCrystal(LunarCrystal lunarCrystal, Device device);

    public void detectCrystalDependence(LunarCrystal lunarCrystal);

    public void replaceCrystal(LunarCrystal lunarCrystal, Device device);
}
