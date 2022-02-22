INSERT INTO `books` (`id`, `b_name`, `b_year`, `b_quantity`)
VALUES
(1, 'Eugene Onegin', 1985, 2),
(2, 'The Tale of the Fisherman and the Fish', 1990, 3),
(3, 'Founding and empire', 2000, 5),
(4, 'Psychology of programming', 1998, 1),
(5, 'C++ programming language', 1996, 3),
(6, 'Theoretical Physics Course', 1981, 12),
(7, 'The Art of Programming', 1993, 7);

INSERT INTO `authors` (`id`, `a_name`)
VALUES
(1, 'D. Knut'),
(2, 'A. Azimov'),
(3, 'D. Carnegie'),
(4, 'L.D. Landau'),
(5, 'E.M. Lifshitz'),
(6, 'B. Stroustrup'),
(7, 'А.С. Пушкин');


INSERT INTO `genres` (`id`, `g_name`)
VALUES
(1, 'Poetry'),
(2, 'Programming'),
(3, 'Psychology'),
(4, 'The science'),
(5, 'Classic'),
(6, 'Fiction');


INSERT INTO `subscribers` (`id`, `s_name`)
VALUES
(1, 'Ivanov I.I.'),
(2, 'Petrov P.P.'),
(3, 'Sidorov S.S.'),
(4, 'Sidorov S.S.');

INSERT INTO `m2m_books_authors`
(`b_id`, `a_id`)
VALUES
(1, 7),
(2, 7),
(3, 2),
(4, 3),
(4, 6),
(5, 6),
(6, 5),
(6, 4),
(7, 1);


INSERT INTO `m2m_books_genres` (`b_id`, `g_id`)
VALUES
(1, 1),
(1, 5),
(2, 1),
(2, 5),
(3, 6),
(4, 2),
(4, 3),
(5, 2),
(6, 5),
(7, 2),
(7, 5);


INSERT INTO `subscriptions` (`id`, `sb_subscriber`, `sb_book`, `sb_start`, `sb_finish`, `sb_is_active`)
VALUES
(100, 1, 3, '2011-01-12', '2011-02-12', 'N'),
(2, 1, 1, '2011-01-12', '2011-02-12', 'N'),
(3, 3, 3, '2012-05-17', '2012-07-17', 'Y'),
(42, 1, 2, '2012-06-11', '2012-08-11', 'N'),
(57, 4, 5, '2012-06-11', '2012-08-11', 'N'),
(61, 1, 7, '2014-08-03', '2014-10-03', 'N'),
(62, 3, 5, '2014-08-03', '2014-10-03', 'Y'),
(86, 3, 1, '2014-08-03', '2014-09-03', 'Y'),
(91, 4, 1, '2015-10-07', '2015-03-07', 'Y'),
(95, 1, 4, '2015-10-07', '2015-11-07', 'N'),
(99, 4, 4, '2015-10-08', '2025-11-08', 'Y');