package nyc.c4q.bookstoreapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.bookstoreapp.controller.BookAdapter;
import nyc.c4q.bookstoreapp.model.Book;
import nyc.c4q.bookstoreapp.model.BookDataSource;

public class MainActivity extends AppCompatActivity {
    BookDataSource bookDataSource;
    List<Book> bookList=new ArrayList<>();
    BookAdapter bookAdapter;
    String url = "https://raw.githubusercontent.com/tamingtext/book/master/apache-solr/example/exampledocs/books.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookDataSource = new BookDataSource();
        RecyclerView bookRecyclerView = (RecyclerView) findViewById(R.id.book_recyclerview);
        bookAdapter = new BookAdapter(bookList);
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        bookRecyclerView.setAdapter(bookAdapter);
        makeRequestWithOkHttp(url);
        bookRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void makeRequestWithOkHttp(String url) {
        OkHttpClient client = new OkHttpClient();   // 1
        Request request = new Request.Builder().url(url).build();  // 2

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) { // 3

                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String result = response.body().string();  // 4

                Log.d("result", result);

                bookDataSource = bookDataSource.setBookData(result);
                bookList.addAll(bookDataSource);

                Log.d("main", String.valueOf(bookDataSource.size()));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // perform some ui work with `result`  // 5
                            bookAdapter.notifyDataSetChanged();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
