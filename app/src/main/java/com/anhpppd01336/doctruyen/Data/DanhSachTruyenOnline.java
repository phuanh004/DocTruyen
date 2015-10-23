package com.anhpppd01336.doctruyen.Data;

/**
 * Created by Anh Pham on 21/10/2015.
 */
public class DanhSachTruyenOnline {
    String biaTruyen, tenTruyen, tomTatTruyen, linkTruyen;

    public DanhSachTruyenOnline(String biaTruyen, String tenTruyen, String tomTatTruyen, String linkTruyen) {
        this.biaTruyen = biaTruyen;
        this.tenTruyen = tenTruyen;
        this.tomTatTruyen = tomTatTruyen;
        this.linkTruyen = linkTruyen;
    }
    public DanhSachTruyenOnline() {
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

    public String getLinkTruyen() {
        return linkTruyen;
    }

    public void setLinkTruyen(String linkTruyen) {
        this.linkTruyen = linkTruyen;
    }
}
