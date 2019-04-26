# Arkkitehtuurikuvaus

## Rakenne
Rakenne noudattaa nelitasoista kerrosarkkitehtuuria:<br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/pakkausrakenne.png">

## Sovelluslogiikka
Sovelluksen datamallin muodostavat kaksi luokkaa: User ja Bug. 

Toiminnallisuuksista käyttäjiin vastaa UserService ja BugService taas bugeihin liittyvissä toiminnallisuuksissa.

BugService ja UserServiceä kuvaava luokka/pakkauskaavio:
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/pakkauskaavio.png">

## Päätoiminnallisuudet

### Kirjautuminen 
Kun käyttäjä kirjoittaa jo valmiina olevan käyttäjätunnukset tekstikenttään ja painaa kirjautumisnappulaa etenee sovellus seuraavasti:
<br>
<img src="https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/images/kirjautumis_sekvenssi.png">
