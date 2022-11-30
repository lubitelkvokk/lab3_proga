package actors;

import devices.Device;
import location.Location;

public class Lunatic extends Person {


    public Lunatic() {
    }


    public Lunatic(String nativeGalaxy, Location location) {
        super(nativeGalaxy, location);
    }

    public Lunatic(int age, String nativeGalaxy, Location location) {
        super(age, nativeGalaxy, location);
    }

    public void crashDevices(Device... devices) {
        for (Device device : devices) {
            System.out.println(getClass().getSimpleName() + " испортил " + device.getClass().getSimpleName());
            device.breakDevice();
        }
    }
}
