# Rapport de test – SauceDemo (Jour 2)

## Objectif
Vérifier le bon fonctionnement du processus de connexion, ajout d’article au panier et déconnexion sur le site SauceDemo.

## Cas de test réalisés
1. Connexion avec un utilisateur valide (`standard_user`)
2. Ajout d’un article au panier
3. Vérification du panier
4. Déconnexion

## Résultats
- ✅ Connexion réussie
- ✅ Ajout au panier OK
- ✅ Article bien visible
- ❌ Problème lors de la déconnexion : redirection vers modification mot de passe

## Observations
L’environnement de test SauceDemo semble imposer une redirection après logout. À noter pour les futurs tests automatisés.
