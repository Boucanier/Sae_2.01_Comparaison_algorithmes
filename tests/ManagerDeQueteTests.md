# Dossier de tests

| Exploration algorithmique                  | Version : 0             |
|--------------------------------------------|-------------------------|
| Document : Dossier de tests                | Date : 06/06/2023       |
| Responsable de la rédaction : Jules CHIRON |                         |

## 1. Introduction

Ce dossier contient les tests pour les différentes méthodes de la classe ___ManagerDeQuete___.
Les méthodes testées sont _distanceEntrePos_, _peutCommencerQuete_ et _niveau2_. Nous commencons par tester 
la méthode _distanceEntrePos_ car elle est utilisée dans la méthode _peutCommencerQuete_.

## 2. Description de la procédure de test

Pour chaque test, les ensembles des cas de test sont définis. Puis pour chaque
cas, des données de test sont définies. Nous utilisons JUnit 5 pour réaliser nos tests.
Nous comparerons ensuite les résultats obtenus avec les résultats attendus.

## 3. Description des informations à enregistrer pour les tests

### 1. Campagne de test

| Produit testé : classe _ManagerDeQuete_                                 |
|-------------------------------------------------------------------------|
| Configuration logicielle : Java 18, IntelliJ, JUnit 5                   |
| Configuration matérielle : Ubuntu 22.04, Windows 11                     |
| Date de début : 11/05/2023                                              |
| Date de finalisation : 06/05/2023                                       |
| Tests à appliquer : _distanceEntrePos_, _peutCommencerQuete_, _niveau2_ |
| Responsable de la campagne de test : Jules CHIRON                       |

### 2. Tests

| Identification du test : 0               |
|------------------------------------------|
| Version : 0                              |
| Description du test : _distanceEntrePos_ |
| Ressources requises : Java 18, JUnit 5   |
| Responsable : Jules CHIRON               |

__Cas de test__

Partitions d'équivalence :

- _A1 = {x,y ∈ ℤ | x = 0}_
- _A2 = {x,y ∈ ℤ | x > 0}_

| Classe | Donnée 1 |     Donnée 2     |   Résultat attendu    |
|:------:|:--------:|:----------------:|:---------------------:|
|   P1   |  x1, y1  | x2 = x1, y2 = y1 |           0           |
|   P2   |  x1, y1  | x2 > x1, y2 = y1 |        x2 - x1        |
|   P3   |  x1, y1  | x2 > x1, y2 < y1 | (y1 - y2) + (x2 - x1) |
|   P4   |  x1, y1  | x2 > x1, y2 > y1 | (y2 - y1) + (x2 - x1) |
|   P5   |  x1, y1  | x2 < x1, y2 = y1 |        x1 - x2        |
|   P6   |  x1, y1  | x2 < x1, y2 < y1 | (y1 - y2) + (x1 - x2) |
|   P6   |  x1, y1  | x2 < x1, y2 > y1 | (y2 - y1) + (x1 - x2) |
|   P7   |  x1, y1  |  x2 = 0, y2 = 0  |        x1 + y1        |
|   P8   |  x1, y1  | x2 = x1, y2 < y1 |        y1 - y2        |
|   P9   |  x1, y1  | x2 = x1, y2 > y1 |        y2 - y1        |

---

| Identification du test : 1                 |
|--------------------------------------------|
| Version : 0                                |
| Description du test : _peutCommencerQuete_ |
| Ressources requises : Java 18, JUnit 5     |
| Responsable : Jules CHIRON                 |

__Cas de test__

| Classe |    Donnée 1    |     Donnée 2      | Résultat attendu |
|:------:|:--------------:|:-----------------:|:----------------:|
|   P1   | q1, q2, q3, q4 |     ((,),(,))     |       true       |
|   P2   | q1, q2, q3, q4 |    ((q1,),(,))    |       true       |
|   P3   | q1, q2, q3, q4 |   ((q1,q3),(,))   |       true       |
|   P4   | q1, q2, q3, q4 |   ((q1,),(q2,))   |       true       |
|   P5   | q1, q2, q3, q4 |  ((q1,),(q2,q4))  |       true       |
|   P6   | q1, q2, q3, q4 |  ((q1,q3),(q2,))  |       true       |
|   P7   | q1, q2, q3, q4 | ((q1,q4),(q2,q3)) |       true       |
|   P8   | q1, q2, q3, q4 |    ((q5,),(,))    |      false       |
|   P9   | q1, q2, q3, q4 |   ((q6,q5),(,))   |      false       |
|  P10   | q1, q2, q3, q4 |  ((q5,),(q1,q4))  |      false       |
|  P11   | q1, q2, q3, q4 |  ((q1,q5),(q6,))  |      false       |
|  P12   | q1, q2, q3, q4 |   ((q5,),(q6,))   |      false       |
|  P13   | q1, q2, q3, q4 | ((q1,q5),(q7,q6)) |      false       |

