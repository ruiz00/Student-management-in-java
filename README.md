# Gestionnaire d'Étudiants

Application console Java pour gérer une liste d'étudiants (CRUD : ajouter, lister, modifier, supprimer).

## Prérequis

- JDK 17 ou supérieur installé (`java -version` pour vérifier)

## Structure du projet

```
.
├── Main.java
├── Etudiant.java
└── README.md
```

## Compilation

Depuis le dossier du projet :

```bash
javac *.java
```

Cela génère `Main.class` et `Etudiant.class`.

## Exécution

```bash
java Main
```

## Utilisation

Au lancement, un menu s'affiche :

```
1. Ajouter un etudiant
2. Lister tous les etudiants
3. Modifier un etudiant
4. Supprimer un etudiant
5. Quitter l'application
```

Entrez le numéro correspondant à l'action souhaitée, puis suivez les instructions à l'écran :

- **Ajouter** : saisir ID, nom, prénom et moyenne (0-20)
- **Lister** : affiche tous les étudiants enregistrés
- **Modifier** : recherche par ID, laisser un champ vide (ou `-1` pour la moyenne) pour le conserver tel quel
- **Supprimer** : recherche par ID et retire l'étudiant de la liste
- **Quitter** : ferme l'application

> Les données sont stockées en mémoire uniquement — elles sont perdues à la fermeture du programme (pas de base de données ni de fichier de sauvegarde pour l'instant).

## Limitations connues

- Pas de persistance des données (tout est perdu à la fermeture)
- Pas de vérification stricte des doublons autre que l'ID

## Pistes d'amélioration

- Ajouter une persistance avec JDBC (base de données)
- Ajouter une recherche par nom/prénom
- Exporter la liste au format CSV
