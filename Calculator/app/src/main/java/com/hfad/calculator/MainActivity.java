package com.hfad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        EditText a = (EditText) findViewById(R.id.num1);
        EditText b = (EditText) findViewById(R.id.num2);
        Double n1 = Double.parseDouble(a.getText().toString());
        Double n2 = Double.parseDouble(b.getText().toString());


        TextView t = findViewById(R.id.answer);
        t.setText(String.valueOf(n1+n2));
    }

}
