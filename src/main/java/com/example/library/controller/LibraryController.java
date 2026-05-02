package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.LibraryService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // READ Operation
    @GetMapping("/")
    public String listBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooksWithAuthors());
        return "list";
    }

    // CREATE Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "add-book";
    }

    // CREATE Submission + Exception Handling
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Model model) {
        try {
            libraryService.saveBook(book);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Database error: Please ensure all fields are valid.");
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "add-book";
        }
    }

    // UPDATE Form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", libraryService.getBookById(id));
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "update-book";
    }

    // UPDATE Submission
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book) {
        Book existingBook = libraryService.getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        libraryService.saveBook(existingBook);
        return "redirect:/";
    }
}
