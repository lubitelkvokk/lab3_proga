package devices;

import items.crystals.LunarCrystal;

public abstract class Device {
    protected LunarCrystal lunarCrystal;
    protected boolean serviceability = true;
    protected int serialNumber;

    public Device(int serialNumber) {
        this.serialNumber = serialNumber;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Device device = (Device) obj;
        return serialNumber == device.serialNumber;
    }

    @Override
    public int hashCode() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Device{" +
                "Serviceability: " + serviceability +
                ", Serial number: " + serialNumber +
                '}';
    }
}
