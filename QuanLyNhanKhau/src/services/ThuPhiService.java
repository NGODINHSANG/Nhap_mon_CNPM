/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Bean.DotThuBean;
import Bean.ThongTinThuPhiBean;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.DotThuModel;
import models.HoKhauModel;
import models.ThongTinThuPhiModel;

/**
 *
 * @author Ngo Viet Cuong
 */
public class ThuPhiService {

    //Hien thi danh sach dot thu
    public List<DotThuBean> getListDotThu() {
        List<DotThuBean> list = new ArrayList<>(); 
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String Query = "Select * FROM dot_thu ORDER BY ngayTao DESC";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DotThuBean temp = new DotThuBean();
                DotThuModel dotThuModel = temp.getDotThuModel();
                dotThuModel.setIDDotThu(rs.getInt("idDotThu"));
                String maDotThu = rs.getString("maDotThu");
                dotThuModel.setMaDotThu(maDotThu);
                dotThuModel.setTenDotThu(rs.getString("tenDotThu"));
                dotThuModel.setLoaiPhiThu(rs.getString("loaiPhiThu"));
                dotThuModel.setNgayBatDauThu(rs.getDate("ngayBatDauThu"));
                dotThuModel.setNgayKetThucThu(rs.getDate("ngayKetThucThu"));
                dotThuModel.setSoTienTrenMotNhanKhau(rs.getInt("soTienTrenMotNhanKhau"));
                dotThuModel.setNgayTao(rs.getDate("ngayTao")); 
                try{
                    String query = "SELECT * FROM thong_tin_thu_phi WHERE maDotThu = '" + maDotThu +"'"; 
                    PreparedStatement ppsm = (PreparedStatement)connection.prepareStatement(query);
                    ResultSet rs1 = ppsm.executeQuery();
                    List<ThongTinThuPhiModel> listThongTinThuPhiModel = new ArrayList<>();
                    while(rs1.next()){
                        ThongTinThuPhiModel thongTinThuPhiModel = new ThongTinThuPhiModel();
                        thongTinThuPhiModel.setMaDotThu(maDotThu);
                        thongTinThuPhiModel.setMaHoKhau(rs1.getString("maHoKhau"));
                        thongTinThuPhiModel.setSoNhanKhau(rs1.getInt("soNhanKhau"));
                        thongTinThuPhiModel.setTongSoTien(rs1.getInt("tongSoTien"));
                        thongTinThuPhiModel.setNgayThu(rs1.getDate("ngayThu"));
                        listThongTinThuPhiModel.add(thongTinThuPhiModel);
                    }
                    temp.setThongTinThuPhiModel(listThongTinThuPhiModel);
                }
                catch (Exception e) {
                    System.out.println("services.ThuPhiService.getListDotThu()");
                    System.out.println(e.getMessage());
                }
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

    //Thong ke tong so tien can thu
    public static int tongSoTienCanNop(String maDotThu){
        int tien = 0;
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT (SUM(soNhanKhau) * soTienTrenMotNhanKhau) AS sotien FROM `dot_thu` dt,`thong_tin_thu_phi` tt WHERE dt.maDotThu = tt.maDotThu AND tt.maDotThu = '" + maDotThu +"'";         
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                tien = rs.getInt("sotien");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return tien;
    }
    
    //Thong ke tong so tien trong moi dot thu
    public static int tongSoTien(String maDotThu){
        int tien = 0;
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT SUM(tongSoTien) AS tien FROM `thong_tin_thu_phi` WHERE maDotThu = '" + maDotThu + "'";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                tien = rs.getInt("tien");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return tien;
    }
    
    //Thong ke so ho da nop tien
    public static int soHoKhau(String maDotThu){
        int tongSoHo = 0;
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) as tongSoHo FROM thong_tin_thu_phi WHERE maDotThu = '" + maDotThu +"' AND tongSoTien > 0 GROUP BY maDotThu";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                tongSoHo = rs.getInt("tongSoHo");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return tongSoHo;
    }
    
