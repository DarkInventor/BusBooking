package com.example.admin.busbooking;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class mybookings extends AppCompatActivity {

    //TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybookings);


        ImageView ola = (ImageView) findViewById(R.id.ola);
        ImageView uber = (ImageView) findViewById(R.id.uber);
        ImageView dominos=(ImageView) findViewById(R.id.dominos);
        ImageView swiggy=(ImageView) findViewById(R.id.swiggy);

        ola.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

              Uri uri = Uri.parse("market://details?id=com.olacabs.customer");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=com.olacabs.customer")));
                }
            }
              /*  Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.olacabs.customer");
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
              */

            /*     Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.ubercab");
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }*/

            /*    Uri uri = Uri.parse("market://details?id=com.ubercab");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));
                }
            }*/
        });

        uber.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {

                                       Uri uri = Uri.parse("market://details?id=com.ubercab");
                                       Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                                       goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                               Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                               Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                                       try {
                                           startActivity(goToMarket);
                                       } catch (ActivityNotFoundException e) {
                                           startActivity(new Intent(Intent.ACTION_VIEW,
                                                   Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));
                                       }
                                   }
        });


        dominos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri uri = Uri.parse("market://details?id=com.Dominos");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=com.Dominos")));
                }
            }
        });

        swiggy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri uri = Uri.parse("market://details?id=in.swiggy.android");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=in.swiggy.android")));
                }
            }
        });



    }

    //    tablayout = (TabLayout) findViewById(R.id.tabLayout);

// Adding the tabs using addTab() method
//        tablayout.addTab(tablayout.newTab().setText("Completed"));
//        tablayout.addTab(tablayout.newTab().setText("Cancelled"));
//
//        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        TextView tv1 = (TextView) (((LinearLayout) ((LinearLayout) tablayout.getChildAt(0)).getChildAt(0)).getChildAt(1));
//        tv1.setScaleY(-1);
//        TextView tv2 = (TextView) (((LinearLayout) ((LinearLayout) tablayout.getChildAt(0)).getChildAt(1)).getChildAt(1));
//        tv2.setScaleY(-1);
    }

