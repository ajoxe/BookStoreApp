package nyc.c4q.bookstoreapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.bookstoreapp.controller.BookAdapter;
import nyc.c4q.bookstoreapp.model.Book;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView bookRecyclerView = (RecyclerView) findViewById(R.id.book_recyclerview);



        //BookAdapter bookAdapter = new BookAdapter();
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        //bookRecyclerView.setAdapter(bookAdapter);
        bookRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
