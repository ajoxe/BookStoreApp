package nyc.c4q.bookstoreapp.model;

/**
 * Created by amirahoxendine on 12/13/17.
 */

public class Book {
    String id;
    String name;
    String author;
    String price;
    String inStock;

    public Book(String id, String name, String author, String price, String inStock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }
}
