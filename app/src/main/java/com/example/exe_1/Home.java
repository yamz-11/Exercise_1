package com.example.exe_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {

    TextView eNama;
    EditText edTask, edTime, edJenis;
    FloatingActionButton tambah;

    String nama, task, waktu, jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edJenis = findViewById(R.id.inJenis);
        eNama = findViewById(R.id.nama);
        edTask = findViewById(R.id.inTask);
        edTime = findViewById(R.id.inTime);
        tambah = findViewById(R.id.submit);

        Bundle bundle = getIntent().getExtras();

        nama = bundle.getString("name");

        eNama.setText(nama);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edTask.getText().toString();
                jenis = edJenis.getText().toString();
                waktu = edTime.getText().toString();

                if (TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    Toast t = Toast.makeText(getApplicationContext(), "Wajib Isi Semua Data!", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    edTask.setError("Masukan Task!");
                }
                else if (!TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    edJenis.setError("Masukan Jenis Task!");
                }
                else if (!TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    edTime.setError("Masukan Lama Task!");
                }
                else if (!TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    edJenis.setError("Masukan Jenis Task!");
                    edTime.setError("Masukan Lama Task!");
                }
                else if (TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    edTask.setError("Masukan Task!");
                    edTime.setError("Masukan Lama Task!");
                }
                else if (TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    edTask.setError("Masukan Task!");
                    edJenis.setError("Masukan Jenis Task!");
                }
                else {

                    Toast t = Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT);
                    t.show();
                    Bundle b = new Bundle();

                    b.putString("task", task.trim());
                    b.putString("jenis", jenis.trim());
                    b.putString("time", waktu.trim());

                    Intent i = new Intent(getApplicationContext(), HasilActivity.class );
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }
}


