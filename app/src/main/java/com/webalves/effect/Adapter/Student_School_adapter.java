package com.webalves.effect.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.webalves.effect.MainActivity;
import com.webalves.effect.R;
import com.webalves.effect.lib.storeSharedPref;

import java.util.List;

/**
 * Created by WebM on 8/10/2016.
 */
public class Student_School_adapter extends RecyclerView.Adapter<Student_School_adapter.MyViewHolder> {
    Context ctx;
    private List<Student_List> stdList;
    public static storeSharedPref sharedpref;
    private String position;
    Activity a;

    public String getPosition() {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView student, attendance, school;

        public MyViewHolder(View view) {
            super(view);

            sharedpref = new storeSharedPref(ctx);
            student = (TextView) view.findViewById(R.id.student_txt);
            attendance = (TextView) view.findViewById(R.id.attendance_txt);
            school = (TextView) view.findViewById(R.id.school_txt);

            student.setOnClickListener(this);
            school.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String strName = stdList.get(getAdapterPosition()).getStudent().toString();
            String strSchool = stdList.get(getAdapterPosition()).getSchool().toString();
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


    public Student_School_adapter(List<Student_List> stdList) {
        this.stdList = stdList;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_school_adapter_layout, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Student_List enquiries = stdList.get(position);
        holder.student.setText(enquiries.getStudent());
        holder.school.setText(enquiries.getSchool());
        holder.attendance.setText(enquiries.getAttendance());

       /* holder.student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"clicked="+ position,Toast.LENGTH_SHORT).show();

            }
        });*/
    }


    @Override
    public int getItemCount() {
        return stdList.size();
    }
}
