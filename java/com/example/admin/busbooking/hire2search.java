package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hire2search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire2search);
    }

    public void hire3local1(View v) {
        Intent i = new Intent(this, hire3local1.class);
        startActivity(i);
    }


    public void hire10out(View v) {
        Intent i = new Intent(this, hire10out.class);
        startActivity(i);
    }

}
