package com.webalves.effect.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.webalves.effect.MainActivity;
import com.webalves.effect.R;


public class Profile_Fragment extends Fragment {

    View view;
ImageView edt_img;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items =4;

    public Profile_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View x = inflater.inflate(R.layout.fragment_profile_, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        edt_img = (ImageView) x.findViewById(R.id.edt_img);

        edt_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).nextPickUpFragment(1);
            }
        });

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));


        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });


        return x;

    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Basic_info_Fragment();
                case 1:
                    return new Grade_Fragment();
                case 2:
                    return new Note_Fragment();
                case 3:
                    return new Test_Fragment();

                default:


            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Basic Info";
                case 1:
                    return "Grade";
                case 2:
                    return "Notes";
                case 3:
                    return "Tests";

            }
            return null;
        }
    }
}
