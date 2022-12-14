package items.crystals;

import items.crystals.properties.Colors;
import items.crystals.properties.Density;
import items.crystals.properties.DepositDepth;
import items.crystals.properties.ThermalConductivity;

// TODO
public class AntiLunit extends LunarCrystal {

    public AntiLunit(double size) {
        super(size, Colors.BLUISH, ThermalConductivity.LOW, Density.HIGH, DepositDepth.DEEP);
        System.out.println("На расстоянии " + size * 0.1 + " м^2 от Antilunit гравитационное поле прекращает действие");
    }

}
