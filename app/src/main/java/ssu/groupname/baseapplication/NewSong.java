package ssu.groupname.baseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewSong extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);
        button1=(Button)findViewById(R.id.guitar_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewSong.this, GuitarActivity.class); startActivity(intent);
            } });
        button2=(Button)findViewById(R.id.drum_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewSong.this, DrumActivity.class); startActivity(intent);
            } });
        button3=(Button)findViewById(R.id.bass_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewSong.this, BassActivity.class); startActivity(intent);
            } });
        button4=(Button)findViewById(R.id.keyboard_button);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewSong.this, KeyboardActivity.class); startActivity(intent);
            } });
    }
}
