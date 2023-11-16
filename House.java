/* This is a stub for the House class */

import java.util.ArrayList; 

/** 
 *  Class representing a House 
 *  The House is a building and it contains residents
 */
 
public class House extends Building {


  //attributes
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator; 
  

  /** 
  *  Constructs a house using its parameters and initializes residents
  *  @param name  The name of house
  *  @param address  The address of house
  *  @param nFloors  The number of floors
  *  @param hasDiningRoom  If the house has a dining room  
  *  @param hasElevator  If the house has an elevator 
  */

  //constructor 
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors);

        System.out.println("\n===\nYou have built a house: 🏠\n===\n");
        
        //initialize residents to a new ArrayList<String>()
        this.residents = new ArrayList<String>(); 
        this.hasDiningRoom = hasDiningRoom; //sets hasDiningRoom to indicate whether or not the house has a dining room. 
        this.hasElevator = hasElevator;
    }

  
  /** 
  *  Checks if the house has a dining room
  *  @return T/F on whether the house has a dining room or not 
  */

  //accessors
  public boolean hasDiningRoom(){ 
    return  this.hasDiningRoom;
  } 


  /** 
  *  Counts and returns the number of residents in the house
  *  @return the size of the residents 
  */

  public int nResidents(){
    return this.residents.size();
  }

    /* Showing Options */

  @Override public void showOptions() {
    super.showOptions();
    System.out.println("Available options at " + this.name + " specifically:\n + moveIn() \n + moveOut() \n + isResident() \n");
  }


  /** Lets you move to non-adjacent floors if there is an elevator
    * @param floorNum number of the floor you want to go to
    */
    
    @Override public void goToFloor(int floorNum) {
        if (floorNum == this.activeFloor + 1 || floorNum == this.activeFloor - 1){
            super.goToFloor(floorNum);
        }

        else if (this.hasElevator){
            super.goToFloor(floorNum);
        }

        else{
          throw new RuntimeException("\nYou cannot move between non-adjacent floors in a single action because there is no elevator. \nPlease use goUp() or goDown() to move between floors.");
        }
    }

  /** 
  *  Adds a new resident to the house and throws an exception if they are in the house already
  *  @param name  The name of the new resident
  */
  
  
  public void moveIn(String name){
    if (!this.residents.contains(name)){
      //adds name
      this.residents.add(name);
      System.out.println("Adding " + name + "...");
    }

    else{
      throw new RuntimeException("this person is already in the house");
    }
  }

  /** 
  *  Adds a new resident and their pet to the house
  *  @param name  The name of the new resident
  *  @param petName The name of the new resident's pet
  */

  public void moveIn(String name, String petName){
    if (!this.residents.contains(name)){
      //adds name of both of them
      this.residents.add(name);
      this.residents.add(petName);
      System.out.println("Added " + name + " and " + petName + " to the house!");
    }

    else{
      throw new RuntimeException("this person is already in the house");
    }
  }


  /** 
  *  Removes a resident from the house and throws an exception if they are out of the house already
  *  @param name  The name of the old resident 
  */

  public String moveOut(String name){
    // return the name of the person who moved out
    if (this.residents.contains(name)){
      //removes name
      this.residents.remove(name);
      System.out.println("Removing " + name + "...");
      return name + "is out of the house";
    }

    else{
      throw new RuntimeException("this person is already out of the house");
    }
  }

  /** 
  *  Removes a resident and their pet from the house
  *  @param name  The name of the resident
  *  @param petName The name of the resident's pet
  */

  public void moveOut(String name, String petName){
    if (this.residents.contains(name) || this.residents.contains(petName)){
      //removes names
      this.residents.remove(name);
      this.residents.remove(petName);
      System.out.println("Removed " + name + " and " + petName + " from the house :(");
    }

    else{
      throw new RuntimeException("they are already out of the house");
    }
  }


  /** 
  *  Tells if a resident is in the house or not  
  *  @param name The name of the resident 
  *  @return T/F on whether they are a resident or not
  */

  public boolean isResident(String person){
    System.out.println(person + " is a resident: " + (this.residents.contains(person) == true));
    return this.residents.contains(person) == true;
  }
  
  
  //main
  public static void main(String[] args) {
    House myHouse = new House("Baldwin", "Smith College", 4, false, false);
    System.out.println(myHouse);
    myHouse.hasDiningRoom();
    myHouse.nResidents();
    myHouse.moveIn("Phoebe", "j");
    myHouse.moveOut("Phoebe", "j");
    myHouse.enter();    
    myHouse.goToFloor(2);
  }
} 
