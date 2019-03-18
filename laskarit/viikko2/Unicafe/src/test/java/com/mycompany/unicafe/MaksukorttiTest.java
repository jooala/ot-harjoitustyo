package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    public void saldoTarkistus() {
        assertEquals(kortti.saldo(), kortti.saldo());
    }
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLatausKasvattaaSaldoa() {
        kortti.lataaRahaa(200);
        assertEquals("saldo: 2.10", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeKunRahaaTarpeeksi() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void saldoEiMuutuKunRahaaEiTarpeeksi() {
        assertEquals(false, kortti.otaRahaa(15));
    }
}
