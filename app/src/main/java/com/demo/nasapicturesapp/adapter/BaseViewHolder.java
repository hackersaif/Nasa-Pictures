package com.demo.nasapicturesapp.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

    V binding;

    public BaseViewHolder(V binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
