CREATE TYPE ROLE AS ENUM ('USER', 'ADMIN');
CREATE TYPE STATUS AS ENUM ('ACTIVE', 'BANNED');

CREATE TABLE users
(
    id BIGSERIAL CONSTRAINT user_pk PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ROLE DEFAULT 'USER',
    status STATUS DEFAULT 'ACTIVE'
);

CREATE UNIQUE INDEX user_email_uindex ON users (email);