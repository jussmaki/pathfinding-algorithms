## Laboratoriotyön aihe

Tietojenkäsittelytieteen kandiohjelmaan kuuluvan TiRa-laboratoriotyön aiheeksi valisin polunetsintä algoritmien tehokkuusvertailun. Tarkoituksenani on toteuttaa Java -ohjelmointkielellä ohjelma, jolla voi vertailla lyhyimmän polunetsimisen tehokkuutta kolmella eri algoritmillä. Dokumentaation kirjoitan suomenkielellä.

### Vertailtavat algoritmit ja toteutettavat tietorakenteet

|Algoritmi|tavoiteltava aikavaativuus (pahin tapaus)|tavoiteltava tilavaativuus|
| :----:|:-----| :-----|
|Djikstra|O(n + m log n)|O(n)|
| AStar |O(n + m log n)| O(n)|
|IDAStar|O(m^n)|O(d)|

Tehokkuusvertailuun valitsin mukaan Djikstran algoritmin, AStarin, ja IDAStarin. AStarin ja Djikstran valitsin siksi että ne ovat lyhyimmän polun etsimisessä “standardi” ja IDAStarin, koska en sitä ole aiemmin aiemmin toteuttanut.

#### Miten tavoiteltaviin tila- ja aikavaativuuksiin on päädytty?

AStarin ja Djiktran algoritmin voi molemmat toteuttaa keon avulla, jolloin keon operaatioiden aikavaativuuksien johdosta kokonaisaikavaativuudeksi tulee O(n + m log n) ja tilavaativuus on keon toiminnan johdosta O(n). Toisin kuin edellämainitut IDAStar käyttää syvyyshakua ja pitää muistissa vain löydettyä polkua pinossa. IDAstarin hyöty ja haitta onkin se että algoritmi ei pidä kirjaa kaikista solmuista, joissa se on käynyt, joten se voi saman haun aikana käydä samassa solmussa useamman kerran. Astarin tilavaativuus näin ollen on O(d), jossa d on haun syvyys.

### Ohjelman toiminta

Ohjelma saa syötteeksi sivulla https://movingai.com/benchmarks/grids.html olevia karttoja, jotka tallennetaan kaksiuloitteiseen taulukkoon. Ohjelmaan annetaan reitin haluttu alku- ja loppupiste ja valitaan haluttu algoritmi. Ohjelma näyttää visuaalisesti löydetyn polun ja algoritmin tehokkuuteen liittyviä tietoja. Ohjelmalle voi antaa syötteeksi myös samalta sivustolta ladattavia skenaario-tiedostoja, joissa on eri karttojen alku- ja loppupisteitä ja niiden lyhimpien polkujen pituuksia.


### Lähteet

Wikipedia: [Djikstra’s algorithm](https://en.wikipedia.org/wiki/Dijkstra's_algorithm), luettu 22.1.2021

Wikipedia: [A* search algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm), luettu 22.1.2021

Wikipedia: [Iterative deepening A*](https://en.wikipedia.org/wiki/Iterative_deepening_A*), luettu 10.2.2021
