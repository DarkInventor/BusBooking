package com.example.admin.busbooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bus6book extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    String p,q;
    String a,b,c,d,e,f,s;
    EditText et1,et2,et3;
   // bus1search b1s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus6book);

       //Intent i = getIntent();

//             b1s=new bus1search();
//
//           String a=b1s.cname1.getText().toString();
//           String b=b1s.cname2.getText().toString();



//        Intent intent2 = getIntent();
//
        et1=(EditText) findViewById(R.id.custname);
        et2=(EditText) findViewById(R.id.custemail);
        et3=(EditText) findViewById(R.id.custphone);


        t1=(TextView) findViewById(R.id.fromhere);
        t2=(TextView) findViewById(R.id.tothere);
        t3=(TextView) findViewById(R.id.foragency);
        t4=(TextView) findViewById(R.id.fordate);
        t5=(TextView) findViewById(R.id.forseat);

        Intent i=getIntent();

        p=i.getStringExtra("from");
        q=i.getStringExtra("to");
        s=i.getStringExtra("date");

        c=i.getStringExtra("noOfSeats");

        t1.setText(p);
        t2.setText(q);
        t4.setText(s);
        t5.setText(c);

        Toast.makeText(this, "date="+s, Toast.LENGTH_SHORT).show();

        a=i.getStringExtra("travel");

        t3.setText(a);



//
//         p = intent2.getStringExtra("from");
//         q= intent2.getStringExtra("to");

//         t1.setText(a);
//         t2.setText(b);


//
//            double d1=Double.parseDouble(t1.getText().toString().trim());
//            double d2=Double.parseDouble(t2.getText().toString().trim());
//
//            double p1=i.getDoubleExtra("from",d1);
//            double q1=i.getDoubleExtra("to",d2);
//
//            t1.setText("from="+p1);
//            t1.setText("to="+q1);


//        intent2.getStringExtra("from");
//        intent2.getStringExtra("to");


       /* String str = intent.getStringExtra("from");
        String str2 = intent.getStringExtra("to");
        fromhere.setText(str);
        tothere.setText(str2);
        startActivity(intent);*/
    }

    public void bus7pay(View v)
    {
     //  Intent i=new Intent(this,bus7pay.class);
        new bus6book.SearchAsync().execute();
       // startActivity(i);
    }

    private class SearchAsync extends AsyncTask<Void, Void, Void> {
        private WSbook wssearch;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(bus6book.this, "", "Loading...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wssearch = new WSbook(bus6book.this);
            wssearch.executeService(et1.getText().toString(), et2.getText().toString(),et3.getText().toString(),t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),t5.getText().toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (wssearch.isSuccess()) {

                Intent i=new Intent(bus6book.this,bus7pay.class);
                Toast.makeText(bus6book.this, "successfully get the city name  !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();
                startActivity(i);

            } else {
                Toast.makeText(bus6book.this, "Please enter city !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }


}
