package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class bus5ac extends AppCompatActivity {

    String p,q;
    String a,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus5ac);

        Intent i=getIntent();

        p=i.getStringExtra("from");
        q=i.getStringExtra("to");

        a=i.getStringExtra("travel");
         s=i.getStringExtra("date");
        Toast.makeText(this, "date is selected"+s, Toast.LENGTH_SHORT).show();
    }

    public void seat(View v)
    {
        Intent i=new Intent(this,bus3seat.class);
        i.putExtra("from",p);
        i.putExtra("to",q);

        i.putExtra("travel",a);
        i.putExtra("date",s);

        startActivity(i);
    }
}
