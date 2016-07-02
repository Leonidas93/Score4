package score4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {
    
    public BoardTest() {
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
    public void testPrint_array() {
        System.out.println("print_array");
        Board instance = new Board();
        instance.print_array();
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testPlay() {
        System.out.println("play");
        int choice = 0;
        int player = 0;
        Board instance = new Board();
        instance.play(choice, player);
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testIsfull() {
        System.out.println("isfull");
        int i = 0;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isfull(i);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testCheckpoints() {
        System.out.println("checkpoints");
        int x = 0;
        int y = 0;
        int player = 0;
        Board instance = new Board();
        instance.checkpoints(x, y, player);
        fail("The test case is a prototype.");
    }
    
}
