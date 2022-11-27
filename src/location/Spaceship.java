package location;

import devices.Device;

import java.util.ArrayList;
import java.util.List;

public class Spaceship extends Location{
    private List<Device> listOfDevices = new ArrayList<Device>();

    public void addDevice(Device device) {
        listOfDevices.add(device);
    }

    public void removeDevice(Device device) {
        listOfDevices.remove(device);
    }

}
