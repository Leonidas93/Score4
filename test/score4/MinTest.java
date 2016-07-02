package score4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MinTest {
    
    public MinTest() {
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

    
    @Test(expected=NullPointerException.class)
    public void testFind_best_move() {
        System.out.println("find_best_move");
        Min instance = null;
        instance.find_best_move();
    }

    
    @Test(expected=NullPointerException.class)
    public void testSetChildren() {
        System.out.println("setChildren");
        int x = 0;
        Min instance = null;
        instance.setChildren(x);
    }

    
    @Test(expected=NullPointerException.class)
    public void testIsfull() {
        System.out.println("isfull");
        int i = 0;
        Min instance = null;
        boolean expResult = false;
        boolean result = instance.isfull(i);
        assertEquals(expResult, result);
    }
    
}
