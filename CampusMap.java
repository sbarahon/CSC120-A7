import java.util.ArrayList;

/** Defines a CampusMap class */
public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
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

    /**
     * Defines how the campus map object is to be printed as a string
     * @returns String representation of Campus Map object
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Runs the main program
     * @param args empty string array
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Decora House", "66 Paradise Road Northampton, MA 01060", 2, false, false));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063", 1));
        myMap.addBuilding(new House("Comstock House", "Mandelle Road Northampton, MA 01060", 4, true, true));
        myMap.addBuilding(new Library("Forbes Library", "20 West St Northampton, MA 01060", 2, true));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St Northampton, MA 01063", 1));
        myMap.addBuilding(new House("Wilson House", "16 Kensington Ave Northampton, MA 01060", 4, false, false));
        myMap.addBuilding(new House("Chase House", "45 Elm Street Northampton, MA 01063", 3, true, false));
        myMap.addBuilding(new Building("Ainsworth Gym and Olin Fitness Center", "102 Lower College Ln Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm St Northampton, MA 01060", 1 ));

        System.out.println(myMap);
    }
    
}
