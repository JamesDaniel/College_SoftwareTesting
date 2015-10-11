/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author t00126681
 */
@RunWith(value = Parameterized.class)
public class Parameterized_Totalpayment {

    private double expected;
    private double amount;
    private double rate;
    private int period;

    @Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
            {6374.11, 5000.0, 10.0, 5}, //expected,  amount, rate, period 
            {6374.11, 5000.0, 10.0, 5},//expected,  amount, rate, period   
        });
    }

    public Parameterized_Totalpayment(double expected, double amount, double rate, int period) {
        this.expected = expected;
        this.amount = amount;
        this.rate = rate;
        this.period = period;
    }

    @Test
    public void TestTotalPayment_Calc() {
        System.out.println("Test TotalPayment" + amount);
        Loan calc = new Loan(amount, rate, period);
        assertEquals(expected, calc.getTotalPayment(), 0.5);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
