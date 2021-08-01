package com.example.myapp2;

import android.os.Bundle;

import com.example.myapp2.utils.BaseActivity;
import com.example.myapp2.utils.MySharedPreferences;

import static com.example.myapp2.utils.MyFile.readFile;
import static com.example.myapp2.utils.MyFile.writeFile;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Http.get("123", null, new RunInner() {
//            @Override
//            public void inner(final String resStr) {
//                MainActivity.super.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        showToast(resStr);
//                    }
//                });
//            }
//        });


//        writeFile(this,"test.txt", "123");
        String s = readFile(this,"test1.txt");
        System.out.println(s);
        showToast(s);

        MySharedPreferences.writeIntoSharedPreferences(this, "213", "23", "21");
        s = (String) MySharedPreferences.readIntoSharedPreferences(this, "213", "23");
        showToast(s);


    }
}