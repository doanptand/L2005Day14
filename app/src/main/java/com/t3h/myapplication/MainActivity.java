package com.t3h.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.t3h.myapplication.adapter.MusicAdapter;
import com.t3h.myapplication.model.Music;
import com.t3h.myapplication.network.MusicClient;
import com.t3h.myapplication.network.MusicService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMusic;
    private List<Music> musics;
    private MusicAdapter adapter;
    private MusicService musicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMusic = findViewById(R.id.rv_music);
        rvMusic.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        musics = new ArrayList<>();
        adapter = new MusicAdapter(musics, this);
        rvMusic.setAdapter(adapter);
        musicService = MusicClient.getInstance().create(MusicService.class);
        musicService.getAllMusics().enqueue(new Callback<List<Music>>() {
            @Override
            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
                if(response.isSuccessful()) {
                    musics.clear();
                    musics.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Music>> call, Throwable t) {

            }
        });
    }
}