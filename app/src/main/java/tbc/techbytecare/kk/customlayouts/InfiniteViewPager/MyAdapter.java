package tbc.techbytecare.kk.customlayouts.InfiniteViewPager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import tbc.techbytecare.kk.customlayouts.R;

public class MyAdapter extends PagerAdapter {

    List<Integer> lstImage;
    Context context;
    LayoutInflater inflater;

    public MyAdapter(List<Integer> lstImage, Context context) {
        this.lstImage = lstImage;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lstImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = inflater.inflate(R.layout.card_item,container,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(lstImage.get(position));
        container.addView(view);

        return view;
    }
}
