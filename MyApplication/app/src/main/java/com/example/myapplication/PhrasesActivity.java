package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_phrases);

        final ArrayList<Phrases> linsOfPhrases = new ArrayList<Phrases>();

//             Word w = new Word("one","lutti");
//             linsOfNumbers.add(w);

        linsOfPhrases.add(new Phrases("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        linsOfPhrases.add(new Phrases("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        linsOfPhrases.add(new Phrases("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        linsOfPhrases.add(new Phrases("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        linsOfPhrases.add(new Phrases("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        linsOfPhrases.add(new Phrases("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        linsOfPhrases.add(new Phrases("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        linsOfPhrases.add(new Phrases("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        linsOfPhrases.add(new Phrases("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        linsOfPhrases.add(new Phrases("Come here.", "әnni'nem", R.raw.phrase_come_here));


//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, android.R.layout.simple_list_item_1, linsOfNumbers);
        PhrasesAdapter<Phrases> itemsPhrasesAdapter = new PhrasesAdapter<Phrases>(this, linsOfPhrases, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrases_root_id);

        listView.setAdapter((ListAdapter) itemsPhrasesAdapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Phrases phrases = linsOfPhrases.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrases.getPhraseId());

                // Start the audio file
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

