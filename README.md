# Bugiraportointi- työkalu: Ohjelmistotekniikka, Harjoitustyö

Sovelluksen avulla pystytään lisäämään bugeja tietokantaan ja selaamaan sovelluksen avulla lisättyjä bugeja. Bugeista kysytään tietoja ja minkä tasoinen prioriteetti kyseisellä bugilla on. Bugeja pystyy selaamaan listassa, avaamaan bugin tiedot ja merkkaamaan tehdyiksi. Käyttäjä voi myös tuoda itselleen esille prioriteettitasolla suurimman bugin ja pystyy valitsemaan mikäli selvitti bugin tehdyksi. 



## Dokumentaatio
[Alustava määrittelydokumentti](https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md)

[Työaikakirjanpito](https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/jooala/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

## Releaset
[Viikko 5](https://github.com/jooala/ot-harjoitustyo/releases/tag/viikko5)


## Komentorivitoiminnot

### Testaaminen

Testit suoritetaan seuraavalla komennolla:

```
mvn test
```

Testikattavuusraportti luodaan komennolla:

```
mvn jacoco:report
```

Kattavuusraportin voit nähdä hakemistosta target/site/jacoco/index.html

### Suoritettavan jar-tiedoston generointi

Jar-tiedoston pystyt generoimaan seuraavalla komennolla:

```
mvn package
```

Generoi hakemistoon target jar-tiedoston: bugiraportti-1.0-SNAPSHOT.jar


### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/jooala/ot-harjoitustyo/blob/master/bugiraportti/checkstyle.xml) määrittelemät tarkistukset suoritetaan seuraavalla komennolla:

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html
