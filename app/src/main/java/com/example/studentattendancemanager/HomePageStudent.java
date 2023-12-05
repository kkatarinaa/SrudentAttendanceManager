package com.example.studentattendancemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageStudent extends AppCompatActivity {

    private Button checkVisitsStudent;
    private Button getVisitsStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_student);

        checkVisitsStudent = findViewById(R.id.checkVisitsStudent);
        getVisitsStudent = findViewById(R.id.getVisitStudent);

        checkVisitsStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageStudent.this, CheckVisitsStudent.class);
                startActivity(intent);
            }
        });

        getVisitsStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageStudent.this, QRCodeStudent.class);
                startActivity(intent);
            }
        });
    }
}