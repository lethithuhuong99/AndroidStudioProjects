package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    EditText edtN;
    TextView tvResult;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtN = findViewById(R.id.edt_n);
        tvResult = findViewById(R.id.tv_result);
    }

//    public void doCheck(View v) {
//        n = Integer.parseInt(edtN.getText().toString());
//        if (isPrime(n)) {
//            tvResult.setText("isPrime");
//        }
//        else {
//            tvResult.setText("not is Prime");
//        }
//    }

    public void doCheck(View v) {
        n = Integer.parseInt(edtN.getText().toString());
        tvResult.setText("Prime Number: " + countNumberPrimesLessThan(n));
    }

    boolean isPrime(int n) {

        if (n == 2) {
            return true;
        }
        int i = 2;
        while (i < sqrt(n)+1) {
            if (n % i == 0) {
                return false;
            }
                i++;
        }
        return true;
    }

    int countNumberPrimesLessThan ( int n) {
        int sum = 0, i = 2;
        while (i <= n) {
            if (isPrime(i)) {
                sum++;
            }
            i++;
        }

        return sum;
    }
}


