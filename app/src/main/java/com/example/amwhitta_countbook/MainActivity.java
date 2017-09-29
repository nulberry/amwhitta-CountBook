package com.example.amwhitta_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ListView counterList;
    private EditText counterNumber;

    private ArrayList<Counter> counters = new ArrayList<Counter>();
    private ArrayAdapter<Counter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterList = (ListView) findViewById(R.id.listViewCounters);
        counterNumber = (EditText) findViewById(R.id.editTextNumCounters);
        Button newCounter = (Button) findViewById(R.id.buttonNewCounter);

        newCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewCounterActivity.class);
                startActivity(intent);
            }
        });

        counterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, CounterActivity.class);
                intent.putExtra("Counter", counters.get(i));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //loadFromFile();
    }

    @Override
    protected void onListItemClick() {

    }


}
