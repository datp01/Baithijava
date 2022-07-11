import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bookk {
    public static Connection getConnection() throws SQLException{
        String dbURL = "jdbc:mysql://localhost:3306/book";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(dbURL,username,password);
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        if (getConnection()!=null){
            System.out.println("Ket noi thanh cong");
        }
    }
    public static void addBook(BookPR book) throws SQLException{
        Connection connection = getConnection();
        String query = "insert into 4 values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,book.getBookid());
        preparedStatement.setString(2,book.getBookname());
        preparedStatement.setString(3,book.getAuthor());
        preparedStatement.setDouble(4,book.getPrice());
        preparedStatement.executeUpdate();
    }
    List<BookPR> list = new ArrayList<>();
    public void SavetoFile() throws SQLException, IOException {
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get("BookAll"));
        gson.toJson(this.list,writer);
        writer.close();
    }

    public static void menu() {
    }
    public void display() throws SQLException {
        String query = "SELECT * from book";
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String id = resultSet.getString("bookid");
            String name = resultSet.getString("bookname");
            String author = resultSet.getString("author");
            Double price = resultSet.getDouble("price");
            System.out.println(id+" "+name+" "+author+" "+price);
        }
    }
}
