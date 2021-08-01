package com.example.myapp2.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
    //存数据
    public static void writeIntoSharedPreferences(Context mContext, String mSpName, String key, String value) {
        SharedPreferences mSp = mContext.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    //读数据
    public static Object readIntoSharedPreferences(Context mContext,String mSpName, String key) {
        SharedPreferences mSp = mContext.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        return mSp.getString(key, "");
    }
}
