package com.example.flashgo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    boolean isShowingOptions = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer1).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.flashcard_answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer1).setVisibility(View.INVISIBLE);
            }
        });/**/
        findViewById(R.id.flashcard_answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
            }
        });
        findViewById(R.id.flashcard_answer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
            }
        });
        findViewById(R.id.flashcard_answer4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer4).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        // 6TH Feature
        findViewById(R.id.toggle_choices_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingOptions) {
                    ((ImageView) (findViewById(R.id.toggle_choices_visibility))).setImageResource(R.drawable.hide_icon_foreground);
                    toggleOptions();
                } else {
                    ((ImageView) (findViewById(R.id.toggle_choices_visibility))).setImageResource(R.drawable.hide_icon_background);
                    toggleOptions();
                }
                isShowingOptions = !isShowingOptions;
            }
        });
    }

    private void toggleOptions() {
        int visibility = isShowingOptions ? View.INVISIBLE : View.VISIBLE;
        findViewById(R.id.flashcard_answer2).setVisibility(visibility);
        findViewById(R.id.flashcard_answer3).setVisibility(visibility);
        findViewById(R.id.flashcard_answer4).setVisibility(visibility);
    }
}