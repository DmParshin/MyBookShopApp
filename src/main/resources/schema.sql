CREATE TABLE authors
(
    id        INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(250) NOT NULL,
    lastName  VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books
(
    id       INT NOT NULL AUTO_INCREMENT,
    author_id INT NOT NULL,
    title    VARCHAR(250) NOT NULL,
    priceOld VARCHAR(250) DEFAULT NULL,
    price    VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

