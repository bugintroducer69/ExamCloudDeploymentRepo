package com.example.tek2examdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class HelloController {
    List<Book> books = List.of(
            new Book("The Midnight Dispatch", "A gothic tale of inheritance, hidden passageways, and a family's dark secret.", "Evelyn Hartley", 1817),
            new Book("Notes on Rural Industry", "An observational account of agricultural practices and cottage trades in northern England.", "Samuel R. Pembroke", 1832),
            new Book("Sketches of London Life", "A set of short social sketches exposing class contrasts and city hardships.", "Clara Beaumont", 1845),
            new Book("The Hartmoor Letters", "Epistolary novel following two cousins as they navigate love, duty, and social expectation.", "Margaret Liddon", 1799),
            new Book("Principles of Natural Philosophy", "An accessible introduction to mechanics and natural philosophy for educated readers.", "Thomas A. Winslow", 1789),
            new Book("A Voyage to the Southern Isles", "Narrative of a merchant captain's travels, encounters with islanders, and maritime hazards.", "Robert K. Ellery", 1828),
            new Book("The Engineer's Handbook", "Practical manual on bridge-building, steam engines, and early industrial techniques.", "Henry J. Cartwright", 1856),
            new Book("Tales from the Highlands", "Collected folktales and ballads adapted from oral tradition, with notes on local customs.", "Isobel MacArthur", 1804),
            new Book("The City Surgeon", "Medical cases and moral dilemmas faced by a London surgeon treating the urban poor.", "Jonathan Price", 1862),
            new Book("The Reformer's Manifesto", "An impassioned pamphlet advocating parliamentary reform and expanded suffrage.", "Edward M. Clarke", 1831),
            new Book("Autumn at Westwyck", "A domestic novel about family reconciliation, estate decline, and moral renewal.", "E. Winthrop Hale", 1874),
            new Book("Lectures on Comparative Languages", "A scholarly survey comparing Indo-European languages and etymological roots.", "Charlotte V. Emerson", 1883)
    );

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        Optional<Book> book = books.stream().filter(item -> item.title().equals(title)).findFirst();
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
