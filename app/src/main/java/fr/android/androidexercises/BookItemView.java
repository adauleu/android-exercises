package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by albandauleu on 15/12/15.
 */
public class BookItemView extends LinearLayout {
    private TextView nameView;
    private TextView priceView;

    public BookItemView(Context context) {
        super(context);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        nameView = (TextView) findViewById(R.id.book_title);
        priceView = (TextView) findViewById(R.id.book_price);
    }

    public void bindView(String name, float price){
        nameView.setText(name);
        priceView.setText(price+"€");
    }
}
