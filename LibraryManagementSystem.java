import java.util.ArrayList;
import java.util.Scanner;

class Book {

    int bookId;
    String bookName;
    String authorName;
    boolean isIssued;

    // Constructor
    Book(int bookId, String bookName, String authorName) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isIssued = false;
    }

    // Display Book Details
    void displayBook() {

        System.out.println("==================================");
        System.out.println("Book ID      : " + bookId);
        System.out.println("Book Name    : " + bookName);
        System.out.println("Author Name  : " + authorName);
        System.out.println("Book Status  : " + (isIssued ? "Issued" : "Available"));
        System.out.println("==================================");
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> library = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Add Book
    static void addBook() {

        System.out.print("Enter Book ID: ");

        int id = sc.nextInt();

        sc.nextLine();

        // Duplicate ID Check
        for (Book b : library) {

            if (b.bookId == id) {

                System.out.println("\nBook ID Already Exists!");

                return;
            }
        }

        System.out.print("Enter Book Name: ");

        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");

        String author = sc.nextLine();

        library.add(new Book(id, name, author));

        System.out.println("\n==================================");
        System.out.println("Book Added Successfully!");
        System.out.println("==================================");
    }

    // View Books
    static void viewBooks() {

        if (library.isEmpty()) {

            System.out.println("\nNo Books Available!");

        } else {

            System.out.println("\n========== BOOK LIST ==========");

            for (Book b : library) {

                b.displayBook();
            }
        }
    }

    // Search Book
    static void searchBook() {

        System.out.print("Enter Book ID to Search: ");

        int id = sc.nextInt();

        for (Book b : library) {

            if (b.bookId == id) {

                System.out.println("\nBook Found!");

                b.displayBook();

                return;
            }
        }

        System.out.println("\nBook Not Found!");
    }

    // Issue Book
    static void issueBook() {

        System.out.print("Enter Book ID to Issue: ");

        int id = sc.nextInt();

        for (Book b : library) {

            if (b.bookId == id) {

                if (!b.isIssued) {

                    b.isIssued = true;

                    System.out.println("\n==================================");
                    System.out.println("Book Issued Successfully!");
                    System.out.println("==================================");

                } else {

                    System.out.println("\nBook Already Issued!");
                }

                return;
            }
        }

        System.out.println("\nBook Not Found!");
    }

    // Return Book
    static void returnBook() {

        System.out.print("Enter Book ID to Return: ");

        int id = sc.nextInt();

        for (Book b : library) {

            if (b.bookId == id) {

                if (b.isIssued) {

                    b.isIssued = false;

                    System.out.println("\n==================================");
                    System.out.println("Book Returned Successfully!");
                    System.out.println("==================================");

                } else {

                    System.out.println("\nBook Was Not Issued!");
                }

                return;
            }
        }

        System.out.println("\nBook Not Found!");
    }

    // Remove Book
    static void removeBook() {

        System.out.print("Enter Book ID to Remove: ");

        int id = sc.nextInt();

        for (Book b : library) {

            if (b.bookId == id) {

                library.remove(b);

                System.out.println("\n==================================");
                System.out.println("Book Removed Successfully!");
                System.out.println("==================================");

                return;
            }
        }

        System.out.println("\nBook Not Found!");
    }

    // Total Books Count
    static void totalBooks() {

        System.out.println("\nTotal Books Available : " + library.size());
    }

    public static void main(String[] args) {

        int choice;

        System.out.println("=================================================");
        System.out.println("         LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=================================================");

        do {

            System.out.println("\n============== MENU ==============");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Total Books Count");
            System.out.println("8. Exit");
            System.out.println("==================================");

            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    addBook();

                    break;

                case 2:

                    viewBooks();

                    break;

                case 3:

                    searchBook();

                    break;

                case 4:

                    issueBook();

                    break;

                case 5:

                    returnBook();

                    break;

                case 6:

                    removeBook();

                    break;

                case 7:

                    totalBooks();

                    break;

                case 8:

                    System.out.println("\n==================================");
                    System.out.println("Thank You For Using Library System");
                    System.out.println("==================================");

                    break;

                default:

                    System.out.println("\nInvalid Choice! Please Try Again.");
            }

        } while (choice != 8);

        sc.close();
    }
}