package Week7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

public class RunLocalTest {

    private Flavor flavor;
    private Restaurant restaurant;
    private IceCream iceCream;

    private final PrintStream originalOutput = System.out;
    private final InputStream originalSysin = System.in;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayInputStream testIn;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayOutputStream testOut;

    @Before
    public void outputStart() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreInputAndOutput() {
        System.setIn(originalSysin);
        System.setOut(originalOutput);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @SuppressWarnings("SameParameterValue")
    private void receiveInput(String str) {
        testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }

    @Before
    public void setUp() {
        flavor = new Flavor("Chocolate", 2.5);
        // Create sample data for testing
        Flavor[] flavors = new Flavor[]{
                flavor,
                null,
                new Flavor("Strawberry", 3.0)
        };

        int[][] cupsSold = new int[][]{
                {100, 120, 130, 110, 150, 140, 100},
                {90, 110, 100, 120, 80, 90, 70},
                {80, 70, 60, 50, 40, 30, 20}
        };
        restaurant = new Restaurant("Test Restaurant", flavors, cupsSold, 40, true);

        Flavor[] flavorsForIceCream = new Flavor[]{
                new Flavor("Mint", 3.0),
                new Flavor("Caramel", 3.5),
                new Flavor("Cookie Dough", 4.0)
        };
        Restaurant[] restaurantsForIceCream = new Restaurant[]{
                restaurant,
                new Restaurant("New Restaurant 1", flavorsForIceCream, cupsSold, 50, false),
                new Restaurant("New Restaurant 2", flavorsForIceCream, cupsSold, 45, true)
        };
        iceCream = new IceCream(restaurantsForIceCream, true, 2, 1);

    }

    @Test(timeout = 1000)
    public void testAddFlavor() {
        // Create a new flavor to add
        Flavor newFlavor1 = new Flavor("Mango", 3.5);
        Flavor newFlavor2 = new Flavor("Coffee", 4.0);

        // Add the new flavor
        restaurant.addFlavor(newFlavor1);

        // Check if the flavor was added at the first null position
        Flavor[] updatedFlavors = restaurant.getFlavors();
        String capturedOutput = getOutput();
        //assertEquals("Error, no available space!", capturedOutput);

        // Second test
        restaurant.addFlavor(newFlavor1);
        restaurant.addFlavor(newFlavor2);
        updatedFlavors = restaurant.getFlavors();

        assertEquals("Chocolate", updatedFlavors[0].getName());
        assertEquals(2.5, updatedFlavors[0].getCost(), 0.01);
        assertEquals("Mango", updatedFlavors[1].getName());
        assertEquals(3.5, updatedFlavors[1].getCost(), 0.01);
        assertEquals("Strawberry", updatedFlavors[2].getName());
        assertEquals(3.0, updatedFlavors[2].getCost(), 0.01);

    }

    @Test(timeout = 1000)
    public void testAddFlavorNoAvailableSpace() {
        // Fill up all available positions in the flavors array
        Flavor[] flavors = restaurant.getFlavors();
        for (int i = 0; i < flavors.length; i++) {
            restaurant.addFlavor(new Flavor("Flavor" + i, 2.0 + i));
        }

        // Attempt to add one more flavor (should print "Error, no available space!")
        Flavor newFlavor = new Flavor("Extra Flavor", 4.0);

        // Capture the printed output to check for the error message
        outputStart();
        restaurant.addFlavor(newFlavor);
        String output = getOutput();

        // Check that the error message is printed
        assertTrue(output.contains("Error, no available space!"));

        // Check that no additional flavors were added
        Flavor[] updatedFlavors = restaurant.getFlavors();
        assertEquals(flavors.length, updatedFlavors.length);
    }


    @Test
    public void testFlavor() {
        assertEquals("Chocolate", flavor.getName());
        assertEquals(2.5, flavor.getCost(), 0.01);
    }

    @Test
    public void testRestaurantTotalSales() {
        double totalSales = restaurant.totalSales();
        assertEquals(4495d, totalSales, 0.01);
    }

    @Test
    public void testRestaurantClose() {
        double totalSales = restaurant.totalSales();
        double numberOfClosedBusinesses = restaurant.closeRestaurant();
        assertEquals(totalSales, numberOfClosedBusinesses, 0.01);
        assertNull(restaurant.getName());
        assertNull(restaurant.getFlavors());
        assertNull(restaurant.getCupsSold());
        assertEquals(0, restaurant.getHours());
        assertFalse(restaurant.hasSummerDiscount());
    }

    @Test
    public void testIceCreamApplySummerDiscounts() {
        iceCream.applySummerDiscounts();
        assertTrue(restaurant.getFlavors()[0].getCost() < 2.5);
        assertTrue(restaurant.getFlavors()[1].getCost() < 2.0);
        assertTrue(restaurant.getFlavors()[2].getCost() < 3.0);
    }

    @Test(timeout = 1000)
    public void testIceCreamCloseBusinesses() {
        int numberOfClosedBusinesses = iceCream.closeBusinesses();
        assertEquals(1, numberOfClosedBusinesses);
    }


    @Test(timeout = 1000)
    public void restaurantClassDeclarationTest() {
        Class<?> clazz;
        int modifiers;
        Class<?> superclass;
        Class<?>[] superinterfaces;
        // Set the class being tested
        clazz = Restaurant.class;
        // Perform tests

        modifiers = clazz.getModifiers();

        superclass = clazz.getSuperclass();

        superinterfaces = clazz.getInterfaces();

        assertTrue("Ensure that `Restaurant` is `public`!", Modifier.isPublic(modifiers));

        assertFalse("Ensure that `Restaurant` is NOT `abstract`!", Modifier.isAbstract(modifiers));

        assertEquals("Ensure that `Restaurant` extends `Object`!", Object.class, superclass);

        assertEquals("Ensure that `Restaurant` implements no interfaces!", 0, superinterfaces.length);
    }

    @Test(timeout = 1000)
    public void flavorClassDeclarationTest() {
        Class<?> clazz;
        int modifiers;
        Class<?> superclass;
        Class<?>[] superinterfaces;

        // Set the class being tested
        clazz = Flavor.class;

        // Perform tests
        modifiers = clazz.getModifiers();

        superclass = clazz.getSuperclass();

        superinterfaces = clazz.getInterfaces();

        assertTrue("Ensure that `Flavor` is `public`!", Modifier.isPublic(modifiers));

        assertFalse("Ensure that `Flavor` is NOT `abstract`!", Modifier.isAbstract(modifiers));

        assertEquals("Ensure that `Flavor` extends `Object`!", Object.class, superclass);

        assertEquals("Ensure that `Flavor` implements no interfaces!", 0, superinterfaces.length);
    }

    @Test(timeout = 1000)
    public void iceCreamClassDeclarationTest() {
        Class<?> clazz;
        int modifiers;
        Class<?> superclass;
        Class<?>[] superinterfaces;

        // Set the class being tested
        clazz = IceCream.class;

        // Perform tests

        modifiers = clazz.getModifiers();

        superclass = clazz.getSuperclass();

        superinterfaces = clazz.getInterfaces();

        assertTrue("Ensure that `IceCream` is `public`!", Modifier.isPublic(modifiers));

        assertFalse("Ensure that `IceCream` is NOT `abstract`!", Modifier.isAbstract(modifiers));

        assertEquals("Ensure that `IceCream` extends `Object`!", Object.class, superclass);

        assertEquals("Ensure that `IceCream` implements no interfaces!", 0, superinterfaces.length);
    }
}