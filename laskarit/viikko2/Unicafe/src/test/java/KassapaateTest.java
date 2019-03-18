/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       kassa = new Kassapaate();
       kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void uusiKassapaateOikein() {
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
    }
    
    @Test
    public void kateisostoToimiiKummassakinLounaassa() {
        kassa.syoEdullisesti(280);
        assertEquals(kassa.kassassaRahaa(), 100240);
        assertEquals(kassa.syoEdullisesti(300), 60);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 2);
        assertEquals(kassa.kassassaRahaa(), 100480);
        assertEquals(kassa.syoMaukkaasti(500), 100);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100880);
        
        assertEquals(kassa.syoEdullisesti(200), 200);
        assertEquals(kassa.kassassaRahaa(), 100880);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 2);
        
        assertEquals(kassa.syoMaukkaasti(354), 354);
        assertEquals(kassa.kassassaRahaa(), 100880);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
    }
    
    @Test
    public void korttiostoToimiiKummassakinLounaassa() {
        assertEquals(kassa.syoEdullisesti(kortti), true);
        assertEquals(kortti.saldo(), 760);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);
        
        assertEquals(kassa.syoMaukkaasti(kortti), true);
        assertEquals(kortti.saldo(), 360);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);
        
        assertEquals(kassa.syoMaukkaasti(kortti), false);
        assertEquals(kortti.saldo(), 360);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);
        
        assertEquals(kassa.syoEdullisesti(kortti), true);
        assertEquals(kortti.saldo(), 120);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 2);
        assertEquals(kassa.kassassaRahaa(), 100000);
        
        assertEquals(kassa.syoEdullisesti(kortti), false);
        assertEquals(kortti.saldo(), 120);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 2);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void kortinLatauksessaSaldoMuuttuu() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(kassa.kassassaRahaa(), 100500);
        
        kassa.lataaRahaaKortille(kortti, -50);
        assertEquals(kassa.kassassaRahaa(), 100500);
    }
}
