package database;





import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "users")
public class UsersEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "profile")
    public String profile;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "image")
    public ImageView image;
}
