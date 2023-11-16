import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;
    ArrayList<House> houses;
    ArrayList<Cafe> cafes;
    ArrayList<Library> libraries;
    

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
        houses = new ArrayList<House>();
        cafes = new ArrayList<Cafe>();
        libraries = new ArrayList<Library>();
        
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Baldwin House", "15 Bedford Terrace Northampton, MA 01063", 4, false, false));
        myMap.addBuilding(new House("Lamont House", "17 Prospect St Northampton, MA 01063", 3, true, false));
        myMap.addBuilding(new Building("Botanic Garden", "16 College Ln Northampton, MA 01063", 1));
        myMap.addBuilding(new Building("Art Museum", "20 Elm St Northampton, MA 01063", 3));
        myMap.addBuilding(new Cafe("Campus Cafe", "100 Elm St Northampton, MA 01063", 2, 1, 1, 1, 1));
        myMap.addBuilding(new Library("Josten Library", "122 Green St Northampton, MA 01063", 2, true));
        myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm St Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Helen Hills Hills Chapel", "123 Elm St Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Ainsworth Gym", "102 Lower College Ln Northampton, MA 01063", 4));
        System.out.println(myMap);
    }
    
}
