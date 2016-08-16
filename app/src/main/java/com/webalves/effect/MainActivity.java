package com.webalves.effect;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.webalves.effect.Activity.Login_Activity;
import com.webalves.effect.Activity.NavDrawerItem;

import com.webalves.effect.Adapter.DividerItemDecoration;
import com.webalves.effect.Adapter.Enquiries_adater;
import com.webalves.effect.Adapter.Enquiries_items;
import com.webalves.effect.Adapter.NavDrawerListAdapter;
import com.webalves.effect.Fragment.Class_Room_Fragment;
import com.webalves.effect.Fragment.Enquiries;
import com.webalves.effect.Fragment.Enquiries_detail;
import com.webalves.effect.Fragment.Equire_Fragment;
import com.webalves.effect.Fragment.Fragment1;
import com.webalves.effect.Fragment.Note_Fragment;
import com.webalves.effect.Fragment.Notes_Detail_Fragment;
import com.webalves.effect.Fragment.Notes_Fragment;
import com.webalves.effect.Fragment.Profile_Fragment;
import com.webalves.effect.Fragment.QR_Search_Fargment;
import com.webalves.effect.Fragment.School_Fragment;
import com.webalves.effect.Fragment.Student_Detail_Fragment;
import com.webalves.effect.Fragment.Student_Fragment;
import com.webalves.effect.Fragment.Student_Register_Fragment;
import com.webalves.effect.Fragment.Welcome_Oprater_Fragment;
import com.webalves.effect.lib.Cons;
import com.webalves.effect.lib.storeSharedPref;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {
    public School_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_school_, container, false);
    }
}



