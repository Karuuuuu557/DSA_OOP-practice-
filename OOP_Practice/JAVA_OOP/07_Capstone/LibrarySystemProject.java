import java.util.ArrayList;
import java.util.List;

/*
 * TOPIC: Capstone mini-project (inheritance + polymorphism + abstraction + patterns)
 * Scenario: A simple library that manages items and borrowing notifications.
 */
public class LibrarySystemProject {
    interface Notifier { void notifyUser(String message); }
    static class ConsoleNotifier implements Notifier {
        @Override public void notifyUser(String message) { System.out.println("[Notify] " + message); }
    }

    static abstract class LibraryItem {
        String title;
        boolean borrowed;
        LibraryItem(String title) { this.title = title; }
        abstract String type();
        void borrow() { borrowed = true; }
        void giveBack() { borrowed = false; }
    }
    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        @Override String type() { return "Book"; }
    }
    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        @Override String type() { return "Magazine"; }
    }

    static class LibraryService {
        private final List<LibraryItem> items = new ArrayList<>();
        private final Notifier notifier;
        LibraryService(Notifier notifier) { this.notifier = notifier; }
        void addItem(LibraryItem item) { items.add(item); }
        void borrow(String title) {
            for (LibraryItem it : items) {
                if (it.title.equalsIgnoreCase(title) && !it.borrowed) {
                    it.borrow();
                    notifier.notifyUser("Borrowed " + it.type() + ": " + it.title);
                    return;
                }
            }
            notifier.notifyUser("Item unavailable: " + title);
        }
        void list() {
            for (LibraryItem it : items) System.out.println(it.type() + " | " + it.title + " | borrowed=" + it.borrowed);
        }
    }

    public static void main(String[] args) {
        LibraryService lib = new LibraryService(new ConsoleNotifier()); // DIP: service depends on Notifier abstraction.
        lib.addItem(new Book("Clean Code")); // Beginner: add concrete item object to collection.
        lib.addItem(new Magazine("Java Monthly")); // Add another subtype to show polymorphic handling.
        lib.list(); // Show current inventory state before borrow action.

        lib.borrow("Clean Code");
        lib.borrow("Clean Code");
        lib.list();

        System.out.println("Pro: capstone combines abstraction, polymorphism, SRP, and simple strategy-like notifier swap.");
    }
}

/*
 * Pitfalls: mixing UI with domain logic, no validation around duplicate titles, mutable global state.
 * Practice:
 * Easy: add return(title).
 * Medium: add Member class with borrow limit.
 * Hard: persist items to file and reload on startup.
 */
