/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.List;
import models.ThongTinThuPhiModel;
/**
 *
 * @author VuDinhHieu
 */
public class ThongTinThuPhiBean {
    private ThongTinThuPhiModel thongTinThuPhiModel;
    
    
    public ThongTinThuPhiBean(){
        this.thongTinThuPhiModel = new ThongTinThuPhiModel();    
    }

    public ThongTinThuPhiModel getThongTinThuPhiModel() {
        return thongTinThuPhiModel;
    }

    public void setThongTinThuPhiModel(ThongTinThuPhiModel thongTinThuPhiModel) {
        this.thongTinThuPhiModel = thongTinThuPhiModel;
    }
    
}
