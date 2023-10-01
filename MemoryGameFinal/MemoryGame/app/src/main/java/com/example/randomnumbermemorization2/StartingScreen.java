package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class StartingScreen extends AppCompatActivity {

    Button button, leaderboard, exitbutton;

    ArrayList<String> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        players = getIntent().getStringArrayListExtra("players");
        if (players == null) {
            players =  FileUtil.getSavedArrayList(getApplicationContext());
        } else {
            FileUtil.saveArrayList(getApplicationContext(), players);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage2();
            }
        });

        leaderboard = (Button) findViewById(R.id.leaderboard);
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(StartingScreen.this, leaderboard.class);
                sendList(intent2);
                startActivity(intent2);
            }
        });


        exitbutton = (Button) findViewById(R.id.exitbutton);
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(StartingScreen.this, exitscreen.class);
                sendList(intent3);
                startActivity(intent3);
            }
        });
    }

    public void openPage2()     {
        Intent intent = new Intent(this, SeeSequenceActivity.class);
        sendList(intent);
        startActivity(intent);
    }

    private void sendList(Intent intent) {
        //intent.putExtra("players", (Serializable) players);
        intent.putStringArrayListExtra("players", players);
    }
}