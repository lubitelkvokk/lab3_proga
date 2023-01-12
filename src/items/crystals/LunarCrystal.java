package items.crystals;

import items.crystals.properties.*;


import java.awt.*;
import java.io.FileNotFoundException;

public abstract class LunarCrystal {
    private double size;
    private Colors color;
    private ThermalConductivity thermalConductivity;
    private Density density;
    private DepositDepth depositDepth;


    public LunarCrystal(Colors color, ThermalConductivity thermalConductivity, Density density, DepositDepth depositDepth) {
        this.color = color;
        this.thermalConductivity = thermalConductivity;
        this.density = density;
        this.depositDepth = depositDepth;
    }

    public LunarCrystal(double size){
        this.size = size;
    }

    public LunarCrystal(double size, Colors color, ThermalConductivity thermalConductivity, Density density, DepositDepth depositDepth)
    {
        this(color, thermalConductivity, density, depositDepth);
        this.size = size;
    }
    public double getSize() {
        return size;
    }


    public Colors getColor(){
        return color;
    }

    public Density getDensity() {
        return density;
    }

    public DepositDepth getDepositDepth() {
        return depositDepth;
    }

    public ThermalConductivity getThermalConductivity() {
        return thermalConductivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
