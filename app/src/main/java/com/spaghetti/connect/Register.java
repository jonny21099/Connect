package com.spaghetti.connect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

public class Register extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    EditText emailInput;
    EditText passwordInput;
    EditText passwordConfirmInput;
    TextView goBacktoLogin;
    Button registerButton;

    Context c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        c = this;

        // map view elements
        emailInput = findViewById(R.id.register_email);
        passwordInput = findViewById(R.id.register_password);
        passwordConfirmInput = findViewById(R.id.register_confirm_password);
        registerButton = findViewById(R.id.register_sign_up_btn);
        goBacktoLogin = findViewById(R.id.register_go_back);

        registerButton.setOnClickListener(view -> attemptRegister());
        goBacktoLogin.setOnClickListener(view -> finish());
    }

    void attemptRegister() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        String passwordConfirm = passwordConfirmInput.getText().toString();

        BinarySignal signal = new BinarySignal();
        Observer onCompleteListen = (o, arg) -> {
            if (signal.getState()) {
                Toast.makeText(c, "Success", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Register.this, MainActivity.class);
                i.putExtra("Initalize User", true);
                startActivity(i);
                finishAffinity();
            } else {
                Toast.makeText(c, "Email Address Already In Use", Toast.LENGTH_LONG).show();
            }
        };
        signal.addObserver(onCompleteListen);

        if (password.equals(passwordConfirm)
                && InputValidator.Companion.validEmail(email)
                && InputValidator.Companion.validPassword(password)) {
            AuthHelper.register(email, password, FirebaseAuth.getInstance(), signal);
        }
    }
}