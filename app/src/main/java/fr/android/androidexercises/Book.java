package fr.android.androidexercises;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by albandauleu on 16/12/15.
 */
public class Book implements Parcelable {
    public final String title;

    public Book(String text) {
        title = text;
    }

    protected Book(Parcel in) {
        title = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
    }
}
