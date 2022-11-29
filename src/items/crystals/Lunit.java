package items.crystals;

import items.crystals.LunarCrystal;
import items.crystals.properties.Colors;
import items.crystals.properties.Density;
import items.crystals.properties.DepositDepth;
import items.crystals.properties.ThermalConductivity;

public class Lunit extends LunarCrystal {


    protected Colors color = Colors.VARIABLE;
    protected ThermalConductivity thermalConductivity = ThermalConductivity.VARIABLE;
    protected Density density = Density.VARIABLE;
    protected DepositDepth depositDepth = DepositDepth.VARIABLE;

    public Lunit(double size) {
        super(size);
    }

    public void setWeightlessRay() {
        System.out.println("Lunit распространяет невесомость на манер светового луча с углом " + size * 0.3 + "");
    }

    public void setWeightlessZone() {
        System.out.println("Lunit распространяет зону невесомости на " + size * 70 + " м^2");
    }


}
