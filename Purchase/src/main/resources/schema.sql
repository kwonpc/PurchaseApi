DROP TABLE IF EXISTS userinfo;
CREATE TABLE userinfo(
    id INT PRIMARY KEY, 
    name VARCHAR(20)  
);

DROP TABLE IF EXISTS productinfo;
CREATE TABLE productinfo(
    id INT PRIMARY KEY, 
    name VARCHAR(100),
    price INT
);

DROP TABLE IF EXISTS purchaseinfo;
CREATE TABLE purchaseinfo(
    id INT PRIMARY KEY, 
    user_id INT,
    product_id INT,
    price INT
);