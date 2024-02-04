package com.example.p8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button clearBtn,callBtn,saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextPhone);
        clearBtn=findViewById(R.id.btn_clear);
        callBtn=findViewById(R.id.btn_call);
        saveBtn=findViewById(R.id.btn_save);
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editText.setText("");
            }
        });
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String number=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL, Contacts.CONTENT_URI);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,number);
                startActivity(intent);
            }
        });
    }
        public void inputNumber(View view)
        {
            Button btn=(Button)view;
            String digit = btn.getText().toString();
            String phoneNumber=editText.getText().toString();
            editText.setText(phoneNumber+digit);
        }
    }
