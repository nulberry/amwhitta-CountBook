package com.example.amwhitta_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class NewCounterActivity extends AppCompatActivity {

    private Counter counter;
    private EditText nameText;
    private EditText initialText;
    private EditText commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_counter);

        nameText = (EditText) findViewById(R.id.editTextNewName);
        initialText = (EditText) findViewById(R.id.editTextNewInitial);
        commentText = (EditText) findViewById(R.id.editTextNewComment);

        // When save button is clicked, save what has been entered in the edit fields
        Button createCounterButton = (Button) findViewById(R.id.buttonCreate);
        createCounterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String new_name = nameText.getText().toString();
                Integer new_initial = Integer.parseInt(initialText.getText().toString());
                String new_comment = commentText.getText().toString();

                counter = new Counter(new_name, new_initial);
                counter.setComment(new_comment);

                Intent intent = new Intent(NewCounterActivity.this, MainActivity.class);
                intent.putExtra("NewCounter", counter);
                //Serializable counter1 = intent.getSerializableExtra("NewCounter");
                //Log.d("PRINT:", counter1.toString());
                startActivity(intent);
                Log.d("Debugging", "end of new counter");
            }
        });
    }
}
