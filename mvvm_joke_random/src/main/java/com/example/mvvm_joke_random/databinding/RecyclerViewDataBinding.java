package com.example.mvvm_joke_random.databinding;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.mvvm_joke_random.data.model.Joke;

import java.util.List;

public class RecyclerViewDataBinding {
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, JokesAdapter adapter, List<Joke> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
