package com.example.admin.busbooking;

        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.GridLayout;
        import android.widget.GridView;
        import android.widget.Toast;

public class homepage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void bus1search(View v)
    {
        Intent i=new Intent(this,bus1search.class);
        startActivity(i);
    }

    public void hire1(View v)
    {
        Intent i=new Intent(this,hire1.class);
        startActivity(i);
    }

    public void mybookings(View v)
    {
        Intent i=new Intent(this,mybookings.class);
        startActivity(i);
    }

    public void myaccount(View v)
    {
        Intent i=new Intent(this,myaccount.class);
        startActivity(i);
    }

    public void finaloffer(View v)
    {
        Intent i=new Intent(this,finaloffers.class);
        startActivity(i);
    }
}

