package com.example.aditya.miwokapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created by aditya on 28-03-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int bgcolor;
    public WordAdapter(Context context, ArrayList<Word> pWords,int background_color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0, pWords);
        bgcolor = background_color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());


        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Set the theme color for the list item
               View textContainer = listItemView.findViewById(R.id.text_container);
                // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), bgcolor);
                // Set the background color of the text container View
                        textContainer.setBackgroundColor(color);


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.ImageView);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if (currentWord.hasImage()) {
                        // If an image is available, display the provided image based on the resource ID
                                imageView.setImageResource(currentWord.getImageResourceId());
                        // Make sure the view is visible
                              imageView.setVisibility(View.VISIBLE);
                   } else {
                        // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
                   }


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.


        return listItemView;
    }
}
