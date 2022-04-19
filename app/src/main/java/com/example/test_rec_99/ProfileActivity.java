package com.example.test_rec_99;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView title_textview = findViewById(R.id.title_textview);

        String title_txt = "TITLE NOT SET";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title_txt = extras.getString("Title");
        }

        title_textview.setText(title_txt);
    }
}