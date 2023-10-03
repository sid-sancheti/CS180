package Midterm1;
public class TravelersLuggage {
    private Luggage luggageOne;
    private Luggage luggageTwo;
    private Luggage luggageThree;

    // Constructor
    public TravelersLuggage(Luggage luggageOne, Luggage luggageTwo, Luggage luggageThree) {
        this.luggageOne = luggageOne;
        this.luggageTwo = luggageTwo;
        this.luggageThree = luggageThree;
    }

    public TravelersLuggage() {} // Default constructor

    
    public boolean addLuggage(Luggage luggage) {
        if (luggageOne == null) {
            luggageOne = luggage;
            return true;
        } else if (luggageTwo == null) {
            luggageTwo = luggage;
            return true;
        } else if (luggageThree == null) {
            luggageThree = luggage;
            return true;
        } else {
            return false;
        }
    } 


    public boolean removeLuggage(Luggage luggage) {

        if (luggageOne != null && luggage.getBrand().equals(luggageOne.getBrand()) && luggage.getModel().equals(luggageOne.getModel()) && luggage.getType().equals(luggageOne.getType())) {
            luggageOne = null;
            return true;
        } else if (luggageTwo != null && luggage.getBrand().equals(luggageTwo.getBrand()) && luggage.getModel().equals(luggageTwo.getModel()) && luggage.getType().equals(luggageTwo.getType())) {
            luggageTwo = null;
            return true;
        } else if (luggageThree != null && luggage.getBrand().equals(luggageThree.getBrand()) && luggage.getModel().equals(luggageThree.getModel()) && luggage.getType().equals(luggageThree.getType())) {
            luggageThree = null;
            return true;
        } else {
            return false;
        }
    }

    public int getOpenings() {
        int counter = 0;
        if (luggageOne == null)
            counter++;
        if (luggageTwo == null)
            counter++;
        if (luggageThree == null)
            counter++;

        return counter;
    }

    public int getLuggageCount() {
        int counter = 0;
        if (luggageOne != null)
            counter++;
        if (luggageTwo != null)
            counter++;
        if (luggageThree != null)
            counter++;
        
        return counter;
    }

    public double calculateAveragePrice() {
        double sum = 0;
        if (luggageOne != null)
            sum += luggageOne.getPurchasePrice();
        if (luggageTwo != null)
            sum += luggageTwo.getPurchasePrice();
        if (luggageThree != null)
            sum += luggageThree.getPurchasePrice();

        
        return sum / getLuggageCount();
    }

    /**
     * Return the heaviest (one with the highest weight value) of the non-null Luggage fields. 
     * @return
     */
    public Luggage getHeaviestLuggage() {
        Luggage heaviest = luggageOne;
        if (luggageTwo != null && luggageTwo.getWeight() > heaviest.getWeight())
            heaviest = luggageTwo;
        if (luggageThree != null && luggageThree.getWeight() > heaviest.getWeight())
            heaviest = luggageThree;

        return heaviest;
    }

}

