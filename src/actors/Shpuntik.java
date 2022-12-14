package actors;

import actions.Moveable;
import actions.Passenger;
import devices.Device;
import items.lumbers.Lumber;
import location.Location;
import location.TypeOfLocation;
import specialties.Inventors;
import transport.Rover;

public class Shpuntik extends Person implements Inventors, Moveable, Passenger {

    public Shpuntik() {
    }

    public Shpuntik(String nativeGalaxy, Location location) {
        super(nativeGalaxy, location);
    }

    public Shpuntik(int age, String nativeGalaxy, Location location) {
        super(age, nativeGalaxy, location);
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
        if (location.getTypeOfLocation() == TypeOfLocation.CONSTRUCTION_SITE) {

            for (Lumber l : lumber) {
                System.out.println("\nShpuntik завез " + l.name() + " на " + location.getTypeOfLocation());
                location.addLumber(l);
            }

        }
    }


}
