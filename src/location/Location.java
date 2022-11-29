package location;

import actors.Person;
import devices.Device;

import java.util.ArrayList;
import java.util.List;

public class Location {
    protected List<Person> listOfPeople = new ArrayList<Person>();
    protected List<Device> listOfDevices = new ArrayList<Device>();
    protected boolean weightless;
    protected int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean getWeightless() {
        return weightless;
    }

    public void setWeightless(boolean weightless) {
        System.out.println("На " + this.getClass().getSimpleName() + " действует невесомость. Работа с тяжестями облегчена и ускорена.");
        this.weightless = weightless;
    }

    public void addPeople(Person person) {
        this.listOfPeople.add(person);
    }

    public void removePeople(Person person) {
        this.listOfPeople.remove(person);
    }


    @Override
    public String toString() {
        return "Location{" +
                "listOfPeople: " + listOfPeople +
                ", weightless: " + weightless +
                '}';
    }

    @Override
    public int hashCode() {
        return x * 257 + y * 139;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Location o = (Location) obj;
        return x == o.x && y == o.y;
    }

}
