package com.example.p3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailtext,passwordtext;
    String remail,rPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailtext=findViewById(R.id.editTextEmail);
        passwordtext=findViewById(R.id.editTextPassword);
        remail=getIntent().getStringExtra("email");
        rPassword=getIntent().getStringExtra("password");

    }
    public void login(View view){
        String email=emailtext.getText().toString();
        String password=passwordtext.getText().toString();
        if(remail.equals(email) && rPassword.equals(password)){
            Intent intent=new Intent(this,LoginSuccesfull.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show();
        }
    }

}