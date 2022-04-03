package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SeeSequenceActivity extends AppCompatActivity {

    TextView thesequence;
    Button thebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_sequence);
        thebutton = (Button) findViewById(R.id.thebutton);
        thesequence = (TextView) findViewById(R.id.thesequence);
        String str = getIntent().getStringExtra("addontothis");

        Bundle extras = getIntent().getExtras();
        List<String> players = getIntent().getStringArrayListExtra("players");

        if(str==null) {
            str = ArrayFile.makeArray();
        }
        else {
            str = str + ArrayFile.makeArray();
        }
        thesequence.setText(str);
        String finalStr = str;
        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SeeSequenceActivity.this, StartActivity.class);
                i.putExtra("key", finalStr);
                i.putExtra("players", (Serializable) players);
                startActivity(i);
            }
        });
    }
}