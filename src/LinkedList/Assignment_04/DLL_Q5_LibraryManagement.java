package LinkedList.Assignment_04;

public class DLL_Q5_LibraryManagement {

    static class Book {
        String title;
        String author;
        String genre;
        int bookId;
        boolean available;
        Book next, prev;

        Book(String title, String author, String genre, int bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
        }

        @Override
        public String toString() {
            return "ID: " + bookId + " | " + title + " | Author: " + author
                    + " | Genre: " + genre + " | " + (available ? "Available" : "Issued");
        }
    }

    static class Library {
        private Book head, tail;
        private int count = 0;

        void addAtBeginning(Book b) {
            if (head == null) {
                head = tail = b;
            } else {
                b.next = head;
                head.prev = b;
                head = b;
            }
            count++;
        }


        void addAtEnd(Book b) {
            if (tail == null) {
                head = tail = b;
            } else {
                tail.next = b;
                b.prev = tail;
                tail = b;
            }
            count++;
        }


        void addAtPosition(int pos, Book b) {
            if (pos <= 1) {
                addAtBeginning(b);
            } else if (pos == count + 1) {
                addAtEnd(b);
            } else if (pos > count + 1) {
                System.out.println("Invalid position " + pos);
            } else {
                Book temp = head;
                for (int i = 1; i < pos - 1; i++) temp = temp.next;
                b.next = temp.next;
                b.prev = temp;
                temp.next.prev = b;
                temp.next = b;
                count++;
            }
        }


        boolean removeById(int id) {
            Book n = head;
            while (n != null && n.bookId != id) n = n.next;
            if (n == null) return false;

            if (n.prev != null) n.prev.next = n.next;
            else head = n.next;

            if (n.next != null) n.next.prev = n.prev;
            else tail = n.prev;

            count--;
            return true;
        }


        void searchByTitle(String title) {
            boolean found = false;
            for (Book n = head; n != null; n = n.next) {
                if (n.title.equalsIgnoreCase(title)) {
                    System.out.println(n);
                    found = true;
                }
            }
            if (!found) System.out.println("No book found with title: " + title);
        }


        void searchByAuthor(String author) {
            boolean found = false;
            for (Book n = head; n != null; n = n.next) {
                if (n.author.equalsIgnoreCase(author)) {
                    System.out.println(n);
                    found = true;
                }
            }
            if (!found) System.out.println("No book found by author: " + author);
        }


        boolean updateAvailability(int id, boolean status) {
            for (Book n = head; n != null; n = n.next) {
                if (n.bookId == id) {
                    n.available = status;
                    return true;
                }
            }
            return false;
        }

        void displayForward() {
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }
            for (Book n = head; n != null; n = n.next) System.out.println(n);
        }

        void displayReverse() {
            if (tail == null) {
                System.out.println("Library is empty.");
                return;
            }
            for (Book n = tail; n != null; n = n.prev) System.out.println(n);
        }

        int countBooks() {
            return count;
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();

        lib.addAtEnd(new Book("Clean Code", "Robert Martin", "Programming", 1, true));
        lib.addAtEnd(new Book("Wings of Fire", "A.P.J. Abdul Kalam", "Autobiography", 2, true));
        lib.addAtBeginning(new Book("Java: The Complete Reference", "Herbert Schildt", "Programming", 3, true));
        lib.addAtPosition(2, new Book("The Alchemist", "Paulo Coelho", "Fiction", 4, true));

        System.out.println("--- Forward ---");
        lib.displayForward();

        System.out.println("\n--- Reverse ---");
        lib.displayReverse();

        System.out.println("\n--- Search by title: Clean Code ---");
        lib.searchByTitle("Clean Code");

        System.out.println("\n--- Search by author: Paulo Coelho ---");
        lib.searchByAuthor("Paulo Coelho");

        System.out.println("\n--- Issue book ID 2 (set unavailable) ---");
        System.out.println(lib.updateAvailability(2, false) ? "Status updated" : "Book not found");
        lib.displayForward();

        System.out.println("\n--- Remove book ID 4 ---");
        System.out.println(lib.removeById(4) ? "Removed" : "Book not found");
        lib.displayForward();

        System.out.println("\nTotal books: " + lib.countBooks());
    }
}
