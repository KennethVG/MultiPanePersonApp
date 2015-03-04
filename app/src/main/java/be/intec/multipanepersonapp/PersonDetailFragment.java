package be.intec.multipanepersonapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonDetailFragment extends Fragment {

    public PersonDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_detail, container, false);
        return view;
    }

    public void setText(String person){
        TextView tv = (TextView) getView().findViewById(R.id.detail_text);
        tv.setText(person);
    }


}
