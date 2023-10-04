package Week7;

import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.Timeout;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;


import static org.junit.Assert.*;

/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Spring 2021</p>
 *
 * @author Purdue CS 
 * @version January 19, 2021
 */
public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
        	for (Failure failure : result.getFailures()) {
            	System.out.println(failure.toString());
        	}
        }
    }
    
    /**
     * A set of public test cases.
     *
     * <p>Purdue University -- CS18000 -- Spring 2021</p>
     *
     * @author Purdue CS 
     * @version January 19, 2021
     */
    public static class TestCase {
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

            Assert.assertTrue("Ensure that `Restaurant` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `Restaurant` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Restaurant` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `Restaurant` implements no interfaces!", 0, superinterfaces.length);
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

            Assert.assertTrue("Ensure that `Flavor` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `Flavor` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Flavor` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `Flavor` implements no interfaces!", 0, superinterfaces.length);
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

            Assert.assertTrue("Ensure that `IceCream` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `IceCream` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `IceCream` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `IceCream` implements no interfaces!", 0, superinterfaces.length);
        }
        
        
       
		

    }    
}