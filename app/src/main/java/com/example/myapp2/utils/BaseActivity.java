package com.example.myapp2.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class BaseActivity extends AppCompatActivity {
    public Context myContext;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = this;
    }

    public void showToast(String s) {
        Toast.makeText(myContext, s, Toast.LENGTH_LONG).show();
    }

    public void navigateTo(Class<?> cls) {
        Intent in = new Intent(myContext, cls);
        startActivity(in);
    }





}
