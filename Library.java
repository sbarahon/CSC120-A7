import java.util.Hashtable;

public class Library extends Building {

    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;


    /**
     * Constructs the library object
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the amount of floors the library has
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        this.hasElevator = hasElevator;
        System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a book title to the libraries collection
     * @param title the title of the book being added to the collection
     */
    public void addTitle(String title){
        this.collection.put(title, true);
    }
  
    /**
     * Removes a book from the collection
     * @param title the title of the book being removed
     * @return the title of the book being removed
     */
    public String removeTitle(String title){
        this.collection.remove(title);
        return title;

    }

    /**
     * Checks out a book and updates inventory to indicate books availability
     * @param title the title of the book being checked out
     */
    public void checkOut(String title){
        this.collection.replace(title, true, false);
    }

    /**
     * Returns a book to the library and updates inventroy to indicate books availability
     * @param title the title of the book being returned
     */
    public void returnBook(String title){
        this.collection.replace(title, false, true);
    }

    /**
     * Checks whether a book is within the collection
     * @param title the name of a book
     * @return T/F: Whether or not it is part of the libraries collection
     */
    public boolean containsTitle(String title){ // returns true if the title appears as a key in the Libary's collection, false otherwise
        return this.collection.containsKey(title);
    }

    /**
     * Checks whether a book is within the collection if it's title is inputted as an int
     * @param title the name of the book
     * @return Whether or not it is part of the libraries collection
     */
    public boolean containsTitle(int title){
        int int_title = title;
        String str_title = String.valueOf(int_title);
        return this.collection.containsKey(str_title);
    }

    /**
     * Checks whether a given book is available
     * @param title the title of a book within the collection
     * @return T/F: Whether or not it is part of the libraries collection
     */
    public boolean isAvailable(String title){
        boolean value = this.collection.getOrDefault(title, false);
        
        if (value == true){
        System.out.println("\"" + title + "\" is Available!");
        } else {
        System.out.println("Sorry, \"" + title + "\" is not Available!");
        }
        return value;
    }


    /**
     * Checks whether a given book is available if it's title is inputted as an int
     * @param title the title of a book within the collection
     * @return T/F: Whether or not it is part of the libraries collection
     */
    public boolean isAvailable(int title){
        int int_title = title;
        String str_title = String.valueOf(int_title);

        boolean value = this.collection.getOrDefault(str_title, false);
        
        if (value == true){
        System.out.println("\"" + str_title + "\" is Available!");
        } else {
        System.out.println("Sorry, \"" + str_title + "\" is not Available!");
        }
        return value;
    }


    /**
     * Prints the libraries collection by indicating book title and it's availability
     */

    public void printCollection(){

        int num_books = this.collection.keySet().size();

        System.out.println("Current Collection:");

        for (int i=0;i < num_books; i++){
        Object book = this.collection.keySet().toArray()[i];
        System.out.println(book + ", Availability: " + this.collection.get(book));
        }
    }

    /**
     * Prints possible nagivation options for the user
     */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + isAvailable() \n + printCollection()");
    }

    /**
     * Accesses value indicating if House has an elevator
     * @return T/F: Whether or not the house has an elevator
     */
    public boolean hasElevator(){
        return this.hasElevator;
    }

     /**
     * Takes the user to desired floor
     * @throws a runtime exception if user tries to skip floor in Library with no elevator
     */
    public void goToFloor(int floorNum){
        if (this.hasElevator || Math.abs(floorNum - activeFloor) == 1 ){
            super.goToFloor(floorNum);
        } else {
            throw new RuntimeException("Sorry, you have to use the stairs to go up or down flights!");
        }
    }

    /**
     * Runs the main program
     * @param args an empty string array
     */
    public static void main(String[] args) {
        Library myLib = new Library("Neilson", "7 Neilson Drive", 4, true);
        myLib.addTitle("The Giver");
        myLib.addTitle("Diary of a Wimpy Kid");
        myLib.addTitle("1942");
        myLib.printCollection();
        myLib.checkOut("The Giver");
        myLib.isAvailable("The Giver");
        myLib.showOptions();
        System.out.println(myLib.containsTitle(1942));
        myLib.isAvailable(1942);
        myLib.enter();
        myLib.goToFloor(3);
        myLib.exit();
    }
    
}
