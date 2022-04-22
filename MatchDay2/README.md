#### spring initializr
Spring initializr cu: Spring Web, Thymeleaf, Spring Data JPA, Spring Security, OAuth2 Client, MySQL Driver 

#### react - npm & yarn
```
yarn create react-app app
cd app
yarn add bootstrap@4.1.3 react-cookie@3.0.4 react-router-dom@4.3.1 reactstrap@6.5.0
npm i -D react-router-dom@latest
yarn start
```

#### docker - mysql container
```
docker-compose up
docker exec -it docker-images_db_1 bash
```

#### mysql - permissions for app user
```
mysql> CREATE USER 'matchday'@'localhost' IDENTIFIED BY 'matchday';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'matchday'@'localhost';
mysql> FLUSH PRIVILEGES;
```
-- or, better
```
mysql> CREATE USER 'matchday'@'%' IDENTIFIED BY 'matchday';
Query OK, 0 rows affected (0.10 sec)

mysql> GRANT ALL PRIVILEGES ON *.* TO 'matchday'@'%';
Query OK, 0 rows affected (0.04 sec)

mysql> FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.03 sec)
```

#### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/match_day
spring.datasource.username=matchday
spring.datasource.password=matchday
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto = update

spring.security.oauth2.client.registration.google.clientId=${MATCHDAY_GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.clientSecret=${MATCHDAY_GOOGLE_CLIENT_SECRET}
spring.security.oauth2.client.registration.google.scope=email,profile
```