import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>();
        int choice;
        do {
            System.out.println("-----Library Management-----");
            System.out.println("1. Add books to the library");
            System.out.println("2. Borrow books");
            System.out.println("3. Show book information.");
            System.out.println("4. Exit program");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add information book");
                    addBook(bookList);
                    break;
                case 2:
                    getInformation(bookList);
                    System.out.println("Enter the name of book you want to borrow: ");
                    rent(bookList);
                    break;
                case 3:
                    System.out.println("print information book: ");
                    getInformation(bookList);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    public static void addBook(List<Book> bookList) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book ID: ");
        String id = sc.nextLine();

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter book author: ");
        String author = sc.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Book book = new Book(id, title, author, quantity);
        bookList.add(book);
        System.out.println("Add successfully!");
    }

    public static void getInformation(List<Book> Library) {
        for (Book num : Library) {
            System.out.println(num);
        }

    }

    public static void rent(List<Book> bookList) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean isBookFound = false;
        for (Book num : bookList){
            if (num.getTitle().equals(name) ){
                isBookFound = true;

                if(num.getQuantity() > 0){
                    num.setQuantity(num.getQuantity() - 1);
                    System.out.println("Borrow successfully: "+num.getTitle());
                }else {
                    System.out.println("The book is out of stock.");
                }
                break;
            }
        }
        if (!isBookFound){
            System.out.println("Book not found.");
        }
    }
}

