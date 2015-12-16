package fr.android.androidexercises;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by albandauleu on 15/12/15.
 */
public class BookListAdapter extends BaseAdapter {

    private Context context;
    private List<Book> books;
    LayoutInflater inflater;

    public BookListAdapter(Context context, List<Book> books){
        this.books = books;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookItemView bookItemView;
        if(convertView == null){
            bookItemView = (BookItemView) inflater.inflate(R.layout.book_item_view, parent, false);
        }else{
            bookItemView = (BookItemView) convertView;
        }
        Book currentBook = books.get(position);
        bookItemView.bindView(currentBook.name, currentBook.price);
        return bookItemView;
    }
}
