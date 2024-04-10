CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users (name, email) VALUES (?, ?);


SELECT * FROM users;

SELECT name, email FROM users;

SELECT name, email FROM users ORDER BY name ASC;


UPDATE users SET email = ? WHERE id = ?;


DELETE FROM users WHERE id = ?;