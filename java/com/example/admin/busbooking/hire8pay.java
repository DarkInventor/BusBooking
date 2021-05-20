package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hire8pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire8pay);
    }

    public void hire9done(View v)
    {
        Intent i=new Intent(this,hire9done.class);
        startActivity(i);
    }

    public void signuppage(View v)
    {
        Intent i=new Intent(this,signup.class);
        startActivity(i);
    }
}
