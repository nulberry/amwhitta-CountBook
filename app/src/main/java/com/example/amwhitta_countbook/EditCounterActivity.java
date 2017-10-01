package com.example.amwhitta_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCounterActivity extends AppCompatActivity {

    private Counter counter;
    private EditText nameText;
    private EditText currentText;
    private EditText initialText;
    private EditText commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_counter);

        nameText = (EditText) findViewById(R.id.editTextNewName);
        currentText = (EditText) findViewById(R.id.editTextCurrent);
        initialText = (EditText) findViewById(R.id.editTextNewInitial);
        commentText = (EditText) findViewById(R.id.editTextNewComment);

        // Store the counter sent by CounterActivity
        counter = (Counter) getIntent().getSerializableExtra("CounterToEdit");

        // When save button is clicked, save what has been entered in the edit fields
        Button saveButton = (Button) findViewById(R.id.buttonSaveEdits);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!TextUtils.isEmpty(nameText.getText().toString())) {
                    counter.setName(nameText.getText().toString());
                }
                if (!TextUtils.isEmpty(currentText.getText().toString())) {
                    counter.setCurrent(Integer.parseInt(currentText.getText().toString()));
                }
                if (!TextUtils.isEmpty(initialText.getText().toString())) {
                    counter.setInitial(Integer.parseInt(initialText.getText().toString()));
                }
                if (!TextUtils.isEmpty(commentText.getText().toString())) {
                    counter.setComment(commentText.getText().toString());
                }
                Intent intent = new Intent(EditCounterActivity.this, CounterActivity.class);
                intent.putExtra("EditedCounter", counter);
                startActivity(intent);
            }
        });
    }
}
