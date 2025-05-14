package lessons_31;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books); // защита от внешней модификации
    }

    public int getBookCount() {
        return books.size();
    }
}
