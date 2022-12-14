package location;

import actors.Person;
import devices.Device;
import items.lumbers.Lumber;

public class StorageLocation {

    private Lumber[] lumberList = new Lumber[8];
    protected Person[] listOfPeople = new Person[8];
    protected Device[] listOfDevices = new Device[8];
    private boolean fully;

    public void addPeople(Person person) {
        int ind = 0;
        while (listOfPeople[ind] != null) {
            ind++;
        }
        listOfPeople[ind] = person;
    }

    public void removePeople(Person person) {
        int ind = 0;
        while (listOfPeople[ind] != person) {
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
        while (lumberList[ind] != null && ind < 7) {
            ind++;
            if (ind == 7) {
                System.out.println("CONSTRUCTION_SITE заполнена");
                fully = true;
            }
        }
        if (!fully) {
            lumberList[ind] = lumber;
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

