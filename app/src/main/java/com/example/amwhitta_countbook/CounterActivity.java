package com.example.amwhitta_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private TextView counterName;
    private TextView currentValue;
    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        ImageButton plusButton = (ImageButton) findViewById(R.id.imageButtonPlus);
        ImageButton minusButton = (ImageButton) findViewById(R.id.imageButtonMinus);
        Button resetButton = (Button) findViewById(R.id.buttonReset);
        Button editButton = (Button) findViewById(R.id.buttonEdit);
        Button deleteButton = (Button) findViewById(R.id.buttonDelete);
        Button detailsButton = (Button) findViewById(R.id.buttonDetails);
    }

    @Override
    protected void onStart() {
        super.onStart();
        counterName.setText(counter.getName());
        currentValue.setText(counter.getCurrent());
    }
}
