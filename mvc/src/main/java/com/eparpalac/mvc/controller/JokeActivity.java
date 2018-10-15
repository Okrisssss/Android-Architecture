package com.eparpalac.mvc.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.eparpalac.mvc.R;
import com.eparpalac.mvc.api.ApiClient;
import com.eparpalac.mvc.api.ApiInterface;
import com.eparpalac.mvc.model.Joke;
import com.eparpalac.mvc.model.JokeResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeActivity extends AppCompatActivity {

    @BindView(R.id.et_joke_id)
    EditText etJokeId;

    @BindView(R.id.tv_joke)
    TextView tvJoke;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        showJoke(etJokeId.getText().toString());

    }

    public void showJoke(String jokeId) {
        apiInterface
                .getJoke(jokeId)
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            Joke joke = data.getJoke();
                            tvJoke.setText(joke.getJokeText());
                        } else {
                            tvJoke.setText("Something went wrong!");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JokeResponse> call, @NonNull Throwable t) {
                        call.cancel();
                        tvJoke.setText(t.getMessage());
                    }
                });
    }
}
