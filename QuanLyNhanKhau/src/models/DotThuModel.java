/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
/**
 *
 * @author SangND
 */
public class DotThuModel {
    private int ID;
    private String tenDotThu;
    private String loaiPhiThu;
    private Date ngayBatDauThu;
    private Date ngayKetThucThu;
    private int soTienTrenMotNhanKhau;
    private Date ngayTao;
    
    public int getID(){
        return ID;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public String getTenDotThu(){
        return tenDotThu;
    }
    
    public void setTenDotThu(String tenDotThu){
        this.tenDotThu = tenDotThu;
    }
    
    public String getLoaiPhiThu(){
        return loaiPhiThu;
    }
    
    public void setLoaiPhiThu(String loaiPhiThu){
        this.loaiPhiThu = loaiPhiThu;
    }
    
    public Date getNgayBatDauThu(){
        return ngayBatDauThu;
    }
    
    public void setNgayBatDauThu(Date ngayBatDauThu){
        this.ngayBatDauThu = ngayBatDauThu;
    }
    
    public Date getNgayKetThucThu(){
        return ngayKetThucThu;
    }
    
    public void setNgayKetThucThu(Date ngayKetThucThu){
        this.ngayKetThucThu = ngayKetThucThu;
    }
    
    public int getSoTienTrenMotNhanKhau(){
        return soTienTrenMotNhanKhau;
    }
    
    public void setSoTienTrenMotNhanKhau(int soTienTrenMotNhanKhau){
        this.soTienTrenMotNhanKhau = soTienTrenMotNhanKhau;
    }
    
    public Date getNgayTao(){
        return ngayTao;
    }
    
    public void setNgayTao(Date ngayTao){
        this.ngayTao = ngayTao;
    }
}


