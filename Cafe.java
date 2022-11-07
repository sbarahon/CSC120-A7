/** Defines a Cafe class that extends Building */
public class Cafe extends Building{

    private int nCoffeeOunces = 100; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets = 100; // The number of sugar packets remaining in inventory
    private int nCreams = 100; // The number of "splashes" of cream remaining in inventory
    private int nCups = 100; // The number of cups remaining in inventory

    /**
     * Constructs the cafe class object
     * @param name the name of the cafe building
     * @param address the address of the cafe building
     * @param nFloors the number of floors the cafe building contains
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Updates the inventory as coffee is sold
     * @param size number of ounces the sold coffee contains
     * @param nSugarPackets number of sugar packets the sold coffee contains
     * @param nCreams the number of creams the sold coffee contains
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size){
        restock(100, 0, 0, 0);}
        if (this.nSugarPackets < nSugarPackets){
            restock(0, 100, 0, 0);}
        if (this.nCreams < nCreams){
            restock(0, 0, 100, 0);}
        if (this.nCups == 0){
            restock(0,0,0,100);}

        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
    }

    /**
     * Updates the inventory as coffee is sold
     * @param size number of ounces the sold coffee contains
     * @param nSugarPackets number of sugar packets the sold coffee contains
     */
    public void sellCoffee(int size, int nSugarPackets){
        if (this.nCoffeeOunces < size){
            restock(100, 0, 0, 0);}
        if (this.nSugarPackets < nSugarPackets){
            restock(0, 100, 0, 0);}
        if (this.nCups == 0){
            restock(0,0,0,100);}

        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets;
    }

     /**
     * Updates the inventory as coffee is sold
     * @param size number of ounces the sold coffee contains
     */
    public void sellCoffee(int size){
        if (this.nCoffeeOunces < size){
            restock(100, 0, 0, 0);}
        if (this.nCups == 0){
            restock(0,0,0,100);}

        this.nCoffeeOunces -= size; 
    }

    /**
     * Throws an exception if person tries to use elevator
     * @throws a runtime exception if user tries to use elevator
     */
    public void goToFloor(int floorNum){
        throw new RuntimeException("Sorry, no elevator available at this location!");    
    }

    /**
     * Restocks the inventory by updating the values
     * @param nCoffeeOunces amount of coffee ounces to restock
     * @param nSugarPackets amount of sugar packets to restock
     * @param nCreams amount of creams to restock
     * @param nCups amount of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups; 
    }

    /**
     * Prints possible nagivation options for the user
     */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + restock() \n + sellCoffee()");
    }

    /**
     * Runs the main program
     * @param args an empty string array
     */
    public static void main(String[] args) {
       Cafe myCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1);
        myCafe.sellCoffee(12, 2, 3);
        myCafe.sellCoffee(12, 2, 3);
        myCafe.showOptions();
        myCafe.enter();
        myCafe.goUp();
    }
    
}
