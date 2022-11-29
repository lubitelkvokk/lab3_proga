package actors;

import devices.Device;
import items.LunarCrystal;
import items.Lunit;
import location.ConstructionSite;
import location.Location;
import specialties.Researchers;

public class Znayka extends Person implements Researchers {


    public Znayka(int age,String galaxy, Location location) {
        super(age, galaxy, location);
    }

    @Override
    public void research(LunarCrystal lunarCrystal) {
        System.out.println("\nZnayka исследует свойства " + lunarCrystal.getClass().getSimpleName());
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


    public void orderToFix(Device device, Person... people) {
        System.out.print("\nZnayka велел ");
        for (Person p : people) {
            System.out.print(p.getClass().getSimpleName() + " ");
        }
        System.out.print(" починить " + device.getClass().getSimpleName());
    }

    public void orderToStop(Person... people) {
        System.out.print("\nZnayka велел");
        for (Person p : people) {
            System.out.print(p.getClass().getSimpleName() + " ");
        }
        System.out.print(" остановиться");
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
