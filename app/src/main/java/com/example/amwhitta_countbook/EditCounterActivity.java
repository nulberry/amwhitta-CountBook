package com.example.amwhitta_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        // EDIT FIELDS
        nameText = (EditText) findViewById(R.id.editTextNewName);
        currentText = (EditText) findViewById(R.id.editTextCurrent);
        initialText = (EditText) findViewById(R.id.editTextNewInitial);
        commentText = (EditText) findViewById(R.id.editTextNewComment);

        // When save button is clicked, save what has been entered in the edit fields
        Button saveButton = (Button) findViewById(R.id.buttonSaveEdits);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String new_name = nameText.getText().toString();
                Integer new_current = Integer.parseInt(currentText.getText().toString());
                Integer new_initial = Integer.parseInt(initialText.getText().toString());
                String new_comment = commentText.getText().toString();

                counter.setName(new_name);
                counter.setCurrent(new_current);
                counter.setInitial(new_initial);
                counter.setComment(new_comment);
            }
        });
    }
}
