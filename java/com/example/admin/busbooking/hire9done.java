package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hire9done extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire9done);
    }

    public void homepage(View homepage)
    {
        Intent i=new Intent(this,homepage.class);
        startActivity(i);
        finish();
    }
}
