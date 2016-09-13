package discordia.ditty;

import android.media.MediaPlayer;

/**
 * Created by dalud on 10.9.2016.
 */
public class InstrumentTrack extends Thread{

    int[] pattern;
    MediaPlayer mp;
    int step;

    public InstrumentTrack(int[] pattern, MediaPlayer mp, int step) {
        this.step = step;
        this.pattern = pattern;
        this.mp = mp;
    }

    public void run() {
        while(true) {
            if (mp.isPlaying()) mp.seekTo(0);
            else mp.start();
            try {
                sleep(step);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
