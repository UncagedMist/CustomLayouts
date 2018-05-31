package tbc.techbytecare.kk.customlayouts.PulseView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gigamole.library.PulseView;

import tbc.techbytecare.kk.customlayouts.R;

public class PulseViewActivity extends AppCompatActivity {

    PulseView pulseView;
    Button btnStart,btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulse_view);

        pulseView = findViewById(R.id.pv);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulseView.startPulse();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulseView.finishPulse();
            }
        });
    }
}
