package discordia.ditty;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int tempo;
    int beats;
    int cursor;
    int step;
    static int hhId;
    static int kickId;
    static int snareId;
    static int[] kick, snare, hh;
    SoundPool pool;
    InstrumentTrack track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setBackgroundDrawableResource(R.drawable.layout);

        pool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        hhId = pool.load(this, R.raw.hihat, 1);
        kickId = pool.load(this, R.raw.kick, 1);
        snareId = pool.load(this, R.raw.snare, 1);

        tempo = 160;
        beats = 16;
        cursor = 0;
        step = 1000/(tempo/30);

        //default ON-LOAD song:
        kick = new int[]{1,0,0,0, 1,1,0,0, 1,1,0,1, 0,1,0,0};
        hh = new int[]{1,1,1,1, 1,1,1,1, 1,1,1,1, 1,1,1,1};
        snare = new int[]{0,0,1,0, 0,0,1,0, 0,0,1,0, 0,0,1,0};
        track = new InstrumentTrack(step, cursor, beats, pool);



        Button Play = (Button) findViewById(R.id.play);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                track.start();
            }
        });
        Button Stop = (Button) findViewById(R.id.stop);
        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                track.setPlaying(false);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}