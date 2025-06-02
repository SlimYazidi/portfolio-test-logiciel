#Rapport de test - OrangeHRM

#Informations générales
- **Projet** : OrangeHRM
- **Testeur** : Slim Yazidi
- **Date** : 02 juin 2025
- **Version testée** : OrangeHRM Demo (https://opensource-demo.orangehrmlive.com/)
- **Navigateurs** : Chrome 136

#Objectif du test
Vérifier les fonctionnalités de base de l’authentification (login/logout) de l’application OrangeHRM.

#Résumé des tests

| ID    | Titre du test                | Résultat attendu                   | Résultat réel                    | Statut     |
|-------|------------------------------|------------------------------------|----------------------------------|------------|
| TC001 | Connexion réussie            | Redirection vers Dashboard         | OK                               |    Passé   |
| TC002 | Connexion échouée (MDP)      | Message : "Invalid credentials"    | OK                               |    Passé   |
| TC003 | Champs vides                 | Message : "Required"               | OK                               |    Passé   |
| TC004 | Déconnexion                  | Retour à la page de login          | OK                               |    Passé   |

#Bugs identifiés
Aucun bug bloquant détecté lors de cette session.

#Conclusion
Les tests fonctionnels basiques du module d’authentification sont conformes. Il est recommandé de poursuivre avec des tests UI avancés (champs masqués, injection, performance login…).
