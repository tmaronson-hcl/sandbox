DROP TABLE IF EXISTS books;
CREATE TABLE books (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  price DEC (10,2) default NULL,
  PRIMARY KEY (id)
);