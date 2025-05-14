package lessons_31;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("1984", "George Orwell");
    }

    @Test
    public void testAddBook() {
        library.addBook(book);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book);
        boolean removed = library.removeBook(book);
        assertTrue(removed);
        assertEquals(0, library.getBookCount());
    }
}


