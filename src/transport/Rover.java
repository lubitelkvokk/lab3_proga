package transport;

import actions.Moveable;
import actions.Passenger;
import actors.Person;
import location.Location;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Moveable {

    public class HandleBar {
        int x;
    }
    private Location location;
    private int serialNumber;
    private int hp;
    private List<Passenger> passengers = new ArrayList<Passenger>();

    public Rover(int serialNumber, int hp) {
        this.serialNumber = serialNumber;
        this.hp = hp;
    }


    @Override
    public void goToLocation(Location location) {
        if (!passengers.isEmpty()) {
            this.location = location;
            System.out.println("Rover отправляется в " + location.getTypeOfLocation().name());
            for (Passenger p : passengers) {
                ((Person) p).goToLocation(location);
            }
        }
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void removePassanger(Passenger passenger) {
        passengers.remove(passenger);
    }

    public List<Passenger> getPassangers() {
        return passengers;
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
