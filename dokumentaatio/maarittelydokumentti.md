## Laboratoriotyön aihe

Tietojenkäsittelytieteen kandiohjelmaan kuuluvan TiRa-laboratoriotyön aiheeksi valisin polunetsintä algoritmien tehokkuusvertailun. Tarkoituksenani on toteuttaa Java -ohjelmointkielellä ohjelma, jolla voi vertailla lyhyimmän polunetsimisen tehokkuutta kolmella eri algoritmillä. Dokumentaation kirjoitan suomenkielellä.

### Vertailtavat algoritmit ja toteutettavat tietorakenteet

|Algoritmi|tavoiteltava aikavaativuus (pahin tapaus)|tavoiteltava tilavaativuus|
| :----:|:-----| :-----|
| A* |O(n + m log n)| O(n)|
|Djikstra|O(n + m log n)|O(n)|
|JPS|O(n + m log n)|O(n)|

Tehokkuusvertailuun valitsin mukaan A* , Djikstran algoritmin ja Jump Point Searchin (JPS). A* ja Djikstran valitsin siksi että ne ovat lyhyimmän polun etsimisessä “standardi” ja JPS:n, koska olen lukenut sen olevan edellisiä tehokkaampi ja sitä en ole aiemmin toteuttanut.

#### Miten tavoiteltaviin tila- ja aikavaativuuksiin on päädytty?

A*:n ja Djiktran algoritmin voi molemmat toteuttaa keon avulla, jolloin keon operaatioiden aikavaativuuksien johdosta kokonaisaikavaativuudeksi tulee O(n + m log n) ja tilavaativuus on keon toiminnan johdosta O(n). JPS on parannus A*, joten oletan sen toimivan käytännössä nopeammin vaikka pahimman tapauksen aikavaativuus on edelleen sama.

### Ohjelman toiminta

Ohjelma saa syötteeksi sivulla https://movingai.com/benchmarks/grids.html olevia karttoja, jotka tallennetaan kaksiuloitteiseen taulukkoon. Ohjelmaan annetaan reitin haluttu alku- ja loppupiste ja valitaan haluttu algoritmi. Ohjelma näyttää visuaalisesti löydetyn polun ja algoritmin tehokkuuteen liittyviä tietoja.


### Lähteet

Wikipedia: [Djikstra’s algorithm](https://en.wikipedia.org/wiki/Dijkstra's_algorithm), luettu 22.1.2021

Wikipedia: [A* search algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm), luettu 22.1.2021

Wikipedia: [Jump point search](https://en.wikipedia.org/wiki/Jump_point_search), luettu 22.1.2021
