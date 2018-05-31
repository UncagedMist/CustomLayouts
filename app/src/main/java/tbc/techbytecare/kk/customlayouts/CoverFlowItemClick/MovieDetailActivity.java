package tbc.techbytecare.kk.customlayouts.CoverFlowItemClick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import tbc.techbytecare.kk.customlayouts.R;

public class MovieDetailActivity extends AppCompatActivity {

    KenBurnsView movieImage;
    TextView movieTitle,movieSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movieImage = findViewById(R.id.movie_image);
        movieSummary = findViewById(R.id.movie_summary);
        movieTitle = findViewById(R.id.movie_title);

        if (getIntent() != null)    {

            int movie_index = getIntent().getIntExtra("movie_index",-1);

            if (movie_index != -1)  {
                loadMovieDetails(movie_index);
            }
        }
    }

    private void loadMovieDetails(int index) {
        Movie movie = Common.movieList.get(index);

        Picasso.with(getBaseContext()).load(movie.getUrl()).into(movieImage);
        movieTitle.setText(movie.getTitle());
        movieSummary.setText(movie.summary);
    }
}
