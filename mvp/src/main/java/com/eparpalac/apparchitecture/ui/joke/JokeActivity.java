package com.eparpalac.apparchitecture.ui.joke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.eparpalac.apparchitecture.R;
import com.eparpalac.apparchitecture.data.model.Joke;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JokeActivity extends AppCompatActivity implements JokeView {

    @BindView(R.id.et_joke_id)
    EditText etJokeId;

    @BindView(R.id.tv_joke)
    TextView tvJoke;

    JokePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        ButterKnife.bind(this);

        presenter = new JokePresenter(this);

    }

    @OnClick(R.id.btn_show_joke)
    public void showJoke(View view) {
        presenter.showJoke(etJokeId.getText().toString());
    }

    @Override
    public void onJokeReceived(Joke joke) {
        tvJoke.setText(joke.getJokeText());
    }

    @Override
    public void onError(String message) {
        tvJoke.setText(message);
    }
}
