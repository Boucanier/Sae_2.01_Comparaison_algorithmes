# Dossier de tests

| Exploration algorithmique                  | Version : 0             |
|--------------------------------------------|-------------------------|
| Document : Dossier de tests                | Date : 23/05/2023       |
| Responsable de la rédaction : Jules CHIRON |                         |

## 1. Introduction

Ce dossier contient les tests pour les différentes méthodes de la classe ___ManagerDeQuete___.
Les méthodes testées sont _distanceEntrePos_, _peutCommencerQuete_. Nous commencons par tester 
la méthode _distanceEntrePos_ car elle est utilisée dans la méthode _peutCommencerQuete_.

## 2. Description de la procédure de test

Pour chaque test, les ensembles des cas de test sont définis. Puis pour chaque
cas, des données de test sont définies. Nous utilisons JUnit 5 pour réaliser nos tests.
Nous comparerons ensuite les résultats obtenus avec les résultats attendus.

## 3. Description des informations à enregistrer pour les tests

### 1. Campagne de test

| Produit testé : classe _ManagerDeQuete_                      |
|--------------------------------------------------------------|
| Configuration logicielle : Java 18, IntelliJ, JUnit 5        |
| Configuration matérielle : Ubuntu 22.04, Windows 11          |
| Date de début : 11/05/2023                                   |
| Date de finalisation : 23/05/2023                            |
| Tests à appliquer : _distanceEntrePos_, _peutCommencerQuete_ |
| Responsable de la campagne de test : Jules CHIRON            |

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

| Référence du test appliqué : 2             |
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

| Référence du test appliqué : 2   |
|----------------------------------|
| Responsable : Matis RODIER       |
| Date de l'application du test :  |
| Résultat du test :               |
| Occurrence des résultats :       |

__Données d'entrée__

