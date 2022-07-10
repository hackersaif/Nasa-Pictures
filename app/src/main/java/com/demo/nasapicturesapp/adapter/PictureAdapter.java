package com.demo.nasapicturesapp.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.demo.nasapicturesapp.ImageDetailActivity;
import com.demo.nasapicturesapp.R;
import com.demo.nasapicturesapp.databinding.RowNasaBinding;
import com.demo.nasapicturesapp.model.NasaResponse;

public class PictureAdapter extends BaseAdapter<NasaResponse, RowNasaBinding>{
    
    static DiffUtil.ItemCallback<NasaResponse> diffCallback = new DiffUtil.ItemCallback<NasaResponse>() {
        @Override
        public boolean areItemsTheSame(@NonNull NasaResponse oldItem, @NonNull NasaResponse newItem) {
            return oldItem.getUrl().equals(newItem.getUrl());
        }

        @Override
        public boolean areContentsTheSame(@NonNull NasaResponse oldItem, @NonNull NasaResponse newItem) {
            return oldItem.equals(newItem);
        }
    };

    public PictureAdapter() {
        super(diffCallback);
    }

    @Override
    protected RowNasaBinding createBinding(ViewGroup parent, int viewType) {
        RowNasaBinding binding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.row_nasa,
                        parent,
                        false);
        return binding;
    }

    @Override
    protected void bind(RowNasaBinding binding, NasaResponse item, int position) {
        Glide.with(binding.img.getContext())
                .load(item.getUrl())
                .apply(new RequestOptions().override(200, 200))
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .thumbnail(0.05f)
                .placeholder(R.drawable.place_holder)
                .listener(new RequestFutureTarget<>(200,200){
                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        super.onLoadCleared(placeholder);
                    }

                    @Override
                    public void onLoadStarted(@Nullable Drawable placeholder) {
                        super.onLoadStarted(placeholder);
                    }

                    @Override
                    public synchronized void onLoadFailed(@Nullable Drawable errorDrawable) {
                        super.onLoadFailed(errorDrawable);
                    }

                    @Override
                    public synchronized void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        super.onResourceReady(resource, transition);
                    }

                    @Override
                    public synchronized boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return super.onLoadFailed(e, model, target, isFirstResource);
                    }
                })
                .into(binding.img);

        binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.img.getContext().startActivity(new Intent(binding.img.getContext(), ImageDetailActivity.class).putExtra("data",item));
            }
        });
    }

}
