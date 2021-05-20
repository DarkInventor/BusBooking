package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class hire5local4 extends AppCompatActivity {

    String a,b,c,d,e,f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire5local4);

        Intent i=getIntent();

        a=i.getStringExtra("hirecity");
        b=i.getStringExtra("pickup");
        c=i.getStringExtra("destination");
        d=i.getStringExtra("prsn");
        e=i.getStringExtra("date1");
        f=i.getStringExtra("date2");
    }

    public void hire7local5(View v)
    {
        Intent i=new Intent(this,hire7local5.class);
        i.putExtra("hirecity",a);
        i.putExtra("pickup", b);
        i.putExtra("destination",c);
        i.putExtra("prsn",d);
        i.putExtra("date1",e);
        i.putExtra("date2",f);

        Toast.makeText(hire5local4.this, "" + a, Toast.LENGTH_SHORT).show();

        startActivityForResult(i, 1);
        startActivity(i);
    }
}
