package com.example.studentattendancemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageTeacher extends AppCompatActivity {

    private Button checkVisitsTeacher;
    private Button getVisitsTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_teacher);

        checkVisitsTeacher = findViewById(R.id.checkVisitsTeacher);
        getVisitsTeacher = findViewById(R.id.getVisitsTeacher);

        checkVisitsTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageTeacher.this, CheckVisitsTeacher.class);
                startActivity(intent);
            }
        });

        getVisitsTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageTeacher.this, CameraTeacher.class);
                startActivity(intent);
            }
        });
    }
}