/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author VuDinhHieu
 */
public class ThongTinThuPhiModel {
    private String maDotThu;
    private String maHoKhau;
    //private int soNhanKhau;
    private int tongSoTien;

    public ThongTinThuPhiModel() {
    }

    public ThongTinThuPhiModel(String maDotThu, String maHoKhau, int tongSoTien, Date ngayThu) {
        this.maDotThu = maDotThu;
        this.maHoKhau = maHoKhau;
        this.tongSoTien = tongSoTien;
        this.ngayThu = ngayThu;
    }

    
    
    public String getMaDotThu() {
        return maDotThu;
    }

    public void setMaDotThu(String maDotThu) {
        this.maDotThu = maDotThu;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }
    //private Date ngayTao;
    private Date ngayThu;



    public int getTongSoTien() {
        return tongSoTien;
    }

    public void setTongSoTien(int tongSoTien) {
        this.tongSoTien = tongSoTien;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }
    
}
