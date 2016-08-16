package com.webalves.effect.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webalves.effect.MainActivity;
import com.webalves.effect.R;

public class Notes_Detail_Fragment extends Fragment {
View view;
LinearLayout delete_btn,edt_btn;
    public Notes_Detail_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_notes__detail_, container, false);
        delete_btn=(LinearLayout)view.findViewById(R.id.delete_btn);
        edt_btn=(LinearLayout)view.findViewById(R.id.edt_btn);
        edt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).nextPickUpFragment3(1);
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Note Delete ",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).nextPickUpFragment3(0);

            }
        });
    return view;
    }


}
