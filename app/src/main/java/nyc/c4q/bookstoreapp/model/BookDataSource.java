package nyc.c4q.bookstoreapp.model;

import java.util.ArrayList;

/**
 * Created by amirahoxendine on 12/13/17.
 */

//TODO load json into book data source

public class BookDataSource extends ArrayList<Book>{
    public Book addBook(String title, String author, String price, String isbn, String inStock) {

        final Book b = new Book(isbn, title, author,price, inStock);
        add(b);
        return b;
    }





}
