package com.t3h.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicClient {
    private static Retrofit INSTANCE;

    private MusicClient() {
    }
    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl("https://songserver.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }
}
