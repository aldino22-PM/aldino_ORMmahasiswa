package com.example.ormmahasiswanew;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {mahasiswa.class}, version = 1)
public abstract class mahasiswadatabase extends RoomDatabase {
    public abstract mahasiswadao mahasiswadao();

    private static volatile mahasiswadatabase INSTANCE;

    public static mahasiswadatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (mahasiswadatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    mahasiswadatabase.class, "mahasiswa_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}