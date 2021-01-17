package com.spaghetti.connect;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        Intent i = new Intent(StartUpActivity.this, Register.class);
        startActivity(i);
        Intent i2 = new Intent(StartUpActivity.this, LogIn.class);
        startActivity(i2);

    }

}