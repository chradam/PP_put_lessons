package pl.poznan.put.gol.game;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellsTest {
    
    public CellsTest() {
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
     * Test of getNeighbors method, of class Cells.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        
        ConwaysCell cc = new ConwaysCell(1,1);
        ConwaysCell cc2 = new ConwaysCell(2,2);
        
        Cells instance = new Cells(cc, cc2);
        Cells sasiedzi = instance.getNeighbors();
        
        Cells i2 = new Cells();
        i2.addAll(cc.neighbors());
        i2.addAll(cc2.neighbors());
        
        boolean expResult = true;
        boolean result = i2.equals(sasiedzi);
        assertEquals(expResult, result);
        
    }
}
