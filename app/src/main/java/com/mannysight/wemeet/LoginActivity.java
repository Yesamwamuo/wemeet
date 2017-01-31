package com.mannysight.wemeet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firstName = (EditText) findViewById(R.id.username);
        lastName = (EditText) findViewById(R.id.passwordField);
        login = (Button) findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginClicked();
            }
        });
    }

    private void loginClicked() {

//               if(getText.trim().equals("") || getText.trim().equals("")) {
//                    showToast("First Name or last name cannot be empty");
//                } else {
//                    createUser(getText(), getText());
        startActivity(new Intent(this, MainActivity.class));
//                }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
