package com.example.admin.busbooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class hire10out extends AppCompatActivity {

    EditText fromhere,tothere,forpickup;
    String p,q,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire10out);
    }

    public void hire4local2(View v)
    {
        new hire10out.SearchAsync().execute();
//        Intent i=new Intent(this,hire4local2.class);
//        startActivity(i);
    }

    private class SearchAsync extends AsyncTask<Void, Void, Void> {
        private WSoutsearch wssearch;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(hire10out.this, "", "Loading...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            fromhere=(EditText) findViewById(R.id.fromhere);
            tothere=(EditText) findViewById(R.id.tothere);
            forpickup=(EditText) findViewById(R.id.forpickup);
            wssearch = new WSoutsearch(hire10out.this);
            wssearch.executeService(fromhere.getText().toString(),tothere.getText().toString(),forpickup.getText().toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (wssearch.isSuccess()) {
                p=fromhere.getText().toString();
                q=tothere.getText().toString();
                r=forpickup.getText().toString();



//                if(p.equals(q))
//                {
//                    pickup.requestFocus();
//                    pickup.setError("Enter cities");
//                }
//
//                if(p.equals(r))
//                {
//                    pickup.setError(null);
//                    destination.requestFocus();
//                    destination.setError("Enter  cities");
//                }
//
//                if(q.equals(p))
//                {
//                    destination.clearFocus();
//                    hirecity.requestFocus();
//                    hirecity.setError("Enter  cities");
//                }
//
//
//                if(q.equals(r))
//                {
//                    hirecity.clearFocus();
//                    destination.requestFocus();
//                    destination.setError("Enter  cities");
//                }
//
//
//                if(r.equals(p))
//                {
//                    destination.clearFocus();
//                    hirecity.requestFocus();
//                    hirecity.setError("Enter  cities");
//                }
//
//
//                if(r.equals(q))
//                {
//                    hirecity.clearFocus();
//                    pickup.requestFocus();
//                    pickup.setError("Enter cities");
//                }
//
//                else {


                Intent i = new Intent(hire10out.this, hire4local2.class);
                i.putExtra("hirecity", p);
                i.putExtra("pickup", q);
                i.putExtra("destination", r);

                Toast.makeText(hire10out.this, "" + p, Toast.LENGTH_SHORT).show();

                startActivityForResult(i, 1);
                startActivity(i);
                //}



//                p = hirecity.getText().toString();
//                q = pickup.getText().toString();
//                r = destination.getText().toString();


         /*   if(TextUtils.isEmpty(p))
            {
                hirecity.requestFocus();
                hirecity.setError("Enter city name");
            }

            else if(TextUtils.isEmpty(q))
            {
                hirecity.setError(null);
                pickup.requestFocus();
                pickup.setError("enter pick up point");
            }

            else if(TextUtils.isEmpty(r))
            {
                pickup.setError(null);
                destination.requestFocus();
                destination.setError("enter valid destination")
            }
//
//               if(p.equals(q))
//                {
//                    pickup.requestFocus();
//                    pickup.setError("Enter different cities");
//                }
//
//                if(p.equals(r))
//                {
//                    pickup.setError(null);
//                    destination.requestFocus();
//                    destination.setError("Enter different cities");
//                }
//
//                if(q.equals(p))
//                {
//                    destination.clearFocus();
//                    hirecity.requestFocus();
//                    hirecity.setError("Enter different cities");
//                }
//
//
//                if(q.equals(r))
//                {
//                    hirecity.clearFocus();
//                    destination.requestFocus();
//                    destination.setError("Enter different cities");
//                }
//
//
//                if(r.equals(p))
//                {
//                    destination.clearFocus();
//                    hirecity.requestFocus();
//                    hirecity.setError("Enter different cities");
//                }
//
//
//                if(r.equals(q))
//                {
//                    hirecity.clearFocus();
//                    pickup.requestFocus();
//                    pickup.setError("Enter different cities");
//                }*/



//                    destination.setError(null);

//                    Intent intent1 = new Intent(hire3local1.this,bus2agencies.class);
//
//                    intent1.putExtra("hirecity",hirecity.getText().toString());
//                    intent1.putExtra("pickup",pickup.getText().toString());
//                    intent1.putExtra("destination",destination.getText().toString());
//
//
//                    Toast.makeText(hire3local1.this, "gottcha"+hirecity.getText().toString(), Toast.LENGTH_SHORT).show();
//
//                    startActivityForResult(intent1,1);
////
//
////                    intent1.putExtra("from",p);
////                    intent1.putExtra("to",q);
//
////                  i.putExtra("from",p1);
////                  i.putExtra("to",q1);
////
////                  i.putExtra("from",0);
////                  i.putExtra("to",0);
////
//
//                    startActivity(intent1);
//
                Toast.makeText(hire10out.this, "successfully get the city name  !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();




            } else {
                Toast.makeText(hire10out.this, "Please enter city !!" + wssearch.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }
}
