package nyc.c4q.bookstoreapp;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import nyc.c4q.bookstoreapp.model.Book;

/**
 * Created by amirahoxendine on 1/9/18.
 */

public class Librarian {
    private List<Book> bookList;
    private List<Book> sortedBookList;
    private HashMap<String, Book> bookMap;
    String bookString;

    public Librarian (String bookString){
        buidBookList(bookString);
    }

    public void buidBookList(String bookString){
        Type collectiontype = new TypeToken<Collection<Book>>() {
        }.getType();
        Gson gs = new Gson();
        Collection<Book> books = null;
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(bookString.getBytes(StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(is);
        books = gs.fromJson(isr, collectiontype);
        bookList = new ArrayList<>();
        bookList.addAll(books);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public HashMap<String, Book> getBookMap() {
        return bookMap;
    }

    public void buildBookMap(){
        bookMap = new HashMap<>();
        for (Book b : bookList) {
            bookMap.put(b.getId(), b);
        }
    }

    public List<Book> sortBookList(List<Book> bookList){

        for (int n = bookList.size(); n > 0; n--) {
            // step 1: find largest element
            Book largest = bookList.get(0);
            int bookIndex = bookList.indexOf(largest);
            for(int i = 0; i < n; i++) {
                if (bookList.get(i).compareTo(largest) > 0) {
                    largest = bookList.get(i);
                    bookIndex = bookList.indexOf(largest);
                }
            }
            bookList.set(bookIndex, bookList.set(n-1, bookList.get(bookIndex))) ;
    }
    return bookList;

    }


}
