package com.webalves.effect.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.webalves.effect.MainActivity;
import com.webalves.effect.R;
import com.webalves.effect.lib.Cons;
import com.webalves.effect.lib.CropOption;
import com.webalves.effect.lib.CropOptionAdapter;
import com.webalves.effect.lib.storeSharedPref;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webalves.effect.R;


public class Notes_Fragment extends Fragment {
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
