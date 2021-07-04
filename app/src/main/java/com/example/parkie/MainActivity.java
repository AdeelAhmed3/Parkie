package com.example.parkie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    TextInputLayout emailText,passwordText;
    Button signInBtn;
    SharedPreferences preferences;
    SharedPreferences.Editor prefEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        prefEditor = preferences.edit();

        if(preferences.getBoolean("signin",false)){

            Intent i = new Intent(MainActivity.this,ControlActivity.class);
            startActivity(i);
            finish();

        }
        emailText = findViewById(R.id.email_text);
        passwordText = findViewById(R.id.password_text);
        signInBtn = findViewById(R.id.signinBtn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefEditor.putBoolean("signin",true);
                prefEditor.commit();
                Intent i = new Intent(MainActivity.this,ControlActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}