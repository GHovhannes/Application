package database;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsersDao {
    @Query("SELECT * FROM users")
    List<UsersEntity> getAll();
}
