package com.demo.nasapicturesapp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public abstract class BaseAdapter<T,V extends ViewDataBinding> extends ListAdapter<T, BaseViewHolder<V>> {


    protected BaseAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public BaseViewHolder<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        V binding = createBinding(parent,viewType);
        return new BaseViewHolder(binding);
    }


    protected abstract V createBinding(ViewGroup parent,int viewType);

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<V> holder, int position) {
        bind(holder.binding, getItem(position), position);
        holder.binding.executePendingBindings();
    }

    protected abstract void bind( V binding,T item,int position);

}
