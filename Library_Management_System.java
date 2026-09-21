package String;
import java.util.Scanner;
class Book {
    int bookId;
    String title;
    String author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class Library_Management_System {

    public static int removeDuplicates(Book[] books, int n) {
        if (n == 0) {
            return 0;
        }

        int uniqueCount = 1;

        for (int i = 1; i < n; i++) {
            if (books[i].bookId != books[uniqueCount - 1].bookId) {
                books[uniqueCount] = books[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static void searchByTitle(Book[] books, int count, String query) {
        String searchQuery = query.toLowerCase();
        boolean found = false;

        System.out.println("\nSearch Results for '" + query + "':");

        for (int i = 0; i < count; i++) {
            if (books[i].title.toLowerCase().contains(searchQuery)) {
                System.out.println("- Found: [" + books[i].bookId + "] "
                        + books[i].title + " (Rs. " + books[i].price + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }

    public static void sortByPrice(Book[] books, int count) {
        int swaps = 0;

        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minIndex].price) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Book temp = books[i];
                books[i] = books[minIndex];
                books[minIndex] = temp;
                swaps++;
            }
        }

        System.out.println("\nBooks Sorted by Price:");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". [" + books[i].bookId + "] "
                    + books[i].title + " - Rs. " + books[i].price);
        }

        System.out.println("Total Swaps: " + swaps);
    }

    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Double.compare(books[mid].price, targetPrice) == 0) {
                return mid;
            }

            if (books[mid].price < targetPrice) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        double currentSum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < count; right++) {
            currentSum += books[right].price;

            while (currentSum >= targetCost) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= books[left].price;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void printBooks(Book[] books, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("[" + books[i].bookId + "] "
                    + books[i].title + " - Rs. " + books[i].price);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = {
                new Book(101, "Data Structures", "Mark", 400.0),
                new Book(101, "Data Structures", "Mark", 400.0),
                new Book(102, "Java Basics", "James", 300.0),
                new Book(103, "Python Guide", "Guido", 600.0),
                new Book(104, "Database Systems", "Raghu", 500.0),
                new Book(105, "Computer Networks", "Andrew", 700.0)
        };

        int count = books.length;

        System.out.println("LIBRARY MANAGEMENT SYSTEM");

        count = removeDuplicates(books, count);

        System.out.println("\nUnique Books Count: " + count);
        printBooks(books, count);

        searchByTitle(books, count, "data");

        sortByPrice(books, count);

        double targetPrice = 500.0;
        int priceIndex = searchByPrice(books, count, targetPrice);

        System.out.println("\nSearching for Price Rs. " + targetPrice + "...");

        if (priceIndex != -1) {
            System.out.println("Result: Book found at index " + priceIndex + ": ["
                    + books[priceIndex].bookId + "] "
                    + books[priceIndex].title + " (Rs. "
                    + books[priceIndex].price + ")");
        } else {
            System.out.println("Result: Book not found.");
        }

        double targetCost = 1000.0;
        int minimumBooks = minBooksForTargetCost(books, count, targetCost);

        System.out.println("\nFinding minimum consecutive books whose total price >= Rs. "
                + targetCost + "...");
        System.out.println("Minimum Consecutive Books Needed: " + minimumBooks);

        scanner.close();
    }
}