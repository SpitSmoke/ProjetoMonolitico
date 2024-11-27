![](https://s2.gifyu.com/images/telefone.gif)


To make this project work, you need to create a Postgres database with the following setup:

```
Postgres <domain>:<port>: localhost:5432
Database name: db_telephone_list
Username: telephone_list_user 
Password: secret
```
Then, you need to create some tables following the SQL sample below.

```SQL
CREATE TABLE tb_user(id INT PRIMARY KEY, name VARCHAR(50) NOT NULL, telephone VARCHAR(16) NOT NULL UNIQUE, type telephone_type);
CREATE SEQUENCE sq_user START 1 INCREMENT 1 OWNED BY tb_user.id;
CREATE TYPE telephone_type AS ENUM('CELLPHONE', 'PUBLIC', 'LANDLINE');
```

Now, you need to download a gradle jar by using the following command on the project root folder:

```bash
gradle wrapper 
```

I made some basic tests that can be run with the command below:

```bash
 ./gradlew war
```
The artifact will be available on `/build/libs/usar.war`
