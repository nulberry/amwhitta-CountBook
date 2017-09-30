package com.example.amwhitta_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private TextView counterName;
    private TextView currentValue;
    private Counter counter;
    private Counter edited_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counter = (Counter) getIntent().getSerializableExtra("Counter");
        edited_counter = (Counter) getIntent().getSerializableExtra("EditedCounter");

        counterName = (TextView) findViewById(R.id.textViewName);
        currentValue = (TextView) findViewById(R.id.textViewCurrent);
        ImageButton plusButton = (ImageButton) findViewById(R.id.imageButtonPlus);
        ImageButton minusButton = (ImageButton) findViewById(R.id.imageButtonMinus);
        Button resetButton = (Button) findViewById(R.id.buttonReset);
        Button editButton = (Button) findViewById(R.id.buttonEdit);
        Button deleteButton = (Button) findViewById(R.id.buttonDelete);
        Button detailsButton = (Button) findViewById(R.id.buttonDetails);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.increment();
                currentValue.setText(Integer.toString(counter.getCurrent()));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.decrement();
                currentValue.setText(Integer.toString(counter.getCurrent()));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.reset();
                currentValue.setText(Integer.toString(counter.getCurrent()));
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, EditCounterActivity.class);
                intent.putExtra("CounterToEdit", counter);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, MainActivity.class);
                intent.putExtra("DeleteCounter", true);
                startActivity(intent);
            }
        });

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, CounterDetailsActivity.class);
                intent.putExtra("CounterDetails", counter);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (edited_counter != null) {
            counter = edited_counter;
        }
        counterName.setText(counter.getName());
        currentValue.setText(Integer.toString(counter.getCurrent()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CounterActivity.this, MainActivity.class);
        intent.putExtra("UpdatedCounter", counter);
        startActivity(intent);
    }
}
