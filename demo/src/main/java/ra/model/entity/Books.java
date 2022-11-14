package ra.model.entity;

public class Books {
    private String bookId;
    private String bookName;
    private float price;
    private String author;
    private Boolean bookStatus;

    public Books() {

    };

    public Books(String bookId, String bookName, float price, String author,Boolean bookStatus){
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookStatus = bookStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}


