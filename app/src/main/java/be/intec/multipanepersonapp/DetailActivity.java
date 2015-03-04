package be.intec.multipanepersonapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class DetailActivity extends ActionBarActivity {

    public static final String PERSON = "person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String person = extras.getString(PERSON);
            PersonDetailFragment detailFragment = (PersonDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_detail_act);
            detailFragment.setText(person + " is awesome");
        }
    }

}
