package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_family_members);


        final ArrayList<FamilyMember> linesOfFamilyMembers = new ArrayList<FamilyMember>();

//             FamilyMember family = new FamilyMember("one","lutti");
//             linsOfNumbers.add(family);


        linesOfFamilyMembers.add(new FamilyMember("Father","әpә",R.drawable.family_father, R.raw.family_father));
        linesOfFamilyMembers.add(new FamilyMember("Mother","әṭa",R.drawable.family_mother, R.raw.family_mother));
        linesOfFamilyMembers.add(new FamilyMember("Son","angsi",R.drawable.family_son, R.raw.family_son));
        linesOfFamilyMembers.add(new FamilyMember("Daughter","tune",R.drawable.family_daughter, R.raw.family_daughter));
        linesOfFamilyMembers.add(new FamilyMember("Older Brother","taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        linesOfFamilyMembers.add(new FamilyMember("Younger Brother","chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        linesOfFamilyMembers.add(new FamilyMember("Older Sister","teṭe",R.drawable.family_older_sister, R.raw.family_older_sister));
        linesOfFamilyMembers.add(new FamilyMember("Younger Sister","kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        linesOfFamilyMembers.add(new FamilyMember("Grand Mother","ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        linesOfFamilyMembers.add(new FamilyMember("Grand Father","paapa",R.drawable.family_grandfather, R.raw.family_grandfather));


//        ArrayAdapter<Color> ItemsAdapter = new ArrayAdapter<color>(this, android.R.layout.simple_list_item_1, linsOfNumbers);

        FamilyMemberAdapter<FamilyMember> itemsofFamilyMemberAdapter = new FamilyMemberAdapter<FamilyMember>(this, linesOfFamilyMembers, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.family_members_root_id);

        listView.setAdapter(itemsofFamilyMemberAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FamilyMember familyMember = linesOfFamilyMembers.get(position);

                MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this,familyMember.getFamilyMemberId());
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