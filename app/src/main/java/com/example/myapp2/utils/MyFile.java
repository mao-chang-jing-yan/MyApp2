package com.example.myapp2.utils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MyFile {

    public static String readFile(Context mContext, String fileName) {
        try {
            FileInputStream inStream = mContext.openFileInput(fileName);
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }

            inStream.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writeFile(Context mContext, String fileName, String msg) {
        // 步骤1：获取输入值
        if (msg == null) return;
        try {
            // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
            FileOutputStream fos = mContext.openFileOutput(fileName,
                    0);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasFile(Context mContext, String fileName){

        return false;
    }

}
