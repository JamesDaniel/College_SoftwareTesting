/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author t00126681
 */
public class LoanTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public LoanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    /* for console output testing */
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    /* for console output testing */
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * Test of getAmount method, of class Loan.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Loan instance = new Loan(5000.0, 10.0, 5);
        double expResult = 5000.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPeriod method, of class Loan.
     */
    @Test
    public void testGetPeriod() {
        System.out.println("getPeriod");
        Loan instance = new Loan(5000.0, 10.0, 5);
        int expResult = 5;
        int result = instance.getPeriod();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRate method, of class Loan.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        Loan instance = new Loan(5000.0, 10.0, 5);
        double expResult = 10.0;
        double result = instance.getRate();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMonthlyPayment method, of class Loan.
     */
    @Test
    public void testGetMonthlyPayment() {
        System.out.println("getMonthlyPayment");
        Loan instance = new Loan(5000.0, 10.0, 5);
        double expResult = 106.23;
        double result = instance.getMonthlyPayment();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getTotalPayment method, of class Loan.
     */
    @Test
    public void testGetTotalPayment() {
        System.out.println("getTotalPayment");
        Loan instance = new Loan(5000.0, 10.0, 5);
        double expResult = 6374.11;
        double result = instance.getTotalPayment();
        assertEquals(expResult, result, 0.01);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

//    @Test
//    public void invalidMessagesShouldThrowAutoPopulateException() {
//        thrown.expect(IllegalArgumentException.class);
//        thrown.expectMessage("Error Negative and zero amount values invalid");
//        Loan testloan = new Loan(-500.0, 10.0, 5);
//        System.out.println("amt is " + testloan.getAmount());
//    }

    @Test
    public void testMain() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Loan testloan = new Loan(-500.0, 10.0, 5);
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(//
                System.getProperty("line.separator"));
        assertEquals(1, linesOfOutput.length);
        assertEquals("Error Negative and zero amount values invalid", linesOfOutput[0]);
    }

}
