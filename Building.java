import javax.management.RuntimeErrorException;

/** Defines a Building class */
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     * The default constructor for the building object
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * An overloaded constructor for the building object
     * @param address the building address
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    
    /**
     * An overloaded constructor for the building object
     * @param name the building name
     * @param address the building address
     */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    
    /**
     * Full constructor for the buildling object
     * @param name the building name
     * @param address the building address
     * @param nFloors the amount of floors the building has
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /* Accessors */

    /**
     * Accessor for the building name
     * @return the building name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for the address of the building 
     * @return the buildinga ddress
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Accessor for the amount of floors the building object has
     * @return the number of floors the building object contains
     */
    public int getFloors() {
        return this.nFloors;
    }

    /* Navigation methods */

    /**
     * Enters the user into the building
     * @return the building object
     */
    public Building enter() {
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Exits the user from the building
     * @throws a runtime exception if user tries to exit building they haven't entered
     * @throws a runtime exception if user tries to exit without being on the ground floor
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        return null; // We're outside now, so the building is null
    }

    /**
     * Takes the user to the floor indicated
     * @param floorNumt the floor the user wants to navigate to
     * @throws a runtime exception if user tries to use without entering building
     * @throws a runtime exception if user tries to input invalid building number
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Navigates the user up one floor
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Navigates the user down one floor
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }


    /**
     * Prints possible nagivation options for the user
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Dictates how to print the building object as a string
     * @return String representation of the building object
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /**
     * Runs the main program
     * @param args an empty string array
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();



        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.goToFloor(3);
        fordHall.goToFloor(1);
        fordHall.exit();
    }

}