package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
      final   ArrayList<word1> word = new ArrayList<word1>();
        word.add(new word1("father" , "әpә",R.drawable.family_father,R.raw.family_father));
        word.add(new word1("mother" , "әṭa",R.drawable.family_mother,R.raw.family_mother));
        word.add(new word1("son" , "angsi",R.drawable.family_son,R.raw.family_son));
        word.add(new word1("daughter" , "tune",R.drawable.family_daughter,R.raw.family_daughter));
        word.add(new word1("older brother" , "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        word.add(new word1("younger brother" , "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        word.add(new word1("older sister" , "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        word.add(new word1("younger sister" , "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        word.add(new word1("grandmother " , "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        word.add(new word1("grandfather" , "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this , word,R.color.colorAccent);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position, long l) {
                word1 words=word.get(position);
                mMediaPlayer= MediaPlayer.create(Family.this,words.getmAudioResourceId());
                mMediaPlayer.start(); mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
