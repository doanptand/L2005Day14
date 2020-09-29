package com.t3h.myapplication.network;

import com.t3h.myapplication.model.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MusicService {

    @GET("api/searchSong")
    Call<List<Music>> getAllMusics();


}
