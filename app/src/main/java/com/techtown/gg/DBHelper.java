package com.techtown.gg;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS DOG (id VARCHAR(20), name VARCHAR(20), age INTEGER, birth VARCHAR(20), sex VARCHAR(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }

    public void insert(String id, String name, int age, String birth, String sex){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO DOG VALUES ( '" + id + "', " + name + ", '" + age + "', '" + birth + "', '" + sex + "');");
        db.close();
    }

    //public void delete(String item){}

    public String getResult(String id, String item, int i) {  // item 하나씩 찾아서 반환
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT" +  item + " FROM DOG WHERE ID = " + id , null);

        result = cursor.getString(i);

        return result;
    }

}
