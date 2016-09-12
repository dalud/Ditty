package discordia.ditty;

import android.media.MediaPlayer;

/**
 * Created by dalud on 10.9.2016.
 */
public class InstrumentTrack {

    int[] pattern;
    MediaPlayer mp;

    public InstrumentTrack(int[] pattern, MediaPlayer mp) {

        this.pattern = pattern;
        this.mp = mp;
    }

    public void run(int i) {
        if(pattern[i] != 0) {
            if (mp.isPlaying()) mp.seekTo(0);
            else mp.start();
        }
    }
}
