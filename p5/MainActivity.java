package com.example.p5;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    TextView textCounter;
    int i = 1;
    Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        textCounter = findViewById(R.id.textView);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customHandler.postDelayed(updateTimerThread,0);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            customHandler.removeCallbacks(updateTimerThread); }
        });
    }
    private final Runnable updateTimerThread=new Runnable() { @Override
    public void run() {
        textCounter.setText(""+i);
        customHandler.postDelayed(this,1000);
        i++;
    } };
}