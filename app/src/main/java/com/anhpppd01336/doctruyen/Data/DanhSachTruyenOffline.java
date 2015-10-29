package com.anhpppd01336.doctruyen.Data;

/**
 * Created by Anh Pham on 27/10/2015.
 */
public class DanhSachTruyenOffline {
    String biaTruyen, tenTruyen, tomTatTruyen, noiDungTruyen;

    public DanhSachTruyenOffline(String biaTruyen, String tenTruyen, String tomTatTruyen, String noiDungTruyen) {
        this.biaTruyen = biaTruyen;
        this.tenTruyen = tenTruyen;
        this.tomTatTruyen = tomTatTruyen;
        this.noiDungTruyen = noiDungTruyen;
    }

    public DanhSachTruyenOffline() {
    }

    public String getBiaTruyen() {
        return biaTruyen;
    }

    public void setBiaTruyen(String biaTruyen) {
        this.biaTruyen = biaTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTomTatTruyen() {
        return tomTatTruyen;
    }

    public void setTomTatTruyen(String tomTatTruyen) {
        this.tomTatTruyen = tomTatTruyen;
    }

    public String getNoiDungTruyen() {
        return noiDungTruyen;
    }

    public void setNoiDungTruyen(String noiDungTruyen) {
        this.noiDungTruyen = noiDungTruyen;
    }
}
