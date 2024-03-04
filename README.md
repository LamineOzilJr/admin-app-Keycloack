Projet admin-app
Ce projet représente une application basée sur Spring Boot, utilisant Java 8, Maven, Docker, et des fonctionnalités de journalisation, entre autres.

Structure du Projet
Le projet est structuré en plusieurs packages pour assurer une claire séparation des responsabilités :

sn.isi.entities
Ce package englobe les entités JPA, annotées de manière appropriée pour la génération de la base de données.

sn.isi.dto
Il contient des classes DTO (Data Transfer Object) correspondant aux entités, mais sans les annotations JPA. Ceci facilite la manipulation des objets de la base de données dans les vues.

sn.isi.dao
Ce package abrite des interfaces DAO (Data Access Object) pour chaque entité, étendant JpaRepository pour la gestion des opérations CRUD.

sn.isi.mapping
Des interfaces de mappage permettent de convertir chaque entité en son équivalent DTO, et vice versa.

sn.isi.exception
Des classes personnalisées sont fournies pour la gestion des exceptions.

sn.isi.service
Des services pour chaque entité sont regroupés ici, gérant les opérations CRUD ainsi que d'autres fonctionnalités personnalisées.

sn.isi.config
Les configurations de l'application, y compris la gestion des messages sources et la configuration des logs, sont regroupées dans ce package.

sn.isi.controller
Les RestControllers pour chaque entité sont situés ici pour gérer les opérations REST.

sn.isi
La classe de base pour démarrer l'application Spring Boot se trouve dans ce package.

Annotations Utilisées
Les entités JPA dans le package sn.isi.entities sont annotées avec @Entity pour signaler leur persistance.
Les interfaces DAO dans le package sn.isi.dao étendent JpaRepository et sont annotées avec @Repository.
Les classes services dans le package sn.isi.service sont annotées avec @Service.
Les RestControllers dans le package sn.isi.controller sont annotés avec @RestController.
Les classes de configuration dans le package sn.isi.config sont annotées avec @Configuration.
Les classes de gestion des exceptions dans le package sn.isi.exception peuvent utiliser des annotations telles que @ControllerAdvice pour gérer les exceptions globalement.
Dans le répertoire sn.isi.resources du projet, se trouvent des fichiers essentiels tels que les vues, les messages d'erreur dans messages.properties, et la configuration de base de log4j dans log4j2.xml. Le fichier crucial application.yml définit le port de démarrage de l'application, le datasource pour la base de données, et la configuration de l'ORM JPA à travers Hibernate.

Docker
Le projet utilise Docker pour la conteneurisation, avec un fichier docker-compose.yml expliqué ci-dessous.
```
services: 

  mysql-admin-db: 
    image: mysql:8.0
    container_name: container_mysql-admin-db
    environment: 
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: adminapp-db
      MYSQL_USER: user
      MYSQL_PASSWORD: user
    ports: 
      - 3306:3306
    volumes: 
      - mysql_data:/var/lib/mysql
    healthcheck: 
      test: mysqladmin ping -h 127.0.0.1 -u $$MYSQL_USER --password=$$MYSQL_PASSWORD

  phpmyadmin-admin-db: 
    container_name: container_phpmyadmin-admindb
    image: phpmyadmin/phpmyadmin:latest
    ports: 
      - 8085:80
    environment: 
      MYSQL_ROOT_PASSWORD: root
      PMA_HOST: mysql-admin-db
      PMA_USER: user
      PMA_PASSWORD: user
    depends_on: 
      - mysql-admin-db
    restart: unless-stopped 

volumes: 
  mysql_data:
    driver: local

```
