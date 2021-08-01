package com.example.myapp2.api;

import android.util.Log;

import com.example.myapp2.My2;
import com.example.myapp2.utils.StringUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Http {
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//            .addInterceptor(new Interceptor() {
//                @Override
//                public @NotNull Response intercept(@NotNull Chain chain) throws IOException {
//                    return null;
//                }
//            })
//            .cookieJar(new CookieJar() {
//                @Override
//                public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list) {
//
//                }
//
//                @Override
//                public @NotNull List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
//                    return null;
//                }
//            })
//            .connectTimeout(8000, TimeUnit.MILLISECONDS)
            .build();

    public static void get(String url, @Nullable Object data, RunInner runInner) {
        Request request = new Request.Builder()
                .get()
                .url("https://www.baidu.com/s?wd=123")
                .build();

        run(request, runInner);
    }

    public static void run(Request request, RunInner runInner) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.i("TAG", e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                if (!response.isSuccessful()) {
                    Log.i(String.valueOf(response.code()), response.toString());
                    return;
                }
                String resStr = response.body().string();
                runInner.inner(resStr);
                Log.i(String.valueOf(response.code()),  resStr);
            }
        });
    }
}
