package pl.poznan.put.gol.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConwaysCellTest {
    
    public ConwaysCellTest() {
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

    /**
     * Test of neighbors method, of class ConwaysCell.
     */
    @Test
    public void testNeighbors() {
        System.out.println("neighbors");
        ConwaysCell cell = new ConwaysCell(0,0);
        
        ConwaysCell neighbour = new ConwaysCell(0,1);
        
        int expResult = 8;
        Cells result = cell.neighbors();
        
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ConwaysCell.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConwaysCell cell = new ConwaysCell(0,0);
        String expResult = "c(0:0)";
        String result = cell.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ConwaysCell.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ConwaysCell c2 = new ConwaysCell(0,0);
        ConwaysCell instance = new ConwaysCell(0,1);
        boolean expResult = false;
        boolean result = instance.equals(c2);
        assertEquals(expResult, result);
    }
}
