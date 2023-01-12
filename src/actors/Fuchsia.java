package actors;

import devices.Device;
import items.crystals.LunarCrystal;
import items.crystals.Lunit;
import location.Location;
import specialties.Researchers;

public class Fuchsia extends Person implements Researchers {
    public Fuchsia() {
    }

    public Fuchsia(String nativeGalaxy, Location location) {
        super(nativeGalaxy, location);
    }

    public Fuchsia(int age, String nativeGalaxy, Location location) {
        super(age, nativeGalaxy, location);
    }

    @Override
    public void research(LunarCrystal lunarCrystal) {
        System.out.println("Fuchsia исследует свойства " + lunarCrystal.getClass().getSimpleName());
    }

    @Override
    public void setCrystal(LunarCrystal lunarCrystal, Device device) {
        System.out.println("Fuchsia поместилa " + lunarCrystal.getClass().getSimpleName() + " в " + device.getClass().getSimpleName());
        device.setCrystal(lunarCrystal);

    }

    @Override
    public void replaceCrystal(LunarCrystal lunarCrystal, Device device) {
        LunarCrystal prev = device.getCrystal();
        if (prev == null) {
            setCrystal(lunarCrystal, device);
        } else {

            System.out.println("Fuchsia заменила кристалл" + prev.getClass().getSimpleName() + " в " +
                    device.getClass().getName() + " на " + lunarCrystal.getClass().getSimpleName());
            if (device.isServiceability() && lunarCrystal.getSize() != prev.getSize() && prev instanceof Lunit && lunarCrystal instanceof Lunit) {
                detectCrystalDependence(lunarCrystal);
            }
        }
    }

    @Override
    public void detectCrystalDependence(LunarCrystal lunarCrystal) {
        if (lunarCrystal instanceof Lunit) {
            System.out.println("Fuchsia обнаружилa, что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше и зона");
        }

    }

    public void detectFeatureLunit() {
        System.out.println("Fuchsia обнаружила, что зона невесомости перестала распространяться во все стороны, а распространяется лишь в одном направлении, на манер светового луча.");
    }
}
