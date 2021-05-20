package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class hire4local2 extends AppCompatActivity {


    String a,b,c,s;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire4local2);


        Intent i=getIntent();

        a=i.getStringExtra("hirecity");
        b=i.getStringExtra("pickup");
        c=i.getStringExtra("destination");


        et1=(EditText) findViewById(R.id.prsn);

     //   s=et1.getText().toString();

    }

    public void hire5local3(View v)
    {



        s=et1.getText().toString();
        int k=Integer.parseInt(s);

        if(k>=22)
        {
            et1.requestFocus();
            et1.setError("Enter less than 22 Persons");
        }

        else
        {

            Intent i=new Intent(this,hire5local3.class);
            String s=String.valueOf(k);

        i.putExtra("hirecity", a);
        i.putExtra("pickup", b);
        i.putExtra("destination", c);
        i.putExtra("prsn", s);
        Toast.makeText(hire4local2.this, "" + s, Toast.LENGTH_SHORT).show();
        Toast.makeText(hire4local2.this, "" + a, Toast.LENGTH_SHORT).show();

        startActivityForResult(i, 1);

        startActivity(i);
    }

        }
}
