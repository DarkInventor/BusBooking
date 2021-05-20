package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void help1(View v)
    {
        Intent i=new Intent(this,help1.class);
        startActivity(i);
    }

    public void help2(View v)
    {
        Intent i=new Intent(this,help2.class);
        startActivity(i);
    }

}
