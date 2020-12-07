/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.List;
import models.HoKhauModel;
import models.ThongTinThuPhiModel;
/**
 *
 * @author VuDinhHieu
 */
public class ThongTinThuPhiBean {
    private ThongTinThuPhiModel thongTinThuPhiModel;
    private HoKhauModel hoKhauModel;

    public ThongTinThuPhiBean(ThongTinThuPhiModel thongTinThuPhiModel, HoKhauModel hoKhauModel) {
        this.thongTinThuPhiModel = thongTinThuPhiModel;
        this.hoKhauModel = hoKhauModel;
    }

    public ThongTinThuPhiBean() {
        this.thongTinThuPhiModel = new ThongTinThuPhiModel();
        this.hoKhauModel = new HoKhauModel();

    }
   

    
    
    public HoKhauModel getHoKhauModel(){
        return hoKhauModel;
    }
   
    public void setHoKhauModel(HoKhauModel hoKhauModel){
        this.hoKhauModel = hoKhauModel;
    }

    public ThongTinThuPhiModel getThongTinThuPhiModel() {
        return thongTinThuPhiModel;
    }

    public void setThongTinThuPhiModel(ThongTinThuPhiModel thongTinThuPhiModel) {
        this.thongTinThuPhiModel = thongTinThuPhiModel;
    }
        
}
