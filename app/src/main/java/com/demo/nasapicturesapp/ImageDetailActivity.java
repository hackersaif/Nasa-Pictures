package com.demo.nasapicturesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.demo.nasapicturesapp.databinding.ActivityImageDetailBinding;
import com.demo.nasapicturesapp.model.NasaResponse;

import java.util.concurrent.ExecutionException;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityImageDetailBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_image_detail);

        NasaResponse data = ((NasaResponse) getIntent().getSerializableExtra("data"));

        Glide.with(this)
                    .asBitmap()
                    .load(data.getHdurl())
                    .apply(new RequestOptions().override(200, 200))
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.05f)
                    .placeholder(R.drawable.place_holder)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.img.setImageBitmap(resource);
                            }
                        });
                        return false;
                    }
                })
                    .submit();



        binding.txt.setText("Title: "+data.getTitle()+"\n"+"Date: "+data.getDate()+"\n"+
        "Copyright: "+data.getCopyright()+ "Explanation: "+data.getExplanation());

    }

}