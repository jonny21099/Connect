package com.spaghetti.connect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.spaghetti.connect.data.BinarySignal;
import com.spaghetti.connect.firebaseAuth.AuthHelper;
import com.spaghetti.connect.utility.InputValidator;

import java.util.Observable;
import java.util.Observer;

public class ForgotPassword extends AppCompatActivity {

    EditText emailInput;
    Button emailRecovery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailInput = findViewById(R.id.recoveryEmail);
        emailRecovery = findViewById(R.id.recovery_button);

        emailRecovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (InputValidator.Companion.validEmail(emailInput.getText().toString())) {
                    BinarySignal signal = new BinarySignal();
                    Observer onCompleteListener = new Observer() {
                        @Override
                        public void update(Observable o, Object arg) {
                            if (signal.getState()) {
                                Toast.makeText(ForgotPassword.this, "Check your email!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(ForgotPassword.this, "Something went wrong, please try again.", Toast.LENGTH_LONG).show();
                            }
                        }
                    };
                    signal.addObserver(onCompleteListener);

                    AuthHelper.passwordReset(emailInput.getText().toString(), FirebaseAuth.getInstance(), signal);
                } else {
                    Toast.makeText(ForgotPassword.this, "Invalid Email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}