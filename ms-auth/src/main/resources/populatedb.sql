-- password: admin
INSERT INTO users (email, first_name, last_name, password, status)
VALUES('admin@gmail.com', 'admin', 'Adminov', '$2a$12$9Ie8rDcJa.Puj6KZxPvdie.ENjI45A/B5L2PdVTvBOaZJU.W/INPq', 'ACTIVE');
-- password: user
INSERT INTO users (email, first_name, last_name, password, status)
VALUES('user@gmail.com', 'user', 'Userov', '$2a$12$btz8gudaSANZHIXTDNJXX.EAKu3mDMX.h76dnwgOIRIXT5G0ZneSC', 'ACTIVE');
-- password: banned
INSERT INTO users (email, first_name, last_name, password, status)
VALUES('banned@gmail.com', 'banned', 'Banned', '$2a$12$jIalC7Xnh0LIkwST4bGA2.eiGnJR67SXEK8mQ/rS3Eca/zdNy8xkC', 'BANNED');

INSERT INTO roles (name)
VALUES('ADMIN');
INSERT INTO roles (name)
VALUES('USER');

INSERT INTO authorities (name)
VALUES('READ');
INSERT INTO authorities (name)
VALUES('WRITE');

INSERT INTO users_roles (user_id, role_id)
VALUES(1, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES(2, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES(3, 2);

INSERT INTO roles_authorities (role_id, authority_id)
VALUES(1, 1);
INSERT INTO roles_authorities (role_id, authority_id)
VALUES(1, 2);
INSERT INTO roles_authorities (role_id, authority_id)
VALUES(2, 1);

