/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Bean.DotThuBean;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.DotThuModel;
import models.ThongTinThuPhiModel;
/**
 *
 * @author Ngo Viet Cuong
 */
public class ThuPhiService {
    public List<DotThuBean> getListDotThu() {
        List<DotThuBean> list = new ArrayList<>();
        
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String Query = "Select * FROM dot_thu ORDER BY ngayTao DESC LIMIT 3";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DotThuBean temp =  new DotThuBean();
                DotThuModel dotThuModel = temp.getDotThuModel();
                dotThuModel.setIDDotThu(rs.getInt("idDotThu"));
                dotThuModel.setTenDotThu(rs.getString("tenDotThu"));
                dotThuModel.setLoaiPhiThu(rs.getString("loaiPhiThu"));
                dotThuModel.setNgayBatDauThu(rs.getDate("ngayBatDauThu"));
                dotThuModel.setNgayKetThucThu(rs.getDate("ngayKetThucThu"));
                dotThuModel.setSoTienTrenMotNhanKhau(rs.getInt("soTienTrenMotNhanKhau"));
                dotThuModel.setNgayTao(rs.getDate("ngayTao"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());   
        }
        return list;
    }
    
    //Tim kiem dot thu theo ten
    public List<DotThuBean> search(String keyword) {
        List<DotThuBean> list = new ArrayList<>();
        if(keyword.trim().isEmpty()){
            return this.getListDotThu();
        }
        try{
            String query = "SELECT * FROM dot_thu WHERE MATCH(tenDotThu) AGAINST ('"
                            + keyword
                            + "' IN NATURAL LANGUAGE MODE)";
              
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DotThuBean temp = new DotThuBean();
                DotThuModel dotThu = temp.getDotThuModel();
                dotThu.setIDDotThu(rs.getInt("idDotThu"));
                dotThu.setTenDotThu(rs.getString("tenDotThu"));
                dotThu.setLoaiPhiThu(rs.getString("loaiPhiThu"));
                dotThu.setNgayBatDauThu(rs.getDate("ngayBatDauThu"));
                dotThu.setNgayKetThucThu(rs.getDate("ngayKetThucThu"));
                dotThu.setSoTienTrenMotNhanKhau(rs.getInt("soTienTrenMotNhanKhau"));
                dotThu.setNgayTao(rs.getDate("ngayTao"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    

   
}
