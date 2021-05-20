package com.example.admin.busbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class bus3seat extends AppCompatActivity implements OnSeatSelected {

    private static final int COLUMNS = 5;
    private TextView txtSeatSelected;
    String p,q;
    TextView forseat;

    String a,b,c,d,e,f,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus3seat);

        txtSeatSelected = (TextView)findViewById(R.id.txt_seat_selected);

        List<AbstractItem> items = new ArrayList<>();
        for (int i=0; i<30; i++) {

            if (i%COLUMNS==0 || i%COLUMNS==4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(manager);

        AirplaneAdapter adapter = new AirplaneAdapter(this, items);
        recyclerView.setAdapter(adapter);

        Intent i=getIntent();


        p=i.getStringExtra("from");
        q=i.getStringExtra("to");
        a=i.getStringExtra("travel");
        b=i.getStringExtra("date");




    }

    @Override

    public void onSeatSelected(int count) {

        txtSeatSelected.setText("Book " + count + " seats");

        if (count >= 7) {
            txtSeatSelected.requestFocus();
            Toast.makeText(this, "select less than 6 seats", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,bus3seat.class);
            startActivity(i);
        }

        else
        {
            new bus6book();
        }

    }

    public void bus6book(View v)
    {

        forseat=(TextView) findViewById(R.id.txt_seat_selected);



        Intent i=new Intent(this,bus6book.class);
//        i.putExtra("travel",forseat.getText().toString());
        startActivityForResult(i,1);
        i.putExtra("from",p);
        i.putExtra("to",q);
        i.putExtra("travel",a);

        String s=String.valueOf(forseat.getText());

        i.putExtra("date",b);
        i.putExtra("noOfSeats",forseat.getText().toString());
        //Toast.makeText(this, "date is selected"+b, Toast.LENGTH_SHORT).show();
        startActivityForResult(i,1);
        startActivity(i);
    }
}



