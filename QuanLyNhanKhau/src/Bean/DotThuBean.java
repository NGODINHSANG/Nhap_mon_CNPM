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
import services.ThuPhiService;
/**
 *
 * @author Ngo Viet Cuong
 */
public class DotThuBean {
    private DotThuModel dotThuModel;
    private List<ThongTinThuPhiModel> listThongTinThuPhiModels;
    
    public DotThuBean(DotThuModel dotThuModel, List<ThongTinThuPhiModel> listThongTinThuPhiModels){
        this.dotThuModel = dotThuModel;
        this.listThongTinThuPhiModels = listThongTinThuPhiModels;
    }
    
    public DotThuBean(){
        this.dotThuModel = new DotThuModel();
        this.listThongTinThuPhiModels = new ArrayList<>();
    }
    
    public DotThuModel getDotThuModel(){
        return this.dotThuModel;
    }
    
    public void setDotThuModel(DotThuModel dotThuModel){
        this.dotThuModel = dotThuModel;
    }
    
    public List<ThongTinThuPhiModel> getThongTinThuPhiModel(){
        return listThongTinThuPhiModels;
    }
    
    public void setThongTinThuPhiModel(List<ThongTinThuPhiModel> listThongTinThuPhiModels){
        this.listThongTinThuPhiModels = listThongTinThuPhiModels;
    }
    
    @Override
    public String toString(){
        String res = "<html><style>p {padding: 5px; margin-left: 20px;} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px} </style>  <div>"
                + "<h3>Thông tin đợt thu:"
                + "<p>Mã đợt thu: <b>" + dotThuModel.getMaDotThu() + "</p>"
                + "<p>Tên đợt thu : <b>" + dotThuModel.getTenDotThu() +"</p>"
                + "<p>Loại phí thu: <b>" + dotThuModel.getLoaiPhiThu() + "</p>"
                + "<p>Ngày bắt đầu thu: <b>" + dotThuModel.getNgayBatDauThu().toString() + "</p>"
                + "<p>Ngày kết thúc thu: <b>" + dotThuModel.getNgayKetThucThu().toString() + "</p>"
                + "<p>Số tiền trên một nhân khẩu: <b>" + dotThuModel.getSoTienTrenMotNhanKhau() + "(đồng)</p>"
                + "<p>Ngày tạo : <b>" + dotThuModel.getNgayTao() + "</p>";
                if(dotThuModel.getLoaiPhiThu().equals("Bắt buộc")){
                    res += "<p>Tổng số tiền cần thu: <b>" + ThuPhiService.tongSoTienCanNop(this.dotThuModel.getMaDotThu()) + "(đồng)</p>";
                }   
            res += "<h4>Danh sách các hộ: "
                + "<tr>"
                + "<th>Mã hộ khẩu</th>"
                + "<th>Số nhân khẩu</th>"
                + "<th>Số tiền(đồng)</th>"
                + "<th>Ngày thu</th>"
                + "</tr>";
        for(ThongTinThuPhiModel thongTinThuPhi: listThongTinThuPhiModels){
            String temp = (thongTinThuPhi.getNgayThu()==null)?"Chưa thu":thongTinThuPhi.getNgayThu().toString();
            res += "<tr>"
                    + "<td>"
                    + thongTinThuPhi.getMaHoKhau()
                    + "</td>"
                    + "<td>"
                    + thongTinThuPhi.getSoNhanKhau()
                    + "</td>"
                    + "<td>"        
                    + thongTinThuPhi.getTongSoTien()
                    + "</td>"
                    + "<td>"
                    + temp
                    + "</td>" 
                    +"</tr>";          
        }
        res +=  "</table>"
              + "<h3>Tồng số tiền đã thu: " + ThuPhiService.tongSoTien(this.dotThuModel.getMaDotThu()) +"(đồng)"
              + "<h3 style=" + "margin-top:-2px;" + ">Số hộ đã nộp: " + ThuPhiService.soHoKhau(this.dotThuModel.getMaDotThu())
              + "</div></html>";
        return res;
    }
}
