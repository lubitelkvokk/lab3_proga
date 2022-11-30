package location;

import actors.Person;
import devices.Device;
import items.lumbers.Lumber;

import java.util.ArrayList;
import java.util.List;

public class StorageLocation {
    protected List<Person> listOfPeople = new ArrayList<Person>();
    protected List<Device> listOfDevices = new ArrayList<Device>();
    private List<Lumber> lumberList = new ArrayList<Lumber>();
    private boolean fully;

    public void addPeople(Person person) {
        this.listOfPeople.add(person);
    }

    public void removePeople(Person person) {
        this.listOfPeople.remove(person);
    }

    public List<Person> getListOfPeople(){
        return listOfPeople;
    }

    public void addDevice(Device device) {
        listOfDevices.add(device);
    }

    public void removeDevice(Device device) {
        listOfDevices.remove(device);
    }
    public List<Device> getListOfDevices(){
        return listOfDevices;
    }


    public boolean getFullness() {
        return fully;
    }

    public void addLumber(Lumber lumber) {
        if (lumberList.size() > 8) {
            fully = true;
            System.out.println("ConstructionSite заполнена");
        } else {
            System.out.println(lumber.name() + " поступил на ConstructionSite");
            lumberList.add(lumber);
        }

    }
}
