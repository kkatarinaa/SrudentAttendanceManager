package com.example.studentattendancemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button entrance_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.text_login);
        password = findViewById(R.id.text_password);
        entrance_button = findViewById(R.id.entrance_button);

        entrance_button.setOnClickListener(v -> {
            String login_str = login.getText().toString();
            if (login_str.equals("teacher")) {
                Intent intent = new Intent(MainActivity.this, HomePageTeacher.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, HomePageStudent.class);
                startActivity(intent);
            }
        });

    }
}