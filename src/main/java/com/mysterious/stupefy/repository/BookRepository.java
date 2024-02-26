package com.mysterious.stupefy.repository;

import com.mysterious.stupefy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByName(String name);
}
