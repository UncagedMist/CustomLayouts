package tbc.techbytecare.kk.customlayouts.CoverFlow;

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

    private List<Movie> movieList;
    private Context mContext;

    public MovieAdapter(List<Movie> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
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

        View rowView = view;

        if (rowView == null)    {
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item,null);

            TextView name = rowView.findViewById(R.id.label);
            ImageView image = rowView.findViewById(R.id.image);

            Picasso.with(mContext).load(movieList.get(position).getImageURL()).into(image);
            name.setText(movieList.get(position).getName());
        }

        return rowView;
    }
}
