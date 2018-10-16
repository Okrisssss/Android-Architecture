package com.example.mvp_dagger.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvp_dagger.R;
import com.example.mvp_dagger.di.Injector;
import com.example.mvp_dagger.model.Joke;
import com.example.mvp_dagger.model.JokeResponse;
import com.example.mvp_dagger.presenter.JokesPresenter;
import com.example.mvp_dagger.repository.network.ApiInterface;
import com.example.mvp_dagger.utils.TextUtils;
import com.example.mvp_dagger.view.adapter.JokesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements JokeView {
    @BindView(R.id.btn_show_joke)
    Button btnShow;
    @Inject
    JokesPresenter presenter;

    @Inject
    ApiInterface apiInterface;

    TextUtils textUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.INSTANCE.initMainComponent(this);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_show_joke})
    public void showJokes() {
        presenter.showJoke(textUtils.getRandomDigit());
    }

    @Override
    public void onJokeReceived(List<Joke> joke) {
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new JokesAdapter(joke, R.layout.joke_item, getApplicationContext()));
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Call<JokeResponse> getJokes(String jokeNumber) {
        return apiInterface.getRandomJokes(jokeNumber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Injector.INSTANCE.releaseMainComponent();
    }
}
