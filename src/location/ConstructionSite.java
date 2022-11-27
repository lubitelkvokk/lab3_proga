package location;

import items.Lumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConstructionSite extends Location{
    private List<Lumber> lumberList = new ArrayList<Lumber>();
    private boolean fully;
    public List<Lumber> getLumberList() {
        return lumberList;
    }
    public boolean getFullness(){
        return fully;
    }
    public void addLumber(Lumber lumber) {
        if (lumberList.size() > 8 ){
            fully = true;
            System.out.println("ConstructionSite заполнена");
        }
        else{
            System.out.println(lumber.name() + " поступил на ConstructionSite");
            lumberList.add(lumber);
        }

    }

}
