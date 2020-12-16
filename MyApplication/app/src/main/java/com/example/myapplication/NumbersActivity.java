package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_numbers);



         final ArrayList<Word> linsOfNumbers = new ArrayList<Word>();

//             Word w = new Word("one","lutti");
//             linsOfNumbers.add(w);

        linsOfNumbers.add(new Word("One","Lutti", R.drawable.number_one, R.raw.number_one));
        linsOfNumbers.add(new Word("Two","Ottiko", R.drawable.number_two, R.raw.number_two));
        linsOfNumbers.add(new Word("Three","Tolookusu", R.drawable.number_three, R.raw.number_three));
        linsOfNumbers.add(new Word("Four","Oyyisa", R.drawable.number_four, R.raw.number_four));
        linsOfNumbers.add(new Word("Five","Massokka", R.drawable.number_five, R.raw.number_five));
        linsOfNumbers.add(new Word("Six","Temmolla", R.drawable.number_six, R.raw.number_six));
        linsOfNumbers.add(new Word("Seven","Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        linsOfNumbers.add(new Word("Eight","Kwainta", R.drawable.number_eight, R.raw.number_eight));
        linsOfNumbers.add(new Word("Nine","Wo'e", R.drawable.number_nine, R.raw.number_nine));
        linsOfNumbers.add(new Word("Ten","Na;aacha", R.drawable.number_ten, R.raw.number_ten));


//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, android.R.layout.simple_list_item_1, linsOfNumbers);

        WordAdapter<Word> itemsWordAdapter = new WordAdapter<Word>(this,linsOfNumbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.numbers_root_id);

        listView.setAdapter(itemsWordAdapter);


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = linsOfNumbers.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
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

