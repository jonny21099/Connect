package com.spaghetti.connect;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    EditText nameInput;
    EditText emailInput;
    EditText passwordInput;
    EditText registerButton;
    EditText goBacktoLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // map view elements
        nameInput = findViewById(R.id.register_name);
        emailInput = findViewById(R.id.register_name);
        passwordInput = findViewById(R.id.register_name);
        registerButton = findViewById(R.id.register_name);
        goBacktoLogin = findViewById(R.id.register_name);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        goBacktoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });





    }

    public void signup() {
        Log.d(TAG, "Signup");


    }

    public boolean validate() {
        boolean valid = true;

        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String button = registerButton.getText().toString();



        if (name.isEmpty() || name.length() < 3) {
            nameInput.setError("at least 3 characters");
            valid = false;
        } else {
            nameInput.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("enter a valid email address");
            valid = false;
        } else {
            emailInput.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordInput.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordInput.setError(null);
        }

        return valid;
    }
}