package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class sqlLite extends SQLiteOpenHelper {
    public static final String dbname = "empl.db";


    public sqlLite(@Nullable Context context) {
        super(context, dbname, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table empo ( id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT ,sex TEXT ,BaseSalary FLOAT,TotalSales FLOAT,CommissionRate FLOAT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS empo");
        onCreate(db);
    }

    public boolean insert(String name, String sex, float BaseSalary, float TotalSales, float CommissionRate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("sex", sex);
        contentValues.put("BaseSalary", BaseSalary);
        contentValues.put("TotalSales", TotalSales);
        contentValues.put("CommissionRate", CommissionRate);

        long result = db.insert("empo", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }


    public boolean modify(String id, String name, String sex, float BaseSalary, float TotalSales, float CommissionRate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("sex", sex);
        contentValues.put("BaseSalary", BaseSalary);
        contentValues.put("TotalSales", TotalSales);
        contentValues.put("CommissionRate", CommissionRate);
        db.update("empo", contentValues, "id= ?", new String[]{id});

        return true;
    }


    int delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("empo", "id= ?", new String[]{id});

    }

    public ArrayList getData(int s) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from empo where id=" + s, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            String s1 = res.getString(0);
            String s2 = res.getString(1);
            String s3 = res.getString(2);
            String s4 = res.getString(3);
            String s5 = res.getString(4);
            String s6 = res.getString(5);
            arrayList.add("id = " + s1 + "\n" + "name =" + s2 + "\n" + "sex = " + s3 + "\n" + "Base Salary=" + s4 + "\n" + "Total Salary =" + s5 + "\n" + "Commission  Rate = " + s6 + "\n");

            res.moveToNext();
        }
        return arrayList;

    }

    public ArrayList search(int s) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from empo where id=" + s, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            String s1 = res.getString(0);
            String s2 = res.getString(1);
            String s3 = res.getString(2);
            String s4 = res.getString(3);
            String s5 = res.getString(4);
            String s6 = res.getString(5);
            arrayList.add("id = " + s1 + "\n" + "name =" + s2 + "\n" + "sex = " + s3 + "\n" + "Base Salary=" + s4 + "\n" + "Total Salary =" + s5 + "\n" + "Commission  Rate = " + s6 + "\n");

            res.moveToNext();
        }
        return arrayList;

    }
}






