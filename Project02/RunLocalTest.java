package Project02;
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
 * <p>Purdue University -- CS18000 -- Spring 2022</p>
 *
 * @author Purdue CS
 * @version January 10, 2022
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
     * <p>Purdue University -- CS18000 -- Spring 2022</p>
     *
     * @author Purdue CS
     * @version January 10, 2022
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
        public void classDeclarationTestOne() {
            Class<?> clazz = Session.class;

            int modifiers = clazz.getModifiers();

            Class<?>[] superinterfaces = clazz.getInterfaces();

            assertTrue("Ensure that `Session` is `public`!", Modifier.isPublic(modifiers));

            assertFalse("Ensure that `Session` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Session` implements no interfaces!", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void classDeclarationTestTwo() {
            Class<?> clazz = Lab.class;

            int modifiers = clazz.getModifiers();

            Class<?>[] superinterfaces = clazz.getInterfaces();

            assertTrue("Ensure that `Lab` is `public`!", Modifier.isPublic(modifiers));

            assertFalse("Ensure that `Lab` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Lab` implements no interfaces!", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void classDeclarationTestThree() {
            Class<?> clazz = LabManager.class;

            int modifiers = clazz.getModifiers();

            Class<?>[] superinterfaces = clazz.getInterfaces();

            assertTrue("Ensure that `LabManager` is `public`!", Modifier.isPublic(modifiers));

            assertFalse("Ensure that `LabManager` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `LabManager` implements no interfaces!", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void classDeclarationTestFour() {
            Class<?> clazz = TimeKeeper.class;

            int modifiers = clazz.getModifiers();

            Class<?>[] superinterfaces = clazz.getInterfaces();

            assertTrue("Ensure that `TimeKeeper` is `public`!", Modifier.isPublic(modifiers));

            assertFalse("Ensure that `TimeKeeper` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `TimeKeeper` implements no interfaces!", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void fullOutputTestOne() {
            try {

                String expected = "Welcome to the TimeKeeper application!" + System.lineSeparator() +
                        "1. Initialize Application" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "Thank you for using TimeKeeper!" + System.lineSeparator();

                String input = "2" + System.lineSeparator();
                receiveInput(input);
                TimeKeeper.main(new String[0]);
                String output = getOutput();
                expected = expected.replace("\r\n", "\n");
                output = output.replace("\r\n", "\n");
                Assert.assertEquals("Ensure TimeKeeper functions as described in the handout!", expected, output);
            } catch (Exception e){
                e.printStackTrace();
                fail();
            }
        }

        @Test(timeout = 1000)
        public void fullOutputTestTwo() {
            try {

                String expected = "Welcome to the TimeKeeper application!" + System.lineSeparator() +
                        "1. Initialize Application" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "Invalid input. Please try again." + System.lineSeparator() +
                        "1. Initialize Application" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "Invalid input. Please try again." + System.lineSeparator() +
                        "1. Initialize Application" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "Thank you for using TimeKeeper!" + System.lineSeparator();

                String input = "12" + System.lineSeparator() +
                        "99" + System.lineSeparator() +
                        "2" + System.lineSeparator();
                receiveInput(input);
                TimeKeeper.main(new String[0]);
                String output = getOutput();
                expected = expected.replace("\r\n", "\n");
                output = output.replace("\r\n", "\n");
                Assert.assertEquals("Ensure TimeKeeper functions as described in the handout!", expected, output);
            } catch (Exception e){
                e.printStackTrace();
                fail();
            }
        }

    }
}

