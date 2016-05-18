package com.example.sean.hellomoon;

/**
 * Created by Sean on 5/17/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {

    private Button playButton;
    private Button stopButton;
    private AudioPlayer audioPlayer = new AudioPlayer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreateView(layoutInflater, viewGroup, savedInstanceState);

        View view = layoutInflater.inflate(R.layout.fragment_hello_moon, viewGroup, false);

        wirePlayButton(view);
        wireStopButton(view);

        return view;
    }

    private void wireStopButton(View view) {
        stopButton = (Button)view.findViewById(R.id.hellomoon_stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                audioPlayer.stop();
            }
        });
    }

    private void wirePlayButton(View view) {
        playButton = (Button)view.findViewById(R.id.hellomoon_playButton);
        playButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                audioPlayer.play(getActivity());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        audioPlayer.stop();
    }
}