package loan;

/*
 * Testing private data and methods using reflection. 

 */

/**
 *
 * @author Administrator
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TestPrivateMembers {
   /**
     * Accessing a private field
     * Test of loanamount, of class Loan.
     */
    @Test
    public void testSetAmount1() throws Exception {
        System.out.println("setAmount1");
        Loan target = new Loan(4000.0, 10.0, 5);
        
        /*creat secret class */
        Class secretClass = target.getClass();
        
        /* The the private field */
        Field f = secretClass.getDeclaredField("loanAmount");
        
        /*Set tha field to accessible */
        f.setAccessible(true);
        System.out.println("The value in f is " + f.get(target));
 
        /*get the value of the field */
        double result =  f.getDouble(target);
        
        /*Assert the value is correct */
        assertEquals("The amounts should be equal", 4000.00,  result, 0.0);
      
    }
    
    @Test
    public void testSetAmount2() throws Exception {
        System.out.println("setAmount2");
       
        /* Set up a new loan */
        Loan target = new Loan();
        
        /* get the setAmount method details */
        Method method = Loan.class.getDeclaredMethod("setAmount", double.class);
        
        /* make the field assessible */
        method.setAccessible(true);
        
        /* invoke the method setAmount with the value 3000.0 */
        method.invoke(target, 3000.0);
   
        /*access the field loanAmount and check its value is set the 3000.0*/
        Class secretClass = target.getClass();
        Field f = secretClass.getDeclaredField("loanAmount");
        f.setAccessible(true);
     
        double result =  f.getDouble(target);
        
        assertEquals("The amounts should be equal", 3000.00,  result, 0.0);
      
    }
    //setPeriod(int periodInYears)
    @Test
    public void testSetPeriod() throws Exception {
        System.out.println("test setPeriod()");
        
        Loan target = new Loan(4000.0, 10.0, 5);
        
        Method method = Loan.class.getDeclaredMethod("setPeriod", int.class);
        method.setAccessible(true);
        method.invoke(target, 60);
        
        Class secretClass = target.getClass();
        Field f = secretClass.getDeclaredField("numberOfPayments");
        f.setAccessible(true);
        
        int result =  f.getInt(target);
        
        Class secretClass2 = target.getClass();
        Field f2 = secretClass.getDeclaredField("MONTHS_IN_YEAR");
        f2.setAccessible(true);
        int field2 = f2.getInt(target);
        
        int expectedResult = 60 * field2;
        
        assertEquals("The amounts should be equal", expectedResult,  result, 0.0);
    }
}
