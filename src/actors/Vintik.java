package actors;

import actions.Moveable;
import actions.Passanger;
import devices.Device;
import items.lumbers.Lumber;
import location.Location;
import location.TypeOfLocation;
import specialties.Inventors;
import transport.Rover;

public class Vintik extends Person implements Inventors, Moveable, Passanger {


    public Vintik() {
    }


    public Vintik(String nativeGalaxy, Location location) {
        super(nativeGalaxy, location);
    }

    public Vintik(int age, String nativeGalaxy, Location location) {
        super(age, nativeGalaxy, location);
    }

    @Override
    public void fixDevice(Device device) {
        device.fixDevice();
    }

    @Override
    public void seatIn(Rover rover) {
        System.out.println("Vintik сел в " + rover.getClass().getSimpleName());
        rover.addPassenger(this);
    }

    @Override
    public void comeOut(Rover rover) {
        System.out.println("Vintik вышел из " + rover.getClass().getSimpleName());
        rover.removePassanger(this);
    }

    public void clutterSite(Lumber... lumber) {
        if (location.getTypeOfLocation() == TypeOfLocation.CONSTRUCTION_SITE) {
            System.out.println();
            for (Lumber l : lumber) {
                System.out.println("\nVintik завез " + l.name() + " на " + location.getTypeOfLocation());
                location.addLumber(l);
            }
            System.out.println();
        }
    }


}



