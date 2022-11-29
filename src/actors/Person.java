package actors;

import actions.Moveable;
import location.Location;

public abstract class Person implements Moveable {
    protected String nativeGalaxy;
    protected int age;
    Location location;


    public Person(int age, String nativeGalaxy, Location location) {
        this.age = age;
        this.nativeGalaxy = nativeGalaxy;
        this.location = location;
    }

    @Override
    public void goToLocation(Location location) {
        System.out.println(this.getClass().getSimpleName() + " отправляется в " + location.getClass().getSimpleName());
        this.location = location;
    }


    @Override
    public int hashCode() {
        return (getClass().getSimpleName()  + nativeGalaxy).hashCode() + age * 23;
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
        return hashCode() == obj.hashCode() && age == o.age && nativeGalaxy.equals((o.nativeGalaxy));
    }
}
