package com.example.admin.busbooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {

    EditText et1, et2;
    TextInputLayout il1;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = findViewById(R.id.etusername);
        et2 = findViewById(R.id.etpass);

        bt1 = findViewById(R.id.bt1);
    }

    public void register(View v) {
        Intent i = new Intent(this, signup.class);
        startActivity(i);
    }

    public void home(View view) {
        new LoginAsync().execute();
    }

    private class LoginAsync extends AsyncTask<Void, Void, Void> {
        private WSLogin wsLogin;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(login.this, "", "Loading...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            EditText uname, pass;
            uname = findViewById(R.id.etusername);
            pass = findViewById(R.id.etpass);
            wsLogin = new WSLogin(login.this);
            wsLogin.executeService(uname.getText().toString(), pass.getText().toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

                  if (wsLogin.isSuccess()) {

                    et1 = findViewById(R.id.etusername);
                    et2 = findViewById(R.id.etpass);

                String username = et1.getText().toString();
                String password = et2.getText().toString();

                if(TextUtils.isEmpty(username) )
                {
                    et1.requestFocus();
                    et1.setError("Enter the username");

                }


                if(TextUtils.isEmpty(password))
                {
                    et2.requestFocus();
                    et2.setError("Enter the password");
                }

                if(!TextUtils.isEmpty(username))
                {
                    et1.setError(null);
                    startActivity(new Intent(login.this, homepage.class));
                    finish();
                }

                 if(!TextUtils.isEmpty(password))
                {
                    et2.setError(null);
                    startActivity(new Intent(login.this, homepage.class));
                    finish();
                }

                //     Toast.makeText(login.this, "login successful !!" + wsLogin.getMessage(), Toast.LENGTH_SHORT).show();

                 //finish();

            } else {
                Toast.makeText(login.this, "login failed !!" + wsLogin.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }



}

