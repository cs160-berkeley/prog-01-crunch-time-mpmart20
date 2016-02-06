package com.example.m117.calorieconverter;

import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.*;


/**
 * Created by M117 on 2/5/16.
 */
public class myCalorieActions implements TextView.OnEditorActionListener {

    public void updateCaloriesFromExercises(float count, String myName){
        float myNum = myExerciseActions.getConversionReps(myName) * count;
        MainActivity.inputCalories.setText(Float.toString(myNum));
        new myExerciseActions().updateCellsFromCals(MainActivity.gridView, 1, true, myNum);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        Float vInfo = Float.parseFloat(v.getText().toString());
        if (actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            new myExerciseActions().updateCellsFromCals(MainActivity.gridView, 1, true,vInfo);
            return true;
        }
        return false;
    }
}
