package com.gsy.glsurvive.sqlite;

/**
 * Created by Administrator on 2017/3/6.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_M extends SQLiteOpenHelper {
    public static final String table_name="info";

    public DB_M(Context context) {
        super(context, "searchList.db", null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String  table_sql="create table "+table_name+"( _id  integer primary key autoincrement," +
                " userId varchar(20) not null, historyItem varchar(100) )";
        db.execSQL(table_sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
}