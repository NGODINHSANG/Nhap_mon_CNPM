/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import java.util.ArrayList;
import java.util.List;
import models.HoKhauModel;
import models.DotThuModel;
import models.ThongTinThuPhiModel;
/**
 *
 * @author Ngo Viet Cuong
 */
public class DotThuBean {
    private DotThuModel dotThuModel;
    private List<HoKhauModel> hoKhauModel;
    private List<ThongTinThuPhiModel> thongTinThuPhiModel;
    
    public DotThuBean(DotThuModel dotThuModel, List<HoKhauModel> hoKhauModel, List<ThongTinThuPhiModel> thongTinThuPhiModel){
        this.dotThuModel = dotThuModel;
        this.hoKhauModel = hoKhauModel;
        this.thongTinThuPhiModel = thongTinThuPhiModel;
    }
    
    public DotThuBean(){
        this.dotThuModel = new DotThuModel();
        this.hoKhauModel = new ArrayList<>();
        this.thongTinThuPhiModel = new ArrayList<>();
    }
    
    public DotThuModel getDotThuModel(){
        return this.dotThuModel;
    }
    
    public void setDotThuModel(DotThuModel dotThuModel){
        this.dotThuModel = dotThuModel;
    }
    
    public List<HoKhauModel> getHoKhauModel(){
        return hoKhauModel;
    }
    
    public void setHoKhauModel(List<HoKhauModel> hoKhauModel){
        this.hoKhauModel = hoKhauModel;
    }
    
    public List<ThongTinThuPhiModel> getThongTinThuPhiModel(){
        return thongTinThuPhiModel;
    }
    
    public void setThongTinThuPhiModel(List<ThongTinThuPhiModel> thongTinThuPhiModel){
        this.thongTinThuPhiModel = thongTinThuPhiModel;
    }
    
    @Override
    public String toString(){
        String res = "";
        return res;
    }
}
