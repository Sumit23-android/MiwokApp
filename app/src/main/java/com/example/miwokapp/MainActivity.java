package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.FontResourcesParserCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openfamily(View view) {
        Intent i = new Intent(this, Family.class);
        startActivity(i);
    }

    public void Numberslist(View view) {
        Intent j = new Intent(this, Numbers.class);
        startActivity(j);
    }

    public void opencolors(View view) {
        Intent k = new Intent(this, colors1.class);
        startActivity(k);


    }

    public void openphrases(View view) {
        Intent l = new Intent(this, phrases1.class);
        startActivity(l);

    }
}