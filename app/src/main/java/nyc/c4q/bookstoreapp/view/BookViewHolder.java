package nyc.c4q.bookstoreapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.bookstoreapp.R;
import nyc.c4q.bookstoreapp.model.Book;

/**
 * Created by amirahoxendine on 12/13/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    TextView author;
    TextView isbn;
    TextView price;
    TextView inStock;


    public BookViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.book_title_text_view);
        author = (TextView) itemView.findViewById(R.id.book_author_text_view);
        isbn = (TextView) itemView.findViewById(R.id.book_isbn_text_view);
        price = (TextView) itemView.findViewById(R.id.book_price_text_view);
        inStock = (TextView) itemView.findViewById(R.id.book_instock_text_view);
    }

    public void onBind(Book book){
        title.setText(book.getName());
        author.setText(book.getAuthor());
        isbn.setText(book.getId());
        price.setText(String.valueOf(book.getPrice()));
        inStock.setText(String.valueOf(book.isInstock()));

    }
}
