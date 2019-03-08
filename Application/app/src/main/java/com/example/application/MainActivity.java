package com.example.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtX;
    EditText edtY;
    TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtX = findViewById(R.id.edt_x);
        edtY = findViewById(R.id.edt_y);
        tvresult = findViewById(R.id.tv_result);
    }

    public void doCheck(View v) {
        int x,y;
        x = Integer.parseInt(edtX.getText().toString());
        y = Integer.parseInt(edtY.getText().toString());
        tvresult.setText(Integer.toString(divideBySubtraction(x,y)));
    }

    int divideBySubtraction(int x, int y){
        int count = 0;

        while ( x >= y ) {
            x = x-y;
            count ++;
        }
        return count;
    }

}
