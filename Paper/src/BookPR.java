public class BookPR {
    private String bookid;
    private String bookname;
    private String author;
    private Double price;

    public BookPR(String bookid, String bookname, String author, Double price) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public String getBookid(){
        return bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }
}
