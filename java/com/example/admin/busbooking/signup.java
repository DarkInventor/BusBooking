package com.example.admin.busbooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    Button signup;
    TabLayout tablayout;
    EditText fname,lname,uname,pswrd,pswrd2,mobileno;
    RadioGroup rg1;
    RadioButton rd1,rd2;
    CheckBox cb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        fname=(EditText) findViewById(R.id.fname);
        lname=(EditText) findViewById(R.id.lname);
        uname=(EditText) findViewById(R.id.uname);
        pswrd=(EditText) findViewById(R.id.pswrd);
        pswrd2=(EditText) findViewById(R.id.pswrd2);
        rg1=(RadioGroup) findViewById(R.id.rg1);
        rd1=(RadioButton) findViewById(R.id.rd1);
        rd2=(RadioButton) findViewById(R.id.rd2);
        cb1=(CheckBox) findViewById(R.id.cb1);
        mobileno=(EditText) findViewById(R.id.mobileno);



// Adding the tabs using addTab() method
        tablayout.addTab(tablayout.newTab().setText("SignUp"));
        tablayout.addTab(tablayout.newTab().setText("Login"));

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TextView tv1 = (TextView) (((LinearLayout) ((LinearLayout) tablayout.getChildAt(0)).getChildAt(0)).getChildAt(1));
        tv1.setScaleY(-1);
        TextView tv2 = (TextView) (((LinearLayout) ((LinearLayout) tablayout.getChildAt(0)).getChildAt(1)).getChildAt(1));
        tv2.setScaleY(-1);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), signup.class);
                startActivityForResult(myIntent, 0);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), login.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    public void submit(View v) {
       /* Intent i = new Intent(this, homepage.class);
        startActivity(i);
        Toast.makeText(this, "You Have Successfully Registered", Toast.LENGTH_SHORT).show();*/
        new signup.SignupAsync().execute();
    }

    private class SignupAsync extends AsyncTask<Void, Void, Void> {
        private WSsignup wssignup;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(signup.this, "", "Loading...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            EditText username, pass;
            username = findViewById(R.id.etusername);
            pass = findViewById(R.id.etpass);
            String gender;

            if(rg1.getCheckedRadioButtonId()==R.id.rd1)
            {
                gender="male";
            }

            else
            {
                gender="female";
            }

            wssignup = new WSsignup(signup.this);
            wssignup.executeService(fname.getText().toString(), lname.getText().toString(),uname.getText().toString(),pswrd.getText().toString(),pswrd2.getText().toString(),gender,mobileno.getText().toString());


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (wssignup.isSuccess()) {

                fname=(EditText) findViewById(R.id.fname);
                cb1=(CheckBox) findViewById(R.id.cb1);
                lname=(EditText) findViewById(R.id.lname);
                uname=(EditText) findViewById(R.id.uname);
                pswrd=(EditText) findViewById(R.id.pswrd);
                pswrd2=(EditText) findViewById(R.id.pswrd2);
                rg1=(RadioGroup) findViewById(R.id.rg1);
                rd1=(RadioButton) findViewById(R.id.rd1);
                rd2=(RadioButton) findViewById(R.id.rd2);
                cb1=(CheckBox) findViewById(R.id.cb1);
                mobileno=(EditText) findViewById(R.id.mobileno);


                String fname1 = fname.getText().toString();
                String lname1 = lname.getText().toString();
                String uname1 = uname.getText().toString();
                String pswrd1 = pswrd.getText().toString();
                String pswrd3 = pswrd2.getText().toString();
                String num=mobileno.getText().toString();



                if(TextUtils.isEmpty(fname1) )
                {
                    fname.requestFocus();
                    fname.setError("Enter the firstname");

                }

                else if(TextUtils.isEmpty(lname1) )
                {
                    fname.clearFocus();
                    lname.requestFocus();
                    lname.setError("Enter the lastname");

                }

                else if(TextUtils.isEmpty(uname1) )
                {
                    lname.clearFocus();
                    uname.requestFocus();
                    uname.setError("Enter the username");
                }

                else if(TextUtils.isEmpty(pswrd1) )
                {
                    uname.clearFocus();
                    pswrd.requestFocus();
                    pswrd.setError("Enter the valid password");
                }

                else if(TextUtils.isEmpty(pswrd3) )
                {
                    pswrd.clearFocus();
                    pswrd2.requestFocus();
                    pswrd2.setError("Enter the valid password");
                }


//                else {
//
//                    startActivity(new Intent(signup.this, homepage.class));
//
//                    Toast.makeText(signup.this, "login successful !!" + wssignup.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    finish();
//
//                }
                if(TextUtils.isEmpty(num) )
                {
                    mobileno.requestFocus();
                    mobileno.setError("Enter the Correct mobile number");

                    if(mobileno.getText().length()>=10)
                    {
                        mobileno.requestFocus();
                        mobileno.setError("Enter the valid number");
                    }

                    if(mobileno.getText().length()<=10)
                    {
                        mobileno.requestFocus();
                        mobileno.setError("Enter the valid number");
                    }

                    if (mobileno.getText().length()==10)
                    {
                        startActivity(new Intent(signup.this, homepage.class));

                        Toast.makeText(signup.this, "login successful !!" + wssignup.getMessage(), Toast.LENGTH_SHORT).show();

                        finish();
                        Toast.makeText(signup.this, "Details are correct", Toast.LENGTH_SHORT).show();
                    }


                }

                else
                {
                    startActivity(new Intent(signup.this, homepage.class));

                    Toast.makeText(signup.this, "login successful !!" + wssignup.getMessage(), Toast.LENGTH_SHORT).show();

                    finish();
                    Toast.makeText(signup.this, "Details are correct", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(signup.this, "login failed !!" + wssignup.getMessage(), Toast.LENGTH_SHORT).show();
            }


            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }




}