package location;

import actors.Person;
import devices.Device;
import items.lumbers.Lumber;

public class Location {
    protected boolean weightless;
    protected int x, y;
    protected StorageLocation storageLocation = new StorageLocation();
    protected TypeOfLocation typeOfLocation;

    public TypeOfLocation getTypeOfLocation() {
        return typeOfLocation;
    }

    public Location(TypeOfLocation typeOfLocation, int x, int y) {
        this.typeOfLocation = typeOfLocation;
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
        storageLocation.addPeople(person);
    }

    public void removePeople(Person person) {
        storageLocation.removePeople(person);
    }

    public void addDevice(Device device) {
        storageLocation.addDevice(device);
    }

    public void removeDevice(Device device) {
        storageLocation.removeDevice(device);
    }


    public boolean getFullness() {
        return storageLocation.getFullness();
    }

    public void addLumber(Lumber lumber) {
        storageLocation.addLumber(lumber);
    }

    @Override
    public String toString() {
        return "Location{" +
                "listOfPeople: " + storageLocation.listOfPeople +
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
