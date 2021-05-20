package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class bus7pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus7pay);
    }

    public void bus8done(View v)
    {
        Intent i=new Intent(this,bus8done.class);
        startActivity(i);
    }

    public void signuppage(View v)
    {
        Intent i=new Intent(this,signup.class);
        startActivity(i);
    }
}
