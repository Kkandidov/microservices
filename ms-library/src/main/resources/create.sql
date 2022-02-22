SET FOREIGN_KEY_CHECKS=0; 

/* Drop Tables */
DROP TABLE IF EXISTS `authors` CASCADE;
DROP TABLE IF EXISTS `books` CASCADE;
DROP TABLE IF EXISTS `genres` CASCADE;
DROP TABLE IF EXISTS `m2m_books_authors` CASCADE;
DROP TABLE IF EXISTS `m2m_books_genres` CASCADE;
DROP TABLE IF EXISTS `subscribers` CASCADE;
DROP TABLE IF EXISTS `subscriptions` CASCADE;

ALTER DATABASE library CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

/* Create Tables */
CREATE TABLE `authors`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`a_name` VARCHAR(150) NOT NULL,
	CONSTRAINT `PK_authors` PRIMARY KEY (`id` ASC)
);

CREATE TABLE `books`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`b_name` VARCHAR(150) NOT NULL,
	`b_year` SMALLINT UNSIGNED NOT NULL,
	`b_quantity` SMALLINT UNSIGNED NOT NULL,
	CONSTRAINT `PK_books` PRIMARY KEY (`id` ASC)
);

CREATE TABLE `genres`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`g_name` VARCHAR(150) NOT NULL,
	CONSTRAINT `PK_genres` PRIMARY KEY (`id` ASC)
);

CREATE TABLE `m2m_books_authors`
(
	`b_id` BIGINT UNSIGNED NOT NULL,
	`a_id` BIGINT UNSIGNED NOT NULL,
	CONSTRAINT `PK_m2m_books_authors` PRIMARY KEY (`b_id` ASC, `a_id` ASC)
);

CREATE TABLE `m2m_books_genres`
(
	`b_id` BIGINT UNSIGNED NOT NULL,
	`g_id` BIGINT UNSIGNED NOT NULL,
	CONSTRAINT `PK_m2m_books_genres` PRIMARY KEY (`b_id` ASC, `g_id` ASC)
);

CREATE TABLE `subscribers`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`s_name` VARCHAR(150) NOT NULL,
	CONSTRAINT `PK_subscribers` PRIMARY KEY (`id` ASC)
);

CREATE TABLE `subscriptions`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`sb_subscriber` BIGINT UNSIGNED NOT NULL,
	`sb_book` BIGINT UNSIGNED NOT NULL,
	`sb_start` DATE NOT NULL,
	`sb_finish` DATE NOT NULL,
	`sb_is_active` ENUM ('Y', 'N') NOT NULL,
	CONSTRAINT `PK_subscriptions` PRIMARY KEY (`id` ASC)
);

/* Create Primary Keys, Indexes, Uniques, Checks */
ALTER TABLE `genres` 
 ADD CONSTRAINT `UQ_genres_g_name` UNIQUE (`g_name` ASC);

/* Create Foreign Key Constraints */
ALTER TABLE `m2m_books_authors` 
 ADD CONSTRAINT `FK_m2m_books_authors_authors`
	FOREIGN KEY (`a_id`) REFERENCES `authors` (`id`) ON DELETE Cascade ON UPDATE Cascade;

ALTER TABLE `m2m_books_authors` 
 ADD CONSTRAINT `FK_m2m_books_authors_books`
	FOREIGN KEY (`b_id`) REFERENCES `books` (`id`) ON DELETE Cascade ON UPDATE Cascade;

ALTER TABLE `m2m_books_genres` 
 ADD CONSTRAINT `FK_m2m_books_genres_books`
	FOREIGN KEY (`b_id`) REFERENCES `books` (`id`) ON DELETE Restrict ON UPDATE Restrict;

ALTER TABLE `m2m_books_genres` 
 ADD CONSTRAINT `FK_m2m_books_genres_genres`
	FOREIGN KEY (`g_id`) REFERENCES `genres` (`id`) ON DELETE Restrict ON UPDATE Restrict;

ALTER TABLE `subscriptions` 
 ADD CONSTRAINT `FK_subscriptions_books`
	FOREIGN KEY (`sb_book`) REFERENCES `books` (`id`) ON DELETE Cascade ON UPDATE Cascade;

ALTER TABLE `subscriptions` 
 ADD CONSTRAINT `FK_subscriptions_subscribers`
	FOREIGN KEY (`sb_subscriber`) REFERENCES `subscribers` (`id`) ON DELETE Cascade ON UPDATE Cascade;

SET FOREIGN_KEY_CHECKS=1; 
