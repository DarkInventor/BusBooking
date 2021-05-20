package com.example.admin.busbooking;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity {

    Button sub;
    ImageView baloon;
    Animation frombottom, fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sub = (Button) findViewById(R.id.sub);
        baloon = (ImageView) findViewById(R.id.ballon);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        sub.setAnimation(frombottom);

        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        baloon.setAnimation(fromtop);
    }

    public void signuppage(View v)
    {
        Intent i=new Intent(this,homepage.class);
        startActivity(i);
        finish();
    }


}
