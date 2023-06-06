# SAÉ S2.01.02

SAÉ 2.01.02 : Développement d’une application, Exploration algorithmique d'un problème

## Lancement du programme

Version graphique :
    Pour lancer la version graphique, il faut lancer la classe _vue.SaeApplication.java_
    
Clients en lignes de commandes :
    Les classes clients du projet se trouvent dans le package _client_


## Présentation du programme

Le but de ce projet est de réaliser une application en java pour évaluer la durée de vie d'un ju de type RPG.
Le jeu comporte différents scénarios qui sont écrits dans des fichiers _.txt_ dans le répertoire _scenarios_. Chaque fichier de scénario contient des quêtes. Chaque quête contient un numéro de quête, une position, des préconditions, une durée, de l’expérience délivrée et un intitulé. La quête avec le numéro 0 est la quête finale. Pour cette quête, l'expérience écrite dans le fichier de scénario correspond au niveau d'expérience à avoir pour jouer la quête et non le niveau d'expérience qu'elle délivre.

Notre objectif était de fournir des solutions pour réaliser ces scénarios selon différents critères. Il existe deux types de solutions possibles : les solutions efficace et les solutions exhaustive. Les solutions efficaces réalisent les quêtes possibles jusqu'à ce que la quête finale puisse être exécutée (elle peut être plus longues en fonction de différents critères). Les solutions exhaustives prcourent toutes les quêtes afin de finir les scénarios à 100%.

Nous avons atteint le niveau 3 de ce projet. Ainsi, l'utilisateur doit choisir un critère pour les solutions (meilleure durée ...) et un nombre maximum de solutions à afficher. L'interface graphique contient un formulaire détaillé afin de fournir des solutions personnlisées.

## Problèmes rencontrés

Dans les scénarios présents sur ce dépôt, le scénario 10 possède trop de solutions. Ce scénario ne fonctionne donc pas pour l'instant.

## Remarque

Les classe de tests se trouvent dans le dossier _intellij/sae2_01/src/test/java/test_. Les dossiers de test se trouvent dans le dossier _tests_.
