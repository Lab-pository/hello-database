CREATE TABLE MEMBER
(
    id   INT(11)     NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE ORDERS
(
    id    INT(11)     NOT NULL PRIMARY KEY,
    buyer VARCHAR(20) NOT NULL
);

CREATE TABLE INVOICE
(
    id       INT(11)     NOT NULL PRIMARY KEY,
    order_id INT(11)     NOT NULL,
    buyer    VARCHAR(20) NOT NULL
);

CREATE TABLE ACCOUNTS
(
    id      INT(11) NOT NULL PRIMARY KEY,
    balance INT(11)
);
