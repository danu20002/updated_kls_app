package com.example.kls_git;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class interfacectivity extends AppCompatActivity {
TextView dot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfacectivity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent intent=new Intent(interfacectivity.this,mainscreen.class);
            startActivity(intent);
             finish();
            }
        },4000);
    }
}