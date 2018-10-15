package apple.example.com.mvp_random_jokes.ui.jokes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import apple.example.com.mvp_random_jokes.R;
import apple.example.com.mvp_random_jokes.data.model.Joke;
import butterknife.BindView;
import butterknife.ButterKnife;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokeViewHolder>{

    private List<Joke> jokes;
    private int rowLayout;
    private Context context;
    final static private String CHUCK_NORRIS_PHOTO_URL = "https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwj5_cW_pIPeAhVI3aQKHbHABGYQjRx6BAgBEAU&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F248190629435428432%2F&psig=AOvVaw25vHtIQNvesnsrPC0qSV-3&ust=1539515549412633";

    public static class JokeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.description)
        TextView jokeDescription;
        @BindView(R.id.imageView)
        ImageView imageView;

        public JokeViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public JokesAdapter(List<Joke> jokes, int rowLayout, Context context) {
        this.jokes = jokes;
        this.rowLayout = rowLayout;
        this.context = context;
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
    Picasso.with(context).load(CHUCK_NORRIS_PHOTO_URL).resize(150,150).centerCrop().into(jokeViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }
}
