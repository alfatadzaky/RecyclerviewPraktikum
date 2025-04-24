package com.example.recyclerviewpraktikum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText inputTitle, inputDesc, inputCreator, inputDate;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        inputTitle = findViewById(R.id.inputTitle);
        inputDesc = findViewById(R.id.inputDesc);
        inputCreator = findViewById(R.id.inputCreator);
        inputDate = findViewById(R.id.inputDate);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String title = inputTitle.getText().toString();
            String desc = inputDesc.getText().toString();
            String creator = inputCreator.getText().toString();
            String date = inputDate.getText().toString();

            if (!title.isEmpty()) {
                Intent intent = new Intent();
                intent.putExtra("title", title);
                intent.putExtra("desc", desc);
                intent.putExtra("creator", creator);
                intent.putExtra("date", date);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(this, "Nama konten wajib diisi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


