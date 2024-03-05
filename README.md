## Admin-app manage with ELK & Keycloack
## ELK
## Captures d'écran

 ## Requette pour recuperer tous les etudiants : http://localhost:9098/api/etudiants/getAllEtudiant
 ##           
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/elasticsearchfirstrun.png?raw=true)
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/elas-login-page.png?raw=true)
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/elas-first-connected.png?raw=true)
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/reset-elas-password.png?raw=true)



# Projet admin-app

Ce projet Spring Boot utilise Java 8, Maven, Docker, et des logs pour construire une architecture solide.

## Structure du Projet

Le projet est divisé en plusieurs packages pour une meilleure organisation :

### `sn.isi.entities`

Contient les entités JPA avec les annotations nécessaires pour générer la base de données.

### `sn.isi.dto`

Inclut des classes DTO (Data Transfer Object) pour les mêmes entités sans les annotations, simplifiant la manipulation dans les vues.

### `sn.isi.dao`

Comprend des interfaces DAO (Data Access Object) pour chaque entité, étendant `JpaRepository` pour gérer les opérations CRUD.

### `sn.isi.mapping`

Contient des interfaces pour les mappers qui permettent de transformer chaque entité en sa correspondance DTO et vice versa.

### `sn.isi.exception`

Héberge des classes personnalisées pour la gestion des exceptions.

### `sn.isi.service`

Englobe des services pour chaque entité, gérant les opérations CRUD et d'autres personnalisées.

### `sn.isi.config`

Comprend des configurations pour l'application, y compris la gestion des messages sources et la configuration des logs.

### `sn.isi.controller`

Contient des RestControllers pour chaque entité, gérant les opérations REST.

### `sn.isi`

Contient la classe de base pour le démarrage de l'application Spring Boot.

## Annotations Utilisées

- Les entités JPA dans le package `sn.isi.entities` sont annotées avec `@Entity` pour indiquer leur persistance.
- Les interfaces DAO dans le package `sn.isi.dao` étendent `JpaRepository` et sont annotées avec `@Repository`.
- Les classes services dans le package `sn.isi.service` sont annotées avec `@Service`.
- Les RestControllers dans le package `sn.isi.controller` sont annotés avec `@RestController`.
- Les classes de configuration dans le package `sn.isi.config` sont annotées avec `@Configuration`.
- Les classes de gestion des exceptions dans le package `sn.isi.exception` peuvent utiliser des annotations comme `@ControllerAdvice` pour gérer les exceptions globalement.

Au niveau du projet dans `sn.isi.resources`, le dossier est crucial pour les vues et contient des fichiers de configuration essentiels tels que `messages.properties`, et `log4j2.xml`. Notamment, le fichier `application.yml` définit le port de démarrage, le datasource, et l'ORM JPA via `hibernate`.

## Docker

Le projet utilise Docker pour la conteneurisation. Le fichier `docker-compose.yml` à la racine du projet configure les services Docker via Docker Compose. Ci-dessous, une explication des principales lignes du fichier :

```yaml
services:
  mysql-admin-db:
    # Configuration du service MySQL
    image: mysql:8.0
    # ... (configurations)
  
  phpmyadmin-admin-db:
    # Configuration du service PHPMyAdmin
    image: phpmyadmin/phpmyadmin:latest
    # ... (configurations)
  
volumes:
  mysql_data:
    driver: local
