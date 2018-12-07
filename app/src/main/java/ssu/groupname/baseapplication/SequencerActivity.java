package ssu.groupname.baseapplication;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SequencerActivity extends AppCompatActivity {

    Button crash[], hihat[], snare[], kick[];
    private boolean crash_is_pressed[], hihat_is_pressed[], snare_is_pressed[], kick_is_pressed[];
    private SoundPool sp;
    private int hihat_sound, crash_sound, kick_sound, snare_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequencer);



//            crash[0] = (Button) findViewById(R.id.crash1);
//            hihat[0] = (Button) findViewById(R.id.hihat1);
//            snare[0] = (Button) findViewById(R.id.snare1);
//            kick[0] = (Button) findViewById(R.id.kick1);
//
//            crash[1] = (Button) findViewById(R.id.crash2);
//            hihat[1] = (Button) findViewById(R.id.hihat2);
//            snare[1] = (Button) findViewById(R.id.snare2);
//            kick[1] = (Button) findViewById(R.id.kick2);
//
//            crash[2] = (Button) findViewById(R.id.crash3);
//            hihat[2] = (Button) findViewById(R.id.hihat3);
//            snare[2] = (Button) findViewById(R.id.snare3);
//            kick[2] = (Button) findViewById(R.id.kick3);
//
//            crash[3] = (Button) findViewById(R.id.crash4);
//            hihat[3] = (Button) findViewById(R.id.hihat4);
//            snare[3] = (Button) findViewById(R.id.snare4);
//            kick[3] = (Button) findViewById(R.id.kick4);
//
//            crash[4] = (Button) findViewById(R.id.crash5);
//            hihat[4] = (Button) findViewById(R.id.hihat5);
//            snare[4] = (Button) findViewById(R.id.snare5);
//            kick[4] = (Button) findViewById(R.id.kick5);
//
//            crash[5] = (Button) findViewById(R.id.crash6);
//            hihat[5] = (Button) findViewById(R.id.hihat6);
//            snare[5] = (Button) findViewById(R.id.snare6);
//            kick[5] = (Button) findViewById(R.id.kick6);
//
//            crash[6] = (Button) findViewById(R.id.crash7);
//            hihat[6] = (Button) findViewById(R.id.hihat7);
//            snare[6] = (Button) findViewById(R.id.snare7);
//            kick[6] = (Button) findViewById(R.id.kick7);
//
//            crash[7] = (Button) findViewById(R.id.crash8);
//            hihat[7] = (Button) findViewById(R.id.hihat8);
//            snare[7] = (Button) findViewById(R.id.snare8);
//            kick[7] = (Button) findViewById(R.id.kick8);
//
//            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//
//            hihat_sound = sp.load(this, R.raw.hihat, 1);
//            kick_sound = sp.load(this, R.raw.basskick, 1);
//            crash_sound = sp.load(this, R.raw.crash, 1);
//            snare_sound = sp.load(this, R.raw.snare, 1);

//            for(int i = 0; i < 8; i++)
//            {
//                crash_is_pressed[i] = false;
//                hihat_is_pressed[i] = false;
//                snare_is_pressed[i] = false;
//                kick_is_pressed[i] = false;
//
//            }
//
//            for(int i = 0; i < 8; i++) {
//                int iteration = i;
//                crash[iteration].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (crash_is_pressed[iteration] == true) {
//                            crash[iteration].setBackgroundColor(getResources().getColor(R.color.lightpurple));
//                            crash_is_pressed[iteration] = true;
//                        } else
//                            crash[iteration].setBackgroundColor(getResources().getColor(R.color.darkpurple));
//                            crash_is_pressed[iteration] = false;
//                    }
//                });
//
//                hihat[iteration].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (hihat_is_pressed[iteration] == true) {
//                            hihat[iteration].setBackgroundColor(getResources().getColor(R.color.lightpurple));
//                            hihat_is_pressed[iteration] = true;
//                        } else
//                            hihat[iteration].setBackgroundColor(getResources().getColor(R.color.darkpurple));
//                            hihat_is_pressed[iteration] = true;
//                    }
//                });
//
//                kick[iteration].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (kick_is_pressed[iteration] == false) {
//                            kick[iteration].setBackgroundColor(getResources().getColor(R.color.lightpurple));
//                            kick_is_pressed[iteration] = true;
//                        } else
//                            kick[iteration].setBackgroundColor(getResources().getColor(R.color.darkpurple));
//                            kick_is_pressed[iteration] = false;
//                    }
//                });
//
//                snare[iteration].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (snare_is_pressed[iteration] == true) {
//                            snare[iteration].setBackgroundColor(getResources().getColor(R.color.lightpurple));
//                            snare_is_pressed[iteration] = true;
//                        } else
//                            snare[iteration].setBackgroundColor(getResources().getColor(R.color.darkpurple));
//                            snare_is_pressed[iteration] = false;
//                    }
//                });
//
//
//
//
//            }






    }
}
