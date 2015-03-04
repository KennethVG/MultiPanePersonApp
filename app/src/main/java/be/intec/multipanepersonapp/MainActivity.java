package be.intec.multipanepersonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements PersonFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPersonSelected(String person) {
        PersonDetailFragment detail = (PersonDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_detail);
        if(detail != null && detail.isInLayout()){
            detail.setText(person);
        }else{
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.PERSON, person);
            startActivity(intent);
        }
    }
}
