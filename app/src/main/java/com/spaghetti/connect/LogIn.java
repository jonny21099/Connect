package com.spaghetti.connect;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    private static final String TAG = "LogInActivity";

    EditText logInEmailInput;
    EditText logInPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // map view elements
        logInEmailInput = findViewById(R.id.editTextTextEmailAddress);
        logInPasswordInput= findViewById(R.id.editTextNumberPassword);

        logInEmailInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        logInPasswordInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }



}