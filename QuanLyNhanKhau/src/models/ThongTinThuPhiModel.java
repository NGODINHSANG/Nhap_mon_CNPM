/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author VuDinhHieu
 */
public class ThongTinThuPhiModel {
    private int idDotThu;
    private int idHoKhau;
    private int soNhanKhau;
    private int tongSoTien;
    private Date ngayTao;
    private Date ngayThu;

    public int getIDDotThu() {
        return idDotThu;
    }

    public void setIDDotThu(int idDotThu) {
        this.idDotThu = idDotThu;
    }

    public int getIDHoKhau() {
        return idHoKhau;
    }

    public void setIDHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
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
