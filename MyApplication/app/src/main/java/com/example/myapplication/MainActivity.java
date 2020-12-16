package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         *       NumbersOnClick clickListener = new NumbersOnClick();
         * This code is for onclick funcationality for numbers textview
         * */
        TextView numbersTextView = (TextView) findViewById(R.id.numbers);
        numbersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Open The List Of Numbers",
                        Toast.LENGTH_SHORT).show();
                Intent numbersIntent = new Intent(getApplicationContext(), NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        /**
         * This code is for onclick funcationality for fa,ily members textview
         * */
    TextView familyMembersTextView = (TextView) findViewById(R.id.family);
    familyMembersTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                    "Open The List Of Family Members",
                    Toast.LENGTH_SHORT).show();
            Intent familyIntent = new Intent(getApplicationContext(), FamilyMembersActivity.class);
            startActivity(familyIntent);
        }
    });


        /**
         * This code is for onclick funcationality for phrases textview
         * */
    TextView phrasesTextView = (TextView) findViewById(R.id.phrases);
    phrasesTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                    "Open The List Of Phrases",
                    Toast.LENGTH_SHORT).show();
            Intent phrasesIntent = new Intent(getApplicationContext(), PhrasesActivity.class);
            startActivity(phrasesIntent);
        }
    });

        /**
         * This code is for onclick funcationality for colors textview
         * */
    TextView colorsTextView = (TextView) findViewById(R.id.colors);
    colorsTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                    "Open The List Of Colors",
                    Toast.LENGTH_SHORT).show();
            Intent colorsIntent = new Intent(getApplicationContext(), ColorsActivity.class);
            startActivity(colorsIntent);
        }
    });


    }
}

/**
 *             public void onclickcolors(View view) {
 *             Intent i2= new Intent(getApplicationContext(), colors.class);
 *             startActivity(i2);    }
 * */
