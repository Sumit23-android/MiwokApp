package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.AdapterView;
import java.util.ArrayList;

public class colors1 extends AppCompatActivity {
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
        word.add(new word1("red" , "wetetti",R.drawable.color_red,R.raw.color_red));
        word.add(new word1("mustard yellow" , "chiwitta",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        word.add(new word1("dusty yellow" , "topisa",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        word.add(new word1("green" , "chokokki",R.drawable.color_green,R.raw.color_green));
        word.add(new word1("brown" , "takkakki",R.drawable.color_brown,R.raw.color_brown));
        word.add(new word1("gray" , "topoppi",R.drawable.color_gray,R.raw.color_gray));
        word.add(new word1("black" , "kululli",R.drawable.color_black,R.raw.color_black));
        word.add(new word1("white" , "kulelli",R.drawable.color_white,R.raw.color_white));

        WordAdapter adapter = new WordAdapter(this , word,R.color.colorPrimary);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position , long l) {
                word1 words=word.get(position);
                mMediaPlayer=MediaPlayer.create(colors1.this,words.getmAudioResourceId());
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
