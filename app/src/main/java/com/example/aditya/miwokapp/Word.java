package com.example.aditya.miwokapp;

/**
 * Created by aditya on 28-03-2017.
 */

public class Word {


    private String mDefaultTranslation,mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
                mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation,String miwokTranslation,int imageResourceId,int audioResourceId)

    {
        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage() {
                return mImageResourceId != NO_IMAGE_PROVIDED;
            }
    /**
     +     * Return the audio resource ID of the word.
     +     */
     public int getAudioResourceId() {
                return mAudioResourceId;
           }






}
