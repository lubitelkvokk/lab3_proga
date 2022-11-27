package location;

import actors.Person;
import devices.Device;

import java.util.ArrayList;
import java.util.List;

public class Location {
    protected List<Person> listOfPeople = new ArrayList<Person>();
    protected List<Device> listOfDevices = new ArrayList<Device>();
    protected boolean weightless;

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
                "listOfPeople=" + listOfPeople +
                ", weightless=" + weightless +
                '}';
    }


}
