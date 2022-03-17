package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    Button enterbutton;
    TextView textviewlevel;
    int currentlevel = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        EditText inputsequence = (EditText) findViewById(R.id.inputsequence);
        enterbutton = findViewById(R.id.enterbutton);
        textviewlevel = (TextView) findViewById(R.id.textview_level);
        String thescore5 = getIntent().getStringExtra("thescore");
        if(thescore5!=null) {
            textviewlevel.setText("Level " + thescore5);
        }
        else {
            textviewlevel.setText("Level "+currentlevel);
        }
        String thestring = getIntent().getStringExtra("key");

        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputseq = inputsequence.getText().toString().trim();
                String str2 = thestring.trim();
                if(inputseq.equals(str2)){
                    currentlevel+=1;
                    Intent i = new Intent(StartActivity.this, Correctscreen.class);
                    i.putExtra("currentlevel",currentlevel);
                    i.putExtra("correctstring",thestring);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(StartActivity.this, Wrongscreen.class);
                    i.putExtra("correctsequence",thestring);
                    startActivity(i);
                }
            }
        });
    }




}