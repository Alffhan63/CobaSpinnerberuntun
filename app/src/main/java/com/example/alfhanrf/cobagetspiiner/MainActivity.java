    package com.example.alfhanrf.cobagetspiiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Spinner spinner1;
    public  TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.kocak);
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button button = (Button) findViewById(R.id.button);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements

        // Creating adapter for spinner
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_list_item_1);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final ArrayAdapter<CharSequence> dataAdapter1 = ArrayAdapter.createFromResource(this,R.array.spinner1, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> dataAdapter2 = ArrayAdapter.createFromResource(this, R.array.spinner2, android.R.layout.simple_list_item_1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(position ==3){
                   spinner1.setAdapter(dataAdapter1);
               }else{
                   spinner1.setAdapter(dataAdapter2);
               }
               return;
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {





        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
