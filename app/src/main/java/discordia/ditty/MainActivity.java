package discordia.ditty;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    int tempo, beats, cursor;
    int[] kick, snare, hh;
    long step;
    MediaPlayer kickMP, snareMP, hhMP;
    InstrumentTrack hihaT, kickT, snareT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setBackgroundDrawableResource(R.drawable.layout);

        kickMP = MediaPlayer.create(this, R.raw.kick);
        snareMP = MediaPlayer.create(this, R.raw.snare);
        hhMP = MediaPlayer.create(this, R.raw.hihat);

        tempo = 120;
        beats = 16;
        cursor = 0;
        kick = new int[]{1,0,0,0, 1,1,0,0, 1,1,0,1, 0,1,0,0};
        hh = new int[]{1,1,1,1, 1,1,1,1, 1,1,1,1, 1,1,1,1};
        snare = new int[]{0,0,1,0, 0,0,1,0, 0,0,1,0, 0,0,1,0};
        step = 1000/(tempo/30);
        hihaT = new InstrumentTrack(tempo, beats, cursor, hh, step, hhMP);
        kickT = new InstrumentTrack(tempo, beats, cursor, kick, step, kickMP);
        snareT = new InstrumentTrack(tempo, beats, cursor, snare, step, snareMP);


        Button A = (Button) findViewById(R.id.a);
        A.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    play();
                }
                return false;
            }
        });

    }
    public void play() {
        long time = System.currentTimeMillis();
        long elapsed;
        cursor = 0;

        while(cursor < beats) {
            elapsed = System.currentTimeMillis() - time;

            if(elapsed == step) {
                if(hh[cursor] != 0){
                    if(hhMP.isPlaying()) hhMP.seekTo(0);
                    else hhMP.start();
                }
                if(kick[cursor] != 0){
                    if(kickMP.isPlaying()) kickMP.seekTo(0);
                    else kickMP.start();
                }
                if(snare[cursor] != 0){
                    if(snareMP.isPlaying()) snareMP.seekTo(0);
                    else snareMP.start();
                }
                time = System.currentTimeMillis();
                cursor++;
            }
        }
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
