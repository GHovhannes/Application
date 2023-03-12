package database;

import android.content.Context;

import androidx.room.Room;

public class Database {
    private static final String DB_NAME = "users.db";
    private static Database instance;
    private final AppDatabase appDatabase;

    private Database(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = new Database(context);
        }
        return instance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
