## Admin-app manage with ELK & Keycloack
## ELK
## Captures d'écran

 ## 
 ## Nous demmarons elasticsearch           
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/elasticsearchfirstrun.png?raw=true)
 ## 
 ## On se log a elasticsearch
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/elas-login-page.png?raw=true)
 ## 
 ## La nous avons bien acces
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/elas-first-connected.png?raw=true)
 ## 
 ## La on regenere um mot de passe pour l'utisateur elastic et l'utiliser pour se connecter dorénavant 
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/e/reset-elas-password.png?raw=true)
 ## 
 ## La on lance kibana
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/k/kibana-run.png?raw=true)
 ## 
 ## C'est bien demarre mais nous devons nous rendre sur l'interface d'aministration pour le configurer
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/k/kibana-config-link.png?raw=true)
 ## 
 ## Ici on genere notre token depuis elasticsearch et que nous allons ensuite utiliser pour le linker a kibana
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/k/generate-enrollment-token.png?raw=true)
 ## 
 ## ici on renseigne notre token et on clique sur configure elastic
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/k/pasted-enroll-token.png?raw=true)
 ## 
 ## Tout c'est bien passe : on acces a elastic a partir de kibana 
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/k/kibana-dashbord-connected-by-elastic.png?raw=true)
 ## 
 ## A ce niveau on install un "sample web logs"
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/l/install-sample-web-logs.png?raw=true)
 ## 
 ## La nous donnons a logtash le fichier des logs
 ![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/l/logtashcof.png?raw=true)
 ##
 ## Ici nous voyons que le test de notre end-point qui se trouve dans notre application s'est bien passe
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/test-endpoint-spingboot.png?raw=true)
 ## 
 ## Et si nous visualisons les logs au niveau de logstash, nous voyons que les informations ont tous bien ete repertiriees
![alt text](https://github.com/LamineOzilJr/admin-app-Keycloack/blob/main/elk-images/final-test-logs.png?raw=true)



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
