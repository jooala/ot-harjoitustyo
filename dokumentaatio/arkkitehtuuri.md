# Arkkitehtuurikuvaus

## Rakenne
Rakenne noudattaa nelitasoista kerrosarkkitehtuuria:<br><br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/pakkausrakenne.png">

UI sisältää JavaFX ja FXML:n avulla tehdyt näkymät sekä logiikan, miten näkymät asetetaan. Controllerit lukevat käyttäjän tekemisiä käyttöliittymässä ja kutsuvat metodeja domainista handlerien avulla. Domainissa on sovelluslogiikka ja Dao:ssa tietojen tallentamiseen vastaava koodi. 
<hr>

## Käyttöliittymä
Käyttöliittymässä on 6 eri näkymää

- Kirjautuminen
- Rekisteröityminen
- Etusivu toiminnoille
- Bugien lisääminen
- Bugien listaaminen
- Bugien selvittäminen

Jokainen näkymä on luotu FXML-tiedostojen avulla. Käyttöliittymä on täysin erillään sovelluslogiikasta ja vain pelkästään metodien kutsut toimivat handlerien avulla.
<hr>

## Sovelluslogiikka
Sovelluksen datamallin muodostavat kaksi luokkaa: User ja Bug. 

Toiminnallisuuksista käyttäjiin vastaa UserService ja BugService taas bugeihin liittyvissä toiminnallisuuksissa. Luokilla on käyttöliittymän tarpeisiin olevia metodeja. 

UserServicen metodeja:
- boolean login(String username)
- logout()
- User getLoggedUser()
- boolean register(String name, String username)

BugServicen metodeja:
- reportBug(String title, String summary, int priority, String steps, String expectedResult,String actualResult)
- ObservableList<Bug> listBugs()
- List<Bug> priorityBug()
- List<Bug> oldBug()
- Bug findBug(int value)
- save(int idS, boolean solvedS)

BugService ja UserServiceä kuvaava luokka/pakkauskaavio:<br><br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/pakkauskaavio.png">
<hr>

## Tietojen pysyväistallennus
Tiedot tallennetaan H2-tietokantaan pakkauksen bugiraportti.dao luokkien DBBugDao ja DBUserDao kautta. 

Luokat ovat DAO:n (Data Access Object -suunnittelumalli) mukaisia ja pystytään helposti korvata uusilla toteutuksilla mikäli on tarpeellista jossain vaiheessa siirtyä uuteen tiedontallentamistapaan. Kummatkin luokat on eriytetty sovelluslogiikasta ja ei käytä luokkia suoraan.

Tietokannan luo schema.sql tiedosto ja application.properties tiedosto asettaa tietokannan nimen, salasanan sekä tyypin. 
<hr>

## Päätoiminnallisuudet

### Kirjautuminen 
Kun käyttäjä kirjoittaa jo valmiina olevan käyttäjätunnukset tekstikenttään ja painaa kirjautumisnappulaa etenee sovellus seuraavasti:
<br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/kirjautumis_sekvenssi.png">

### Rekisteröityminen
Käyttäjän kirjoitettuaan käyttäjänimi ja nimi sekä painettuaan Register-nappia sovellus toimii seuraavasti:
<br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/register_sekvenssi.png">

### Bugin lisääminen
Käyttäjän kirjoitettuaan bugin tiedot ja valittuaan prioriteetin sekä painettuaan Add a new Bug-nappia sovellus toimii seuraavasti:
<br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/addbug_sekvenssi.png">
