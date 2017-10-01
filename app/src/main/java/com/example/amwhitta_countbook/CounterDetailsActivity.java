package com.example.amwhitta_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class CounterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_details);

        Counter counter = (Counter) getIntent().getSerializableExtra("CounterDetails");

        TextView counterName = (TextView) findViewById(R.id.textViewNameDetail);
        TextView counterDate = (TextView) findViewById(R.id.textViewDateDetail);
        TextView counterCurrent = (TextView) findViewById(R.id.textViewCurrentDetail);
        TextView counterInitial = (TextView) findViewById(R.id.textViewInitialDetail);
        TextView counterComment = (TextView) findViewById(R.id.textViewCommentDetail);

        counterName.setText("Name: " + counter.getName());
        counterDate.setText("Date modified: " + counter.getDate());
        counterCurrent.setText("Current count: " + Integer.toString(counter.getCurrent()));
        counterInitial.setText("Initial count: " + Integer.toString(counter.getInitial()));
        counterComment.setText("Comment: " + counter.getComment());
    }
}
