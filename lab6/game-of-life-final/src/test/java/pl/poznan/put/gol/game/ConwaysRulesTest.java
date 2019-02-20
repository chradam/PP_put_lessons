package pl.poznan.put.gol.game;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConwaysRulesTest {

	private ConwaysRules rules;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

	@Before
	public void setUp() {
		rules = new ConwaysRules();
	}

    @After
    public void tearDown() throws Exception {
    }

	@Test
	public void diesBecauseOfUnderpopulation() {
		assertFalse(rules.inNextGeneration(true, 1));
	}

	@Test
	public void staysAlive() {
		assertTrue(rules.inNextGeneration(true, 2));
		assertTrue(rules.inNextGeneration(true, 3));
	}

	@Test
	public void diesBecauseOfOverpopulation() {
		assertFalse(rules.inNextGeneration(true, 4));
	}

	@Test
	public void aCellIsBorn() {
		assertTrue(rules.inNextGeneration(false, 3));
	}

    /**
     * Test of inNextGeneration method, of class ConwaysRules.
     */
    @Test
    public void testInNextGeneration() {
        System.out.println("inNextGeneration");
        boolean alive = true;
        int numberOfNeighbors = 4;
        ConwaysRules instance = new ConwaysRules();
        /*
            W zależności do implentacji populacja będzie się zwiększać (komórki będą pozostawać żywe)
            lub kurczyć (komórki będą umierać).
        */
        boolean expResult = false;
        boolean result = instance.inNextGeneration(alive, numberOfNeighbors);
        assertEquals(expResult, result);
    }
}
