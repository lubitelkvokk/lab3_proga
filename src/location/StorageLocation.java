package location;

import actors.Person;
import devices.Device;
import items.lumbers.Lumber;
import location.exceptions.LocationOverflowException;

import java.util.Arrays;

public class StorageLocation {

    private Lumber[] lumberList = new Lumber[8];
    protected Person[] listOfPeople = new Person[8];
    protected Device[] listOfDevices = new Device[8];
    private boolean fully;

    public void addPeople(Person person) {
        int ind = 0;
        while (listOfPeople[ind] != null && ind < 7) {
            ind++;
        }
        listOfPeople[ind] = person;
    }

    public void removePeople(Person person) {
        int ind = 0;
        while (listOfPeople[ind] != person && ind < 7) {
            ind++;
        }
        listOfPeople[ind] = null;
    }

//    public Person[] getListOfPeople() {
//        return listOfPeople;
//    }

    public void addDevice(Device device) {
        int ind = 0;
        while (listOfDevices[ind] != null) {
            ind++;
        }
        listOfDevices[ind] = device;
    }

    public void removeDevice(Device device) {
        int ind = 0;
        while (listOfDevices[ind] != device) {
            ind++;
        }
        listOfDevices[ind] = null;
    }

    public void addLumber(Lumber lumber) {
        int ind = 0;
        try {
            while (lumberList[ind] != null && ind < 7) {
                ind++;
                if (ind == 7) {
                    fully = true;
                    throw new LocationOverflowException("CONSTRUCTION_SITE заполнена");
                }
            }
            if (!fully) {
                lumberList[ind] = lumber;
            }
        } catch (LocationOverflowException e) {
            e.printStackTrace();
        }

    }
//    public Device[] getListOfDevices() {
//        return listOfDevices;
//    }
//

    public boolean getFullness() {
        return fully;
    }

}

