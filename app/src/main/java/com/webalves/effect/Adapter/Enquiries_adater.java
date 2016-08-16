package com.webalves.effect.Adapter;

/**
 * Created by WebM on 8/9/2016.
 */

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.webalves.effect.MainActivity;
import com.webalves.effect.R;
import com.webalves.effect.lib.Cons;
import com.webalves.effect.lib.storeSharedPref;

import java.util.List;


public class Enquiries_adater extends RecyclerView.Adapter<Enquiries_adater.MyViewHolder> {
    Context ctx;
    private List<Enquiries_items> enqList;
    public static storeSharedPref sharedpref;
    private String position;
    Activity a;

    public String getPosition() {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView student, date, school;

        public MyViewHolder(View view) {
            super(view);

            sharedpref = new storeSharedPref(ctx);
            student = (TextView) view.findViewById(R.id.student_txt);
            date = (TextView) view.findViewById(R.id.enq_date);
            school = (TextView) view.findViewById(R.id.school_txt);

            student.setOnClickListener(this);
            school.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String strName = enqList.get(getAdapterPosition()).getStudent().toString();
            String strSchool = enqList.get(getAdapterPosition()).getSchool().toString();
            if (v.getId() == student.getId()) {

                Toast.makeText(v.getContext(), "Student " + strName, Toast.LENGTH_SHORT).show();
                  //sharedpref.storeSharedValue(Cons.student_name, strName);


                Log.i("==============", "========strName=======" + strName);
                ((MainActivity) itemView.getContext()).nextPickUpFragment2(3);

            } else {
                Toast.makeText(v.getContext(), "School = " + strSchool, Toast.LENGTH_SHORT).show();
                ((MainActivity) itemView.getContext()).nextPickUpFragment2(2);
            }

        }


        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }


    public Enquiries_adater(List<Enquiries_items> enqList) {
        this.enqList = enqList;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.enq_single_item_layout, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Enquiries_items enquiries = enqList.get(position);
        holder.student.setText(enquiries.getStudent());
        holder.school.setText(enquiries.getSchool());
        holder.date.setText(enquiries.getEnq_date());

       /* holder.student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"clicked="+ position,Toast.LENGTH_SHORT).show();

            }
        });*/
    }


    @Override
    public int getItemCount() {
        return enqList.size();
    }
}