package location;

import actors.Person;
import devices.Device;
import items.lumbers.Lumber;

// TODO
public class Location {
    private final int x, y;
    private final StorageLocation storageLocation = new StorageLocation();
    private final TypeOfLocation typeOfLocation;
    private boolean weightless;

    public Location(TypeOfLocation typeOfLocation, int x, int y) {
        this.typeOfLocation = typeOfLocation;
        this.x = x;
        this.y = y;
    }

    public Pair getCoords() {
        return new Pair(x, y);
    }

    public TypeOfLocation getTypeOfLocation() {
        return typeOfLocation;
    }
    public Person[] getListOfPeople() {
        return storageLocation.listOfPeople;
    }

    public boolean getWeightless() {
        return weightless;
    }

    public void setWeightless(boolean weightless) {
        System.out.println("На " + typeOfLocation + " действует невесомость. Работа с тяжестями облегчена и ускорена.");
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

    public boolean searchPerson(Person person) {
        for (Person x : storageLocation.listOfPeople) {
            if (x != null && x.equals(person)) {
                return true;
            }
        }
        return false;
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
        return x * 257 + y * 139 + typeOfLocation.hashCode() >> 3;
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
        return x == o.x && y == o.y && typeOfLocation == o.typeOfLocation;
    }

    public static class Pair {
        double x;
        double y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

}
