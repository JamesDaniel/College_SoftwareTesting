package loan;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;

/**
 *
 * @author t00136071
 */
public class CustomerTest {

    public CustomerTest() {
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

@Test
    public void testTakeoutloan() {
        Customer instance = new Customer("Jake Black", 0.0);

        /*call the createMock to create a mock for the Loan class */
         Loan mockloan = EasyMock.createMock(Loan.class);
        
        /* set up the expected values and return values */
        expect(mockloan.getMonthlyPayment()).andReturn(106.23);

        /*activate the mock */
        replay(mockloan);

        double expResult = 106.23;
        System.out.println("takeoutloan");

        instance.takeoutloan(mockloan);
        double result = instance.getMonthlypayments();
        assertEquals("The monthly payments must be equal", expResult, result, 0.5);
    verify(mockloan);
    }
}
