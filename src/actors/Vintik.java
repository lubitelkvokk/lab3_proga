package actors;

import actions.Moveable;
import actions.Passanger;
import devices.Device;
import items.Lumber;
import location.ConstructionSite;
import location.Location;
import specialties.Inventors;
import transport.Rover;

public class Vintik extends Person implements Inventors, Moveable, Passanger {


    public Vintik(Location location) {
        super(location);
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
        if (location instanceof ConstructionSite) {
            System.out.println();
            ConstructionSite site = (ConstructionSite) location;
            for (Lumber l : lumber) {
                System.out.println("\nVintik завез " + l.name() + " на стройплощадку");
                site.addLumber(l);
            }
            System.out.println();
        }
    }


    }


