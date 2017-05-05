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
 * Created by Sangameswaran on 09-10-2016.
 */
public class FragmentThree extends Fragment implements View.OnClickListener {
    Button bu1,bu2,bu3,bu4,bu5,bu6,bu7;
    EditText inrinput;
    TextView inrresult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.three_fragment, container, false);
        inrinput= (EditText) view.findViewById(R.id.inrip1);
        inrresult= (TextView) view.findViewById(R.id.resdisp1);
        bu1=(Button) view.findViewById(R.id.button01);
        bu2=(Button) view.findViewById(R.id.button02);
        bu3=(Button) view.findViewById(R.id.button03);
        bu4=(Button) view.findViewById(R.id.button04);
        bu5=(Button) view.findViewById(R.id.button05);
        bu6=(Button) view.findViewById(R.id.button06);
        bu7=(Button) view.findViewById(R.id.button07);
        bu1.setOnClickListener(this);
        bu2.setOnClickListener(this);
        bu3.setOnClickListener(this);
        bu4.setOnClickListener(this);
        bu5.setOnClickListener(this);
        bu6.setOnClickListener(this);
        bu7.setOnClickListener(this);








        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.button01)
        {
            String enter=inrinput.getText().toString();

                if (enter.equals("")) {
                    Toast.makeText(getContext(), "enter data to be calculated", Toast.LENGTH_LONG).show();

                }
            else
                {
            double val=Integer.parseInt(enter);
            val=val*0.013;
            inrresult.setText("INR to EURO:"+val);

        }}

       else if(id==R.id.button02)
        {
            String enter=inrinput.getText().toString();
            if (enter.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            }
            else
            {
                double val=Integer.parseInt(enter);
            val=val*0.015;
            inrresult.setText("INR to USD:"+val);

        }}

        else if(id==R.id.button03)
        {
            String enter=inrinput.getText().toString();
            if (enter.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            }
            else
            {
                double val=Integer.parseInt(enter);
            val=val*0.012;
            inrresult.setText("INR to POUND:"+val);

        }}
        else if(id==R.id.button04)
        {
            String enter=inrinput.getText().toString();
            if (enter.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            }
            else
            {

                double val=Integer.parseInt(enter);
            val=val*0.055;
            inrresult.setText("INR to UAE Dhirham:"+val);

        }}
        else if(id==R.id.button05)
        {
            String enter=inrinput.getText().toString();
            if (enter.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            }
            else{
                double val=Integer.parseInt(enter);
            val=val*0.0045;
            inrresult.setText("INR to Kuwaiti Dinar:"+val);

        }}

        else if(id==R.id.button06)
        {
            String enter=inrinput.getText().toString();
            if (enter.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            }
            else
            {
                double val=Integer.parseInt(enter);
            val=val*0.020;
            inrresult.setText("INR to Australian Dinar:"+val);

        }}
        else if(id==R.id.button07)
        {
            String enter=inrinput.getText().toString();
            if (enter.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();
            }
            else{
                double val=Integer.parseInt(enter);
            val=val*0.10;
            inrresult.setText("INR to Renminbi :"+val);

        }}
        else
        {

        }








    }
}
