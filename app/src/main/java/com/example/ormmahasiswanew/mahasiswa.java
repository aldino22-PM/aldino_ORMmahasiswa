package com.example.ormmahasiswanew;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mahasiswa")

public class mahasiswa {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nama;
    private String nim;
    private String alamat;
    private String asalSekolah;

    // Constructor, getter, dan setter
    public mahasiswa() {
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.asalSekolah = asalSekolah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }
}
