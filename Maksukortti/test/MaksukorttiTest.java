
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MaksukorttiTest {
    Maksukortti kortti;
    
    public MaksukorttiTest() {
    }

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
     @Test
     public void konstuktoriAsettaaSaldonOikein() {
         String vastaus = kortti.toString();
         assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
     }
     
     @Test
     public void syoEdullisestiVahentaaSaldoaOikein() {
         kortti.syoEdullisesti();
         assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
     }
     
     @Test
     public void syoMaukkastiVahentaaSaldoaOikein() {
         kortti.syoMaukkaasti();
         assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
     }
     
     @Test
     public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         // nyt kortin saldo pitäisi olla 2
         kortti.syoEdullisesti();  
         assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
     }
     
     @Test
     public void kortilleVoiLadataRahaa() {
         kortti.lataaRahaa(25);
         assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
     }
     
     @Test
     public void kortinSaldoEiYlitaMaksimiarvoa() {
         kortti.lataaRahaa(200);
         assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
     }
     
     @Test
     public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         // kortin arvo on 2
         kortti.syoMaukkaasti();
         assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
     }
     
     @Test
     public void negatiivinenLatausEiMuutaSaldoa() {
         kortti.lataaRahaa(-5);
         assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
     }
     
     @Test
     public void ostaEdullinenLounasKunRahaaVainEdulliseen() {
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         // kortin arvo on 2
         kortti.lataaRahaa(0.5);
         // arvo on 2.5
         kortti.syoEdullisesti();
         assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
     }
     
     @Test
     public void ostaMaukasLounasKunRahaaVainMaukkaaseen() {
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         // arvo on 2
         kortti.lataaRahaa(2);
         //arvo on 4
         kortti.syoMaukkaasti();
         assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
     }
}
