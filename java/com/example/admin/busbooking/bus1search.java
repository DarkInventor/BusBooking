package com.example.admin.busbooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bus1search extends AppCompatActivity {

    EditText et1,et2;
    TextInputLayout il1;
    Button bt1;
    private String p,q;
    EditText cname1,cname2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus1search);

        cname1=(EditText) findViewById(R.id.cname1);
        cname2=(EditText) findViewById(R.id.cname2);

        bt1=findViewById(R.id.bt1);

    }

    public void bus2agencies(View v)
    {
        new bus1search.SearchAsync().execute();

        /*Intent i=new Intent(this,bus2agencies.class);
        startActivity(i);*/

      /*  String username = et1.getText().toString();
        String password = et2.getText().toString();

        if(TextUtils.isEmpty(username) )
        {
            et1.requestFocus();
            et1.setError("Enter the source");

        }

        else if(TextUtils.isEmpty(password))
        {
            et2.requestFocus();
            et2.setError("Enter the destination");
        }

        else if(!TextUtils.isEmpty(username))
        {
            et1.setError(null);
            Intent i=new Intent(this,bus2agencies.class);
            startActivity(i);
        }

        else if(!TextUtils.isEmpty(password))
        {
            et2.setError(null);
            Intent i=new Intent(this,bus2agencies.class);
            startActivity(i);
        }

        else
        {
            Intent i=new Intent(this,bus2agencies.class);
            startActivity(i);
        }*/
    }

    private class SearchAsync extends AsyncTask<Void, Void, Void> {
        private WSsearch wssearch;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(bus1search.this, "", "Loading...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            EditText cname1, cname2;
            cname1 = findViewById(R.id.cname1);
            cname2 = findViewById(R.id.cname2);
            wssearch = new WSsearch(bus1search.this);
            wssearch.executeService(cname1.getText().toString(), cname2.getText().toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (wssearch.isSuccess()) {

                p= cname1.getText().toString();
                q=cname2.getText().toString();

                if(p.equals(q))
                {
                    cname2.requestFocus();
                    cname2.setError("Enter different cities");
                }

                else
                {
                    cname2.clearFocus();

                   // p=cname1.getText().toString();
                    //q=cname2.getText().toString();

//                   double p1=Double.parseDouble(cname1.getText().toString().trim());
//                   double q1=Double.parseDouble(cname2.getText().toString().trim());
//
//                   startActivity(new Intent(bus1search.this, bus2agencies.class));
//                    Intent i=new Intent(bus1search.this,bus2agencies.class);
                  /* i.putExtra("from",p);
                    i.putExtra("to",q);*/
//                  i.putExtra("from",p1);
//                  i.putExtra("to",q1);

                    Intent intent1 = new Intent(bus1search.this,bus2agencies.class);

                    intent1.putExtra("from",cname1.getText().toString());
                    intent1.putExtra("to",cname2.getText().toString());


                    startActivityForResult(intent1,1);
//

//                    intent1.putExtra("from",p);
//                    intent1.putExtra("to",q);

//                  i.putExtra("from",p1);
//                  i.putExtra("to",q1);
//
//                  i.putExtra("from",0);
//                  i.putExtra("to",0);
//

                    startActivity(intent1);

                    Toast.makeText(bus1search.this, "successfully get the city name  !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();

                }


            } else {
                Toast.makeText(bus1search.this, "Please enter city !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }



}

