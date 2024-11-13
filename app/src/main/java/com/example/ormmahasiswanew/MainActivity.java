package com.example.ormmahasiswanew;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ormmahasiswa.R;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNama, editTextNIM, editTextAlamat, editTextAsalSekolah;
    private Button buttonSave;
    private TextView textViewDisplay;
    private mahasiswadatabase database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = mahasiswadatabase.getDatabase(this);

        editTextNama = findViewById(R.id.editTextNama);
        editTextNIM = findViewById(R.id.editTextNIM);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        editTextAsalSekolah = findViewById(R.id.editTextAsalSekolah);
        buttonSave = findViewById(R.id.buttonSave);
        textViewDisplay = findViewById(R.id.textViewDisplay);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String nim = editTextNIM.getText().toString();
                String alamat = editTextAlamat.getText().toString();
                String asalSekolah = editTextAsalSekolah.getText().toString();

                mahasiswa student = new mahasiswa();
                student.setNama(nama);
                student.setNim(nim);
                student.setAlamat(alamat);
                student.setAsalSekolah(asalSekolah);

                // Insert the student into the database
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        database.mahasiswadao().insertmahasiswa(student);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                displayStudents();
                            }
                        });
                    }
                }).start();
            }
        });

        displayStudents();
    }

    private void displayStudents() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<mahasiswa> students = database.mahasiswadao().getAllStudents();
                StringBuilder displayText = new StringBuilder();
                for (mahasiswa student : students) {
                    displayText.append("Nama: ").append(student.getNama())
                            .append(", NIM: ").append(student.getNim())
                            .append(", Alamat: ").append(student.getAlamat())
                            .append(", Asal Sekolah: ").append(student.getAsalSekolah())
                            .append("\n\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewDisplay.setText(displayText.toString());
                    }
                });
            }
        }).start();
    }
}