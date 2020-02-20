package com.nadeen.sqliteapplication.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

public class DBManager {
    Context context;
    DataBaseHelper dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    static final String DBNAME="Students";
    static final String DBTable="Login";
    static final int DBVER=1;
    static final String CreateTable="CREATE TABLE IF NOT EXISTS "+DBTable+
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,UserName TEXT ,Password TEXT);";

    static final String Drop="DROP TABLE IF EXISTS "+DBTable;

    static class DataBaseHelper extends SQLiteOpenHelper{
        Context context;
        public DataBaseHelper(Context context){
            super(context,DBNAME,null,DBVER);
         this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreateTable);
            Toast.makeText(context,"Table Is Created",Toast.LENGTH_LONG).show();
        }

        @Override
         public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
               db.execSQL(Drop);
               onCreate(db);
        }
    }

    public DBManager(Context context) {
   this.context=context;
    dataBaseHelper=new DataBaseHelper(context);
   sqLiteDatabase=dataBaseHelper.getWritableDatabase();
    }

      public long InsertDate(ContentValues values){
       long id= sqLiteDatabase.insert(DBTable,"",values);
        return id;
      }
       public Cursor QueryData(String[]Projection,String Selection,String[]SelectionArgs,String OrderData){

           SQLiteQueryBuilder sqLiteQueryBuilder=new SQLiteQueryBuilder();
           sqLiteQueryBuilder.setTables(DBTable);
           Cursor cursor=sqLiteQueryBuilder.query(sqLiteDatabase,Projection,Selection,
                   SelectionArgs,null,null,OrderData);
       return cursor;
       }
   public int Delete(String Selection,String[]SelectionArgs){
        int id=sqLiteDatabase.delete(DBTable,Selection,SelectionArgs);
        return id;
   }
   public int Update(ContentValues values,String Selection,String[]SelectionArgs){
        int id=sqLiteDatabase.update(DBTable,values,Selection,SelectionArgs)
                ;
        return id;
   }
}
