package tbc.techbytecare.kk.customlayouts.InfiniteViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import tbc.techbytecare.kk.customlayouts.R;

public class InfiniteViewPagerActivity extends AppCompatActivity {

    List<Integer> lstImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_view_pager);

        initData();

        HorizontalInfiniteCycleViewPager pager = findViewById(R.id.horizontal_cycle);
        MyAdapter adapter = new MyAdapter(lstImages,this);
        pager.setAdapter(adapter);
    }

    private void initData() {
        lstImages.add(R.drawable.cyclos);
        lstImages.add(R.drawable.meggan);
        lstImages.add(R.drawable.night);
    }
}
