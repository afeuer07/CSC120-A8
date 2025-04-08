public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for a Cafe, starts with supplies for roughly 200 cups of coffee
     * @param n String name
     * @param a String address
     */
     Cafe(String n, String a) {
        super(n,a);
        this.nCoffeeOunces = 1600;
        this.nSugarPackets = 400;
        this.nCreams = 400;
        this.nCups = 200;
        System.out.println("You have built a cafe!");
    }
    
    /**
     * checks that inventory has enough to make the coffee, restocks if not, and removes sold items from inventory
     * @param size Ounces of coffee sold
     * @param nSugarPackets number of sugar packets sold
     * @param nCreams number of creams sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock();
            System.out.println("Restocked supplies!");
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        
        System.out.println("Sold a coffee: " + size + " oz, " + nSugarPackets + " sugar packets, " + nCreams + " creams.");
    }

    /**
     * Sells a regular coffee, 12 oz, 1 sugar packet, 1 cream
     */
    public void sellCoffee(){
        if (this.nCoffeeOunces < 12 || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock();
            System.out.println("Restocked supplies!");
        }       
        
        this.nCoffeeOunces -= 12;
        this.nSugarPackets -= 1;
        this.nCreams -= 1;
        this.nCups -= 1;
        System.out.println("Sold a regular coffee: 12 oz, 1 sugar packet, 1 cream.");
    }

    /**
     * Sells a coffee with 1 sugar packet and 1 cream, but allows the user to specify the size
     * @param size Ounces of coffee sold
     */
    public void sellCofee(int size){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock();
            System.out.println("Restocked supplies!");
        }
        
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= 1;
        this.nCreams -= 1;
        this.nCups -= 1;
        System.out.println("Sold a coffee: " + size + " oz, 1 sugar packet, 1 cream.");
    }

    /**
     * Retocks all ingredients/supplies to starting amount
     */
    private void restock(){
        this.nCoffeeOunces+=1600;
        this.nSugarPackets+=400;
        this.nCreams+=400;
        this.nCups+=200;
    }

    /**
     * Prints out the available options for the Cafe
    */
    public void showOptions(){
    System.out.println("enter()\n exit()\n sellCoffee()\n restock()");
    }

    /**
     * Prevents customers from changing floors in the Cafe
     * @param floorNum the floor number to go to
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("Customers cannot go a different floor in this Cafe.");
    }

    /**
     * Prevents customers from going up a floor in the Cafe
     */
    public void goUp() {
        throw new RuntimeException("Customers cannot go a different floor in this Cafe.");
    }


    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Coffee Shop", "789 Coffee St");

        myCafe.sellCoffee(12, 2, 3);
        myCafe.sellCoffee(16, 3, 1);
        myCafe.sellCoffee(24, 5, 2);

        myCafe.sellCoffee(2000, 100, 100); 

        myCafe.sellCoffee(12, 1, 1);
    }
    
}
