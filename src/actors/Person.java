package actors;

import actions.Moveable;
import location.Location;

public abstract class Person implements Moveable {
    private String nativeGalaxy;
    private int age;
    private Location location;

    public Person() {
    }


    public Person(String nativeGalaxy, Location location) {
        this.nativeGalaxy = nativeGalaxy;
        this.location = location;
    }

    public Person(int age, String nativeGalaxy, Location location) {
        this(nativeGalaxy, location);
        this.age = age;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void goToLocation(Location location) {
        System.out.println(this.getClass().getSimpleName() + " отправляется в " + location.getTypeOfLocation());
        this.location.removePeople(this);
        this.location = location;
        location.addPeople(this);
    }


    @Override
    public int hashCode() {
        return nativeGalaxy.hashCode() + age * 21;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass() || obj == null) {
            return false;
        }
        Person o = (Person) obj;
        return age == o.age && nativeGalaxy.equals(o.nativeGalaxy);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name: " + getClass().getSimpleName() +
                ", Native galaxy:" + nativeGalaxy + "" +
                ", Age: " + age +
                ", Location: " + location +
                '}';
    }
}
