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
    private int soNhanKhau;
    private int tongSoTien;
    private Date ngayTao;
    private Date ngayThu;

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

    public int getSoNhanKhau() {
        return soNhanKhau;
    }

    public void setSoNhanKhau(int soNhanKhau) {
        this.soNhanKhau = soNhanKhau;
    }

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
    
    public void setNgayTao(Date ngayTao){
        this.ngayTao = ngayTao;
    }
    
    public Date getNgayTao(){
        return ngayTao;
    }
}
