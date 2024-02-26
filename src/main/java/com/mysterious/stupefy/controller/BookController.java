package com.mysterious.stupefy.controller;

import com.mysterious.stupefy.model.Book;
import com.mysterious.stupefy.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String check(){
        return "Books Endpoint working fine";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> booksList = bookService.getAllBooks();
        return ResponseEntity.ok(booksList);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook.toString());
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") UUID id,@NotNull @Valid @RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook.toString());
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") UUID id){
        Book deletedBook = bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedBook.toString());
    }
}
