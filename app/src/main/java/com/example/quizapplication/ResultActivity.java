package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textview_result);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = String.valueOf(extras.getInt("Score"));
            result.setText("You Scored " + value);
        }
    }
}

