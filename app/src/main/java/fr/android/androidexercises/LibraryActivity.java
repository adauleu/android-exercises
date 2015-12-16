package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener, Step1Fragment.OnNextStep1Listener {

    public static final String TAG = "TAG";
    public static final String STEP2_TAG = "step2Tag";
    public static final String STEP1_TAG = "step1Tag";
    public static final String STEP0_TAG = "step0Tag";
    private String currentFragmentTag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (currentFragmentTag.isEmpty()) {
            Step0Fragment fragment = new Step0Fragment();
            String step0Tag = STEP0_TAG;
            currentFragmentTag = step0Tag;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, fragment, step0Tag).commit();
        } else {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(currentFragmentTag);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, currentFragment).commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(TAG, currentFragmentTag);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentFragmentTag = savedInstanceState.getString(TAG);
    }

    @Override
    public void onNext() {

        String step1Tag = STEP1_TAG;
        currentFragmentTag = step1Tag;
        getSupportFragmentManager().beginTransaction().addToBackStack("step0")
                .replace(R.id.containerFrameLayout, new Step1Fragment(), step1Tag).commit();
    }

    @Override
    public void onNext(Book book) {
        String step2Tag = STEP2_TAG;
        currentFragmentTag = step2Tag;

        Step2Fragment step2Fragment = Step2Fragment.newInstance(book);
        getSupportFragmentManager().beginTransaction().addToBackStack("step1")
                .replace(R.id.containerFrameLayout, step2Fragment, step2Tag).commit();
    }

    @Override
    public void onBackPressed() {
        switch (currentFragmentTag) {
            case STEP2_TAG:
                currentFragmentTag = STEP1_TAG;
            case STEP1_TAG:
                currentFragmentTag = STEP0_TAG;
            default:
                currentFragmentTag = STEP0_TAG;
        }
        super.onBackPressed();
    }
}
