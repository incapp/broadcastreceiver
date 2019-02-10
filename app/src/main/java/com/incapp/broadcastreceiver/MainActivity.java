package com.incapp.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Context registered broadcast.
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean state = intent
                    .getBooleanExtra("state", false);
            if (state) {
                Toast.makeText(context,
                        "Airplane Mode On", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        "Airplane Mode Off.", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(
                Intent.ACTION_AIRPLANE_MODE_CHANGED
        );

        registerReceiver(receiver, intentFilter);
    }
}
