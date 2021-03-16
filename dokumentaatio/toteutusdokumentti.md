# Toteutusdokumentti

Ohjelma on jaeuttu eri pakkauksiin, joilla erilaisia vastuita. Ohjelman algoritmit ja tietorakenteet on toteutettu itse.

Ohjelman rakenne on seuraava:
```bash
└── pathfinding
    ├── algo
    │   ├── AStar.java
    │   ├── Djikstra.java
    │   ├── IDAStar.java
    │   ├── package-info.java
    │   └── PathFind.java
    ├── domain
    │   ├── Node.java
    │   ├── package-info.java
    │   ├── Point.java
    │   └── Result.java
    ├── file
    │   ├── MapReader.java
    │   ├── package-info.java
    │   ├── Scenario.java
    │   └── ScenarioReader.java
    ├── main
    │   ├── Main.java
    │   └── package-info.java
    ├── pathfinder
    │   ├── package-info.java
    │   └── PathFinder.java
    ├── struct
    │   ├── MinHeap.java
    │   ├── package-info.java
    │   └── StackQueue.java
    └── ui
        ├── BenchmarkUI.java
        ├── package-info.java
        └── UI.java
```

Ohjelman käyttöliittymä ja logiikka on eriytetty mahdollisimman paljon toisistaan.

## Saavutetut aika- ja tilavaativuudet

Djikstra toimii ajassa käytännössä ajassa koska tietorakenteet ja koodi on optimoitu tehokkuutta silmälläpitäen.

## Suorituskyky- ja O-analyysivertailu

### Aika -ja tilavaativuudet

Pinon aikavaativuus on ... Pinon insert toimii vakioajassa O(1), paitsi jos taulukkoa tarvitsee kasvattaa tällöin insert toimii ajassa O(n).

Testasin algoritmien toimintaa eri kartoilla ja skenaarioilla. Testauksessa käytetyt tiedostot löytyvät [repositoriosta](linkki).

### Suorituskykyvertailu

#### Vertailu skenaariotiedostoilla


|Algoritmi|kartta       |koko       |skenaarioita|kokonaisaika (s.)|kokonaismatka     |solmuja poluilla yhteensä     |vierailtuja solmuja yhteensä|
|:-------:|:-----------:|:---------:|:----------:|:---------------:|:----------------:|:----------------------------:|:--------------------------:|
|Djikstra|lt_house      |54 x 53    |20          |0.007377093      |88.84062043356596 |96                            |897                         |
|AStar   |lt_house      |54 x 53    |20          |0.005001814      |88.84062043356596 |96                            |102                         |
|IDAStar |lt_house      |54 x 53    |20          |0.002722529      |88.84062043356596 |96                            |2298                        |
|Djikstra|ht_store      |37 x 37    |80          |0.033507277      |1262.5849198858498|1174                          |22418                       |
|AStar   |ht_store      |37 x 37    |80          |0.018468832      |1262.5849198858498|1174                          |4695                        |
|IDAStar |ht_store      |37 x 37    |80          |> 60 min         |-                 |-                             |-                           |
|Djikstra|maze512-1-0   |512 x 512  |12120       |206.304204111    |2.9372697E7       |29384816                      |819141125                   |
|AStar   |maze512-1-0   |512 x 512  |12120       |281.687385589    |2.9372697E7       |29384816                      |704500998                   |
|IDAStar |maze512-1-0   |512 x 512  |12120       |-                |-                 |-                             |-                           |
|Djikstra|random512-10-0|512 x 512  |1780        |95.831965891     |633613.6738237863 |524934                        |248557033                   |
|AStar   |random512-10-0|512 x 512  |1780        |38.694554924     |633613.6738237863 |524934                        |46045289                    |
|IDAStar |random512-10-0|512 x 512  |1780        |-                |-                 |-                             |-                           |
|Djikstra|Paris_0_1024  |1024 x 1024|3820        |920.912456741    |2918386.0643204707|2442886                       |1817628238                  |
|AStar   |Paris_0_1024  |1024 x 1024|3820        |429.833178901    |2918386.0643204707|2442886                       |421062222                   |
|IDAStar |Paris_0_1024  |1024 x 1024|3820        |-                |-                 |-                             |-                           |
|Djikstra|Moscow_2_1024 |1024 x 1024|4230        |907.823410829    |3578387.394100259 |3034250                       |2090329028                  |
|AStar   |Moscow_2_1024 |1024 x 1024|4230        |907.823410829    |3578387.394100259 |3034250                       |2090329028                  |

