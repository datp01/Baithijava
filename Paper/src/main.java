import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException, IOException {
        Bookk book = new Bookk();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Bookk.menu();
            int chosse = scanner.nextInt();

            switch (chosse) {
                case 1 -> {
                    System.out.println("Enter BookId: ");
                    String bookid = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter BookTitle: ");
                    String bookname = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter Price: ");
                    Double price = scanner.nextDouble();
                    BookPR bookPR = new BookPR(bookid, bookname, author, price);
                    book.addBook(bookPR);
                }
                case 2 -> book.SavetoFile();
                case 3 -> book.display();
                case 4 -> System.exit(0);
            }
        }
    }
}

