package com.example.studentinfosystem;   // must match your project's package and folder

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etConfirmPassword;
    private EditText etLastName, etFirstName, etMiddleName;
    private EditText etProgram, etSpecialization, etYearLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Account
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        // Student name
        etLastName = findViewById(R.id.etLastName);
        etFirstName = findViewById(R.id.etFirstName);
        etMiddleName = findViewById(R.id.etMiddleName);

        // Academic info
        etProgram = findViewById(R.id.etProgram);
        etSpecialization = findViewById(R.id.etSpecialization);
        etYearLevel = findViewById(R.id.etYearLevel);

        Button btnSignUp = findViewById(R.id.btnSignUp);
        Button btnHaveAccount = findViewById(R.id.btnHaveAccount);

        btnSignUp.setOnClickListener(v -> validateAndSubmit());
        btnHaveAccount.setOnClickListener(v -> finish());   // back to login
    }

    private void validateAndSubmit() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirm = etConfirmPassword.getText().toString();

        String lastName = etLastName.getText().toString().trim();
        String firstName = etFirstName.getText().toString().trim();
        String middleName = etMiddleName.getText().toString().trim();   // optional

        String program = etProgram.getText().toString().trim();
        String specialization = etSpecialization.getText().toString().trim(); // optional
        String yearLevel = etYearLevel.getText().toString().trim();

        if (username.isEmpty()) {
            etUsername.setError("Enter a username");
            etUsername.requestFocus();
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("At least 6 characters");
            etPassword.requestFocus();
            return;
        }
        if (!password.equals(confirm)) {
            etConfirmPassword.setError("Passwords don't match");
            etConfirmPassword.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            etLastName.setError("Enter last name");
            etLastName.requestFocus();
            return;
        }
        if (firstName.isEmpty()) {
            etFirstName.setError("Enter first name");
            etFirstName.requestFocus();
            return;
        }
        if (program.isEmpty()) {
            etProgram.setError("Enter your program");
            etProgram.requestFocus();
            return;
        }
        if (yearLevel.isEmpty()) {
            etYearLevel.setError("Enter your year level");
            etYearLevel.requestFocus();
            return;
        }

        // TODO: save to your database / API using the values above
        Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show();
        finish();   // return to login after signing up
    }
}