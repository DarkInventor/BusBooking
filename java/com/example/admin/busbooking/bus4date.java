package com.example.admin.busbooking;

        import android.app.DatePickerDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.provider.SyncStateContract;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;

        import android.text.Editable;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;

        import android.widget.EditText;
        import android.widget.SeekBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Calendar;

/**
 * Created by Sunil Chauhan on 2/10/2018.
 */

public class bus4date extends AppCompatActivity {

    private static final String TAG = bus4date.class.getSimpleName();

    private SeekBar seekBar;
    EditText btnShowDate;
    Button b1;
    String p,q;
    String s;

    String a,b,c,d,e,f;

    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus4date);
        b1=(Button) findViewById(R.id.bt1);






         btnShowDate = (EditText) findViewById(R.id.activity_third_btn_date);

        btnShowDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


                final DatePickerDialog datePickerDialog
                        = new DatePickerDialog(bus4date.this
                        ,onDateSetListener,year,month,dayOfMonth);


                datePickerDialog.show();

                s=btnShowDate.getText().toString();
            }
        });

        Intent i=getIntent();

        p=i.getStringExtra("from");
        q=i.getStringExtra("to");

        a=i.getStringExtra("travel");
    }



    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            final String date = dayOfMonth + "-" + (month + 1) + "-" + year;
            Toast.makeText(bus4date.this, "" + date, Toast.LENGTH_SHORT).show();
            calendar.set(year,month,dayOfMonth);

            btnShowDate.setText(date);
            s = btnShowDate.getText().toString();
        }
    };

    public void bus5ac(View v)
    {

        String username = btnShowDate.getText().toString();

        if(TextUtils.isEmpty(username) )
        {
            btnShowDate.requestFocus();
            btnShowDate.setError("Please select date");
        }


        else
        {
            btnShowDate.setError(null);
            Intent i=new Intent(this,bus5ac.class);
            i.putExtra("from",p);
            i.putExtra("to",q);
            i.putExtra("travel",a);
            i.putExtra("date", s);

            //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            startActivity(i);
        }

    }

}
