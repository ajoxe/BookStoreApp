package nyc.c4q.bookstoreapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nyc.c4q.bookstoreapp.controller.BookAdapter;
import nyc.c4q.bookstoreapp.model.Book;
import nyc.c4q.bookstoreapp.model.BookDataSource;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener bookOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView bookTitle = (TextView) view.findViewById(R.id.book_title_text_view);
            String tag = bookTitle.getTag().toString();
            Book book = bookMap.get(tag);

            Log.d("bookmap", tag);
            Log.d("bookmap", String.valueOf(bookMap.size()));


            Intent detailIntent = new Intent(MainActivity.this, BookDetailActivity.class);
            detailIntent.putExtra("title", book.getName());
            detailIntent.putExtra("author", book.getAuthor());
            detailIntent.putExtra("price", String.valueOf(book.getPrice()));

            startActivity(detailIntent);

        }
    };
    BookDataSource bookDataSource;
    List<Book> bookList = new ArrayList<>();
    BookAdapter bookAdapter;
    String url = "https://raw.githubusercontent.com/tamingtext/book/master/apache-solr/example/exampledocs/books.json";
    HashMap<String, Book> bookMap = new HashMap<>();
    FrameLayout frameLayout;
    Librarian librarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bookDataSource = new BookDataSource();
        RecyclerView bookRecyclerView = (RecyclerView) findViewById(R.id.book_recyclerview);
        bookAdapter = new BookAdapter(bookList, bookOnClick);
        frameLayout = (FrameLayout) findViewById(R.id.ad_fragment_container);


        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        bookRecyclerView.setAdapter(bookAdapter);
        makeRequestWithOkHttp(url);
        bookRecyclerView.setLayoutManager(linearLayoutManager);

        AdFragment adFragment = new AdFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ad_fragment_container, adFragment);
        fragmentTransaction.commit();
    }

    public void hideAD(View view){
        frameLayout.setVisibility(View.GONE);
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

                //bookDataSource.setBookData(result);
                //bookList.addAll(bookDataSource);
                //bookMap = bookHashMap(bookList);
                librarian = new Librarian(result);
                bookList.addAll(librarian.getBookList());
                bookList = librarian.sortBookList(bookList);

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

    public HashMap<String, Book> bookHashMap(List<Book> bookList) {
        HashMap<String, Book> bookHashMap = new HashMap<>();
        for (Book b : bookList) {
            bookHashMap.put(b.getId(), b);
        }
        return bookHashMap;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.book_options_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.cart_menu_item:
                //
                break;
            case R.id.settings_menu_item:
                //
                break;
            case R.id.help_menu_item:
                //
                break;
            case R.id.profile_menu_item:
                //
                break;
        }
        return true;
    }

    //options menu search cart always tie
    //setting, help, profile
    //cart activity
    //fragment ads thing



}
