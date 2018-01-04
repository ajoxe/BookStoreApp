package nyc.c4q.bookstoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {

    TextView title;
    TextView author;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Intent intent = getIntent();

        title = (TextView) findViewById(R.id.bookdet_title_text_view);
        author = (TextView) findViewById(R.id.bookdet_author_text_view);
        price = (TextView) findViewById(R.id.bookdet_price_text_view);

        title.setText(intent.getStringExtra("title"));
        author.setText(intent.getStringExtra("author"));
        price.setText(intent.getStringExtra("price"));
    }
}
