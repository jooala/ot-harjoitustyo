# Testausdokumentti

Ohjelman testaus on tehty yksikkö- ja integraatiotestein JUnitilla sekä järjestelmätason testein.

## Yksikkö- ja integraatiotestaaminen

### Sovelluslogiikka

Sovelluslogiikkaa eli bugiraportti.domain luokkia BugService ja UserService testaa testiluokka ServiceTest, Bug-luokkaa testaa BugTest ja User-luokkaa UserTest. ServiceTest testaa käyttöliittymälle tärkeitä toiminnallisuuksia ja UserTest sekä BugTest sovellukselle tärkeitä olioita ja niiden muutamia yksikkötestauksia.

Tiedon pysyväistallennusta testataan myös ServiceTest-luokassa.

### DAO -luokat
Molemmat DAO-luokat ja niiden toiminnallisuutta on testattu tilapäisellä tietokannalla hyödyntäen Springin valmiita toiminnallisuuksia.

### Testauskattavuus
Sovelluksen testauksen rivikattavuus on 100% ja haarautumakattavuus myös 100% lukuunottamatta käyttöliittymäkerrosta sekä controllereita, mitkä myös olivat osa käyttöliittymää.
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/rivikattavuus.png"><br>

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on tehty manuaalisesti.

### Asennus ja konfigurointi

Sovellusta on testattu käyttöohjeen kuvaamalla tavalla Windows-ympäristössä. 

Sovellusta on testattu tilanteissa, joissa käyttäjät sekä bugit ovat olleet olemassa ja myös milloin niitä ei ole ollut ja ohjelma on luonut ne itse. 

Kaikki määrittelydokumentin ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi.

## Sovellukseen jääneet laatuongelmat
Ei anna virheilmoituksia kaikissa tilanteissa:
- Liian pitkä nimi, käyttäjänimi tai bugin otsikko
- Ei pysty palaamaan rekisteröitymisnäkymästä kirjautumisnäkymään
- DAO:n testaus omassa DaoTest luokassaan ei onnistunut Bean-ongelman takia