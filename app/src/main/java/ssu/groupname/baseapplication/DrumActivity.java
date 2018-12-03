package ssu.groupname.baseapplication;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DrumActivity extends AppCompatActivity {

    Button basskick_button, china_b, crash_b, hihat_b, lowtom_b, ride_b, snare_b, tom1_b, tom2_b;
    private SoundPool sp;
    private int basskick, china, crash, hihat, lowtom, ride, snare, tom1, tom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum);

        basskick_button = (Button) findViewById(R.id.basskick);
        china_b = (Button) findViewById(R.id.china);
        crash_b = (Button) findViewById(R.id.crash);
        hihat_b = (Button) findViewById(R.id.hihat);
        lowtom_b = (Button) findViewById(R.id.lowtom);
        ride_b = (Button) findViewById(R.id.ride);
        snare_b = (Button) findViewById(R.id.snare);
        tom1_b = (Button) findViewById(R.id.tom1);
        tom2_b = (Button) findViewById(R.id.tom2);




        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);


        basskick = sp.load(this, R.raw.basskick, 1);
        china = sp.load(this, R.raw.china, 1);
        crash = sp.load(this, R.raw.crash, 1);
        hihat = sp.load(this, R.raw.hihat, 1);
        lowtom = sp.load(this, R.raw.lowtom, 1);
        ride = sp.load(this, R.raw.ride, 1);
        snare = sp.load(this, R.raw.snare, 1);
        tom1 = sp.load(this, R.raw.tom1, 1);
        tom2 = sp.load(this, R.raw.tom2, 1);

        basskick_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(basskick, 1, 1, 0, 0, 1);
            }
        });

        china_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(china, 1, 1, 0, 0, 1);
            }
        });

        crash_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(crash, 1, 1, 0, 0, 1);
            }
        });

        hihat_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(hihat, 1, 1, 0, 0, 1);
            }
        });

        lowtom_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(lowtom, 1, 1, 0, 0, 1);
            }
        });

        ride_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(ride, 1, 1, 0, 0, 1);
            }
        });

        snare_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(snare, 1, 1, 0, 0, 1);
            }
        });

        tom1_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(tom1, 1, 1, 0, 0, 1);
            }
        });

        tom2_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(tom2, 1, 1, 0, 0, 1);
            }
        });



    }

}
