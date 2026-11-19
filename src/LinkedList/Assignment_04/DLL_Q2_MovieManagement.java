package LinkedList.Assignment_04;

public class DLL_Q2_MovieManagement {

    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie next, prev;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return title + " | Director: " + director + " | Year: " + year + " | Rating: " + rating;
        }
    }

    static class MovieList {
        private Movie head, tail;
        private int size = 0;

        void addAtBeginning(Movie m) {
            if (head == null) {
                head = tail = m;
            } else {
                m.next = head;
                head.prev = m;
                head = m;
            }
            size++;
        }

        void addAtEnd(Movie m) {
            if (tail == null) {
                head = tail = m;
            } else {
                tail.next = m;
                m.prev = tail;
                tail = m;
            }
            size++;
        }

        void addAtPosition(int pos, Movie m) {
            if (pos <= 1) {
                addAtBeginning(m);
            } else if (pos == size + 1) {
                addAtEnd(m);
            } else if (pos > size + 1) {
                System.out.println("Invalid position " + pos);
            } else {
                Movie temp = head;
                for (int i = 1; i < pos - 1; i++) temp = temp.next;
                m.next = temp.next;
                m.prev = temp;
                temp.next.prev = m;
                temp.next = m;
                size++;
            }
        }

        boolean removeByTitle(String title) {
            Movie n = head;
            while (n != null && !n.title.equalsIgnoreCase(title)) n = n.next;
            if (n == null) return false;

            if (n.prev != null) n.prev.next = n.next;
            else head = n.next;

            if (n.next != null) n.next.prev = n.prev;
            else tail = n.prev;

            size--;
            return true;
        }

        void searchByDirector(String director) {
            boolean found = false;
            for (Movie n = head; n != null; n = n.next) {
                if (n.director.equalsIgnoreCase(director)) {
                    System.out.println(n);
                    found = true;
                }
            }
            if (!found) System.out.println("No movie found for director: " + director);
        }

        void searchByRating(double rating) {
            boolean found = false;
            for (Movie n = head; n != null; n = n.next) {
                if (n.rating == rating) {
                    System.out.println(n);
                    found = true;
                }
            }
            if (!found) System.out.println("No movie found with rating: " + rating);
        }

        void displayForward() {
            if (head == null) {
                System.out.println("No movies.");
                return;
            }
            for (Movie n = head; n != null; n = n.next) System.out.println(n);
        }

        void displayReverse() {
            if (tail == null) {
                System.out.println("No movies.");
                return;
            }
            for (Movie n = tail; n != null; n = n.prev) System.out.println(n);
        }

        boolean updateRating(String title, double newRating) {
            for (Movie n = head; n != null; n = n.next) {
                if (n.title.equalsIgnoreCase(title)) {
                    n.rating = newRating;
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addAtEnd(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        list.addAtBeginning(new Movie("3 Idiots", "Rajkumar Hirani", 2009, 8.4));
        list.addAtEnd(new Movie("Interstellar", "Christopher Nolan", 2014, 8.7));
        list.addAtPosition(2, new Movie("PK", "Rajkumar Hirani", 2014, 8.1));

        System.out.println("--- Forward ---");
        list.displayForward();

        System.out.println("\n--- Reverse ---");
        list.displayReverse();

        System.out.println("\n--- Search by director: Christopher Nolan ---");
        list.searchByDirector("Christopher Nolan");

        System.out.println("\n--- Search by rating: 8.1 ---");
        list.searchByRating(8.1);

        System.out.println("\n--- Update rating of PK to 8.5 ---");
        System.out.println(list.updateRating("PK", 8.5) ? "Updated" : "Movie not found");
        list.displayForward();

        System.out.println("\n--- Remove Inception ---");
        System.out.println(list.removeByTitle("Inception") ? "Removed" : "Movie not found");
        list.displayForward();
    }
}
