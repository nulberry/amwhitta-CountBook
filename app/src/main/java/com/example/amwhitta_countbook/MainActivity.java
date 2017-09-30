package com.example.amwhitta_countbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ListView counterList;
    private TextView counterNumber;
    private ArrayList<Counter> counters;
    private ArrayAdapter<Counter> adapter;
    private Counter new_counter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterList = (ListView) findViewById(R.id.listViewCounters);
        counterNumber = (TextView) findViewById(R.id.textViewCount);
        Button createNewCounter = (Button) findViewById(R.id.buttonNewCounter);

        //If a counter was just created, save it
        //Log.d("PRINT:", new_counter.getName());
        new_counter = (Counter) getIntent().getSerializableExtra("NewCounter");

        createNewCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Debugging", "clicked new counter button");
                Intent intent = new Intent(MainActivity.this, NewCounterActivity.class);
                startActivity(intent);
            }
        });

        counterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Debugging", "clicked counter in list");
                Intent intent = new Intent(MainActivity.this, CounterActivity.class);
                intent.putExtra("Counter", counters.get(i));
                startActivity(intent);
            }
        });
        Log.d("Debugging", "end of onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Counter>(this, R.layout.counter_list_item, counters);
        counterList.setAdapter(adapter);
        if (new_counter != null) {
            counters.add(new_counter);
            new_counter = null;
        }
        adapter.notifyDataSetChanged();
        counterNumber.setText(Integer.toString(counters.size()));
        saveInFile();
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Counter>>() {}.getType();
            counters = gson.fromJson(in, listType);
        }
        catch (FileNotFoundException e) {
            counters = new ArrayList<Counter>();
            //e.printStackTrace();
        }
        catch (IOException e) {
            throw new RuntimeException();
            //e.printStackTrace();
        }
        return;
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(counters, writer);
            writer.flush();
            fos.close();
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            throw new RuntimeException();
        }
        catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
