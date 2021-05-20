package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class myaccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
    }

    public void login(View v)
    {
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }

    public void aboutus(View v)
    {
        Intent i=new Intent(this,aboutus.class);
        startActivity(i);
    }

    public void help(View v)
    {
        Intent i=new Intent(this,help.class);
        startActivity(i);
    }

    public void mybookings(View v)
    {
        Intent i=new Intent(this,mybookings.class);
        startActivity(i);
    }

    public void finaloffers(View v)
    {
        Intent i=new Intent(this,finaloffers.class);
        startActivity(i);
    }



}
