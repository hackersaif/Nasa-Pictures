package com.demo.nasapicturesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.demo.nasapicturesapp.adapter.PictureAdapter;
import com.demo.nasapicturesapp.databinding.ActivityMainBinding;
import com.demo.nasapicturesapp.model.NasaResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recycler.setLayoutManager(new GridLayoutManager(this, 3));
        PictureAdapter adapter = new PictureAdapter();
        binding.recycler.setAdapter(adapter);
        String myJson=inputStreamToString(getResources().openRawResource(R.raw.nasa));
        Type listType = new TypeToken<ArrayList<NasaResponse>>(){}.getType();
        List<NasaResponse> nasaResponseList = new Gson().fromJson(myJson,listType);
        adapter.submitList(nasaResponseList);
    }


    public String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }
}