package com.example.pookies;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etName;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnSignUp;
    private TextView tvAlreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        etEmail = findViewById(R.id.emailInput);
        etName = findViewById(R.id.nameInput);
        etPassword = findViewById(R.id.passwordInput);
        etConfirmPassword = findViewById(R.id.confirmPasswordInput);
        btnSignUp = findViewById(R.id.signupButton);
        tvAlreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);

        // Set click listener for "Already Have an Account?" TextView
        tvAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to LoginActivity
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Sign Up button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                // Simple validation
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform actual sign-up logic here (e.g., Firebase or API call)
                    Toast.makeText(SignUpActivity.this, "Sign-up successful!", Toast.LENGTH_SHORT).show();

                    // Navigate to WelcomeActivity or MainActivity
                    Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
