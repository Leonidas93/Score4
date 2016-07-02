package score4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HeuristicTest {
    
    public HeuristicTest() {
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
    public void testEvaluate() {
        System.out.println("evaluate");
        int[][] a = null;
        Heuristic instance = new Heuristic();
        instance.evaluate(a);
    }

    
    @Test(expected=NullPointerException.class)
    public void testDiag() {
        System.out.println("diag");
        int[][] a = null;
        Heuristic instance = new Heuristic();
        instance.diag(a);
    }

    
    @Test(expected=NullPointerException.class)
    public void testCheck_diag() {
        System.out.println("check_diag");
        int[] a = null;
        Heuristic instance = new Heuristic();
        instance.check_diag(a);
    }

    
    @Test(expected=NullPointerException.class)
    public void testColumns() {
        System.out.println("columns");
        int[][] a = null;
        Heuristic instance = new Heuristic();
        instance.columns(a);
    }

    
    @Test(expected=NullPointerException.class)
    public void testLines() {
        System.out.println("lines");
        int[][] a = null;
        Heuristic instance = new Heuristic();
        instance.lines(a);
    }

   
    @Test
    public void testCheck_result() {
        System.out.println("check_result");
        int sum1 = 0;
        int sum = 1;
        Heuristic instance = new Heuristic();
        instance.check_result(sum1, sum);
        fail();
    }
    
}
