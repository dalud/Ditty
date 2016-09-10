package discordia.ditty;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setBackgroundDrawableResource(R.drawable.layout);

        int tempo, beats, cursor;
        MediaPlayer kickMP = MediaPlayer.create(this, R.raw.kick);
        MediaPlayer snareMP = MediaPlayer.create(this, R.raw.snare);
        MediaPlayer hhMP = MediaPlayer.create(this, R.raw.hihat);
        int[] kick, snare, hh;

        //song, myöhemmin oma class prolly
        tempo = 120;
        beats = 16;
        cursor = 0;
        kick = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0};
        hh = new int[]{1,1,1,1, 1,1,1,1, 1,1,1,1, 1,1,1,1};
        snare = new int[]{0,0,1,0, 0,0,1,0, 0,0,1,0, 0,0,1,0};

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
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }
}
