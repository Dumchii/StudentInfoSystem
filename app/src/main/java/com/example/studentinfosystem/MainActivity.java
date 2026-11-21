package com.example.studentinfosystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnForgot, btnMakeAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnForgot = findViewById(R.id.btnForgot);
        btnMakeAccount = findViewById(R.id.btnMakeAccount);

        btnLogin.setOnClickListener(v -> attemptLogin());

        btnForgot.setOnClickListener(v ->
                Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show());

        btnMakeAccount.setOnClickListener(v ->
                startActivity(new Intent(this, SignUpActivity.class)));
    }

    private void attemptLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();

        if (username.isEmpty()) {
            etUsername.setError("Enter your username");
            etUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Enter your password");
            etPassword.requestFocus();
            return;
        }

        // TODO: check the username and password against your database / API
        Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();

    }
}