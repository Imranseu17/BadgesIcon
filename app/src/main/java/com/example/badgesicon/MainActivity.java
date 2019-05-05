package com.example.badgesicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import me.leolin.shortcutbadger.ShortcutBadger;


public class MainActivity extends AppCompatActivity {

    Button count,remove;
    private String TAG = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = findViewById(R.id.count);
        remove = findViewById(R.id.remove);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int badgeCount = 0;
                try {
                    badgeCount = 9;
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Error input", Toast.LENGTH_SHORT).show();
                }

                boolean success = ShortcutBadger.applyCount(MainActivity.this, badgeCount);

                Toast.makeText(getApplicationContext(), "Set count=" + badgeCount + ", success=" + success, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
