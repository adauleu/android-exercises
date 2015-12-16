package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Step2Fragment extends Fragment {

    public static final String BOOK = "BOOK";
    private TextView textView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step2, container, false);
        Book book = this.getArguments().getParcelable(BOOK);
        textView = (TextView) view.findViewById(R.id.step2TextView);
        textView.setText(book.title);
        return view;
    }

    public static Step2Fragment newInstance(Book book) {
        Step2Fragment fragment = new Step2Fragment();
        Bundle args = new Bundle();
        args.putParcelable(BOOK, book);
        fragment.setArguments(args);
        return fragment;
    }
}
