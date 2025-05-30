# Projet de test automatisé - OrangeHRM Demo

Ce projet contient deux scripts de test automatisé pour le site [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/) en utilisant Selenium WebDriver.

## Objectif

1. Connexion avec les identifiants `Admin / admin123`
2. Vérification que le tableau de bord s'affiche
3. Déconnexion de l'application

## Structure du projet

orangehrm-test/  
├── src/test/java/com/slim/testing/  
│   ├── OrangeHRMTest.java        # Script simple avec méthode main  
│   └── OrangeHRMTestNG.java      # Script avec TestNG (annotations @Test)  
├── pom.xml                       # Fichier Maven avec les dépendances  
└── README.md                     # Documentation du projet  

## Technologies utilisées

- Java  
- Maven  
- Selenium WebDriver  
- WebDriverManager  
- TestNG  

## Exécution des tests

- OrangeHRMTest.java : clic droit > Run As > Java Application  
- OrangeHRMTestNG.java : clic droit > Run As > TestNG Test  

## Remarques

- Aucun framework avancé (Page Object Model, assertions, reporting) n'est utilisé ici.  
- Ce projet est volontairement simple, pour montrer une première automatisation propre.

Réalisé par Slim Yazidi
