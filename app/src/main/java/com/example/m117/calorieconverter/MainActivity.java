package com.example.m117.calorieconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.GridView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {
    static GridView gridView;
    static RelativeLayout rView;
    static EditText inputCalories;

    static final String[ ] myExercises = new String[] {
            "Pushups" ,
            "Situps",
            "Squats" ,
            "Leg-Lifts",
            "Planks" ,
            "Jumping Jacks",
            "Pullups",
            "Cycling",
            "Walking" ,
            "Jogging",
            "Swimming",
            "Stair-Climbing"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new MyGridAdapter(this, myExercises));
        rView = (RelativeLayout) findViewById(R.id.layout1);
        inputCalories = (EditText) rView.findViewById(R.id.editText);
        inputCalories.setOnEditorActionListener(new myCalorieActions());

    }




}
