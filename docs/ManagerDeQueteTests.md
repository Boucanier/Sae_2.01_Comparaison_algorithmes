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
| Configuration matérielle : Ubuntu 22.04                      |
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

## 4. Conclusion

Tous les tests que nous avons effectués pour la classe ___ManagerDeQuete___ sont OK, nos méthodes fonctionnent bien.