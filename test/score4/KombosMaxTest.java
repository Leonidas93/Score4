package score4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KombosMaxTest {
    
    public KombosMaxTest() {
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
        KombosMax instance = null;
        int expResult = 0;
        int result = instance.find_best_move();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
    @Test(expected=NullPointerException.class)
    public void testSetChildren() {
        System.out.println("setChildren");
        int x = 0;
        KombosMax instance = null;
        instance.setChildren(x);
    }

    
    @Test(expected=NullPointerException.class)
    public void testIsfull() {
        System.out.println("isfull");
        int i = 0;
        KombosMax instance = null;
        boolean expResult = false;
        boolean result = instance.isfull(i);
        assertEquals(expResult, result);
    }

    
    @Test(expected=NullPointerException.class)
    public void testCheckpoints() {
        System.out.println("checkpoints");
        int x = 0;
        int y = 0;
        KombosMax instance = null;
        instance.checkpoints(x, y);
    }
    
}
