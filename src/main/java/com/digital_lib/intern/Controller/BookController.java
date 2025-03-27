package com.digital_lib.intern.Controller;

import com.digital_lib.intern.Entity.Book;
import com.digital_lib.intern.Repository.BookRepository;
import com.digital_lib.intern.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*") // Allows frontend apps to access API
public class BookController {

    private final BookRepository bookRepository;

    // Constructor Injection (Preferred)
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    // Optional<Book> book = bookService.getBookById(id);
    // return book.map(ResponseEntity::ok).orElseGet(() ->
    // ResponseEntity.notFound().build());
    // }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    if (updatedBook.getTitle() != null && !updatedBook.getTitle().isEmpty()) {
                        book.setTitle(updatedBook.getTitle());
                    }
                    if (updatedBook.getAuthor() != null && !updatedBook.getAuthor().isEmpty()) {
                        book.setAuthor(updatedBook.getAuthor());
                    }
                    book.setAvailable(updatedBook.isAvailable());
                    return ResponseEntity.ok(bookRepository.save(book));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
