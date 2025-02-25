package com.tavant.spring.core.SpringOnlineBookStore;

import com.tavant.spring.core.SpringOnlineBookStore.entity.Book;
import com.tavant.spring.core.SpringOnlineBookStore.entity.Cart;
import com.tavant.spring.core.SpringOnlineBookStore.entity.Order;
import com.tavant.spring.core.SpringOnlineBookStore.entity.User;
import com.tavant.spring.core.SpringOnlineBookStore.service.BookService;
import com.tavant.spring.core.SpringOnlineBookStore.service.CartService;
import com.tavant.spring.core.SpringOnlineBookStore.service.OrderService;
import com.tavant.spring.core.SpringOnlineBookStore.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    private static BookService bookService;
    private static CartService cartService;
    private static OrderService orderService;
    private static UserService userService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        bookService = context.getBean(BookService.class);
        cartService = context.getBean(CartService.class);
        orderService = context.getBean(OrderService.class);
        userService = context.getBean(UserService.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Manage Books");
            System.out.println("2. Manage Users");
            System.out.println("3. Manage Cart");
            System.out.println("4. Manage Orders");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageBooks(scanner);
                    break;
                case 2:
                    manageUsers(scanner);
                    break;
                case 3:
                    manageCart(scanner);
                    break;
                case 4:
                    manageOrders(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageBooks(Scanner scanner) {
        while (true) {
            System.out.println("Manage Books:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. View Book");
            System.out.println("5. View All Books");
            System.out.println("6. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter book details (id, title, author, price, category):");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    String category = scanner.nextLine();
                    Book book = new Book(id, title, author, price, category);
                    bookService.updateBook(book);
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.println("Enter book id to remove:");
                    int removeId = scanner.nextInt();
                    bookService.deleteBook(removeId);
                    System.out.println("Book removed.");
                    break;
                case 3:
                    System.out.println("Enter book details to update (id, title, author, price, category):");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    String updateTitle = scanner.nextLine();
                    String updateAuthor = scanner.nextLine();
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine();
                    String updateCategory = scanner.nextLine();
                    Book updateBook = new Book(updateId, updateTitle, updateAuthor, updatePrice, updateCategory);
                    bookService.updateBook(updateBook);
                    System.out.println("Book updated.");
                    break;
                case 4:
                    System.out.println("Enter book id to view:");
                    int viewId = scanner.nextInt();
                    Book viewBook = bookService.getBookById(viewId);
                    System.out.println(viewBook);
                    break;
                case 5:
                    List<Book> books = bookService.getAllBooks();
                    books.forEach(System.out::println);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageUsers(Scanner scanner) {
        while (true) {
            System.out.println("Manage Users:");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Update User");
            System.out.println("4. View User");
            System.out.println("5. View All Users");
            System.out.println("6. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter user details (id, name, email, password):");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String email = scanner.nextLine();
                    String password = scanner.nextLine();
                    User user = new User(id, name, email, password);
                    userService.addUser(user);
                    System.out.println("User added.");
                    break;
                case 2:
                	// Rest of the manageUsers method

                    System.out.println("Enter user id to remove:");
                    int removeId = scanner.nextInt();
                    userService.deleteUser(removeId);
                    System.out.println("User removed.");
                    break;
                case 3:
                    System.out.println("Enter user details to update (id, name, email, password):");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    String updateName = scanner.nextLine();
                    String updateEmail = scanner.nextLine();
                    String updatePassword = scanner.nextLine();
                    User updateUser = new User(updateId, updateName, updateEmail, updatePassword);
                    userService.addUser(updateUser);
                    System.out.println("User updated.");
                    break;
                case 4:
                    System.out.println("Enter user id to view:");
                    int viewId = scanner.nextInt();
                    User viewUser = userService.getUserById(viewId);
                    System.out.println(viewUser);
                    break;
                case 5:
                    List<User> users = userService.getAllUsers();
                    users.forEach(System.out::println);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageCart(Scanner scanner) {
        while (true) {
            System.out.println("Manage Cart:");
            System.out.println("1. Add Book to Cart");
            System.out.println("2. Remove Book from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter user id and book details (id, title, author, price, category):");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    String category = scanner.nextLine();
                    Book book = new Book(bookId, title, author, price, category);
                    cartService.addBookToCart(userId, book);
                    System.out.println("Book added to cart.");
                    break;
                case 2:
                    System.out.println("Enter user id and book id to remove from cart:");
                    int removeUserId = scanner.nextInt();
                    int removeBookId = scanner.nextInt();
                    Book removeBook = bookService.getBookById(removeBookId);
                    cartService.removeBookFromCart(removeUserId, removeBook);
                    System.out.println("Book removed from cart.");
                    break;
                case 3:
                    System.out.println("Enter user id to view cart:");
                    int viewUserId = scanner.nextInt();
                    List<Book> cartBooks = cartService.viewCart(viewUserId);
                    cartBooks.forEach(System.out::println);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageOrders(Scanner scanner) {
        while (true) {
            System.out.println("Manage Orders:");
            System.out.println("1. Create Order");
            System.out.println("2. View Order");
            System.out.println("3. View Order History");
            System.out.println("4. Cancel Order");
            System.out.println("5. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter order details (orderId, userId, orderDate, list of book ids):");
                    int orderId = scanner.nextInt();
                    int userId = scanner.nextInt();
                    LocalDate orderDate = LocalDate.now();
                    List<Book> books = cartService.viewCart(userId);
                    Order order = new Order(orderId, userId, orderDate, books);
                    orderService.createOrder(order);
                    System.out.println("Order created.");
                    break;
                case 2:
                    System.out.println("Enter order id to view:");
                    int viewOrderId = scanner.nextInt();
                    Order viewOrder = orderService.viewOrder(viewOrderId);
                    System.out.println(viewOrder);
                    break;
                case 3:
                    System.out.println("Enter user id to view order history:");
                    int viewOrderUserId = scanner.nextInt();
                    List<Order> orders = orderService.viewOrderHistory(viewOrderUserId);
                    orders.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter order id to cancel:");
                    int cancelOrderId = scanner.nextInt();
                    orderService.cancelOrder(cancelOrderId);
                    System.out.println("Order cancelled.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
