# Kata Emplacement

L'objectif de cet exercice est d'évaluer la capacité du candidat à coder un algorithme simple mais complet.

Le but est de calculer la densité de population à partir d'un fichier d'entrée.

## Exercice

À partir d'un fichier d'entrée fourni (fichier au format csv contenant des points d'intérêts (POIs) caractérisés par:
id, lat, lon), on veut calculer le nombre de points dʼintérêts (POIs) d'une zone et trouver les N zones les plus
denses (ie. les zones contenant le plus de POIs). Pour simplifier l'exercice, on pourra considérer que le monde est une
grille allant de -90 a 90 et de -180 a 180 par incréments de 0,5. Une zone est donc une case de la grille. Par exemple:
Paris est dans la zone [(49, 2), (48.5, 2.5)].

Le code doit être Intégré dans un test unitaire ou, bonus, dans un service web. Écrire le code en Java, sans s'appuyer
sur une base de données. Les librairies externes sont autorisées.

## Exemples

Étant donné le fichier de données en entrée suivant :

```
@id @lat @lon
id1 -48.6 -37.7
id2 -27.1 8.4
id3 6.6 -6.9
id4 -2.3 38.3
id5 6.8 -6.9
id6 -2.5 38.3
id7 0.1 -0.1
id8 -2.1 38.1
```

Pour la question "Calculer le nombre de POIs d'une zone" (avec minlat= 6.5 et minlon= -7)
Le résultat attendu est le suivant : 2

Pour la question "Trouver les N zones les plus denses" (avec N= 2), le résultat attendu est le suivant :
[ {"minLat":-2.5, "maxLat":-2, "minLon":38, "maxLon":38.5}, {"minLat":6.5,
"maxLat":7, "minLon":-7, "maxLon":-6.5}]

# Remarques

## Reste à faire

- Ajout des controles des données et renvoi d'erreurs (ex : borner -90 a 90 et de -180 a 180)
- Ajout de la couche controller (API)