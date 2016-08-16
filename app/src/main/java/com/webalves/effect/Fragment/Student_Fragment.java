package com.webalves.effect.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.webalves.effect.Adapter.Enquiries_adater;
import com.webalves.effect.Adapter.Enquiries_items;
import com.webalves.effect.Adapter.Student_List;
import com.webalves.effect.Adapter.Student_School_adapter;
import com.webalves.effect.MainActivity;
import com.webalves.effect.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Student_Fragment extends Fragment {
    LinearLayout linear1,linear2;
    View view;
    Spinner school_sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_equire_, container, false);

        school_sp=(Spinner)view.findViewById(R.id.school_sp);
        ArrayList<String> years = new ArrayList<String>();
        ArrayList<String> days = new ArrayList<String>();

        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 1995; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, years);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, days);

        Spinner spinYear = (Spinner) view.findViewById(R.id.years);
        Spinner spinDay = (Spinner) view.findViewById(R.id.days);

        spinYear.setAdapter(adapter);
        spinDay.setAdapter(adapter2);


        school_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(R.color.gray);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }


}
