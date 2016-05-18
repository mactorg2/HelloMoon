package com.example.sean.hellomoon;
/**
 * Created by Sean on 5/17/2016.
 */

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void play(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.one_small_step);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.stop();
            }
        });
        mediaPlayer.start();
    }
}