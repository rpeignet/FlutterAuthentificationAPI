# Flutter Intégration API

Robin Peignet

Repo git : https://github.com/rpeignet/FlutterAuthentificationAPI

## API REST

L'API qui gère la connexion est développée en java avec le framwork spring.

Pour l'utiliser, récupérez le projet en local et lancez-le avec l'ide de votre choix.

Cette api utilise une base de donnée H2 (https://www.h2database.com/html/main.html) avec des données en mémoire.

Son rôle principal est de gérer la connexion d'utilisateur, pour cela, on met a disposition une route de login :
```
http://localhost:8080/api/auth/login
```

Cette route utilise la méthode ``HTTP post`` et a donc besoin d'un corps de requête (ici du `JSON`) : 
```json
{
	"email": "robin@gmail.com",
	"password": "rpeignet"
}
```

Le mot de passe est hashé avec l'algorithme de hash ``SHA-256``, de cette manière les mots de passe ne sont jamais stockés en clair dans notre base de données : 
![](/image/bdd.png)

Lors d'une connexion réussie, l'api renvoie un code 200 ainsi qu'un DTO avec les informations suivantes : 
```json
{
	"id": 1,
	"firstName": "robin",
	"lastName": "peignet",
	"email": "robin@gmail.com",
	"role": "admin",
	"status": 200,
	"message": "Success"
}
```
En cas d'erreur, elle renvoie une `bad request` code 400 avec un descriptif détaillé du problème : 
```
Erreur lors de la connexion avec l'email : robin@gmail.com
```

## L'application flutter

L'objectif du projet est de reprendre une application flutter existante et de la liée à l'api rest précédemment évoquée.

Pour cela, on importe les packages suivant dans l'application flutter : 
- http (pour effectuer des requêtes)
- riverpod (pour gérer l'état des données de connexion)

pubspec.yaml : 
```yaml
dependencies:
  flutter:
    sdk: flutter
  crypto: ^3.0.1
  flutter_riverpod: ^2.0.0
  http: ^1.2.2
  riverpod_annotation: ^2.6.1

dev_dependencies:
  flutter_test:
    sdk: flutter
  riverpod_generator: ^2.0.0
  build_runner:
```

Penser au besoin d'éxecuter la commande : 
```bash
flutter pub get
```

Modification de l'architecture du projet :
### Models
On crée deux modèles/dto's utilisés lors des appels API : 
- ``login_request_dto`` : Il contient l'email et le password et est utilisé lors d'une demande de login.
- ``login_response_dto`` il contient les données de l'utilisateur connecté renvoyées par l'api.

### Services
On supprimera l'ancien ``auth_service`` pour le remplacer par un ``login_provider``.

On annote le provider avec ``@riverpod`` car c'est le framework Riverpod qui gèrera l'auto-génération du provider.

On passe au provider les propriétés ``email`` et ``password`` pour la connexion.
Ce provider utilisera également la librairie ``http`` pour faire les appels API.

On renvoie un résultat ``asynchrone`` donc on englobe le tout dans une ``Future``.

### Screens

Sur la partie UI/UX on modifiera la méthode ``login()`` pour qu'elle puisse utiliser notre ``login_provider``.

Lors de l'appel, on attendra donc un ``login_response_dto`` et on enverra ce dto à la page de profile.

On ajoutera également un ``indicateur de chargement`` qui dépendra de l'état de chargement des données.

On mettra wrappera notre page dans un ``SingleChildScrollView`` ce qui rendra plus responsive l'application.

## Images de démonstration : 

### Test des requêtes Backend avec insomnia
![](/image/insomnia1.png)
![](/image/insomnia2.png)

### Test réussi sur l'app flutter : 
![](/image/login_page.png)
![](/image/profil_page.png)

### Test d'échec sur l'app flutter : 
![](/image/erreur_pop.png)

Detail : L'ensemble des tests ont été réalisés avec ``windows desktop``. Il sera peut-être nécessaire d'adapter la configuration pour le lancer sur un autre device.