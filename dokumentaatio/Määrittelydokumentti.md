# Vaativuusmäärittely

## Sovelluksen tarkoitus
Sovelluksen avulla pystytään lisäämään bugeja, mitä ollaan löydetty jostain toisesta projektista. Ideana on siis bugilista-työkalu, millä pystytään tarkistamaan mitkä bugit ovat uusia, miten kriittinen tietty bugi on, miten bugi saadaan aikaan, seuraukset sekä myös onko bugi korjattu ja milloin se on korjattu. Tiivistettynä siis yleinen apuväline toisiin sovelluksiin bugreport-työkaluna.

## Käyttäjät
Aluksi on vain yksi käyttäjärooli eli tavallinen käyttäjä. Ideana olisi kuitenkin jossain vaihessa lisätä pääkäyttäjä paremmilla oikeuksilla.

<hr>

## Suunnitellut toiminnallisuudet
### Kirjautuminen
* Käyttäjä voi luoda järjestelmään käyttäjätunnukset
* Käyttäjä pystyy kirjautumaan olemassa olevalla tunnuksellaan järjestelmään

<hr>

### Järjestelmässä
* Käyttäjä voi raportoida uudesta bugista
  * Käyttäjältä kysytään tietoja bugista mm. miten bugi replikoidaan, mitä se aiheuttaa, miten sen pitäisi oikeasti toimia
* Käyttäjä voi nähdä listan bugeista ja tiedot (id, otsikko, tiivistelmä, tila)
* Käyttäjälle voidaan näyttää bugi, mikä on kriittisin arvoltaan tai vanhin rekisteröity bugi, mikä pitää korjata.
  * Bugin tiedot näytetään
  * Voi valita saiko bugin korjattua
* Käyttäjä voi palata aina etusivulle
* Käyttäjä voi kirjautua ulos järjestelmästä

<hr>

### Jatkokehitysideat
* Pääkäyttäjä voi poistaa bugeja/turhia raportteja
* Pääkäyttäjä näkee tilastoja
  * Ketkä käyttäjät raportoivat bugeista eniten
  * Ketkä korjaavat bugeja eniten
* Jos on monia eri sovelluksia, mistä pitää ottaa talteen bugeja, niin käyttäjä voi valita mitä sovellusta raportoi/korjaa bugeja.
