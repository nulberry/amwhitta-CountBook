package com.example.amwhitta_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class CounterDetailsActivity extends AppCompatActivity {

    private Counter counter;
    private TextView counterName;
    private TextView counterDate;
    private TextView counterCurrent;
    private TextView counterInitial;
    private TextView counterComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_details);

        counter = (Counter) getIntent().getSerializableExtra("CounterDetails");

        counterName = (TextView) findViewById(R.id.textViewNameDetail);
        counterDate = (TextView) findViewById(R.id.textViewDateDetail);
        counterCurrent = (TextView) findViewById(R.id.textViewCurrentDetail);
        counterInitial = (TextView) findViewById(R.id.textViewInitialDetail);
        counterComment = (TextView) findViewById(R.id.textViewCommentDetail);

        counterName.setText("Name: " + counter.getName());
        counterDate.setText("Date modified: " + counter.getDate());
        counterCurrent.setText("Current value: " + Integer.toString(counter.getCurrent()));
        counterInitial.setText("Initial value: " + Integer.toString(counter.getInitial()));
        counterComment.setText("Comment: " + counter.getComment());
    }
}
