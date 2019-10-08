package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveMessageActvity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message_actvity);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra("message1");
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }
}
