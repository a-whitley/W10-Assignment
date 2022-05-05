CREATE DATABASE IF NOT EXISTS instruments;

USE instruments;

DROP TABLE IF EXISTS instruments;

CREATE TABLE instruments (
	id INT(10) NOT NULL auto_increment,
    name VARCHAR(40) NOT NULL,
    type VARCHAR(40) NOT NULL,
    origin VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);