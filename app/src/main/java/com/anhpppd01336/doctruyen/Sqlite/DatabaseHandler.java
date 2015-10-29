package com.anhpppd01336.doctruyen.Sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOffline;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;

import java.util.ArrayList;

/**
 * Created by Anh Pham on 19/10/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbDocTruyen";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void doTableTruyenVuaDocOnline(SQLiteDatabase db) {
        String sSQL = "CREATE TABLE tbTruyenVuaDocOnline (tenTruyen TEXT, tomTat TEXT, biaTruyen TEXT, link TEXT)";
        db.execSQL(sSQL);
    }

    public void doTableTruyenVuaDocOffline(SQLiteDatabase db) {
        String sSQL = "CREATE TABLE tbTruyenVuaDocOffline (tenTruyen TEXT, tomTat TEXT, biaTruyen TEXT, noiDung TEXT)";
        db.execSQL(sSQL);
    }

    public void doTableTruyenCuaToiOffline(SQLiteDatabase db) {
        String sSQL = "CREATE TABLE tbTruyenCuaToiOffline (tenTruyen TEXT, tomTat TEXT, biaTruyen TEXT, noiDung TEXT)";
        db.execSQL(sSQL);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        doTableTruyenVuaDocOnline(db);
        doTableTruyenVuaDocOffline(db);
        doTableTruyenCuaToiOffline(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Phuong Thuc
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

    public void addDataTruyenVuaDocOffline(DanhSachTruyenOffline danhSachTruyenOffline) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenTruyen", danhSachTruyenOffline.getTenTruyen());
        values.put("tomTat", danhSachTruyenOffline.getTomTatTruyen());
        values.put("biaTruyen", danhSachTruyenOffline.getBiaTruyen());
        values.put("noiDung", danhSachTruyenOffline.getNoiDungTruyen());
        db.insert("tbTruyenVuaDocOffline", null, values);
        db.close();
    }

    public void addDataTruyenCuaToiOnline(DanhSachTruyenOnline danhSachTruyenOnline) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenTruyen", danhSachTruyenOnline.getTenTruyen());
        values.put("tomTat", danhSachTruyenOnline.getTomTatTruyen());
        values.put("biaTruyen", danhSachTruyenOnline.getBiaTruyen());
        values.put("link", danhSachTruyenOnline.getLinkTruyen());
        db.insert("tbTruyenCuaToiOnline", null, values);
        db.close();
    }

    public void addDataTruyenCuaToiOffline(DanhSachTruyenOffline danhSachTruyenOffline) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenTruyen", danhSachTruyenOffline.getTenTruyen());
        values.put("tomTat", danhSachTruyenOffline.getTomTatTruyen());
        values.put("biaTruyen", danhSachTruyenOffline.getBiaTruyen());
        values.put("noiDung", danhSachTruyenOffline.getNoiDungTruyen());
        db.insert("tbTruyenCuaToiOnline", null, values);
        db.close();
    }

    public void deleteTruyenVuaDocOnline() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sSQL = "DELETE * FROM tbTruyenVuaDocOnline";
        db.execSQL(sSQL);
        db.close();
    }

    public ArrayList<DanhSachTruyenOnline> getAllDataTruyenVuaDocOnline() {
        ArrayList<DanhSachTruyenOnline> danhSachTruyenArrayList = new ArrayList<>();
        String sSQL = "SELECT  * FROM tbTruyenVuaDocOnline";
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sSQL, null);

        if (cursor.moveToFirst()) {
            do {
                DanhSachTruyenOnline danhSachTruyenOnline = new DanhSachTruyenOnline();
                danhSachTruyenOnline.setTenTruyen(cursor.getString(0));
                danhSachTruyenOnline.setTomTatTruyen(cursor.getString(1));
                danhSachTruyenOnline.setBiaTruyen(cursor.getString(2));
                danhSachTruyenOnline.setLinkTruyen(cursor.getString(3));

                danhSachTruyenArrayList.add(danhSachTruyenOnline);
            } while (cursor.moveToNext());
        }

        return danhSachTruyenArrayList;
    }

    public ArrayList<DanhSachTruyenOffline> getAllDataTruyenVuaDocOffline() {
        ArrayList<DanhSachTruyenOffline> danhSachTruyenArrayList = new ArrayList<>();
        String sSQL = "SELECT  * FROM tbTruyenVuaDocOffline";
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sSQL, null);

        if (cursor.moveToFirst()) {
            do {
                DanhSachTruyenOffline danhSachTruyenOffline = new DanhSachTruyenOffline();
                danhSachTruyenOffline.setTenTruyen(cursor.getString(0));
                danhSachTruyenOffline.setTomTatTruyen(cursor.getString(1));
                danhSachTruyenOffline.setBiaTruyen(cursor.getString(2));
                danhSachTruyenOffline.setNoiDungTruyen(cursor.getString(3));

                danhSachTruyenArrayList.add(danhSachTruyenOffline);
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

    public boolean isTruyenVuaDocOfflineAvalable(String tenTruyen, String biaTruyen) {
        ArrayList<DanhSachTruyenOffline> danhSachTruyenArrayList = new ArrayList<>();
        boolean a;
        String sSQL = "SELECT  * FROM tbTruyenVuaDocOffline WHERE tenTruyen='" + tenTruyen + "' AND biaTruyen='" + biaTruyen + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sSQL, null);

        if (cursor.moveToFirst()) {
            do {
                DanhSachTruyenOffline danhSachTruyenOffline = new DanhSachTruyenOffline();
                danhSachTruyenOffline.setTenTruyen(cursor.getString(0));
                danhSachTruyenOffline.setBiaTruyen(cursor.getString(2));

                danhSachTruyenArrayList.add(danhSachTruyenOffline);
            } while (cursor.moveToNext());
        }
        a = danhSachTruyenArrayList.size() > 0;

        return a;
    }
}
