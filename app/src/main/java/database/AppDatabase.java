package database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = UsersEntity.class,version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract UsersDao usersDao();
}
