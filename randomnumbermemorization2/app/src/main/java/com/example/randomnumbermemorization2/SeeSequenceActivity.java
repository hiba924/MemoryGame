package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        if(str==null) {
            str = sequencesomething.makeArray();
        }
        else {
            str = str + sequencesomething.makeArray();
        }
        thesequence.setText(str);
        String finalStr = str;
        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SeeSequenceActivity.this, StartActivity.class);
                i.putExtra("key", finalStr);
                startActivity(i);
            }
        });
    }
}