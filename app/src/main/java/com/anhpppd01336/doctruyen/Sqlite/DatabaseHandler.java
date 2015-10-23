package com.anhpppd01336.doctruyen.Sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyen;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;

import java.util.ArrayList;

/**
 * Created by Anh Pham on 19/10/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbDocTruyen";
    public static final int DATABASE_VERSION = 1;

    public void doTableTruyen(SQLiteDatabase db) {
        String sSQL = "CREATE TABLE tbTruyen (tenTruyen TEXT, tomTat TEXT, biaTruyen TEXT)";
        db.execSQL(sSQL);
    }
    public void doTableTruyenVuaDocOnline(SQLiteDatabase db) {
        String sSQL = "CREATE TABLE tbTruyenVuaDocOnline (tenTruyen TEXT, tomTat TEXT, biaTruyen TEXT, link TEXT)";
        db.execSQL(sSQL);
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        doTableTruyen(db);
        doTableTruyenVuaDocOnline(db);
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
    public void addDataTruyenVuaDocOnline(DanhSachTruyenOnline danhSachTruyenOnline) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenTruyen", danhSachTruyenOnline.getTenTruyen());
        values.put("tomTat", danhSachTruyenOnline.getTomTatTruyen());
        values.put("biaTruyen", danhSachTruyenOnline.getBiaTruyen());
        values.put("link", danhSachTruyenOnline.getLinkTruyen());
        db.insert("tbTruyenVuaDocOnline", null, values);
        db.close();
    }

    public void deleteTruyenVuaDocOnline(String tenTruyen, String link) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sSQL = "DELETE FROM tbTruyenVuaDocOnline WHERE tenTruyen='"+tenTruyen+"' AND link='"+link+"'";
        db.execSQL(sSQL);
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
    public ArrayList<DanhSachTruyen> getAllDataTruyenVuaDocOnline() {
        ArrayList<DanhSachTruyen> danhSachTruyenArrayList = new ArrayList<>();
        String sSQL = "SELECT  * FROM tbTruyenVuaDocOnline";
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
    public boolean isTruyenVuaDocOnlineAvalable(String tenTruyen, String link) {
        ArrayList<DanhSachTruyenOnline> danhSachTruyenArrayList = new ArrayList<>();
        boolean a ;
        String sSQL = "SELECT  * FROM tbTruyenVuaDocOnline WHERE tenTruyen='"+tenTruyen+"' AND link='"+link+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sSQL, null);

        if (cursor.moveToFirst()) {
            do {
                DanhSachTruyenOnline danhSachTruyenOnline = new DanhSachTruyenOnline();
                danhSachTruyenOnline.setTenTruyen(cursor.getString(0));
                danhSachTruyenOnline.setLinkTruyen(cursor.getString(3));

                danhSachTruyenArrayList.add(danhSachTruyenOnline);
            } while (cursor.moveToNext());
        }
        a = danhSachTruyenArrayList.size() > 0;

        return a;
    }
}
