package org.astashonok.library.repositories;

import org.astashonok.library.entities.Book;
import org.astashonok.library.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
