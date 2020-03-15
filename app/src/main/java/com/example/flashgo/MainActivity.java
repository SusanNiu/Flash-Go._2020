package com.example.flashgo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(0).getAnswer());
        }

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
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
        });
        /*findViewById(R.id.flashcard_answer2).setOnClickListener(new View.OnClickListener() {
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
*/
        // 6TH Feature
        /*findViewById(R.id.toggle_choices_visibility).setOnClickListener(new View.OnClickListener() {
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
        findViewById(R.id.flashcard_answer4).setVisibility(visibility);/**/
        findViewById(R.id.myAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });
        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCardDisplayedIndex++;
                if(currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }
                ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            String string1 = data.getExtras().getString("string1");
            String string2 = data.getExtras().getString("string2");
            ((TextView) findViewById(R.id.flashcard_question)).setText(string1);
            ((TextView) findViewById(R.id.flashcard_answer1)).setText(string2);
            flashcardDatabase.insertCard(new Flashcard(string1, string2));
            allFlashcards = flashcardDatabase.getAllCards();

        }

    }

    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;


}

