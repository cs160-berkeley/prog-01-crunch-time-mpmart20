package com.example.m117.calorieconverter;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by M117 on 2/4/16.
 */
public class MyGridAdapter extends BaseAdapter{

    private Context context;
    private final String[] gridValues;

    static final ArrayList reps = new ArrayList<String>(Arrays.asList("Pushups",
            "Situps",
            "Squats",
            "Pullups"));

    //Constructor to initialize values
    public MyGridAdapter(Context context, String[] gridValues) {
        this.context        = context;
        this.gridValues     = gridValues;
    }

    @Override
    public int getCount() {
        return gridValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewMod(position,convertView,parent,0);
    }

    public View getViewMod(int position, View convertView, ViewGroup parent, int isEdit) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myGrid;
        if (convertView == null) {
            myGrid = inflater.inflate( R.layout.griditem , null);
            TextView textView = (TextView) myGrid.findViewById(R.id.grid_item_label);
            textView.setText(gridValues[position]);
            textView = (TextView) myGrid.findViewById(R.id.grid_item_rep);
            EditText editTCh = (EditText) myGrid.findViewById(R.id.editText);
            editTCh.setOnEditorActionListener(new myExerciseActions());
            if (reps.contains(gridValues[position])){

                textView.setText("reps");

            }else{
                textView.setText("mins");
            }
        } else {

            myGrid = (View) convertView;
        }
        return myGrid;
    }
}
