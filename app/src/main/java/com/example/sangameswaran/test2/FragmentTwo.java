package com.example.sangameswaran.test2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sangameswaran on 24-09-2016.
 */
public class FragmentTwo extends Fragment implements View.OnClickListener {

    Button buOne;
    Button buTwo;

    TextView result1;
    EditText ip1, ip2, ip3;

    public FragmentTwo() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_fragment, container, false);

        ip1 = (EditText) view.findViewById(R.id.ppl);
        ip2 = (EditText) view.findViewById(R.id.noof);
        ip3 = (EditText) view.findViewById(R.id.rate);
        buOne = (Button) view.findViewById(R.id.butt01);
        //buTwo = (Button) view.findViewById(R.id.butt02);

        result1 = (TextView) view.findViewById(R.id.disp);
        buOne.setOnClickListener(this);
        //buTwo.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.butt01) {
            String value1 = ip1.getText().toString();
            String value2 = ip2.getText().toString();
            String value3 = ip3.getText().toString();
            if ((value1.equals("")) || (value2.equals("")) || (value3.equals(""))) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            } else {
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double c = Double.parseDouble(value3);
                double d = (a * b * c) / 100;
                result1.setText("SI=" + d);
            }


        }
        /*if (id == R.id.butt02) {
            String value1 = ip1.getText().toString();
            String value2 = ip2.getText().toString();
            String value3 = ip3.getText().toString();
            if ((value1.equals("")) || (value2.equals("")) || (value3.equals(""))) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            } else {
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double c = Double.parseDouble(value3);
                double d = (a * Math.pow(1 + c / 12, 12 * b))-a;
                //result1.setText("CI(compounded monthly)=" + d);

            }


        }*/
    }}
