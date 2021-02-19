# Toteutusdokumentti

Tämä dokumentti on vielä vaiheessa. Sen sisältö tulee vielä päivittymään harjoitustyön etenemisen myötä.

## Ohjelman yleisrakenne

Ohjelma on jaeuttu eri pakkauksiin, joilla erilaisia vastuita.

Ohjelman rakenne on tällä hetkellä seuraava:
```bash
├── algo
    ├── AStar.java
│   ├── Djikstra.java
│   └── PathFind.java
├── domain
│   ├── ANode.java
│   ├── DNode.java
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
│   ├── ArrayList.java
│   └── MinHeap.java
└── ui
    └── UI.java
```

Ohjelman käyttöliittymä ja logiikka on eriytetty mahdollisimman paljon toisistaan.

## Saavutetut aika- ja tilavaativuudet

Ei ajankohtainen.

## Suorituskyky- ja O-analyysivertailu

```bash
Djikstra - runtime: 0.105976779 s, distance: 179.33809511662415 nodes in path: 153 visited nodes: 41119
AStar - runtime: 0.026113823 s, distance: 179.33809511662415 nodes in path: 153 visited nodes: 7100
```
Algoritmien suorituskykytestaus on aloitettu.

## Työn mahdolliset puutteet ja parannusehdotukset

Työ on vielä kesken. Tällä hetkellä algoritmejä pitää vielä korjata ja omia tietorakenteita totetuttaa niille lisää. Käyttöliittymä kaipaa vielä hiomista algoritmien tietojen näyttämisen osalta. Käyttöliittymää parannan enemmänkin jos jää aikaa.
 
## Lähteet

Tulee myöhemmin.
