package Midterm1;

import org.junit.*;

import static org.junit.Assert.*;

public class LuggageTest {

    @Test
    public void testConstructorAndGetters() {
        Luggage luggage = new Luggage("Tumi", "Alpha", "Backpack", "Medium", 15.00, 450.00);
        assertEquals("Tumi", luggage.getBrand());
        assertEquals("Alpha", luggage.getModel());
        assertEquals("Backpack", luggage.getType());
        assertEquals("Medium", luggage.getSize());
        assertEquals(15.00, luggage.getWeight(), 0.01);
        assertEquals(450.00, luggage.getPurchasePrice(), 0.01);
    }

    @Test
    public void testSetters() {
        Luggage luggage = new Luggage("Tumi", "Alpha", "Backpack", "Medium", 15.00, 450.00);
        luggage.setBrand("Samsonite");
        luggage.setModel("ModelX");
        luggage.setType("Suitcase");
        luggage.setSize("Large");
        luggage.setWeight(20.00);
        luggage.setPurchasePrice(500.00);

        assertEquals("Samsonite", luggage.getBrand());
        assertEquals("ModelX", luggage.getModel());
        assertEquals("Suitcase", luggage.getType());
        assertEquals("Large", luggage.getSize());
        assertEquals(20.00, luggage.getWeight(), 0.01);
        assertEquals(500.00, luggage.getPurchasePrice(), 0.01);
    }

    @Test
    public void testToString() {
        Luggage luggage = new Luggage("Tumi", "Alpha", "Backpack", "Medium", 15.00, 450.00);
        String expected = "Luggage<brand=Tumi, model=Alpha, type=Backpack, size=Medium, weight=15.00, purchasePrice=450.00>";
        assertEquals(expected, luggage.toString());
    }

    @Test
    public void testAddLuggage() {
        Luggage luggage1 = new Luggage("Brand1", "Model1", "Type1", "Size1", 10.00, 300.00);
        TravelersLuggage travelersLuggage = new TravelersLuggage();
        assertTrue(travelersLuggage.addLuggage(luggage1));
        assertEquals(1, travelersLuggage.getLuggageCount());
    }

    @Test
    public void testRemoveLuggage() {
        Luggage luggage1 = new Luggage("Brand1", "Model1", "Type1", "Size1", 10.00, 300.00);
        TravelersLuggage travelersLuggage = new TravelersLuggage(luggage1, null, null);
        assertTrue(travelersLuggage.removeLuggage(luggage1));
        assertEquals(3, travelersLuggage.getOpenings());
    }

    @Test
    public void testGetOpeningsAndLuggageCount() {
        Luggage luggage1 = new Luggage("Brand1", "Model1", "Type1", "Size1", 10.00, 300.00);
        Luggage luggage2 = new Luggage("Brand2", "Model2", "Type2", "Size2", 15.00, 350.00);
        TravelersLuggage travelersLuggage = new TravelersLuggage(luggage1, luggage2, null);

        assertEquals(1, travelersLuggage.getOpenings());
        assertEquals(2, travelersLuggage.getLuggageCount());
    }

    @Test
    public void testCalculateAveragePrice() {
        Luggage luggage1 = new Luggage("Brand1", "Model1", "Type1", "Size1", 10.00, 300.00);
        Luggage luggage2 = new Luggage("Brand2", "Model2", "Type2", "Size2", 15.00, 350.00);
        TravelersLuggage travelersLuggage = new TravelersLuggage(luggage1, luggage2, null);

        assertEquals(325.00, travelersLuggage.calculateAveragePrice(), 0.01);
    }

    @Test
    public void testGetHeaviestLuggage() {
        Luggage luggage1 = new Luggage("Brand1", "Model1", "Type1", "Size1", 10.00, 300.00);
        Luggage luggage2 = new Luggage("Brand2", "Model2", "Type2", "Size2", 15.00, 350.00);
        TravelersLuggage travelersLuggage = new TravelersLuggage(luggage1, luggage2, null);

        assertEquals(luggage2, travelersLuggage.getHeaviestLuggage());
    }

    // Test case to ensure adding more than 3 luggages is not possible
    @Test
    public void testAddExcessLuggage() {
        Luggage luggage1 = new Luggage("Brand1", "Model1", "Type1", "Size1", 10.00, 300.00);
        Luggage luggage2 = new Luggage("Brand2", "Model2", "Type2", "Size2", 15.00, 350.00);
        Luggage luggage3 = new Luggage("Brand3", "Model3", "Type3", "Size3", 20.00, 400.00);
        Luggage luggage4 = new Luggage("Brand4", "Model4", "Type4", "Size4", 25.00, 450.00);

        TravelersLuggage travelersLuggage = new TravelersLuggage();
        assertTrue(travelersLuggage.addLuggage(luggage1));
        assertTrue(travelersLuggage.addLuggage(luggage2));
        assertTrue(travelersLuggage.addLuggage(luggage3));
        assertFalse(travelersLuggage.addLuggage(luggage4));  // should not be possible to add fourth luggage
    }
}
