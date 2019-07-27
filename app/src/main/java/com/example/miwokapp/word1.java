package com.example.miwokapp;
public class word1 {
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;
private int iImageResourceId = NO_IMAGE_PROVIDED;
private static final int NO_IMAGE_PROVIDED=-1;
     static int mAudioResourceId;
    /*
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public word1(String defaultTranslation, String miwokTranslation,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId=audioResourceId;
    }
    public word1(String defaultTranslation,String miwokTranslation,int imageResourceId,int audioresourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        iImageResourceId=imageResourceId;
        mAudioResourceId=audioresourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getiImageResource() {
        return iImageResourceId;
    }
    public boolean hasImage(){
      return  iImageResourceId!=NO_IMAGE_PROVIDED;
    }

    public static int getmAudioResourceId() {
        return mAudioResourceId;
    }

}
