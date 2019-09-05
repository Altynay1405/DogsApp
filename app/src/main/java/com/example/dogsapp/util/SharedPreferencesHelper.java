package com.example.dogsapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class SharedPreferencesHelper {

    private static final String PREF_TIME = "Pref time";
    private static SharedPreferencesHelper instance;
    private SharedPreferences prefs;

    private SharedPreferencesHelper(Context context){
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferencesHelper getInstance(Context context){
        if (instance == null){
            instance = new SharedPreferencesHelper(context);
        }
        return instance;
    }

    public void saveUpdateTime(long time){ //store information
        prefs.edit().putLong(PREF_TIME, time).apply();
    }

    public long getUpdatedTime(){  //retrieve information
        return prefs.getLong(PREF_TIME, 0);
    }

    public String getCacheDuration(){
        return prefs.getString("pref_cache_duration", "");
    }
}
