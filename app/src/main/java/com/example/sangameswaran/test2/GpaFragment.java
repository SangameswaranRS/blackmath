package com.example.sangameswaran.test2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sangameswaran.test2.R;

/**
 * Created by Sangameswaran on 23-10-2016.
 */
public class GpaFragment extends Fragment implements View.OnClickListener {
    EditText gradeSelect;
    RadioGroup CrSelect;
    Button enterBut, ResetBut, calgpa;
    TextView gpa, advice;
    EditText noofsub;
    int global_credit_array[] = new int[15];
    int global_grade_array[] = new int[15];
    int iterator, size = 0;
    int global_count = 8;
    int enter_press_count = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_gpa, container, false);
        for(int i=0;i<15;i++){
            global_grade_array[i]=0;
        }
        for(int j=0;j<15;j++){
            global_credit_array[j]=2;
        }

        gradeSelect = (EditText) view.findViewById(R.id.gSel);
        CrSelect = (RadioGroup) view.findViewById(R.id.radioGroup);
        enterBut = (Button) view.findViewById(R.id.EnterButton);
        ResetBut = (Button) view.findViewById(R.id.ResetButton);
        gpa = (TextView) view.findViewById(R.id.GpaTextView);
        advice = (TextView) view.findViewById(R.id.adviceTextView);
        calgpa = (Button) view.findViewById(R.id.calculateGpaButton);
        noofsub = (EditText) view.findViewById(R.id.noofSubj);
        enterBut.setOnClickListener(this);
        ResetBut.setOnClickListener(this);
        calgpa.setOnClickListener(this);
        // global_count=Integer.parseInt(noofsub.getText().toString());


        CrSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.CrSub2) {
                    global_credit_array[size] = 2;
                    for (int i = size; i < 15; i++)
                        global_credit_array[i] = 2;
                } else {
                    if (checkedId == R.id.CrSub3) {
                        global_credit_array[size] = 3;
                        for (int i = size; i < 15; i++) {
                            global_credit_array[i] = 3;
                        }

                    } else if (checkedId == R.id.crSub4) {
                        global_credit_array[size] = 4;
                        for (int i = size; i < 15; i++) {
                            global_credit_array[i] = 4;
                        }
                    }
                }


            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.EnterButton) {
            if (enter_press_count < global_count) {
            /*update the values in the array"*/
                String string;
                string = gradeSelect.getText().toString();
                if (string.equals("")) {
                    Toast.makeText(getContext(),"enter the Data",Toast.LENGTH_LONG).show();

                } else {
                    try {
                        if(string.equals("A")||(string.equals("a")))
                            global_grade_array[size]=8;
                        else if(string.equals("a+")||(string.equals("A+")))
                            global_grade_array[size]=9;
                        else if(string.equals("o")||(string.equals("O")))
                            global_grade_array[size]=10;
                        else if(string.equals("b+")||(string.equals("B+")))
                            global_grade_array[size]=7;
                        else if(string.equals("b")||(string.equals("B")))
                            global_grade_array[size]=6;
                        else if(string.equals("RA")||(string.equals("ra")))
                            global_grade_array[size]=5;
                        else
                            Toast.makeText(getContext(),"Enter Valid Grade-CBCS 2015 Regulation ",Toast.LENGTH_LONG).show();


                        gradeSelect.setText("");
                        enter_press_count++;
                        size++;
                    } catch (NumberFormatException e) {
                        Toast.makeText(getContext(),"exception ",Toast.LENGTH_LONG).show();

                    }
                }
            } else {
                Toast.makeText(getContext(), "press Calculate,cant enter more", Toast.LENGTH_LONG).show();
            }
        }
        if (id == R.id.ResetButton) {
            Toast.makeText(getContext(), "Resetting", Toast.LENGTH_LONG).show();
            size = 0;
            enter_press_count=0;

            for(int i=0;i<15;i++){
                global_grade_array[i]=0;
            }
            for(int j=0;j<15;j++){
                global_credit_array[j]=2;
            }
            gpa.setText("");

            gradeSelect.setText("");
        }
        if (id == R.id.calculateGpaButton) {
            //Toast.makeText(getContext(), "GPA calculated", Toast.LENGTH_LONG).show();
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += global_credit_array[j];
            }
            int sum1 = 0;
            for (int k = 0; k < size; k++) {
                sum1 += global_grade_array[k] * global_credit_array[k];
            }
            float resultgpa = (float) sum1 / sum;
            gpa.setText("your GPA is" + resultgpa);
           if(resultgpa>8.0) {
               advice.setText("Advice: Your GPA is enough but try to improve it.");
           }
           else if(resultgpa<6.0){
               advice.setText("Advice:Take a serious concern in your studies.Work hard");
           }
            else if(resultgpa<8.0){
               advice.setText("Advice:Not enough for placements ,Work Hard");
           }
            else{

           }
        }

    }
}
