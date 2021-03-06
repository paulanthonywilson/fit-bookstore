package bookshop;

import static bookshop.Pounds.inPounds;

public class Book {
    private String title = "";
    private String author = "";
    private String description = "";
    private Pounds price = inPounds(0);
    private int id;

    public Book(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public Book withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book withAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book withDescription(String description) {
        this.description = description;
        return this;
    }


    public String toString() {
        return "Book: '" + title +"' by '"+ author + "'";
    }

    public String getDescription() {
        return description;
    }

    public Book atPrice(Pounds price) {
        this.price = price;
        return this;
    }

    public Pounds getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return ("/book-images/" + title + ".jpg").toLowerCase().replace(' ', '_').replace("'", "");
    }
}

