/* This is a stub for the Cafe class */

//extending
public class Cafe extends Building {

    //attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /** 
    *  Creates constructor
    *  @param name  The names of residents
    *  @param address  The address of house
    *  @param nFloors  The number of floors
    *  @param nCoffeeOunces  The numbers of coffee ounces
    *  @param nSugarPackets  The numbers of sugar packets
    *  @param nCreams  The numbers of creams
    *  @param nCups  The numbers of cups that are left
    */

    //constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        //inheriting 
        super(name, address, nFloors);
        System.out.println("\n===\nYou have built a cafe: ☕\n===\n");

        //setting start values
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /* Showing options */

    @Override public void showOptions() {
        super.showOptions();
        System.out.println("Available options at " + this.name + " specifically:\n + sellCoffee() \n + restock()");
    }

    /** Does not let you move above the 1st floor
    * @param floorNum number of the floor you want to go to
    */
    
    @Override public void goToFloor(int floorNum) {
        if (floorNum == 1){
            System.out.println("You are on floor #1 of the cafe.");
        }
        
        else{
            throw new RuntimeException("\nYou cannot go there because it is a staff-only floor. \nPlease stay on the 1st floor.");
        }
    }

    /** 
    *  Decreases the items used when a coffee is sold and prints inventory
    *  @param size  The ounces of coffee
    *  @param nSugarPackets  The number of sugar packets
    *  @param nCreams  The number creams used 
    */

    public void sellCoffee(int nCoffeeOunces, int nSugarPackets, int nCreams){
        System.out.println("\n----------\nCoffee sold!!\nThank you for your order!!\n----------\n");
        
        if (this.nCoffeeOunces >= nCoffeeOunces && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1){
            this.nCoffeeOunces -= nCoffeeOunces;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Decreased stock for a coffee.");
        }

        else{
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
            this.nCoffeeOunces -= nCoffeeOunces;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Decreased stock for a coffee.");
        }

        System.out.println("\nNumber of items left:");
        System.out.println("Coffee ounces: " + this.nCoffeeOunces + ", Sugar Packets: " + this.nSugarPackets + ", Creams: " + this.nCreams + ", Cups: " + this.nCups +"\n");
    }

    public void sellCoffee(double nCoffeeOunces, double nSugarPackets, double nCreams){
        System.out.println("\n----------\nCoffee sold!!\nThank you for your order!!\n----------\n");
        
        if (this.nCoffeeOunces >= nCoffeeOunces && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1){
            this.nCoffeeOunces -= nCoffeeOunces;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Decreased stock for a coffee.");
        }

        else{
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
            this.nCoffeeOunces -= nCoffeeOunces;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Decreased stock for a coffee.");
        }

        System.out.println("\nNumber of items left:");
        System.out.println("Coffee ounces: " + this.nCoffeeOunces + ", Sugar Packets: " + this.nSugarPackets + ", Creams: " + this.nCreams + ", Cups: " + this.nCups +"\n");
    }


    /** 
    *  Restocks the items needed in a cafe and prints inventory
    *  @param nCoffeeOunces  The numbers of coffee ounces
    *  @param nSugarPackets  The numbers of sugar packets
    *  @param nCreams  The numbers of creams
    *  @param nCups  The numbers of cups that are left
    */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked items.");
        System.out.println("[UPDATED] Number of items left:");
        System.out.println("Coffee ounces: " + this.nCoffeeOunces + ", Sugar Packets: " + this.nSugarPackets + ", Creams: " + this.nCreams + ", Cups: " + this.nCups +"\n");
    }

    private void restock(double nCoffeeOunces, double nSugarPackets, double nCreams, double nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked items.");
        System.out.println("[UPDATED] Number of items left:");
        System.out.println("Coffee ounces: " + this.nCoffeeOunces + ", Sugar Packets: " + this.nSugarPackets + ", Creams: " + this.nCreams + ", Cups: " + this.nCups +"\n");
    }


    //main
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Woodstar Cafe", "Northampton", 1, 40, 5, 6, 7);
        System.out.println(myCafe);
        myCafe.sellCoffee(110, 1, 1);
        myCafe.sellCoffee(110.0, 1.0, 1.0);
        myCafe.goToFloor(1);
    }
}
