package items.crystals;

import items.crystals.properties.Colors;
import items.crystals.properties.Density;
import items.crystals.properties.DepositDepth;
import items.crystals.properties.ThermalConductivity;

public class AntiLunit extends LunarCrystal {
    protected Colors color = Colors.BLUISH;
    protected ThermalConductivity thermalConductivity = ThermalConductivity.LOW;
    protected Density density = Density.HIGH;
    protected DepositDepth depositDepth = DepositDepth.DEEP;

    public AntiLunit(double size) {
        super(size);
        System.out.println("На расстоянии " + size * 0.1 + " м^2 от Antilunit гравитационное поле прекращает действие");
    }

}
