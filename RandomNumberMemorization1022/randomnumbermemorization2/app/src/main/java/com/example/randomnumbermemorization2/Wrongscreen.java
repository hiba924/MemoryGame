package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Wrongscreen extends AppCompatActivity {

    TextView seque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrongscreen);
        String thecorrectsequence = getIntent().getStringExtra("correctsequence");
        seque = (TextView) findViewById(R.id.thecorrectsequence);
        seque.setText(thecorrectsequence);
    }
}