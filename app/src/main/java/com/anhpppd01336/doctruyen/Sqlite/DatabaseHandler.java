package com.anhpppd01336.doctruyen.Sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyen;

import java.util.ArrayList;

/**
 * Created by Anh Pham on 19/10/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbDocTruyen";
    public static final int DATABASE_VERSION = 1;

    public void doTableTruyen(SQLiteDatabase db) {
        String sSQL = "CREATE  TABLE tbTruyen (tenTruyen TEXT, tomTat TEXT, biaTruyen TEXT)";
        db.execSQL(sSQL);
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        doTableTruyen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Phuong Thuc

    public void addDataThuChi(DanhSachTruyen danhSachTruyen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenTruyen", danhSachTruyen.getTenTruyen());
        values.put("tomTat", danhSachTruyen.getTomTatTruyen());
        values.put("biaTruyen", danhSachTruyen.getBiaTruyen());
        db.insert("tbChiTieu", null, values);
        db.close();
    }

    public ArrayList<DanhSachTruyen> getAllDataTruyen() {
        ArrayList<DanhSachTruyen> danhSachTruyenArrayList = new ArrayList<>();
        String sSQL = "SELECT  * FROM tbTruyen";
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sSQL, null);

        if (cursor.moveToFirst()) {
            do {
                DanhSachTruyen danhSachTruyen = new DanhSachTruyen();
                danhSachTruyen.setTenTruyen(cursor.getString(0));
                danhSachTruyen.setTomTatTruyen(cursor.getString(1));
                danhSachTruyen.setBiaTruyen(cursor.getString(2));

                danhSachTruyenArrayList.add(danhSachTruyen);
            } while (cursor.moveToNext());
        }

        return danhSachTruyenArrayList;
    }
}
