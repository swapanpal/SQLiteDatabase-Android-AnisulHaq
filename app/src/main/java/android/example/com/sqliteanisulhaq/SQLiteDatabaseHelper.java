package android.example.com.sqliteanisulhaq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "Student.db";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final int VERSION_NUMBER = 2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+AGE+" INTEGER , \"+GENDER+\" VERCHER(15))";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    Context context;

    public SQLiteDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            Toast.makeText(context,"onCreate is created ",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context,"Exception: " + e,Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context,"onUpgrade is called ",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context,"Exception: " + e,Toast.LENGTH_SHORT).show();
        }


    }
}
