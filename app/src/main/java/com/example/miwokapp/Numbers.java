package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
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
     final ArrayList<word1> word=new ArrayList<word1>();
        word.add(new word1("one","lutti",R.drawable.number_one,R.raw.number_one));
        word.add(new word1("two","ottiko",R.drawable.number_two,R.raw.number_two));
        word.add(new word1("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        word.add(new word1("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        word.add(new word1("five","massokka",R.drawable.number_five,R.raw.number_five));
        word.add(new word1("six","temmokka",R.drawable.number_six,R.raw.number_six));
        word.add(new word1("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        word.add(new word1("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        word.add(new word1("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        word.add(new word1("ten" , "na'achha",R.drawable.number_ten,R.raw.number_ten));
        WordAdapter adapter = new WordAdapter(this,word,R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position , long l) {
                releaseMediaPlayer();
                word1 words=word.get(position);
                mMediaPlayer=MediaPlayer.create(Numbers.this,words.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
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

