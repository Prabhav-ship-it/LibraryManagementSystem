package com.example.library.config;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public DataInitializer(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 10; i++) {
            Author author = new Author("Author Name " + i);
            authorRepo.save(author);
            Book book = new Book("Sample Book Title " + i, author);
            bookRepo.save(book);
        }
    }
}
