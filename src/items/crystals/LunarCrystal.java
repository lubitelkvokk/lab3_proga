package items.crystals;

import items.crystals.properties.Colors;
import items.crystals.properties.Density;
import items.crystals.properties.DepositDepth;
import items.crystals.properties.ThermalConductivity;

public abstract class LunarCrystal {
    protected double size;
    protected Colors color;
    protected ThermalConductivity thermalConductivity;
    protected Density density;
    protected DepositDepth depositDepth;


    public LunarCrystal(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        LunarCrystal obj = (LunarCrystal) o;
        return obj.size == size && color == obj.color && thermalConductivity == obj.thermalConductivity && density == obj.density && depositDepth == obj.depositDepth;
    }

    @Override
    public int hashCode() {
        return (int) size + color.hashCode() * 11 + thermalConductivity.hashCode() * 13 + density.hashCode() * 17 + depositDepth.hashCode() * 19;
    }

    @Override
    public String toString() {
        return "LunarCrystal{" +
                "size: " + size +
                ", color: " + color +
                ", thermalConductivity: " + thermalConductivity +
                ", density: " + density +
                ", depositDepth: " + depositDepth +
                '}';
    }
}
