package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditContactActivity extends AppCompatActivity {

    private EditText mEdtFullName, mEdtCompany, mEdtTitle, mEdtMobile, mEdtEmail;
    private TextView mTvCreatedAt;
    private ImageView mIvAvata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        mEdtFullName = (EditText)findViewById(R.id.edt_full_name);
        mEdtCompany = (EditText)findViewById(R.id.edt_company);
        mEdtTitle =(EditText)findViewById(R.id.edt_title);
        mEdtMobile = (EditText)findViewById(R.id.edt_mobile);
        mEdtEmail = (EditText)findViewById(R.id.edt_email);

        mTvCreatedAt = (TextView)findViewById(R.id.tv_create_at);
        mIvAvata = (ImageView)findViewById(R.id.iv_avatar);

        Intent intentData = getIntent();
        Bundle packBundle = intentData.getBundleExtra("My package");
        Contact getContact = (Contact)packBundle.getSerializable("Contact");

        mEdtFullName.setText(getContact.getFullname());
        mEdtCompany.setText(getContact.getCompany());
        mEdtTitle.setText(getContact.getTitle());
        mEdtMobile.setText(getContact.getMobile());
        mEdtEmail.setText(getContact.getEmail());
//        mTvCreatedAt.setText(getContact.getCreatedAt().toString());
    }
}
