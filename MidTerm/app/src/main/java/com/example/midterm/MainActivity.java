package com.example.midterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mEdtFullName, mEdtAge, mEdtAddress;
    Button mBtAdd;
    ListView mLvResult;
    ArrayList<String> arrayResults;
    ArrayAdapter<String> arrayAdapter;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtFullName = (EditText) findViewById(R.id.edt_full_name);
        mEdtAge = (EditText) findViewById(R.id.edt_age);
        mEdtAddress = (EditText) findViewById(R.id.edt_address);
        mBtAdd = (Button) findViewById(R.id.btn_add);
        mLvResult = (ListView) findViewById(R.id.lv_information);

        arrayResults = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayResults);
        mLvResult.setAdapter(arrayAdapter);

        mLvResult.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayResults.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    public void getInformation(View v){
        String st1,st2,st3;
        st1 = mEdtFullName.getText().toString();
        st2 = mEdtAge.getText().toString();
        st3 = mEdtAddress.getText().toString();

        result = st1 + "\n" + st2 + "\n" + st3;

        arrayResults.add(0, result);
        arrayAdapter.notifyDataSetChanged();
    }

}
