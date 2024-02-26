package com.mysterious.stupefy.service;

import com.mysterious.stupefy.model.Book;
import com.mysterious.stupefy.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book addBook(Book book) {
        repository.save(book);
        return repository.findByName(book.getName()).orElse(null);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(repository.findAll());
    }

    public Book updateBook(Book book) {
        repository.save(book);
        return repository.findByName(book.getName()).orElse(null);
    }

    public Book deleteBook(@NotNull UUID id){
        Book deletedBook = repository.findById(id.toString()).orElse(null);
        repository.deleteById(id.toString());
        return deletedBook;
    }
}
