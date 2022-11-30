package actors;

import devices.Device;
import items.crystals.LunarCrystal;
import items.crystals.Lunit;
import location.ConstructionSite;
import location.Location;
import specialties.Researchers;

public class Znayka extends Person implements Researchers {

    public Znayka() {
    }


    public Znayka(String nativeGalaxy, Location location) {
        super(nativeGalaxy, location);
    }

    public Znayka(int age, String nativeGalaxy, Location location) {
        super(age, nativeGalaxy, location);
    }

    @Override
    public void research(LunarCrystal lunarCrystal) {
        System.out.println("Znayka исследует свойства " + lunarCrystal.getClass().getSimpleName());

    }

    @Override
    public void setCrystal(LunarCrystal lunarCrystal, Device device) {
        System.out.println("Znayka поместил " + lunarCrystal.getClass().getSimpleName() + " в " + device.getClass().getSimpleName());
        if (device.isServiceability()) {
            device.setCrystal(lunarCrystal);
        }
    }

    @Override
    public void detectCrystalDependence(LunarCrystal lunarCrystal) {
        if (lunarCrystal instanceof Lunit) {
            System.out.println("Znayka обнаружил, что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше и зона");
        }
    }

    @Override
    public void replaceCrystal(LunarCrystal lunarCrystal, Device device) {
        LunarCrystal prev = device.getCrystal();
        if (prev == null) {
            setCrystal(lunarCrystal, device);
        } else {

            System.out.println("Znayka заменил кристалл " + prev.getClass().getSimpleName() + " в " +
                    device.getClass().getSimpleName() + " на " + lunarCrystal.getClass().getSimpleName());
            if (device.isServiceability() && lunarCrystal.getSize() != prev.getSize() && prev instanceof Lunit && lunarCrystal instanceof Lunit) {
                detectCrystalDependence(lunarCrystal);
            }
        }

    }


    public void orderToFix(Device device, Person... people) {
        System.out.print("Znayka велел ");
        for (Person p : people) {
            System.out.print(p.getClass().getSimpleName() + " ");
        }
        System.out.println(" починить " + device.getClass().getSimpleName());
    }

    public void orderToStop(Person... people) {
        System.out.print("Znayka велел ");
        for (Person p : people) {
            System.out.print(p.getClass().getSimpleName() + " ");
        }
        System.out.println(" остановиться");
    }


    public void seeSituationOnSite(Person... people) {
        if (location instanceof ConstructionSite) {
            ConstructionSite site = (ConstructionSite) location;
            if (site.getFullness()) {
                System.out.print("Znayka увидел, что ");
                for (Person p : people) {
                    System.out.print(p.getClass().getSimpleName() + " ");
                }
                System.out.println(" завалили стройплощадку пиломатериалами");
            }

        }
    }


}