    //Tim kiem dot thu theo ten
    public List<DotThuBean> search(String keyword) {
        List<DotThuBean> list = new ArrayList<>();
        if(keyword.trim().isEmpty()){
            return this.getListDotThu();
        }
        try{
            String query = "SELECT * FROM dot_thu WHERE MATCH(tenDotThu,maDotThu) AGAINST ('"
                            + keyword
                            + "' IN NATURAL LANGUAGE MODE)";
              
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DotThuBean temp = new DotThuBean();
                DotThuModel dotThu = temp.getDotThuModel();
                dotThu.setIDDotThu(rs.getInt("idDotThu"));
                dotThu.setMaDotThu(rs.getString("maDotThu"));
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
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<ThongTinThuPhiBean> getListThongTinThuPhiDS(String maDotThu) {
        List<ThongTinThuPhiBean> list = new ArrayList<>(); 
        try{
            List<ThongTinThuPhiModel> listThongTinThuPhiModel = new ArrayList<>();
            try (Connection connection = MysqlConnection.getMysqlConnection()) {
                String Query = "Select * FROM thong_tin_thu_phi "
                        + "WHERE maDotThu = ?";
                try (PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(Query)) {
                    preparedStatement.setString(1,maDotThu);
                    ResultSet rs = preparedStatement.executeQuery();
                    while(rs.next()){
                        ThongTinThuPhiBean temp = new ThongTinThuPhiBean();
                        ThongTinThuPhiModel thongTinThuPhiModel = temp.getThongTinThuPhiModel();
                        thongTinThuPhiModel.setMaDotThu(rs.getString(1));
                        thongTinThuPhiModel.setMaHoKhau(rs.getString(2));
                        thongTinThuPhiModel.setSoNhanKhau(rs.getInt(3));
                        thongTinThuPhiModel.setTongSoTien(rs.getInt(4));
                        thongTinThuPhiModel.setNgayThu(rs.getDate(5));
                        //listThongTinThuPhiModel.add(thongTinThuPhiModel);
                        temp.setThongTinThuPhiModel(thongTinThuPhiModel);
                        list.add(temp);
                    }
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());   
        }
        return list;
    }
   
    
    public List<ThongTinThuPhiBean> getListThongTinThuPhiTK(String maHKjtf ) {
        List<ThongTinThuPhiBean> list = new ArrayList<>(); 
        try{
            List<ThongTinThuPhiModel> listThongTinThuPhiModel = new ArrayList<>();
            try (Connection connection = MysqlConnection.getMysqlConnection()) {
                String Query = "Select * FROM thong_tin_thu_phi "
                        + "WHERE maHoKhau = ?";
                try (PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(Query)) {
                    preparedStatement.setString(1,maHKjtf);
                    ResultSet rs = preparedStatement.executeQuery();
                    while(rs.next()){
                        ThongTinThuPhiBean temp = new ThongTinThuPhiBean();
                        ThongTinThuPhiModel thongTinThuPhiModel = temp.getThongTinThuPhiModel();
                        thongTinThuPhiModel.setMaDotThu(rs.getString(1));
                        thongTinThuPhiModel.setMaHoKhau(rs.getString(2));
                        thongTinThuPhiModel.setSoNhanKhau(rs.getInt(3));
                        thongTinThuPhiModel.setTongSoTien(rs.getInt(4));
                        thongTinThuPhiModel.setNgayThu(rs.getDate(5));
                        //listThongTinThuPhiModel.add(thongTinThuPhiModel);
                        temp.setThongTinThuPhiModel(thongTinThuPhiModel);
                        list.add(temp);
                    }
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());   
        }
        return list;
    }
        public List<ThongTinThuPhiBean> getListThongTinThuPhi() {
        List<ThongTinThuPhiBean> list = new ArrayList<>(); 
        try{
            List<ThongTinThuPhiModel> listThongTinThuPhiModel = new ArrayList<>();
            try (Connection connection = MysqlConnection.getMysqlConnection()) {
                String Query = "Select * FROM thong_tin_thu_phi ";
                       // + "WHERE maDotThu = ?";
                try (PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(Query)) {
                    //preparedStatement.setString(1,maDotThu);
                    ResultSet rs = preparedStatement.executeQuery();
                    while(rs.next()){
                        ThongTinThuPhiBean temp = new ThongTinThuPhiBean();
                        ThongTinThuPhiModel thongTinThuPhiModel = temp.getThongTinThuPhiModel();
                        thongTinThuPhiModel.setMaDotThu(rs.getString(1));
                        thongTinThuPhiModel.setMaHoKhau(rs.getString(2));
                        thongTinThuPhiModel.setSoNhanKhau(rs.getInt(3));
                        thongTinThuPhiModel.setTongSoTien(rs.getInt(4));
                        thongTinThuPhiModel.setNgayThu(rs.getDate(5));
                        //listThongTinThuPhiModel.add(thongTinThuPhiModel);
                        temp.setThongTinThuPhiModel(thongTinThuPhiModel);
                        list.add(temp);
                    }
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());   
        }
        return list;
    }

    
    
}
