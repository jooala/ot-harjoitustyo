/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bugiraportti.domain.Bug;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joonas
 */
public class BugTest {
    
    Bug bug;
    
    public BugTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bug = new Bug(1, "otsikko", "tiivistelmä", 9, "askeleet", "odotettuTulos", "oikea tulos");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void konstuktoriAsettaaOikein() {
        assertEquals(1, bug.getId());
        assertEquals("otsikko", bug.getTitle());
        assertEquals("tiivistelmä", bug.getSummary());
        assertEquals(9, bug.getPriority());
        assertEquals("askeleet", bug.getSteps());
        assertEquals("odotettuTulos", bug.getExpectedResult());
        assertEquals("oikea tulos", bug.getActualResult());
        bug = new Bug("title", "summary", 4, "step", "väärä", "oikein");
        assertEquals("title", bug.getTitle());
        assertEquals("summary", bug.getSummary());
        assertEquals(4, bug.getPriority());
        assertEquals("step", bug.getSteps());
        assertEquals("väärä", bug.getExpectedResult());
        assertEquals("oikein", bug.getActualResult());
    }
    @Test
    public void setteritToimii() {
        bug.setId(8);
        bug.setTitle("hei vaan");
        bug.setSummary("olen uusi tiivistelmä");
        bug.setPriority(6);
        bug.setSteps("monta askelta");
        bug.setExpectedResult("testissä");
        bug.setActualResult("hupsista hello");
        assertEquals(8, bug.getId());
        assertEquals("hei vaan", bug.getTitle());
        assertEquals("olen uusi tiivistelmä", bug.getSummary());
        assertEquals(6, bug.getPriority());
        assertEquals("monta askelta", bug.getSteps());
        assertEquals("testissä", bug.getExpectedResult());
        assertEquals("hupsista hello", bug.getActualResult());
    }
}
