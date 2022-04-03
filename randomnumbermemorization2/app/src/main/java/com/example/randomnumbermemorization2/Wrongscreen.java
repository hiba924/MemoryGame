package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wrongscreen extends AppCompatActivity {

    TextView seque;
    Button leaderBoardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrongscreen);
        String scoreString = getIntent().getStringExtra("score");
        String correctstring = getIntent().getStringExtra("correctstring");
        ArrayList<String> players = getIntent().getStringArrayListExtra("players");
        seque = (TextView) findViewById(R.id.thecorrectsequence);
        seque.setText(correctstring);
        leaderBoardButton = (Button) findViewById(R.id.leaderBoardButton);

        EditText personNameTextBox = (EditText) findViewById(R.id.PersonName);
        personNameTextBox.requestFocus();

        leaderBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(personNameTextBox.getText())) {
                    personNameTextBox.setError("Name is required!");
                } else {

                    String personName = personNameTextBox.getText().toString().trim();
                    players.add(personName + "\t\t\t\t" + scoreString);
                    Intent intent = new Intent(Wrongscreen.this, leaderboard.class);
                    intent.putStringArrayListExtra("players", players);
                    startActivity(intent);
                }
            }
        });




            /**
             *   You can Toast a message here that the Username is Empty
             **/










    }
}