package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;



    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        final ArrayList<Color> linsOfColors = new ArrayList<Color>();

//             Color color = new Color("one","lutti");
//             linsOfNumbers.add(color);

        linsOfColors.add(new Color("Red", "weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        linsOfColors.add(new Color("Green", "chokokki",R.drawable.color_green, R.raw.color_green));
        linsOfColors.add(new Color("Brown", "ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        linsOfColors.add(new Color("Gray", "ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        linsOfColors.add(new Color("Black", "kululli",R.drawable.color_black, R.raw.color_black));
        linsOfColors.add(new Color("White", "kelelli",R.drawable.color_white, R.raw.color_white));
        linsOfColors.add(new Color("Dusty Yellow", "ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        linsOfColors.add(new Color("Musterd Yellow", "chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

//        ArrayAdapter<Color> ItemsAdapter = new ArrayAdapter<color>(this, android.R.layout.simple_list_item_1, linsOfNumbers);

        ColorAdapter<Color> itemsColorAdapter = new ColorAdapter<Color>(this, linsOfColors, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.colors_root_id);

        listView.setAdapter(itemsColorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Color color = linsOfColors.get(position);

                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this,color.getColorsId());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}


//        LinearLayout numbersRoot = (LinearLayout) findViewById(R.id.numbers_root_id);
//
//        for(int i=0; i<linsOfNumbers.size(); i++)
//        {
//            TextView numberTextView = new TextView(this);
//            numberTextView.setText(linsOfNumbers.get(i));
//            numbersRoot.addView(numberTextView);
//        }
