package com.anhpppd01336.doctruyen.Data;

/**
 * Created by Anh Pham on 01/10/2015.
 */
public class DanhSachTruyen {
    String biaTruyen, tenTruyen, tomTatTruyen;

    public DanhSachTruyen(String biaTruyen, String tenTruyen, String tomTatTruyen) {
        this.biaTruyen = biaTruyen;
        this.tenTruyen = tenTruyen;
        this.tomTatTruyen = tomTatTruyen;
    }
    public DanhSachTruyen() {
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
}
