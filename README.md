# Étude de la durée de vie d'un RPG

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-1572B6?style=for-the-badge&logo=css3&logoColor=white)

SAÉ 2.01.02 : Développement d’une application, Exploration algorithmique d'un problème

## Lancement du programme

Attention : Le projet se trouve dans le répertoire [_intellij/sae2_01_](intellij/sae2_01), c'est ce dossier qu'il faut ouvrir avec un IDE.

Version graphique :
    Pour lancer la version graphique, il faut lancer la classe [_vue.SaeApplication.java_](intellij/sae2_01/src/main/java/vue/SaeApplication.java)
    
Clients en lignes de commandes :
    Les classes clients du projet se trouvent dans le package [_client_](intellij/sae2_01/src/main/java/client)


## Présentation du programme

Le but de ce projet est de réaliser une application en java pour évaluer la durée de vie d'un jeu de type RPG.
Le jeu comporte différents scénarios qui sont écrits dans des fichiers _.txt_ dans le répertoire [_scenarios_](intellij/sae2_01/scenarios). Chaque fichier de scénario contient des quêtes. Chaque quête contient un numéro de quête, une position, des préconditions, une durée, de l’expérience délivrée et un intitulé. La quête avec le numéro 0 est la quête finale. Pour cette quête, l'expérience écrite dans le fichier de scénario correspond au niveau d'expérience à avoir pour jouer la quête et non le niveau d'expérience qu'elle délivre.

Notre objectif était de fournir des solutions pour réaliser ces scénarios selon différents critères. Il existe deux types de solutions possibles : les solutions efficaces et les solutions exhaustives. Les solutions efficaces réalisent les quêtes possibles jusqu'à ce que la quête finale puisse être exécutée (elle peut être plus longue en fonction de différents critères). Les solutions exhaustives parcourent toutes les quêtes afin de finir les scénarios à 100%.

Nous avons atteint le niveau 3 de ce projet. Ainsi, l'utilisateur doit choisir un critère pour les solutions (meilleure durée ...) et un nombre maximum de solutions à afficher. L'interface graphique contient un formulaire détaillé afin de fournir des solutions personnalisées.

## Problèmes rencontrés

Dans les scénarios présents sur ce dépôt, le scénario 10 possède trop de solutions. Ce scénario ne fonctionne donc pas pour l'instant. Nous avons bloquer la possibilité de lancer l'algorithme afin de ne pas avoir d'erreur.

## Remarque

Les classes de tests se trouvent dans le dossier [_intellij/sae2_01/src/test/java/test_](intellij/sae2_01/src/test/java/test). Les dossiers de test se trouvent dans le dossier [_tests_](tests).

## BONUS

La fonctionnalité _simuler_ permet de visualiser une solution.

## Crédits
Projet réalisé par :
- [Matis RODIER](https://github.com/matisrod)
- [Jules CHIRON](https://github.com/Boucanier)

---

Projet réalisé dans le cadre des SAÉ 2.01 et 2.02 du deuxième semestre de BUT informatique à l'IUT de Vélizy

Juin 2023
