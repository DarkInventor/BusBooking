package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hire1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire1);
    }

    public void hire2search(View v)
    {
        Intent i=new Intent(this,hire2search.class);
        startActivity(i);
    }
}
