package com.fsociety2.aboutsliit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isuru Jayathilaka on 2018-03-30.
 */


public class DBHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "sliit.db";
    private static final String TABLE_ACADEMIC_STAFF = "academic_staff";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_POSITION = "position";

    public DBHelper(Context context){
        super(context.getApplicationContext(), DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE academic_staff(id integer PRIMARY KEY, title text, name text, position text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void save(AcademicStaffModel model){

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, model.getTitle());
        cv.put(COLUMN_NAME, model.getName());
        cv.put(COLUMN_POSITION, model.getPosition());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ACADEMIC_STAFF, null, cv);
        db.close();
    }

    public List<AcademicStaffModel> readAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM academic_staff",null);
        cur.moveToNext();
        int idIdx = cur.getColumnIndex(COLUMN_ID);
        int titleIdx = cur.getColumnIndex(COLUMN_TITLE);
        int nameIdx = cur.getColumnIndex(COLUMN_NAME);
        int positionIdx = cur.getColumnIndex(COLUMN_POSITION);
        List<AcademicStaffModel> data = new ArrayList<>();

        while (!cur.isAfterLast()){
            Integer id = cur.getInt(idIdx);
            String title = cur.getString(titleIdx);
            String name = cur.getString(nameIdx);
            String position = cur.getString(positionIdx);

            data.add(new AcademicStaffModel(id, title, name, position));
            cur.moveToNext();
        }
        return data;
    }
}