| Classe | Scénario | TypeSolution  | pire ou meilleur  | Object observé  | Résultat attendu | Résultat observé | Résultat test |
|:------:|:--------:|:-------------:|:-----------------:|:---------------:|:----------------:|:----------------:|---------------|
|   P1   |    0     |   efficace    |     meilleur      |   dureeTotal    |        27        |                  |               |
|   P2   |    0     |   efficace    |       pire        |   dureeTotal    |        30        |                  |               |
|   P3   |    0     |  exhaustive   |     meilleur      |   dureeTotal    |        36        |                  |               |
|   P4   |    0     |  exhaustive   |       pire        |   dureeTotal    |        40        |                  |               |
|   P5   |    0     |   efficace    |     meilleur      |   experience    |       350        |                  |               |
|   P6   |    0     |   efficace    |       pire        |   experience    |       450        |                  |               |
|   P7   |    0     |  exhaustive   |     meilleur      |   experience    |       550        |                  |               |
|   P8   |    0     |  exhaustive   |       pire        |   experience    |       550        |                  |               |
|   P9   |    0     |   efficace    |     meilleur      |   deplacement   |        14        |                  |               |
|  P10   |    0     |   efficace    |       pire        |   deplacement   |        20        |                  |               |
|  P11   |    0     |  exhaustive   |     meilleur      |   deplacement   |        20        |                  |               |
|  P12   |    0     |  exhaustive   |       pire        |   deplacement   |        24        |                  |               |
|  P13   |    0     |   efficace    |     meilleur      |   parcoursNum   |        4         |                  |               |
|  P14   |    0     |   efficace    |       pire        |   parcoursNum   |        4         |                  |               |
|  P15   |    0     |  exhaustive   |     meilleur      |   parcoursNum   |        5         |                  |               |
|  P16   |    0     |  exhaustive   |       pire        |   parcoursNum   |        5         |                  |               |
|  P17   |    1     |   efficace    |     meilleur      |   dureeTotal    |        34        |                  |               |
|  P18   |    1     |   efficace    |       pire        |   dureeTotal    |        40        |                  |               |
|  P19   |    1     |  exhaustive   |     meilleur      |   dureeTotal    |        34        |                  |               |
|  P20   |    1     |  exhaustive   |       pire        |   dureeTotal    |        40        |                  |               |
|  P21   |    1     |   efficace    |     meilleur      |   experience    |       450        |                  |               |
|  P22   |    1     |   efficace    |       pire        |   experience    |       500        |                  |               |
|  P23   |    1     |  exhaustive   |     meilleur      |   experience    |       500        |                  |               |
|  P24   |    1     |  exhaustive   |       pire        |   experience    |       500        |                  |               |
|  P25   |    1     |   efficace    |     meilleur      |   deplacement   |        17        |                  |               |
|  P26   |    1     |   efficace    |       pire        |   deplacement   |        23        |                  |               |
|  P27   |    1     |  exhaustive   |     meilleur      |   deplacement   |        17        |                  |               |
|  P28   |    1     |  exhaustive   |       pire        |   deplacement   |        23        |                  |               |
|  P29   |    1     |   efficace    |     meilleur      |   parcoursNum   |        5         |                  |               |
|  P30   |    1     |   efficace    |       pire        |   parcoursNum   |        6         |                  |               |
|  P31   |    1     |  exhaustive   |     meilleur      |   parcoursNum   |        6         |                  |               |
|  P32   |    1     |  exhaustive   |       pire        |   parcoursNum   |        6         |                  |               |
|  P33   |    2     |   efficace    |     meilleur      |   dureeTotal    |        80        |                  |               |
|  P34   |    2     |   efficace    |       pire        |   dureeTotal    |       106        |                  |               |
|  P35   |    2     |  exhaustive   |     meilleur      |   dureeTotal    |        91        |                  |               |
|  P36   |    2     |  exhaustive   |       pire        |   dureeTotal    |       117        |                  |               |
|  P37   |    2     |   efficace    |     meilleur      |   experience    |       1000       |                  |               |
|  P38   |    2     |   efficace    |       pire        |   experience    |       1050       |                  |               |
|  P39   |    2     |  exhaustive   |     meilleur      |   experience    |       1200       |                  |               |
|  P40   |    2     |  exhaustive   |       pire        |   experience    |       1200       |                  |               |
|  P41   |    2     |   efficace    |     meilleur      |   deplacement   |        35        |                  |               |
|  P42   |    2     |   efficace    |       pire        |   deplacement   |        57        |                  |               |
|  P43   |    2     |  exhaustive   |     meilleur      |   deplacement   |        39        |                  |               |
|  P44   |    2     |  exhaustive   |       pire        |   deplacement   |        65        |                  |               |
|  P45   |    2     |   efficace    |     meilleur      |   parcoursNum   |        9         |                  |               |
|  P46   |    2     |   efficace    |       pire        |   parcoursNum   |        9         |                  |               |
|  P47   |    2     |  exhaustive   |     meilleur      |   parcoursNum   |        10        |                  |               |
|  P48   |    2     |  exhaustive   |       pire        |   parcoursNum   |        10        |                  |               |
|  P49   |    3     |   efficace    |     meilleur      |   dureeTotal    |        53        |                  |               |
|  P50   |    3     |   efficace    |       pire        |   dureeTotal    |        72        |                  |               |
|  P51   |    3     |  exhaustive   |     meilleur      |   dureeTotal    |        64        |                  |               |
|  P52   |    3     |  exhaustive   |       pire        |   dureeTotal    |        74        |                  |               |
|  P53   |    3     |   efficace    |     meilleur      |   experience    |       650        |                  |               |
|  P54   |    3     |   efficace    |       pire        |   experience    |       950        |                  |               |
|  P55   |    3     |  exhaustive   |     meilleur      |   experience    |       950        |                  |               |
|  P56   |    3     |  exhaustive   |       pire        |   experience    |       950        |                  |               |
|  P57   |    3     |   efficace    |     meilleur      |   deplacement   |        26        |                  |               |
|  P58   |    3     |   efficace    |       pire        |   deplacement   |        36        |                  |               |
|  P59   |    3     |  exhaustive   |     meilleur      |   deplacement   |        28        |                  |               |
|  P60   |    3     |  exhaustive   |       pire        |   deplacement   |        38        |                  |               |
|  P61   |    3     |   efficace    |     meilleur      |   parcoursNum   |        6         |                  |               |
|  P62   |    3     |   efficace    |       pire        |   parcoursNum   |        8         |                  |               |
|  P63   |    3     |  exhaustive   |     meilleur      |   parcoursNum   |        8         |                  |               |
|  P64   |    3     |  exhaustive   |       pire        |   parcoursNum   |        8         |                  |               |
|  P65   |    4     |   efficace    |     meilleur      |   dureeTotal    |        95        |                  |               |
|  P66   |    4     |   efficace    |       pire        |   dureeTotal    |       167        |                  |               |
|  P67   |    4     |  exhaustive   |     meilleur      |   dureeTotal    |       115        |                  |               |
|  P68   |    4     |  exhaustive   |       pire        |   dureeTotal    |       171        |                  |               |
|  P69   |    4     |   efficace    |     meilleur      |   experience    |       900        |                  |               |
|  P70   |    4     |   efficace    |       pire        |   experience    |       1100       |                  |               |
|  P71   |    4     |  exhaustive   |     meilleur      |   experience    |       1100       |                  |               |
|  P72   |    4     |  exhaustive   |       pire        |   experience    |       1100       |                  |               |
|  P73   |    4     |   efficace    |     meilleur      |   deplacement   |        49        |                  |               |
|  P74   |    4     |   efficace    |       pire        |   deplacement   |       107        |                  |               |
|  P75   |    4     |  exhaustive   |     meilleur      |   deplacement   |        55        |                  |               |
|  P76   |    4     |  exhaustive   |       pire        |   deplacement   |       111        |                  |               |
|  P77   |    4     |   efficace    |     meilleur      |   parcoursNum   |        7         |                  |               |
|  P78   |    4     |   efficace    |       pire        |   parcoursNum   |        10        |                  |               |
|  P79   |    4     |  exhaustive   |     meilleur      |   parcoursNum   |        10        |                  |               |
|  P80   |    4     |  exhaustive   |       pire        |   parcoursNum   |        10        |                  |               |

## 4. Conclusion

Tous les tests que nous avons effectués pour la classe ___ManagerDeQuete___ sont OK, nos méthodes fonctionnent bien.
