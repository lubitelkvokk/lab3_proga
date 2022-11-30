package actors;

import actions.Moveable;
import location.Location;

public abstract class Person implements Moveable {
    protected String nativeGalaxy;
    protected int age;
    protected Location location;

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

    @Override
    public void goToLocation(Location location) {
        System.out.println(this.getClass().getSimpleName() + " отправляется в " + location.getTypeOfLocation());
        this.location = location;
    }


    @Override
    public int hashCode() {
        return nativeGalaxy.hashCode() + age * 23;
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
