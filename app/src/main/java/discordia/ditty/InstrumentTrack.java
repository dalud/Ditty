package discordia.ditty;

import android.media.SoundPool;

/**
 * Created by dalud on 10.9.2016.
 */
public class InstrumentTrack {

    int step, cursor, beats;
    SoundPool pool;
    private volatile boolean playing = true;

    public InstrumentTrack(int step, int cursor, int beats, SoundPool pool) {
        this.step = step;
        this.cursor = cursor;
        this.beats = beats;
        this.pool = pool;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void start() {

        while (cursor < beats) {
            if (!playing) break;

            if (MainActivity.kick[cursor] != 0) {
                pool.play(MainActivity.kickId, 1, 1, 1, 0, 1);
            }
            if (MainActivity.hh[cursor] != 0) {
                pool.play(MainActivity.hhId, 1, 1, 1, 0, 1);
            }
            if (MainActivity.snare[cursor] != 0) {
                pool.play(MainActivity.snareId, 1, 1, 1, 0, 1);
            }

            try {
                Thread.sleep(step);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cursor++;
            if (cursor == beats) cursor = 0;
        }
    }
}