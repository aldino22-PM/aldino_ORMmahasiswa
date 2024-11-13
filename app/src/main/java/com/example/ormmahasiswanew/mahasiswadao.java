package com.example.ormmahasiswanew;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface mahasiswadao {
    @Insert
    void insertmahasiswa(mahasiswa mahasiswa);

    @Query("SELECT * FROM mahasiswa")
    List<mahasiswa> getAllStudents();
}
