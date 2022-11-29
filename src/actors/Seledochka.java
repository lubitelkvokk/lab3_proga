package actors;

import devices.Device;
import items.LunarCrystal;
import items.Lunit;
import location.Location;
import specialties.Researchers;

public class Seledochka extends Person implements Researchers {
    public Seledochka(int age, String nativeGalaxy, Location location) {
        super(age, nativeGalaxy, location);
    }

    @Override
    public void research(LunarCrystal lunarCrystal) {
        System.out.println("Seledochka исследует свойства " + lunarCrystal.getClass().getSimpleName());
    }

    @Override
    public void setCrystal(LunarCrystal lunarCrystal, Device device) {
        System.out.println("Seledochka поместилa " + lunarCrystal.getClass().getSimpleName() + " в " + device.getClass().getSimpleName());
        if (device.isServiceability()) {
            device.setCrystal(lunarCrystal);
        }
    }

    @Override
    public void detectCrystalDependence(LunarCrystal lunarCrystal) {
        if (lunarCrystal instanceof Lunit) {
            System.out.println("Seledochka обнаружилa, что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше и зона");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

//    @Override
//    public boolean equals(Object o){
//
//    }
}
