package be.intec.multipanepersonapp;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.intec.multipanepersonapp.helper.PersonAdapter;
import be.intec.multipanepersonapp.model.Person;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    private OnItemSelectedListener listener;
    private List<Person> persons;
    private ListView lv;
    private PersonAdapter adapter;
    private Person person;

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        persons = new ArrayList<>();
        persons.add(new Person("Pop", 48));
        persons.add(new Person("Karel", 25));
        persons.add(new Person("Bert", 35));
        persons.add(new Person("Vos", 52));
        persons.add(new Person("Paard", 100));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_overview,container,false);
//        Button b = (Button) view.findViewById(R.id.btn_show);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateDetail();
//            }
//        });

        lv = (ListView) view.findViewById(R.id.listView);
        adapter = new PersonAdapter(persons, getActivity());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            person = (Person) parent.getItemAtPosition(position);
            listener.onPersonSelected(person.toString());
        }
    });
    return view;
    }

    public interface OnItemSelectedListener{
        public void onPersonSelected(String person);

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // ACTIVITY MUST IMPLEMENT INTERFACE!
        if(activity instanceof  OnItemSelectedListener){
            listener = (OnItemSelectedListener)activity;
        }else{
            throw new ClassCastException(activity.toString() + " must implement PersonFragment.OnItemSelectedListener");
        }
    }
}
