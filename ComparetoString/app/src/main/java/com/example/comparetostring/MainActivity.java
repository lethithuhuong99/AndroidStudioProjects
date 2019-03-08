package com.example.comparetostring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText edtA;
    EditText edtB;
    ListView lvResult;
    ArrayList<String> arrayResults;
    ArrayAdapter<String> arrayAdapter;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = (EditText) findViewById(R.id.edt_a);
        edtB = (EditText) findViewById(R.id.edt_b);
        lvResult = (ListView) findViewById(R.id.lv_result);

        arrayResults = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayResults);
        lvResult.setAdapter(arrayAdapter);
    }

    public void doCompare(View v) {
        String st1, st2;
        st1 = edtA.getText().toString();
        st2 = edtB.getText().toString();
        arrayResults.add(0, compare(st1, st2));
        arrayAdapter.notifyDataSetChanged();
    }

    public String compare(String st1, String st2) {
        result = "String 1: " + st1 + "\n" + "String 2:" + st2 + "\n";
        if (st1.length() > st2.length())
            result += "String 1 longer than string 2." + "\n";
        else if (st1.length() < st2.length())
            result += "String 1 shorter than string 2." +"\n";
        else
            result += "String 1 equal string 2." + "\n";

        return result;
    }

    public void doCount(View v) {
        String st1, st2;
        st1 = edtA.getText().toString();
        st2 = edtB.getText().toString();
        StringTokenizer strTok1 = new StringTokenizer(st1, " ");
        StringTokenizer strTok2 = new StringTokenizer(st2, " ");
        ArrayList<String> results = new ArrayList<String>();

        while (strTok1.hasMoreElements()) {
            String wordA = strTok1.nextElement().toString();
            strTok2 = new StringTokenizer(st2, " ");

            while (strTok2.hasMoreElements()) {
                String wordB = strTok2.nextElement().toString();
                if (wordB.equals(wordA)) {
                    results.add(wordB);
                }
            }
        }
        arrayResults.add(0, "" + results.size()+ " same word(s)");
        arrayAdapter.notifyDataSetChanged();
    }
}
