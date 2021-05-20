package com.example.admin.busbooking;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class hire5local3 extends AppCompatActivity {

    private static final String TAG = hire5local3.class.getSimpleName();
    EditText btnShowDate,btnShowDate2;
    String s;
    String a,b,c,d;


    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire5local3);

        Intent i=getIntent();

        a=i.getStringExtra("hirecity");
        b=i.getStringExtra("pickup");
        c=i.getStringExtra("destination");
        d=i.getStringExtra("prsn");


        btnShowDate = (EditText) findViewById(R.id.activity_third_btn_date);
        btnShowDate2 = (EditText) findViewById(R.id.activity_four_btn_date);

        btnShowDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


                final DatePickerDialog datePickerDialog1
                        = new DatePickerDialog(hire5local3.this
                        ,onDateSetListener1,year,month,dayOfMonth);


                datePickerDialog1.show();

                s=btnShowDate.getText().toString();
            }
        });

        btnShowDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


                final DatePickerDialog datePickerDialog2
                        = new DatePickerDialog(hire5local3.this
                        ,onDateSetListener,year,month,dayOfMonth);


                datePickerDialog2.show();

                s=btnShowDate2.getText().toString();
            }
        });

    }



    private DatePickerDialog.OnDateSetListener onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            final String date = dayOfMonth + "-" + (month + 1) + "-" + year;
            Toast.makeText(hire5local3.this, "" + date, Toast.LENGTH_SHORT).show();
            calendar.set(year,month,dayOfMonth);

            btnShowDate.setText(date);
        }
    };

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            final String date = dayOfMonth + "-" + (month + 1) + "-" + year;
            Toast.makeText(hire5local3.this, "" + date, Toast.LENGTH_SHORT).show();
            calendar.set(year,month,dayOfMonth);

            btnShowDate2.setText(date);
        }
    };

    public void hire5local4(View v)
    {

        String username = btnShowDate.getText().toString();
        String password = btnShowDate2.getText().toString();

        if(TextUtils.isEmpty(username) )
        {
            btnShowDate.requestFocus();
            btnShowDate.setError("Enter date");

        }

        else if(TextUtils.isEmpty(password))
        {
            btnShowDate2.requestFocus();
            btnShowDate2.setError("Enter date");
        }

        else if(!TextUtils.isEmpty(username))
        {
            btnShowDate.setError(null);
            Intent i=new Intent(this,hire5local4.class);
            i.putExtra("hirecity",a);
            i.putExtra("pickup", b);
            i.putExtra("destination",c);
            i.putExtra("prsn",d);
            i.putExtra("date1",btnShowDate.getText().toString());
            i.putExtra("date2",btnShowDate2.getText().toString());

            Toast.makeText(this, ""+btnShowDate.getText().toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(hire5local3.this, "" + a, Toast.LENGTH_SHORT).show();

            startActivityForResult(i, 1);

            startActivity(i);
        }

        else if(!TextUtils.isEmpty(password))
        {
            btnShowDate2.setError(null);
            Intent i=new Intent(this,hire5local4.class);
            i.putExtra("hirecity",a);
            i.putExtra("pickup", b);
            i.putExtra("destination",c);
            i.putExtra("prsn",d);
            i.putExtra("date1",btnShowDate.getText().toString());
            i.putExtra("date2",btnShowDate2.getText().toString());

            Toast.makeText(this, ""+btnShowDate.getText().toString(), Toast.LENGTH_SHORT).show();

            Toast.makeText(hire5local3.this, "" + a, Toast.LENGTH_SHORT).show();

            startActivityForResult(i, 1);

            startActivity(i);
        }

        else
        {
            Intent i=new Intent(this,hire5local4.class);
            i.putExtra("hirecity",a);
            i.putExtra("pickup", b);
            i.putExtra("destination",c);
            i.putExtra("prsn",d);
            i.putExtra("date1",btnShowDate.getText().toString());
            i.putExtra("date2",btnShowDate2.getText().toString());

            Toast.makeText(this, ""+btnShowDate.getText().toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(hire5local3.this, "" + d, Toast.LENGTH_SHORT).show();
            Toast.makeText(hire5local3.this, "" + a, Toast.LENGTH_SHORT).show();

            startActivityForResult(i, 1);

            startActivity(i);
        }
    }
}
