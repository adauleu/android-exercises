package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by albandauleu on 15/12/15.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    private TextView nameView;
    private TextView priceView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        nameView = (TextView) itemView.findViewById(R.id.book_title);
        priceView = (TextView) itemView.findViewById(R.id.book_price);
    }



    public void bind(Book book){
        nameView.setText(book.name);
        priceView.setText(book.price + "€");
    }
}
