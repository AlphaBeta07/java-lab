import java.util.*;

class Book {
    private final String id, name, author;
    private int qty;
    public Book(String id, String name, String author, int qty) {
        this.id = id; this.name = name; this.author = author; this.qty = qty;
    }
    public String toString() { return id + " | " + name + " | " + author + " | qty=" + qty; }
    public String getId() { return id; }
}

public class CollectionGenericsDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("B001", "Java Basics", "A. Author", 5));
        books.add(new Book("B002", "DSA", "B. Writer", 3));
        books.add(new Book("B003", "DBMS", "C. Author", 2));

        System.out.println("All books:");
        for (Book b : books) System.out.println(b);

        System.out.println("\nSize: " + books.size());

        System.out.println("\nRemoving B002...");
        books.removeIf(b -> b.getId().equals("B002"));

        System.out.println("\nContents after removing:");
        books.forEach(System.out::println);

        System.out.println("\nUsing iterator:");
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
