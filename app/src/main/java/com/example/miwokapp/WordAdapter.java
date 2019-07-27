package com.example.miwokapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<word1>  {
    private int mcolorResourceId;
    public WordAdapter(Activity context, ArrayList<word1> word,int colorResourceId){
        super(context,0,word);
        mcolorResourceId=colorResourceId;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item , parent , false);
        }
        word1 currentword = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miwokTextView.setText(currentword.getMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.miwok_default_view);

        defaultTextView.setText(currentword.getDefaultTranslation());
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentword.hasImage()) {
            miwokImageView.setImageResource(currentword.getiImageResource());
            miwokImageView.setVisibility(View.VISIBLE);
        } else {
            miwokImageView.setVisibility(View.GONE);
        }
        View textContainer=listItemView.findViewById(R.id.text_Container);
        int color= ContextCompat.getColor(getContext(),mcolorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;


    }
}