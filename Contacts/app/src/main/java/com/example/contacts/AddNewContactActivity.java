package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNewContactActivity extends AppCompatActivity {

    private EditText mEdtFullName, mEdtCompany, mEdtTitle, mEdtMobile, mEdtEmail;
    private TextView mTvCreatedAt;
    private ImageView mIvAvata;
    private Button mBtnCancel, mBtnSave;
    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        db = new MyDatabase(this);
        mBtnSave = (Button)findViewById(R.id.btn_save);
        mBtnCancel = (Button)findViewById(R.id.btn_cancel);

        mEdtFullName = (EditText)findViewById(R.id.edt_full_name);
        mEdtCompany = (EditText)findViewById(R.id.edt_company);
        mEdtTitle =(EditText)findViewById(R.id.edt_title);
        mEdtMobile = (EditText)findViewById(R.id.edt_mobile);
        mEdtEmail = (EditText)findViewById(R.id.edt_email);

        mTvCreatedAt = (TextView)findViewById(R.id.tv_create_at);
        mIvAvata = (ImageView)findViewById(R.id.iv_avatar);

        setOnClick();

    }

    public Contact addContacts (){
        Contact newContact = new Contact();
        newContact.setFullname(mEdtFullName.getText().toString());
        newContact.setCompany(mEdtCompany.getText().toString());
        newContact.setTitle(mEdtTitle.getText().toString());
        newContact.setMobile(mEdtMobile.getText().toString());
        newContact.setEmail(mEdtEmail.getText().toString());

        String dateInString = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).format(new Date());
        newContact.setCreatedAt(dateInString);
        newContact.setmId(db.addContact(newContact));

        return newContact;
    }

    public void setOnClick(){
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = addContacts();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("RETURN",contact);
                Log.d("huong", ""+ contact);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
