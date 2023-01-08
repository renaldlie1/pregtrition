package com.example.pregtrition.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.example.pregtrition.R;

public class CoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        SwipeButton swipeButton = (SwipeButton)findViewById(R.id.swipe_btn);

        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {

            @Override

            public void onStateChange(boolean active) {

                Intent intent = new Intent(CoverActivity.this,LoginActivity.class);

                startActivity(intent);

            }

        });





    }
}