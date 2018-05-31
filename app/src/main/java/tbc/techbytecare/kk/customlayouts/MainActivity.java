package tbc.techbytecare.kk.customlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tbc.techbytecare.kk.customlayouts.CollapsingToolbar.CollapsingToolbarActivity;
import tbc.techbytecare.kk.customlayouts.CoverFlow.CoverFlowActivity;
import tbc.techbytecare.kk.customlayouts.CoverFlowItemClick.CoverFlowClickActivity;
import tbc.techbytecare.kk.customlayouts.InfiniteViewPager.InfiniteViewPagerActivity;
import tbc.techbytecare.kk.customlayouts.PulseView.PulseViewActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCoverFlow,btnFlowItemClick,btnCollapsing;

    Button btnInfiniteViewPager,btnPulse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCoverFlow = findViewById(R.id.btnCoverFlow);
        btnFlowItemClick = findViewById(R.id.btnCoverItemClick);
        btnCollapsing = findViewById(R.id.btnCollapsingToolbar);

        btnInfiniteViewPager = findViewById(R.id.btnInfiniteViewPager);
        btnPulse = findViewById(R.id.btnPulse);

        btnCoverFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CoverFlowActivity.class));
            }
        });

        btnFlowItemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CoverFlowClickActivity.class));
            }
        });

        btnCollapsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CollapsingToolbarActivity.class));
            }
        });

        btnInfiniteViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfiniteViewPagerActivity.class));
            }
        });

        btnPulse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PulseViewActivity.class));
            }
        });
    }
}
