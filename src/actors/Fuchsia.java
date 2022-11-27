package actors;

import devices.Device;
import devices.Magnet;
import devices.WeightlessDevice;
import items.LunarCrystal;
import items.Lunit;
import location.Location;
import specialties.Researchers;

public class Fuchsia extends Person implements Researchers {
    public Fuchsia(Location location) {
        super(location);
    }

    @Override
    public void research(LunarCrystal lunarCrystal) {
        System.out.println("Fuchsia исследует свойства " + lunarCrystal.getClass().getSimpleName());
    }

    @Override
    public void setCrystal(LunarCrystal lunarCrystal, Device device) {
        System.out.println("Fuchsia поместилa " + lunarCrystal.getClass().getSimpleName() + " в " + device.getClass().getSimpleName());
        if (device.isServiceability()){
            device.setCrystal(lunarCrystal);
        }

    }

    @Override
    public void detectCrystalDependence(LunarCrystal lunarCrystal) {
        if (lunarCrystal instanceof Lunit){
            System.out.println("Fuchsia обнаружилa, что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше и зона");
        }

    }
    public void detectFeatureLunit(){
        System.out.println("Fuchsia обнаружила, что зона невесомости перестала распространяться во все стороны, а распространяется лишь в одном направлении, на манер светового луча.");
    }
}
