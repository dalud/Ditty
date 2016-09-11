package discordia.ditty;

import android.media.MediaPlayer;

/**
 * Created by dalud on 10.9.2016.
 */
public class InstrumentTrack extends Thread {
    int tempo, beats, cursor;
    long step;
    int[] track;
    MediaPlayer mp;

    public InstrumentTrack(int tempo, int beats, int cursor, int[] track, long step, MediaPlayer mp) {

        this.tempo = tempo;
        this.beats = beats;
        this.cursor = cursor;
        this.track = track;
        this.step = step;
        this.mp = mp;
    }
    @Override
    public void run() {
        long time = System.currentTimeMillis();
        long elapsed;
        cursor = 0;

        while(cursor < beats) {
            elapsed = System.currentTimeMillis() - time;

            if(elapsed == step) {
                if(track[cursor] != 0){
                    if(mp.isPlaying()) mp.seekTo(0);
                    else mp.start();
                }
                time = System.currentTimeMillis();
                cursor++;
            }
        }
    }
}
