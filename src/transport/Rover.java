package transport;

import actions.Moveable;
import actions.Passanger;
import actors.Person;
import location.Location;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Moveable {
    private Location location;
    private int serialNumber;
    private int hp;
    private List<Passanger> passangers = new ArrayList<Passanger>();

    public Rover(int serialNumber, int hp) {
        this.serialNumber = serialNumber;
        this.hp = hp;
    }

    @Override
    public void goToLocation(Location location) {
        if (!passangers.isEmpty()) {
            this.location = location;
            System.out.println("Rover отправляется в " + location.getTypeOfLocation().name());
            for (Passanger p : passangers) {
                ((Person) p).goToLocation(location);
            }
        }
    }

    public void addPassenger(Passanger passanger) {
        passangers.add(passanger);
    }

    public void removePassanger(Passanger passanger) {
        passangers.remove(passanger);
    }

    public List<Passanger> getPassangers() {
        return passangers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rover rover = (Rover) obj;
        return serialNumber == rover.serialNumber && hp == rover.hp;
    }

    @Override
    public int hashCode() {
        return serialNumber / 10 + hp * 27;
    }

    @Override
    public String toString() {
        return "Rover {" +
                "{Serial number: " + serialNumber
                + ", Horsepower: " + hp + "}";
    }
}
