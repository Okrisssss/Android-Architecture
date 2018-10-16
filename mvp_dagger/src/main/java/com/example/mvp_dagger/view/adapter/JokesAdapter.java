package com.example.mvp_dagger.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_dagger.R;
import com.example.mvp_dagger.model.Joke;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokeViewHolder>{
    @Inject
    Context applicationContext;

    private List<Joke> jokes;
    private int rowLayout;

    public static class JokeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.description)
        TextView jokeDescription;

        public JokeViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public JokesAdapter(List<Joke> jokes, int rowLayout, Context applicationContext) {
        this.jokes = jokes;
        this.rowLayout = rowLayout;
        this.applicationContext = applicationContext;
    }
    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup, false);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder jokeViewHolder, int i) {
    jokeViewHolder.jokeDescription.setText(jokes.get(i).getJoke());
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

}
