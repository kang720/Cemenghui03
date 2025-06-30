package com.example.cemenghui03.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cemenghui03.entity.Item4;

import java.util.ArrayList;
import java.util.List;

public class MySqlHelper extends SQLiteOpenHelper {
    private static final String SQL_NAME = "mySQLite.db";
    private static final String TABLE_NAME_ITEM4 = "item4";
    private static final String create_table_sql = "create table " + TABLE_NAME_ITEM4 + "(id integer primary key autoincrement,img integer,name text,introduction text,content text,date text);";

    public MySqlHelper(@Nullable Context context) {
        super(context, SQL_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(Item4 item4) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("introduction", item4.getIntroduction());
        values.put("name", item4.getName());
        values.put("content", item4.getContent());
        values.put("date", item4.getDate());
        values.put("img", item4.getImg());
        return db.insert(TABLE_NAME_ITEM4, null, values);
    }
    public int deleteByName(String name){
        SQLiteDatabase db=getWritableDatabase();
        return db.delete(TABLE_NAME_ITEM4,"name = ?",new String[]{name});
    }

    public List<Item4> selectAllData() {
        SQLiteDatabase db = getWritableDatabase();
        List<Item4> item4List=new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_ITEM4, null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                Integer img = cursor.getInt(cursor.getColumnIndexOrThrow("img"));

                Item4 item4=new Item4(img,name,introduction,content,date);
                item4List.add(item4);

            }
        }
        return item4List;
    }

    public List<Item4> selectByKey(String input) {
        SQLiteDatabase db = getWritableDatabase();
        List<Item4> item4List=new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_ITEM4, null, "name like ?", new String[]{"%" + input + "%"}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                Integer img = cursor.getInt(cursor.getColumnIndexOrThrow("img"));

                Item4 item4=new Item4(img,name,introduction,content,date);
                item4List.add(item4);

            }
        }
        return item4List;
    }
}
