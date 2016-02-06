package com.example.m117.calorieconverter;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import java.util.Hashtable;
import java.util.Map;

import java.util.Dictionary;

/**
 * Created by M117 on 2/5/16.
 */
public class myExerciseActions implements TextView.OnEditorActionListener {

    public static float getConversionReps(String myExercise){
        if(myExercise =="Pushups" ){
            return 100f/350;
        }else if (myExercise == "Situps"){
            return  100f/200;
        }else if (myExercise == "Squats"){
            return 100f/225;
        }else if (myExercise == "Leg-Lifts"){
            return 100f/25;
        }else if (myExercise == "Planks"){
            return 100f/25;
        }else if (myExercise == "Jumping Jacks"){
            return  100f/10;
        }else if (myExercise == "Pullups"){
            return 100f/100;
        }else if (myExercise == "Cycling"){
            return 100f/12;
        }else if (myExercise == "Walking"){
            return 100f/20;
        }else if (myExercise == "Jogging"){
            return 100f/12;
        }else if (myExercise == "Swimming"){
            return 100f/13;
        }
        return 100f/15;
    }

    public static float getConversionCals(String myExercise){
        if(myExercise =="Pushups" ){
            return 350/100f;
        }else if (myExercise == "Situps"){
            return  200/100f;
        }else if (myExercise == "Squats"){
            return 225/100f;
        }else if (myExercise == "Leg-Lifts"){
            return 25/100f;
        }else if (myExercise == "Planks"){
            return 25/100f;
        }else if (myExercise == "Jumping Jacks"){
            return  10/100f;
        }else if (myExercise == "Pullups"){
            return 100/100f;
        }else if (myExercise == "Cycling"){
            return 12/100f;
        }else if (myExercise == "Walking"){
            return 20/100f;
        }else if (myExercise == "Jogging"){
            return 12/100f;
        }else if (myExercise == "Swimming"){
            return 13/100f;
        }
        return 15/100f;
    }

    public void updateCellsFromCals(GridView myGrid, int item,boolean isCal, float totalCals){
        float total = 10/10f;
        if (isCal){
            total = totalCals;
        }
        Log.i("updating cells:","uhghh");
        for(int i = 0; i < myGrid.getChildCount(); i++) {
            ViewGroup gridChild = (ViewGroup) myGrid.getChildAt(i);
            TextView myText = (TextView) gridChild.findViewById(R.id.grid_item_label);
            String myName = String.valueOf(myText.getText());
            EditText myEdit = (EditText) gridChild.findViewById(R.id.editText);
            myEdit.setText(Float.toString(getConversionCals(myName)*total),TextView.BufferType.EDITABLE);
        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            ViewGroup parent = (ViewGroup) v.getParent();
            TextView myText = (TextView) parent.findViewById(R.id.grid_item_label);
            String myName = String.valueOf(myText.getText());
            String vInfo = v.getText().toString();
            new myCalorieActions().updateCaloriesFromExercises(Float.parseFloat(vInfo), myName);
            return true;
        }
        return false;
    }
}
