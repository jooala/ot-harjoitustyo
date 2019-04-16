DROP TABLE User IF EXISTS;

CREATE TABLE User (id INTEGER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), username VARCHAR(255));

DROP TABLE Bug IF EXISTS;

CREATE TABLE Bug (id INTEGER AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), summary TEXT, priority INTEGER, steps TEXT, expectedResult TEXT, actualResult TEXT);