---

| Identification du test : 2             |
|----------------------------------------|
| Version : 0                            |
| Description du test : _niveau2_        |
| Ressources requises : Java 18, JUnit 5 |
| Responsable : Matis RODIER             |

__Cas de test__

Pour les tests du niveau 2, il a été difficile de trouver des cas de tests cohérents car toutes les méthodes 
du niveau 2 possèdent en paramètre des listes de joueurs ou de quêtes, ce qui rend le nombre de cas de tests 
beaucoup trop élevé et donc tres dur à représenter.
Afin de remédier à ce problème, nous avons décidé de prendre les résultats qu'a envoyé M. Auger sur discord 
et de les comparer à nos propres résultats.


### 3. Résultats de tests

| Référence du test appliqué : 0                       |
|------------------------------------------------------|
| Responsable : Jules CHIRON                           |
| Date de l'application du test : 23/05/2023           |
| Résultat du test : OK                                |
| Occurrence des résultats : systématique              |

__Données d'entrée__

| Classe |    Donnée 1    |    Donnée 2    | Résultat attendu | Résultat observé | Résultat test |
|:------:|:--------------:|:--------------:|:----------------:|:----------------:|:-------------:|
|   P1   | x1 = 2, y1 = 3 | x2 = 2, y2 = 3 |        0         |        0         |      OK       |
|   P2   | x1 = 2, y1 = 3 | x2 = 5, y2 = 3 |        3         |        3         |      OK       |
|   P3   | x1 = 2, y1 = 3 | x2 = 5, y2 = 1 |        5         |        5         |      OK       |
|   P4   | x1 = 2, y1 = 3 | x2 = 5, y2 = 5 |        5         |        5         |      OK       |
|   P5   | x1 = 4, y1 = 3 | x2 = 2, y2 = 3 |        2         |        2         |      OK       |
|   P6   | x1 = 4, y1 = 5 | x2 = 2, y2 = 3 |        4         |        4         |      OK       |
|   P7   | x1 = 3, y1 = 4 | x2 = 0, y2 = 0 |        7         |        7         |      OK       |
|   P8   | x1 = 3, y1 = 4 | x2 = 3, y2 = 3 |        1         |        1         |      OK       |
|   P9   | x1 = 3, y1 = 4 | x2 = 3, y2 = 6 |        2         |        2         |      OK       |

---

| Référence du test appliqué : 1             |
|--------------------------------------------|
| Responsable : Jules CHIRON                 |
| Date de l'application du test : 23/05/2023 |
| Résultat du test : OK                      |
| Occurrence des résultats : systématique    |

__Données d'entrée__

| Classe |  Donnée 1  |   Donnée 2    | Résultat attendu | Résultat observé | Résultat test |
|:------:|:----------:|:-------------:|:----------------:|:----------------:|:-------------:|
|   P1   | 1, 2, 3, 4 |    ((),())    |       true       |       true       |      OK       |
|   P2   | 1, 2, 3, 4 |   ((1,),())   |       true       |       true       |      OK       |
|   P3   | 1, 2, 3, 4 |  ((1,3),())   |       true       |       true       |      OK       |
|   P4   | 1, 2, 3, 4 |  ((1,),(2,))  |       true       |       true       |      OK       |
|   P5   | 1, 2, 3, 4 | ((1,),(2,4))  |       true       |       true       |      OK       |
|   P6   | 1, 2, 3, 4 | ((1,3),(2,))  |       true       |       true       |      OK       |
|   P7   | 1, 2, 3, 4 | ((1,4),(2,3)) |       true       |       true       |      OK       |
|   P8   | 1, 2, 3, 4 |  ((5,),(,))   |      false       |      false       |      OK       |
|   P9   | 1, 2, 3, 4 |  ((6,5),())   |      false       |      false       |      OK       |
|  P10   | 1, 2, 3, 4 | ((5,),(1,4))  |      false       |      false       |      OK       |
|  P11   | 1, 2, 3, 4 | ((1,5),(6,))  |      false       |      false       |      OK       |
|  P12   | 1, 2, 3, 4 |  ((5,),(6,))  |      false       |      false       |      OK       |
|  P13   | 1, 2, 3, 4 | ((1,5),(7,6)) |      false       |      false       |      OK       |

---

| Référence du test appliqué : 2             |
|--------------------------------------------|
| Responsable : Matis RODIER                 |
| Date de l'application du test : 06/06/2023 |
| Résultat du test : Ok                      |
| Occurrence des résultats :  systématique   |

__Données d'entrée__

