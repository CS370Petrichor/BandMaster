package ssu.groupname.baseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button navigate_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigate_button=(Button)findViewById(R.id.navigate_button);
        navigate_button.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, NewSong.class); startActivity(intent);
        } });
    }
}
