package actors;

import actions.Moveable;
import actions.Passanger;
import devices.Device;
import items.Lumber;
import location.ConstructionSite;
import location.Location;
import specialties.Inventors;
import transport.Rover;

public class Shpuntik extends Person implements Inventors, Moveable, Passanger {


    public Shpuntik(int age, String galaxy, Location location) {
        super(age, galaxy, location);
    }

    @Override
    public void fixDevice(Device device) {
        device.fixDevice();
    }


    @Override
    public void seatIn(Rover rover) {
        System.out.println("Shpuntik сел в " + rover.getClass().getSimpleName());
        rover.addPassenger(this);
    }

    @Override
    public void comeOut(Rover rover) {
        System.out.println("Shpuntik вышел из " + rover.getClass().getSimpleName());
        rover.removePassanger(this);
    }

    public void clutterSite(Lumber... lumber) {
        if (location instanceof ConstructionSite) {

            ConstructionSite site = (ConstructionSite) location;
            for (Lumber l : lumber) {
                System.out.println("\nShpuntik завез " + l.name() + " на стройплощадку");
                site.addLumber(l);
            }

        }
    }


}
