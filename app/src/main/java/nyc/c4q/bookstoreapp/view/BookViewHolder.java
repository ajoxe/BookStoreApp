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
    TextView price;

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getAuthor() {
        return author;
    }

    public void setAuthor(TextView author) {
        this.author = author;
    }

    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

    public BookViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.book_title_text_view);
        author = (TextView) itemView.findViewById(R.id.book_author_text_view);
        price = (TextView) itemView.findViewById(R.id.book_price_text_view);

    }

    public void onBind(Book book){
        title.setText(book.getName());
        author.setText(book.getAuthor());
        price.setText(String.valueOf(book.getPrice()));
    }
}
