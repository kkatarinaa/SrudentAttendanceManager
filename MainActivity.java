package com.example.studentattendancemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.SimpleCursorAdapter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button entrance_button;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.text_login);
        password = findViewById(R.id.text_password);
        entrance_button = findViewById(R.id.entrance_button);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        // создаем базу данных
        databaseHelper.create_db();
        db = databaseHelper.open();

        entrance_button.setOnClickListener(v -> {
            String login_str = login.getText().toString();
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
            boolean flag = false;
            if (userCursor.moveToFirst()) {
                do {
                    if (login_str.equals(userCursor.getString(userCursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_LOGIN)))){
                        flag = true;
                    }
                } while (userCursor.moveToNext());
            }
            if (flag) {
                Intent intent = new Intent(MainActivity.this, HomePageTeacher.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, HomePageStudent.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}