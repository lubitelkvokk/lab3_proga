package items.crystals;

import items.crystals.properties.Colors;
import items.crystals.properties.Density;
import items.crystals.properties.DepositDepth;
import items.crystals.properties.ThermalConductivity;

// TODO
public class Lunit extends LunarCrystal {

    public Lunit(double size) {
        super(size, Colors.BLUISH, ThermalConductivity.LOW, Density.HIGH, DepositDepth.DEEP);

    }

    public void setWeightlessRay() {
        System.out.println("Lunit распространяет невесомость на манер светового луча с углом " + getSize() * 0.3);
    }

    public void setWeightlessZone() {
        System.out.println("Lunit распространяет зону невесомости на " + getSize() * 70 + " м^2");
    }


}
