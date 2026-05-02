package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooksWithAuthors() {
        Author a1 = new Author("Test Author");
        Book b1 = new Book("Test Book", a1);
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(Arrays.asList(b1));

        List<Book> books = libraryService.getAllBooksWithAuthors();
        
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
        verify(bookRepository, times(1)).findAllBooksWithAuthors();
    }

    @Test
    void testSaveBook() {
        Author a1 = new Author("Test Author");
        Book b1 = new Book("Test Book", a1);
        when(bookRepository.save(b1)).thenReturn(b1);

        Book savedBook = libraryService.saveBook(b1);
        
        assertEquals("Test Book", savedBook.getTitle());
        verify(bookRepository, times(1)).save(b1);
    }
}
