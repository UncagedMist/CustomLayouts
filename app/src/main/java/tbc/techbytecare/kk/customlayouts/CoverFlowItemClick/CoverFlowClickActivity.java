package tbc.techbytecare.kk.customlayouts.CoverFlowItemClick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import tbc.techbytecare.kk.customlayouts.R;

public class CoverFlowClickActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_flow_click);

        initData();

        adapter = new MovieAdapter(Common.movieList,this);

        coverFlow = findViewById(R.id.coverFlow);
        mTitle = findViewById(R.id.title);

        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CoverFlowClickActivity.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);

                return text;
            }
        });

        coverFlow.setAdapter(adapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());

            }

            @Override
            public void onScrolling() {

            }
        });

        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(CoverFlowClickActivity.this,MovieDetailActivity.class)
                .putExtra("movie_index",position)
                );
            }
        });
    }

    private void initData() {
        Movie movie = new Movie("Batman vs Superman",
                "The general public is concerned over having Superman on their planet and letting the Dark Knight - Batman - pursue the streets of Gotham. While this is happening, a power-phobic Batman tries to attack Superman.,Meanwhile Superman tries to settle on a decision, and Lex Luthor, the criminal mastermind and millionaire, tries to use his own advantages to fight the Man of Steel.",
                "http://cdn1-www.comingsoon.net/assets/uploads/gallery/batman-v-superman-dawn-of-justice-1400694960/bvsquad2.jpg");
        Common.movieList.add(movie);

        movie = new Movie("Civil War",
                "With many people fearing the actions of super heroes, the government decides to push for the Hero Registration Act, a law that limits a hero's actions. This results in a division in The Avengers. Iron Man stands with this Act, claiming that their actions must be kept in check otherwise cities will continue to be destroyed, but Captain America feels that saving the world is daring enough and that they cannot rely on the government to protect the world.",
                "http://www.disneytouristblog.com/wp-content/uploads/2016/05/captain_america_civil_war.jpg");
        Common.movieList.add(movie);

        movie = new Movie("Wonder Woman",
                "Diana, princess of the Amazons, trained to be an unconquerable warrior. Raised on a sheltered island paradise, when a pilot crashes on their shores and tells of a massive conflict raging in the outside world, Diana leaves her home, convinced she can stop the threat. Fighting alongside man in a war to end all wars, Diana will discover her full powers and her true destiny.",
                "https://photo2.tinhte.vn/data/attachment-files/2017/05/4055436_Wonder-Woman-Movie-Artwork.jpg");
        Common.movieList.add(movie);

        movie = new Movie("Spider Man",
                "Peter Parker is exploring the concept of becoming an Avenger. Tony Stark tries to help Peter, but he does not have total faith in Spider-Man to become a hero. And so Peter Parker, aka Spider-Man sets off to prove he is worthy to become an Avenger!",
                "https://i.ytimg.com/vi/pXQqcrXhA6c/maxresdefault.jpg");
        Common.movieList.add(movie);
    }
}
