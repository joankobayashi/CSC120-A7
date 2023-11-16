/* This is a stub for the Library class */

//importing
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/** 
 *  Class representing a Library 
 *  The Library is a building and it has a collection of books
 */

public class Library extends Building{
  
  //attribute
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /** 
  *  Creates a library with its name, address, and number of floors and creates a collection
  *  @param name  The name of house
  *  @param address  The address of house
  *  @param nFloors  The number of floors
  */

  //constructor
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("\n===\nYou have built a library: 📖\n===\n");

    //book is available (true) or currently checked out (false)
    this.collection = new Hashtable<String, Boolean>(); 
    this.hasElevator = hasElevator;
  }


  /* Shows Options */

  @Override public void showOptions() {
    super.showOptions();
    System.out.println("Available options at " + this.name + " specifically:\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()"); 
  }


    /** Lets you move to non-adjacent floors if there is an elevator
    * @param floorNum number of the floor you want to go to
    */
    
    @Override public void goToFloor(int floorNum) {
        if (this.hasElevator){
            super.goToFloor(floorNum);
        }

        else{
            throw new RuntimeException("\nYou cannot move between non-adjacent floors in a single action because there is no elevator. \nPlease use goUp() or goDown() to move between floors.");
        }
    }

  /** 
  *  Adds title of the book to the collection 
  *  @param title the title of the book, input from the user 
  */

  public void addTitle(String title){
    this.collection.put(title, true);
    System.out.println("Added "+ title);
  }

  public void addTitle(String title, String subTitle){
    this.collection.put(title, true);
    this.collection.put(subTitle, true);
    System.out.println("Added "+ title + " and " + subTitle);
  }


  /** 
  *  Removes title of the book from the collection 
  *  @param title the title of the book, input from the user 
  *  @return title of the removed book
  */

  public String removeTitle(String title){
    if (this.collection.containsKey(title)){
      this.collection.remove(title);
      //returns the title that we removed
      System.out.println("Removed "+ title);
      return title;
    }

    else{
      throw new RuntimeException("This book is not in the collection.");
    }
  }

  public String removeTitle(String title, String subTitle){
    if (this.collection.containsKey(title)){
      this.collection.remove(title);
      this.collection.remove(subTitle);
      
      //returns the title that we removed
      System.out.println("Removed "+ title + " and " + subTitle);
      return title;
    }

    else{
      throw new RuntimeException("This book is not in the collection.");
    }
  }


  /** 
  *  Checks out the book from the collection by changing the boolean to a false
  *  @param title the title of the book, input from the user 
  */

  public void checkOut(String title){
    if (this.collection.containsKey(title) && this.collection.containsValue(true)){
      this.collection.replace(title, false);
      System.out.println("Checked out "+ title);
    }

    else{
      throw new RuntimeException("This book is currently not available.");
    }
  }


  /** 
  *  Returns the book to the collection by changing the boolean to a true
  *  @param title the title of the book, input from the user 
  */

  public void returnBook(String title){
    if (this.collection.containsKey(title)){
      this.collection.replace(title, true);
      System.out.println("Returned "+ title);
    }

    else{
      throw new RuntimeException("This book is currently not in the collection. \nPlease add it to the collection first.");
    }
  }


  /** 
  *  Returns true if the title appears in the Libary's collection, false otherwise 
  *  @param title the title of the book, input from the user 
  *  @return T/F true or false 
  */ 

  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    }

    else{
      return false;
    }
  } 


  /** 
  *  Returns true if the title (the value) is currently available (true), false otherwise 
  *  @param title the title of the book, input from the user 
  *  @return T/F true or false 
  */ 

  public boolean isAvailable(String title){
    if (this.collection.containsValue(true)){
      return true;
    }

    else{
      return false;
    }
  }


  /** 
  *  Prints out the entire collection including checkout status
  *  Prints "This collection is EMPTY." otherwise
  */ 

  public void printCollection(){

    int arraySize = this.collection.size();
      if (arraySize == 0){
        System.out.println("\nThis collection is EMPTY.");
      }

      else {
        System.out.println("\n[COLLECTION]");

        Iterator<Map.Entry<String, Boolean>> itr = collection.entrySet().iterator();
        
        Map.Entry<String, Boolean> entry = null;
        
        while(itr.hasNext()){
          entry = itr.next();
          String availability = "";

          //if statements to change it to "available" "not available"
          if (entry.getValue() == true){
            availability = "Available";
          }

          else{
            availability = "Not Available";
          }

          System.out.println(" \"" + entry.getKey() + "\"" + " - " + availability);

        }
        System.out.println("----------\n");
      }
  }

  //main
  public static void main(String[] args) {
    Library myLibrary = new Library("Hiller Library", "Smith College", 3, true);
    System.out.println(myLibrary);
    myLibrary.addTitle("LOL");
    myLibrary.addTitle("HAHA", "I laughed");
    myLibrary.removeTitle("LOL");
    myLibrary.printCollection();

    myLibrary.checkOut("HAHA");
    myLibrary.isAvailable("HAHA");
    myLibrary.printCollection();
    myLibrary.enter();
    myLibrary.goToFloor(3);
  
  }
}