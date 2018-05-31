package tbc.techbytecare.kk.customlayouts.CoverFlowItemClick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tbc.techbytecare.kk.customlayouts.R;

public class MovieAdapter extends BaseAdapter {

    List<Movie> movieList;
    Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View rootView = view;

        if (rootView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);

            View itemView = inflater.inflate(R.layout.layout_item, null);

            TextView name = itemView.findViewById(R.id.label);
            ImageView imageView = itemView.findViewById(R.id.image);

            Picasso.with(context).load(movieList.get(position).getUrl()).into(imageView);
            name.setText(movieList.get(position).getTitle());

            return itemView;
        }
        return rootView;
    }
}
