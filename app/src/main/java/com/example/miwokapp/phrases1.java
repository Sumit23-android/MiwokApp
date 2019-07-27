package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrases1 extends AppCompatActivity {
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
       final ArrayList<word1> word = new ArrayList<word1>();
        word.add(new word1("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        word.add(new word1("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        word.add(new word1("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        word.add(new word1("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        word.add(new word1("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        word.add(new word1("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        word.add(new word1("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        word.add(new word1("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        word.add(new word1("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        word.add(new word1("Come here.", "әnni'nem",R.raw.phrase_come_here));


        WordAdapter adapter = new WordAdapter(this, word,R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position , long l) {
                word1 words=word.get(position);
                mMediaPlayer= MediaPlayer.create(phrases1.this,words.getmAudioResourceId());
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