Astar suoritui tässä testissä niin huonosti että kaikki skenaariot sillä sai kohtuullisessa (< 60 min) ajassa testattua vain yhdellä kartalla (lt_house). Kartassa ht_store jouduin keskeyttämään IDAStarin suorittamisen, koska se oli niin hidas. Näin ohjelman tulostuksista että se oli vieraillut loppuun asti ehtineissä skenaariossa huomattavasti useammassa solmussa kuin kilpailijansa kaikissa skenaarioissa yhteensä.

```bash
idastar 1086364021 ns. resources/ht_store start: 8,27 end: 21,9 distance: 24.55634918610405 nodes in path: 21 visited nodes: 33731086
idastar 1447820563 ns. resources/ht_store start: 8,29 end: 16,5 distance: 27.313708498984763 nodes in path: 25 visited nodes: 44907617
idastar 791018843 ns. resources/ht_store start: 14,22 end: 3,4 distance: 24.313708498984763 nodes in path: 22 visited nodes: 25616034
idastar 8559093714 ns. resources/ht_store start: 17,9 end: 5,30 distance: 27.142135623730955 nodes in path: 24 visited nodes: 261276055
idastar 4994736791 ns. resources/ht_store start: 9,31 end: 20,9 distance: 26.55634918610405 nodes in path: 23 visited nodes: 159725507
idastar 374379893 ns. resources/ht_store start: 17,29 end: 10,5 distance: 26.899494936611667 nodes in path: 25 visited nodes: 11712495
```

Isoimmilla kartoilla en edes yrittänyt suorittaa testejä IDAStarilla. Yllättävästi lt_house kartalla IDAStar oli kuitenkin ajallisesti paras.


#### Vertailu manuaalisesti suorittamalla

Sattuman minimimoisiksi tuloksista suoritin pari testiä niin että alku- ja loppupiste pysyivät samana ja sama algoritmi haki saman reitin useampaan kertaan. Nämä testit suoritettiin kolmella eri kartalla, pienellä kartalla, jotta IDAStaria voi verrata ja kahdella isolla kartalla: avoimella ja labyrintillä.
Testejä ajettiin kullakin algoritmillä per reitti 10, 100 ja 1000 kertaa. 

|d|map|4x3|40| 44|5| 5|5|5|55|
|d|map|4x3|40| 44|5| 5|5|5|55|
|d|map|4x3|40| 44|5| 5|5|5|55|

Tulokset olivat odotettuja. AStarin heuristiikka useimmiten ohjaa haun oikeaan suuntaan.

### Johtopäätökset

Algoritmit suorituivat vertailusta ennakkodotusten mukaisesti. Parhaiten kokonaisuudessan suoritui AStar ja sen jälkeen Djikstra. Selvästi huonoiten, jopa odotettua huonommin, suoritui IDAStar. Kaikkien testitapausten suorittaminen loppuun myös IDAStarilla olisi vienyt arvioilta todella paljon aikaa.

Astar hyvä, idastar huono.

IDAStar oli niin huono, mutten odottanut sen olevan niin huono mitä testassena

Visualisoinn algojen vieralemia solmuja kälin ominaisuudella siksi astar selvästi parempi, koska vierailee vähemmässä määrässä solmuja ja ottaa heti suunnan (kuva, normi kartasta ja kuva labyrintistä ero)

Kun etäisyys linnnuntietä hyvä eikä esteitä heuristiikkaa ohjaa astaria hyvin ja algoritmi välttää turhaa työtä.

## Työn mahdolliset puutteet ja parannusehdotukset

Skenaarioilla testaamisen voisi lisätä mahdollisuuden etsiä sama reitti monta kertaa ja ottaa tuloksiin siitä keskiarvo. 

IDAStarin voisi korvata JPS:llä, koska IDAStar on niin hidas että käytännössä kunnollinen vertailu on mahdotonta.

Kartta-aineisto voisi olla vielä monipuolisempaa.

Graafisen käliin voisi toteuttaa myös samat toiminnot kuin tekstikäyttöliittymässä.

## Lähteet

Tulee myöhemmin.

Wikipedia: [Djikstra’s algorithm](https://en.wikipedia.org/wiki/Dijkstra's_algorithm), luettu 22.1.2021

Wikipedia: [A* search algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm), luettu 22.1.2021

Wikipedia: [Iterative deepening A*](https://en.wikipedia.org/wiki/Iterative_deepening_A*), luettu 10.2.2021

