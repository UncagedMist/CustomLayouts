package tbc.techbytecare.kk.customlayouts.CoverFlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import tbc.techbytecare.kk.customlayouts.R;

public class CoverFlowActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList = new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_flow);

        initData();

        mTitle = findViewById(R.id.title);

        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CoverFlowActivity.this);

                TextView text = (TextView) inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        movieAdapter = new MovieAdapter(movieList,this);

        coverFlow = findViewById(R.id.coverFlow);
        coverFlow.setAdapter(movieAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(movieList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });
    }

    private void initData() {
        movieList.add(new Movie("Civil War","http://www.disneytouristblog.com/wp-content/uploads/2016/05/captain_america_civil_war.jpg"));
        movieList.add(new Movie("Batman vs Superman","http://cdn1-www.comingsoon.net/assets/uploads/gallery/batman-v-superman-dawn-of-justice-1400694960/bvsquad2.jpg"));
        movieList.add(new Movie("Wonder Woman","https://photo2.tinhte.vn/data/attachment-files/2017/05/4055436_Wonder-Woman-Movie-Artwork.jpg"));
        movieList.add(new Movie("Spider Man","https://i.ytimg.com/vi/pXQqcrXhA6c/maxresdefault.jpg"));
    }
}
