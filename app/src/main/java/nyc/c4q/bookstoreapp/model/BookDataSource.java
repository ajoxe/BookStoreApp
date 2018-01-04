package nyc.c4q.bookstoreapp.model;

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

import nyc.c4q.bookstoreapp.R;

/**
 * Created by amirahoxendine on 12/13/17.
 */

//TODO load json into book data source

public class BookDataSource extends ArrayList<Book>{
    private BookDataSource bookDataSource;


    public void setBookData(String string){
        Type collectiontype = new TypeToken<Collection<Book>>() {
        }.getType();
        Gson gs = new Gson();
        Collection<Book> books = null;
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(is);
        books = gs.fromJson(isr, collectiontype);
        //bookDataSource = new BookDataSource();
        addAll(books);
        // return bookDataSource;
    }




}
