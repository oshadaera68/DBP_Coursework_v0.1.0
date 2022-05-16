DROP DATABASE IF EXISTS supermarket;
CREATE DATABASE IF NOT EXISTS supermarket;
SHOW DATABASES;
USE supermarket;

#-----------------------------------

CREATE TABLE customer
(
    custId      VARCHAR(10) PRIMARY KEY,
    custTitle   VARCHAR(20),
    custName    VARCHAR(30),
    custAddress VARCHAR(30),
    city        VARCHAR(20),
    province    VARCHAR(20),
    postalCode  VARCHAR(10)
);

DESC customer;
SHOW TABLES;

#-------------------------------

CREATE TABLE item
(
    itemCode    VARCHAR(10) PRIMARY KEY,
    description VARCHAR(50),
    packSize    VARCHAR(30),
    unitPrice   DECIMAL(6, 2),
    qtyOnHand   INT
);

DESC item;
SHOW TABLES;

#--------------------------------

CREATE TABLE orders
(
    orderId   VARCHAR(10) PRIMARY KEY,
    orderDate DATE,
    custId    VARCHAR(10),
    CONSTRAINT FOREIGN KEY (custId) REFERENCES customer (custId)
);

DESC orders;
SHOW TABLES;

#--------------------------------

CREATE TABLE orderDetail
(
    orderId  VARCHAR(10),
    itemCode VARCHAR(10),
    orderQty INT,
    discount DECIMAL
);

DESC orderDetail;
SHOW TABLES;
