package transport;

import actions.Moveable;
import actions.Passanger;
import actors.Person;
import location.Location;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Moveable {
    Location location;
    private List<Passanger> passangers = new ArrayList<Passanger>();


    @Override
    public void goToLocation(Location location) {
        if (!passangers.isEmpty()) {
            this.location = location;
            System.out.println("Rover отправляется в " + location.getClass().getSimpleName());
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
}
