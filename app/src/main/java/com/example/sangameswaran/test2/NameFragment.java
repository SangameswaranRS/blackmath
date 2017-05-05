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

import com.example.sangameswaran.test2.R;

import java.util.zip.Inflater;

import static java.lang.Math.pow;

/**
 * Created by Sangameswaran on 24-09-2016.
 */


public class NameFragment extends Fragment implements View.OnClickListener {
    EditText mEnteredValue;
    Button bOne;
    Button bTwo;
    Button bThree;
    Button bFour;
    Button bFive;
    TextView resDisp;

    public NameFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);


        mEnteredValue = (EditText) view.findViewById(R.id.result);
        bOne = (Button) view.findViewById(R.id.button1);
        bTwo = (Button) view.findViewById(R.id.button2);
        bThree = (Button) view.findViewById(R.id.button3);
        bFour = (Button) view.findViewById(R.id.button4);
        bFive = (Button) view.findViewById(R.id.button5);
        resDisp = (TextView) view.findViewById(R.id.resultDisplay);
        bOne.setOnClickListener((View.OnClickListener) this);
        bTwo.setOnClickListener((View.OnClickListener) this);
        bThree.setOnClickListener((View.OnClickListener) this);
        bFour.setOnClickListener((View.OnClickListener) this);
        bFive.setOnClickListener((View.OnClickListener) this);


        return view;
    }

    public int invert(int a) {
        if (a == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public int balance(int a) {
        if (a > 1) {
            return 1;

        } else {
            return 0;
        }
    }

    public int bintogray(int bin) {
        int a, b, result = 0, i = 0;
        while (bin != 0) {
            a = bin % 10;
            bin = bin / 10;
            b = bin % 10;
            if ((a == 1 && invert(b) == 1) || (invert(a) == 1 && b == 1)) {
                result = (int) (result + pow(10, i));

            }
            i++;

        }
        return result;
    }

    int binToDec(int data) {
        int sum = 0, b = 1;
        //int g0,g1,g2,g3;
        int i, q, r;
        i = 0;
        while (data > 0) {
            r = data % 10;
            sum += r * b;
            b *= 2;
            //cout<<"o";
            data /= 10;

        }
        return sum;
    }

    int decToBin(int data) {

        int i = 0, j, fi;
        int a[] = new int[10];
        int b[] = new int[10];
        while (data > 0) {
            a[i] = data % 2;
            data = data / 2;
            i++;
        }
        fi = i;
        int sum = 0, c = 1;
        for (i = 0; i < fi; i++) {
            sum += a[i] * c;
            c *= 10;

        }


        return sum;


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button1) {
            String value = mEnteredValue.getText().toString();
            if (value.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();


            } else {
                int data = Integer.parseInt(value);
                int result = bintogray(data);
                resDisp.setText("BINARY TO GRAY CODE RESULT=" + result);
            }

        }
        if (id == R.id.button2) {
            /*to excess 3*/
            String value = mEnteredValue.getText().toString();
            if (value.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();


            } else {
                int data = Integer.parseInt(value);
                int a[] = new int[10];
                int b[] = new int[10];
                int i = 0;

                i = binToDec(data);
                i += 3;
                i = decToBin(i);
                resDisp.setText("BINARY TO EXCESS 3" + i);
            }
        }
        if (id == R.id.button3) {
            String value = mEnteredValue.getText().toString();
            if (value.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();


            } else {
                int data = Integer.parseInt(value);
                int recieve = binToDec(data);
                resDisp.setText("DECIMAL EQUIVALENT=" + recieve);
            }

        }
        if (id == R.id.button4) {
            String value = mEnteredValue.getText().toString();
            if (value.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();


            } else {
                int data = Integer.parseInt(value);
                data = binToDec(data);
                String s;
                s = Integer.toHexString(data);
                resDisp.setText("HEXADECIMAL EQUIVALENT:" + s);
            }
        }
        if (id == R.id.button5) {
            String value = mEnteredValue.getText().toString();
            if (value.equals("")) {
                Toast.makeText(getContext(), "enter data", Toast.LENGTH_LONG).show();


            } else {


                int data = Integer.parseInt(value);
                data = binToDec(data);
                String s;
                s = Integer.toOctalString(data);
                resDisp.setText("OCTAL EQUIVALENT:" + s);
            }

        }

    }
}
