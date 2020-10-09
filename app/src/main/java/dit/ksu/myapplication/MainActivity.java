package dit.ksu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.HeaderViewListAdapter;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

     Handler handler;
     Runnable runnable;
     long delay_time;
     long time = 3000L;
    private Object Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent instent = new Intent(MainActivity.this,IndexMainActivity2.class);
                startActivity(instent);
                fileList();


            }
        };
    }// edn oncreate
    public void onResume(){
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable,delay_time);
        time = System.currentTimeMillis();
    }
    public void onPause(){
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time =  (System.currentTimeMillis()-time);
    }
}

