# Käyttöohje

Lataa tiedosto [bugiraportti.jar](https://github.com/jooala/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään seuraavalla komennolla
```
java -jar bugiraportti.jar
```

## Kirjautuminen
Sovellus aukeaa kirjautumisnäkymään
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/käyttöohje/login.png">
Sovellukseen pystyy kirjautumaan sisälle olemassaolevalla käyttäjätunnuksella syöttökenttään kirjoittamalla ja klikkaammalla "Log In"

## Rekisteröinti
Kirjautumisnäkymässä on painike "Register", josta pääsee rekisteröintinäkymään. 
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/käyttöohje/register.png">
Kirjoittamalla syötekenttiin tiedot ja painamalla nappia "Register", luodaan uusi käyttäjä ja palataan takaisin kirjautumisnäkymään.

## Etusivu
Kirjautumisen jälkeen avautuu käyttäjälle etusivunäkymä
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/käyttöohje/frontpage.png">
Valikosta voit valita napeista mihin seuraavaan näkymään haluat mennä, tai voit myös kirjautua ulos napista "Log out".

## Bugien raportointi
Napista "Report a new bug" avautuu bugien lisäämiseen tarkoitettu näkymä
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/käyttöohje/report.png">
Täyttämällä bugien tiedot tekstikenttiin ja valitsemalla oikeaa vastaava numero "Prioritylle" ja lopulta painamalla "Add the bug", raportoidaan bugista ja lisätään bugi selvitettäväksi tietokantaan. Voit myös palata takaisin etusivulle painikkeesta "Return to Main Menu".

## Bugien listaus
Napista "List all the bugs" avautuu näkymä, josta pystyy listaamaan kaikki lisätyt bugit näkyville
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/käyttöohje/list.png">
Painamalla nappia "Refresh", päivitetään lista bugeilla järjestyksessä. "Return to Main Menu"-painikkeesta pääsee takaisin etusivulle.

## Bugien korjaus
Napista "Solve a bug" avautuu näkymä bugien ratkomiseen
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/käyttöohje/solve.png">
Voit valita haluatko vanhimman ei-ratkaistun bugin vai tärkeysjonossa suurimman bugin napeista "Oldest Bug" tai "Bug with biggest priority". Tämän jälkeen esille tulee tietokannasta bugi, mikä vastaa painettua nappiasi ja näyttää bugiin lisätyt tiedot näkymässä. Asettamalla "Set Bug to Solved" tehdyksi ja painamalla nappia "Save" voit tallentaa, mikäli bugi on ratkaistu vai ei. Kuitenkin jos ratkaiset bugin ja päivität toisen bugin, ei vanhaa bugia enää saa ei-ratkaistuksi.