package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    double a,b;
    EditText mEditInput;
    ListView lvHistory;
    ArrayList<String> arrayResults;
    ArrayAdapter<String> arrayAdapter;
    boolean mAddition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditInput = (EditText) findViewById(R.id.edt_input);
        lvHistory = (ListView) findViewById(R.id.lv_history);

        arrayResults = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,arrayResults);
        lvHistory.setAdapter(arrayAdapter);
    }

    public void onClick(View view){
        Toast toats = Toast.makeText(MainActivity.this ,"input again", Toast.LENGTH_SHORT);
        try {
           switch (view.getId()) {
               case R.id.btn_1:
                   mEditInput.append("1");
                   break;
               case R.id.btn_2:
                   mEditInput.append("2");
                   break;
               case R.id.btn_3:
                   mEditInput.append("3");
                   break;
               case R.id.btn_4:
                   mEditInput.append("4");
                   break;
               case R.id.btn_5:
                   mEditInput.append("5");
                   break;
               case R.id.btn_6:
                   mEditInput.append("6");
                   break;
               case R.id.btn_7:
                   mEditInput.append("7");
                   break;
               case R.id.btn_8:
                   mEditInput.append("8");
                   break;
               case R.id.btn_9:
                   mEditInput.append("9");
                   break;
               case R.id.btn_0:
                   mEditInput.append("0");
                   break;
               case R.id.btn_doc:
                   mEditInput.append(".");
                   break;

//
//               case R.id.btn_add :
//                   mAddition = true;
//                   if (!Double.isNaN(a)){
//                       b = Double.parseDouble(mEditInput.getText().toString());
//                       a=a+b;
//                   }
//                   else
           }
       }
       catch (NumberFormatException e ){
            toats.show();
       }

    }

    public void doClearC(View view){
        arrayResults.clear();
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText("");
    }

    public void doClearCe(View view){
        mEditInput.setText("");
    }

    public void doDelete(View view){
        String st = mEditInput.getText().toString();
        if ( st.length() > 0 ) {
            st = st.substring(0, st.length() - 1);
            mEditInput.setText(st);
        }
    }

    public  void doReset(View view){
        arrayResults.removeAll(arrayResults);
        arrayAdapter.notifyDataSetChanged();
    }
    public void doPercent(View view){

        a = Double.parseDouble(mEditInput.getText().toString());
        double result = a/100;
        String stringResult = a + "%" + " = " + result;
        arrayResults.add(0,stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(Double.toString(result));

    }

    public void doSqrt(View view){

        a = Double.parseDouble(mEditInput.getText().toString());
        double result = Math.sqrt(a);
        String stringResult = "√(" + a + ") = " + result;
        arrayResults.add(0,stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(Double.toString(result));
    }

    public void doSquare(View view){

        a = Double.parseDouble(mEditInput.getText().toString());
        double result = a*a;
        String stringResult = a + "^2" + " = " + result;
        arrayResults.add(0,stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(Double.toString(result));

    }

    public void doOneDivX(View view){

        a = Double.parseDouble(mEditInput.getText().toString());
        double result = 1/a;
        String stringResult = "1/" +a+ " = " + result;
        arrayResults.add(0,stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(Double.toString(result));

    }
    public void  doPlusMinus(View view){
        a = Double.parseDouble(mEditInput.getText().toString());
        double result = a *(-1);
        String stringResult = "+-" +a+ " = " + result;
        arrayResults.add(0,stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(Double.toString(result));
    }


    public void doAddition(View view){
        mAddition = true;
        if (!Double.isNaN(a)){
            b = Double.parseDouble(mEditInput.getText().toString());
            a = a + b;

        }
        else
            a = Double.parseDouble(mEditInput.getText().toString());
        String stringResult = a + " +";
        arrayResults.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(null);

    }

    public void doEqual(View view){
        double result = 0;
        if (!Double.isNaN(a)){
            b = Double.parseDouble(mEditInput.getText().toString());
            result = a + b;
        }
        arrayResults.add(Double.toString(result));
        arrayAdapter.notifyDataSetChanged();
        mEditInput.setText(Double.toString(result));
    }
//
//    public void doAddition(View v) {
//        int a , b;
//        a = Integer.parseInt(mEditInput.getText().toString());
//        b = Integer.parseInt(mEditInput.getText().toString());
//        String stringResult = a + " + " + b + " = " + (a+b);
//        arrayResults.add(0,stringResult);
//        arrayAdapter.notifyDataSetChanged();
//    }
//
//    public void doSubtraction(View v) {
//        int a , b;
//        a = Integer.parseInt(mEditInput.getText().toString());
//        b = Integer.parseInt(mEditInput.getText().toString());
//        String stringResult = a + " + " + b + " = " + (a-b);
//        arrayResults.add(0,stringResult);
//        arrayAdapter.notifyDataSetChanged();
//
//    }
//    public void doMultiply (View v) {
//        float a , b;
//        a = Float.parseFloat(mEditInput.getText().toString());
//        b = Float.parseFloat(mEditInput.getText().toString());
//        String stringResult = a + " * " + b + " = " + (a*b);
//        arrayResults.add(0,stringResult);
//        arrayAdapter.notifyDataSetChanged();
//    }
//
//    public void doDivision(View v) {
//        float a , b;
//        a = Float.parseFloat(mEditInput.getText().toString());
//        b = Float.parseFloat(mEditInput.getText().toString());
//        String stringResult = a + " / " + b + " = " + (a/b);
//        arrayResults.add(0,stringResult);
//        arrayAdapter.notifyDataSetChanged();
//    }

}