| Classe | Scénario | TypeSolution  | pire ou meilleur  | Object observé  | Résultat attendu | Résultat observé |  Résultat test  |
|:------:|:--------:|:-------------:|:-----------------:|:---------------:|:----------------:|:----------------:|:---------------:|
|   P1   |    0     |   efficace    |     meilleur      |   dureeTotal    |        27        |        27        |        OK       |
|   P2   |    0     |   efficace    |       pire        |   dureeTotal    |        30        |       30         |        OK       |
|   P3   |    0     |  exhaustive   |     meilleur      |   dureeTotal    |        36        |       36         |        OK       |
|   P4   |    0     |  exhaustive   |       pire        |   dureeTotal    |        40        |       40         |        OK       |
|   P5   |    0     |   efficace    |     meilleur      |   experience    |       350        |       350        |        OK       |
|   P6   |    0     |   efficace    |       pire        |   experience    |       450        |       450        |        OK       |
|   P7   |    0     |  exhaustive   |     meilleur      |   experience    |       550        |       550        |        OK       |
|   P8   |    0     |  exhaustive   |       pire        |   experience    |       550        |       550        |        OK       |
|   P9   |    0     |   efficace    |     meilleur      |   deplacement   |        14        |        14        |        OK       |
|  P10   |    0     |   efficace    |       pire        |   deplacement   |        20        |        20        |        OK       |
|  P11   |    0     |  exhaustive   |     meilleur      |   deplacement   |        20        |        20        |        OK       |
|  P12   |    0     |  exhaustive   |       pire        |   deplacement   |        24        |        24        |        OK       |
|  P13   |    0     |   efficace    |     meilleur      |   parcoursNum   |        4         |         4        |        OK       |
|  P14   |    0     |   efficace    |       pire        |   parcoursNum   |        4         |         4        |        OK       |
|  P15   |    0     |  exhaustive   |     meilleur      |   parcoursNum   |        5         |         5        |        OK       |
|  P16   |    0     |  exhaustive   |       pire        |   parcoursNum   |        5         |         5        |        OK       |
|  P17   |    1     |   efficace    |     meilleur      |   dureeTotal    |        34        |        34        |        OK       |
|  P18   |    1     |   efficace    |       pire        |   dureeTotal    |        40        |        40        |        OK       |
|  P19   |    1     |  exhaustive   |     meilleur      |   dureeTotal    |        34        |        34        |        OK       |
|  P20   |    1     |  exhaustive   |       pire        |   dureeTotal    |        40        |        40        |        OK       |
|  P21   |    1     |   efficace    |     meilleur      |   experience    |       450        |       450        |        OK       |
|  P22   |    1     |   efficace    |       pire        |   experience    |       500        |       500        |        OK       |
|  P23   |    1     |  exhaustive   |     meilleur      |   experience    |       500        |       500        |        OK       |
|  P24   |    1     |  exhaustive   |       pire        |   experience    |       500        |       500        |        OK       |
|  P25   |    1     |   efficace    |     meilleur      |   deplacement   |        17        |        17        |        OK       |
|  P26   |    1     |   efficace    |       pire        |   deplacement   |        23        |        23        |        OK       |
|  P27   |    1     |  exhaustive   |     meilleur      |   deplacement   |        17        |        17        |        OK       |
|  P28   |    1     |  exhaustive   |       pire        |   deplacement   |        23        |        23        |        OK       |
|  P29   |    1     |   efficace    |     meilleur      |   parcoursNum   |        5         |         5        |        OK       |
|  P30   |    1     |   efficace    |       pire        |   parcoursNum   |        6         |         6        |        OK       |
|  P31   |    1     |  exhaustive   |     meilleur      |   parcoursNum   |        6         |         6        |        OK       |
|  P32   |    1     |  exhaustive   |       pire        |   parcoursNum   |        6         |         6        |        OK       |
|  P33   |    2     |   efficace    |     meilleur      |   dureeTotal    |        80        |        80        |        OK       |
|  P34   |    2     |   efficace    |       pire        |   dureeTotal    |       106        |       106        |        OK       |
|  P35   |    2     |  exhaustive   |     meilleur      |   dureeTotal    |        91        |        91        |        OK       |
|  P36   |    2     |  exhaustive   |       pire        |   dureeTotal    |       117        |       117        |        OK       |
|  P37   |    2     |   efficace    |     meilleur      |   experience    |       1000       |      1000        |        OK       |
|  P38   |    2     |   efficace    |       pire        |   experience    |       1050       |      1050        |        OK       |
|  P39   |    2     |  exhaustive   |     meilleur      |   experience    |       1200       |      1200        |        OK       |
|  P40   |    2     |  exhaustive   |       pire        |   experience    |       1200       |      1200        |        OK       |
|  P41   |    2     |   efficace    |     meilleur      |   deplacement   |        35        |        35        |        OK       |
|  P42   |    2     |   efficace    |       pire        |   deplacement   |        57        |        57        |        OK       |
|  P43   |    2     |  exhaustive   |     meilleur      |   deplacement   |        39        |        39        |        OK       |
|  P44   |    2     |  exhaustive   |       pire        |   deplacement   |        65        |        65        |        OK       |
|  P45   |    2     |   efficace    |     meilleur      |   parcoursNum   |        9         |         9        |        OK       |
|  P46   |    2     |   efficace    |       pire        |   parcoursNum   |        9         |         9        |        OK       |
|  P47   |    2     |  exhaustive   |     meilleur      |   parcoursNum   |        10        |        10        |        OK       |
|  P48   |    2     |  exhaustive   |       pire        |   parcoursNum   |        10        |        10        |        OK       |
|  P49   |    3     |   efficace    |     meilleur      |   dureeTotal    |        53        |        53        |        OK       |
|  P50   |    3     |   efficace    |       pire        |   dureeTotal    |        72        |        72        |        OK       |
|  P51   |    3     |  exhaustive   |     meilleur      |   dureeTotal    |        64        |        64        |        OK       |
|  P52   |    3     |  exhaustive   |       pire        |   dureeTotal    |        74        |        74        |        OK       |
|  P53   |    3     |   efficace    |     meilleur      |   experience    |       650        |       650        |        OK       |
|  P54   |    3     |   efficace    |       pire        |   experience    |       950        |       950        |        OK       |
|  P55   |    3     |  exhaustive   |     meilleur      |   experience    |       950        |       950        |        OK       |
|  P56   |    3     |  exhaustive   |       pire        |   experience    |       950        |       950        |        OK       |
|  P57   |    3     |   efficace    |     meilleur      |   deplacement   |        26        |        26        |        OK       |
|  P58   |    3     |   efficace    |       pire        |   deplacement   |        36        |        36        |        OK       |
|  P59   |    3     |  exhaustive   |     meilleur      |   deplacement   |        28        |        28        |        OK       |
|  P60   |    3     |  exhaustive   |       pire        |   deplacement   |        38        |        38        |        OK       |
|  P61   |    3     |   efficace    |     meilleur      |   parcoursNum   |        6         |         6        |        OK       |
|  P62   |    3     |   efficace    |       pire        |   parcoursNum   |        8         |         8        |        OK       |
|  P63   |    3     |  exhaustive   |     meilleur      |   parcoursNum   |        8         |         8        |        OK       |
|  P64   |    3     |  exhaustive   |       pire        |   parcoursNum   |        8         |         8        |        OK       |
|  P65   |    4     |   efficace    |     meilleur      |   dureeTotal    |        95        |        95        |        OK       |
|  P66   |    4     |   efficace    |       pire        |   dureeTotal    |       167        |       167        |        OK       |
|  P67   |    4     |  exhaustive   |     meilleur      |   dureeTotal    |       115        |       115        |        OK       |
|  P68   |    4     |  exhaustive   |       pire        |   dureeTotal    |       171        |       171        |        OK       |
|  P69   |    4     |   efficace    |     meilleur      |   experience    |       900        |       900        |        OK       |
|  P70   |    4     |   efficace    |       pire        |   experience    |       1100       |      1100        |        OK       |
|  P71   |    4     |  exhaustive   |     meilleur      |   experience    |       1100       |      1100        |        OK       |
|  P72   |    4     |  exhaustive   |       pire        |   experience    |       1100       |      1100        |        OK       |
|  P73   |    4     |   efficace    |     meilleur      |   deplacement   |        49        |        49        |        OK       |
|  P74   |    4     |   efficace    |       pire        |   deplacement   |       107        |       107        |        OK       |
|  P75   |    4     |  exhaustive   |     meilleur      |   deplacement   |        55        |        55        |        OK       |
|  P76   |    4     |  exhaustive   |       pire        |   deplacement   |       111        |       111        |        OK       |
|  P77   |    4     |   efficace    |     meilleur      |   parcoursNum   |        7         |         7        |        OK       |
|  P78   |    4     |   efficace    |       pire        |   parcoursNum   |        10        |        10        |        OK       |
|  P79   |    4     |  exhaustive   |     meilleur      |   parcoursNum   |        10        |        10        |        OK       |
|  P80   |    4     |  exhaustive   |       pire        |   parcoursNum   |        10        |        10        |        OK       |

## 4. Conclusion

Tous les tests que nous avons effectués pour la classe ___ManagerDeQuete___ sont OK, nos méthodes fonctionnent bien.
