# Toteutusdokumentti

Tämä dokumentti on vielä vaiheessa. Sen sisältö tulee vielä päivittymään harjoitustyön etenemisen myötä.

## Ohjelman yleisrakenne

Ohjelma on jaeuttu eri pakkauksiin, joilla erilaisia vastuita. Ohjelman algoritmit ja tietorakenteet on toteutettu itse.

Ohjelman rakenne on tällä hetkellä seuraava:
```bash
├── algo
│   ├── AStar.java
│   ├── Djikstra.java
│   ├── JPS.java
│   └── PathFind.java
├── domain
│   ├── Node.java
│   ├── Point.java
│   └── Result.java
├── file
│   └── MapReader.java
├── main
│   └── Main.java
├── pathfinder
│   └── PathFinder.java
├── struct
│   ├── PointStack.java
│   └── MinHeap.java
└── ui
    └── UI.java
```

Ohjelman käyttöliittymä ja logiikka on eriytetty mahdollisimman paljon toisistaan.

## Saavutetut aika- ja tilavaativuudet

Ei ajankohtainen

## Suorituskyky- ja O-analyysivertailu

```bash
Djikstra
min runtime: 0.021032497 s.
max runtime: 0.119102841 s.
avg runtime: 0.023639793 s.
distance: 359.2274887854705 nodes in path: 272 visited nodes: 70198
distance: 359.2274887854705 nodes in path: 272 visited nodes: 70198
AStar
min runtime: 0.021525539 s.
max runtime: 0.049351457 s.
avg runtime: 0.023114085 s.
distance: 359.2274887854705 nodes in path: 272 visited nodes: 70198

```
Algoritmien suorituskykytestaus on aloitettu.

## Työn mahdolliset puutteet ja parannusehdotukset

Käyttöliittymä kaipaa vielä hiomista algoritmien tietojen näyttämisen osalta. Käyttöliittymää parannan enemmänkin jos jää aikaa.
 
## Lähteet

Tulee myöhemmin.
