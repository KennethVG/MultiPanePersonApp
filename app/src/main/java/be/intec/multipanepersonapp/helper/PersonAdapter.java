package be.intec.multipanepersonapp.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import be.intec.multipanepersonapp.R;
import be.intec.multipanepersonapp.model.Person;

/**
 * Created by Kenneth on 27/02/2015.
 */
public class PersonAdapter extends BaseAdapter {


    private List<Person> persons;
    private Context context;

    public PersonAdapter(List<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item,null);
        }

        TextView txtvAge = (TextView) convertView.findViewById(R.id.txtv_age);
        TextView txtvName = (TextView) convertView.findViewById(R.id.txtv_name);

        txtvAge.setText(String.valueOf(getItem(position).getAge()));
        txtvName.setText(getItem(position).getName());


        return convertView;
    }
}
