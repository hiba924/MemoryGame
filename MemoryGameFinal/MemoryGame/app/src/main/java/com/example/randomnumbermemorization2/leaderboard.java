package com.example.randomnumbermemorization2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leaderboard extends AppCompatActivity {
    Button startingScreen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        ArrayList<String> players = getIntent().getStringArrayListExtra("players");

        ArrayList<String> sortedPlayer = sortPlayer(players);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, sortedPlayer);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        startingScreen = (Button) findViewById(R.id.startingScreen);
        startingScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(leaderboard.this, StartingScreen.class);
                intent.putStringArrayListExtra("players", players);
                startActivity(intent);
            }
        });

    }

    private ArrayList<String> sortPlayer(ArrayList<String> players) {
        ArrayList<Player> playerList = new ArrayList<>();
        ArrayList<String> outArrayList = new ArrayList<>();
        for (String player: players) {
            String[] p = player.split("\t\t\t\t");
            playerList.add(new Player(p[0], p[1]));
        }

        Collections.sort(playerList);

        for (Player  player : playerList) {
            outArrayList.add(player.name + "\t\t\t\t" + player.score);
        }
        return outArrayList;
    }
}



