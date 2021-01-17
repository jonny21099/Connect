package com.spaghetti.connect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.spaghetti.connect.data.BinarySignal;
import com.spaghetti.connect.firebaseAuth.AuthHelper;
import com.spaghetti.connect.utility.InputValidator;

import java.util.Observable;
import java.util.Observer;

public class LogIn extends AppCompatActivity {

    private static final String TAG = "LogInActivity";

    EditText logInEmailInput;
    EditText logInPasswordInput;
    Button loginButton;
    TextView recoveryButton;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // map view elements
        logInEmailInput = findViewById(R.id.editTextTextEmailAddress);
        logInPasswordInput= findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.login_button);
        recoveryButton = findViewById(R.id.login_reset_password);
        registerButton = findViewById(R.id.login_signup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logInEmailInput.getText().toString();
                String password = logInPasswordInput.getText().toString();

                BinarySignal signal = new BinarySignal();
                Observer onCompleteListener = new Observer() {
                    @Override
                    public void update(Observable o, Object arg) {
                        if (signal.getState()) {
                            Intent i = new Intent(LogIn.this, MainActivity.class);
                            startActivity(i);
                            finishAffinity();
                        } else {
                            Toast.makeText(LogIn.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                        }
                    }
                };
                signal.addObserver(onCompleteListener);

                if (InputValidator.Companion.validEmail(email) && InputValidator.Companion.validPassword(password)) {
                    AuthHelper.signIn(email, password, FirebaseAuth.getInstance(), signal);
                }
            }
        });

        //TODO change to open password reset class
        recoveryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this, ForgotPassword.class);
                startActivity(i);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this, Register.class);
                startActivity(i);
            }
        });
    }



}