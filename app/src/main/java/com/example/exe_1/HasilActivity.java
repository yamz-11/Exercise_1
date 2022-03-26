package com.example.exe_1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    TextView task, jenis, time;

    String htask, hjenis, htime;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnLogout)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        task = findViewById(R.id.rsTask);
        jenis = findViewById(R.id.rsJenis);
        time = findViewById(R.id.rsTime);

        // Penggunaan Bundle
        Bundle bundle = getIntent().getExtras();

        htask = bundle.getString("task");
        hjenis = bundle.getString("jenis");
        htime = bundle.getString("time");

        task.setText(htask);
        jenis.setText(hjenis);
        time.setText(hjenis);

    }
}