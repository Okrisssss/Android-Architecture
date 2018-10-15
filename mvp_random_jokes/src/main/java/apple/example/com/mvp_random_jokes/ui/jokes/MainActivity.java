package apple.example.com.mvp_random_jokes.ui.jokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import apple.example.com.mvp_random_jokes.R;
import apple.example.com.mvp_random_jokes.data.api.ApiClient;
import apple.example.com.mvp_random_jokes.data.api.ApiInterface;
import apple.example.com.mvp_random_jokes.data.model.Joke;
import apple.example.com.mvp_random_jokes.data.model.JokeResponse;
import apple.example.com.mvp_random_jokes.ui.jokes.adapter.JokesAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements JokeView{
    @BindView(R.id.et_joke_id)
    EditText etJokeId;
    @BindView(R.id.btn_show_joke)
    Button btnShow;
    JokePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new JokePresenter(this);

    }

    @OnClick({R.id.btn_show_joke})
    public void showJokes(){
        presenter.showJoke(etJokeId.getText().toString());
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
}
