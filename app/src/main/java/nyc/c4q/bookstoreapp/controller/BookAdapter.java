package nyc.c4q.bookstoreapp.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.bookstoreapp.R;
import nyc.c4q.bookstoreapp.model.Book;
import nyc.c4q.bookstoreapp.view.BookViewHolder;

/**
 * Created by amirahoxendine on 12/13/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<Book> bookList;
    View.OnClickListener clickListener;



    public BookAdapter(List<Book> bookList, View.OnClickListener clickListener) {
        this.bookList = bookList;
        this.clickListener = clickListener;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_view, parent, false);

        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.onBind(book);
        holder.getTitle().setTag(book.getId());
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
