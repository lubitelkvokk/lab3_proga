package actors;

import actions.Moveable;
import location.Location;

public abstract class Person implements Moveable {
    Location location;

    public Person(Location location){
        this.location = location;
    }

    @Override
    public void goToLocation(Location location) {
        System.out.println(this.getClass().getSimpleName() + " отправляется в " + location.getClass().getSimpleName());
        this.location = location;
    }

}
