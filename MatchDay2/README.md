spring initializr
yarn create react-app app
cd app
yarn add bootstrap@4.1.3 react-cookie@3.0.4 react-router-dom@4.3.1 reactstrap@6.5.0
npm i -D react-router-dom@latest
yarn start

docker-compose up
docker exec -it docker-images_db_1 bash

mysql> CREATE USER 'matchday'@'localhost' IDENTIFIED BY 'matchday';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'matchday'@'localhost';
mysql> FLUSH PRIVILEGES;

-- better --

mysql> CREATE USER 'matchday'@'%' IDENTIFIED BY 'matchday';
Query OK, 0 rows affected (0.10 sec)

mysql> GRANT ALL PRIVILEGES ON *.* TO 'matchday'@'%';
Query OK, 0 rows affected (0.04 sec)

mysql> FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.03 sec)
