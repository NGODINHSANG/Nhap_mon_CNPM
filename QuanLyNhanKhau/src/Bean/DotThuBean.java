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
    private List<ThongTinThuPhiBean> listThongTinThuPhiBeans;
    
    public DotThuBean(DotThuModel dotThuModel, List<ThongTinThuPhiBean> listThongTinThuPhiBeans){
        this.dotThuModel = dotThuModel;
        this.listThongTinThuPhiBeans = listThongTinThuPhiBeans;
    }
    
    public DotThuBean(){
        this.dotThuModel = new DotThuModel();
        this.listThongTinThuPhiBeans = new ArrayList<>();
    }
    
    public DotThuModel getDotThuModel(){
        return this.dotThuModel;
    }
    
    public void setDotThuModel(DotThuModel dotThuModel){
        this.dotThuModel = dotThuModel;
    }
    
    public List<ThongTinThuPhiBean> getThongTinThuPhiModel(){
        return listThongTinThuPhiBeans;
    }
    
    public void setThongTinThuPhiBean(List<ThongTinThuPhiBean> listThongTinThuPhiBeans){
        this.listThongTinThuPhiBeans = listThongTinThuPhiBeans;
    }
    
    @Override
    public String toString(){
        String res = "<html><style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                + "<h3>Thông tin đợt thu:"
                + "<p>Tên đợt thu : <b>" + dotThuModel.getTenDotThu() +"</p>"
                + "<p>Loại phí thu: <b>" + dotThuModel.getLoaiPhiThu() + "</p>"
                + "<p>Ngày bắt đầu thu: <b>" + dotThuModel.getNgayBatDauThu().toString() + "</p>"
                + "<p>Ngày kết thúc thu: <b>" + dotThuModel.getNgayKetThucThu().toString() + "</p>"
                + "<p>Số tiền trên một nhân khẩu: <b>" + dotThuModel.getSoTienTrenMotNhanKhau() + "</p>"
                + "<p>Ngày tạo : <b>" + dotThuModel.getNgayTao() + "</p>"
                + "<h4>Các hộ: "
                + "<tr>"
                + "<th>ID hộ khẩu</th>"
                + "<th>Số nhân khẩu</th>"
                + "<th>Tổng số tiền</th>"
                + "<th>Ngày thu</th>";;
        for(ThongTinThuPhiBean thongTinThuPhi: listThongTinThuPhiBeans){
            res += "<tr>"
                    + "<td>"
                    + thongTinThuPhi.getHoKhauModel().getMaHoKhau()
                    + "</td>"
                    + "<td>"
                    + thongTinThuPhi.getThongTinThuPhiModel().getSoNhanKhau()
                    + "</td>"
                    + "<td>"        
                    + thongTinThuPhi.getThongTinThuPhiModel().getTongSoTien()
                    + "</td>"
                    + "<td>"
                    + thongTinThuPhi.getThongTinThuPhiModel().getNgayThu().toString()
                    + "</td>" 
                    +"</tr>";          
        }
        res +=  "</table>"
                + "</div></html>";
        return res;
    }
}
