package com.example.amwhitta_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CounterDetailsActivity extends AppCompatActivity {

    private Counter counter;
    private ListView detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_details);

        detailsList = (ListView) findViewById(R.id.listViewDetails);

    }
}
