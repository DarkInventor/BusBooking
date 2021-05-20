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

import org.w3c.dom.Text;

public class hire7local5 extends AppCompatActivity {

    String a,b,c,d,e,f;
    EditText et1,et2,et3;
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire7local5);


        Intent i=getIntent();

        a=i.getStringExtra("hirecity");
        b=i.getStringExtra("pickup");
        c=i.getStringExtra("destination");
        d=i.getStringExtra("prsn");
        e=i.getStringExtra("date1");
        f=i.getStringExtra("date2");

        t1=(TextView)findViewById(R.id.localhire);
        t2=(TextView)findViewById(R.id.localpickup);
        t3=(TextView)findViewById(R.id.localdestination);
        t4=(TextView)findViewById(R.id.localperson);
        t5=(TextView)findViewById(R.id.fromwhen);
        t6=(TextView)findViewById(R.id.tillwhen);

        et1=(EditText) findViewById(R.id.localname);
        et2=(EditText) findViewById(R.id.localemail);
        et3=(EditText) findViewById(R.id.localphone);

        t1.setText(a);
        t2.setText(b);
        t3.setText(c);
        t4.setText(d);
        t5.setText(e);
        t6.setText(f);
    }

    public void hire8pay(View v)
    {
        //Intent i=new Intent(this,hire8pay.class);
        new hire7local5.SearchAsync().execute();
        //startActivity(i);
    }

    private class SearchAsync extends AsyncTask<Void, Void, Void> {
        private WSlocalbook wssearch;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(hire7local5.this, "", "Loading...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wssearch = new WSlocalbook(hire7local5.this);
            wssearch.executeService(et1.getText().toString(), et2.getText().toString(),et3.getText().toString(),t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),t5.getText().toString(),t6.getText().toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (wssearch.isSuccess()) {

                Intent i=new Intent(hire7local5.this,hire8pay.class);
                Toast.makeText(hire7local5.this, "successfully get the city name  !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();
                startActivity(i);

            } else {
                Toast.makeText(hire7local5.this, "Please enter city !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }

}
