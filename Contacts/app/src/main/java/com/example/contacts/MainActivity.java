package com.example.contacts;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvContacts;
    Button mBtnAdd;
    ArrayList<String> listContacts;
    ArrayAdapter<String> adapter;
    ArrayList<Contact> listObjectContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvContacts = (ListView)findViewById(R.id.lv_contact);
        mBtnAdd = (Button)findViewById(R.id.btn_add_contact);

        listContacts = new ArrayList<String>();
        listObjectContact = new ArrayList<Contact>();
        Contact contact1 = new Contact("Thu Huong", "VNUK", "Mss", "0832031576", "huong.le170205@vnuk.edu.vn");
        Contact contact2 = new Contact("Hoang Quan", "VNUK", "Mr", "0123456789", "quan.hoang170203@vnuk.edu.vn");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listContacts);
        lvContacts.setAdapter(adapter);
        listContacts.add(contact1.getFullname());
        listContacts.add(contact2.getFullname());
        listObjectContact.add(contact1);
        listObjectContact.add(contact2);
        adapter.notifyDataSetChanged();
        setOnClickOnItem();
        onClickAddBtn();
    }

    public Contact findContact (String name) {
        for (Contact contact:listObjectContact) {
            if (name == contact.getFullname())
                return contact;
        }
        return null;
    }

    public void setOnClickOnItem(){
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditContactActivity.class);
                String item = lvContacts.getItemAtPosition(position).toString();
                Contact getContact = findContact(item);
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Contact", getContact);
                intent.putExtra("My package", bundle);
                startActivity(intent);
            }
        });
    }

    public void onClickAddBtn() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewContactActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Contact contact = (Contact) data.getExtras().getSerializable("RETURN");

            listObjectContact.add(contact);
            listContacts.add(contact.getFullname());
            adapter.notifyDataSetChanged();
        }
    }
}
