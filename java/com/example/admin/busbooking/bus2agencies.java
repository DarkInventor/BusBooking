package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bus2agencies extends AppCompatActivity {

    String p,q;
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus2agencies);


        Intent i=getIntent();

        p=i.getStringExtra("from");
        q=i.getStringExtra("to");

        t1=(TextView) findViewById(R.id.travel1);
        t2=(TextView) findViewById(R.id.travel2);
        t3=(TextView) findViewById(R.id.travel3);
        t4=(TextView) findViewById(R.id.travel4);
        t5=(TextView) findViewById(R.id.travel5);
        t6=(TextView) findViewById(R.id.travel6);

    }

    public void bus3seat1(View v)
    {
        Intent i=new Intent(this,bus4date.class);

        i.putExtra("travel",t1.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        startActivity(i);

    }

    public void bus3seat2(View v)
    {
        Intent i=new Intent(this,bus4date.class);

        i.putExtra("travel",t2.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        startActivity(i);

    }

    public void bus3seat3(View v)
    {
        Intent i=new Intent(this,bus4date.class);

        i.putExtra("travel",t3.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        startActivity(i);

    }

    public void bus3seat4(View v)
    {
        Intent i=new Intent(this,bus4date.class);

        i.putExtra("travel",t4.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        startActivity(i);

    }

    public void bus3seat5(View v)
    {
        Intent i=new Intent(this,bus4date.class);

        i.putExtra("travel",t5.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        startActivity(i);

    }

    public void bus3seat6(View v)
    {
        Intent i=new Intent(this,bus4date.class);

        i.putExtra("travel",t6.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        startActivity(i);

    }
}
