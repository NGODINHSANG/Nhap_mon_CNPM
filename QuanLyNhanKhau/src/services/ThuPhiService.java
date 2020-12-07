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
                dotThuModel.setID(rs.getInt("idDotThu"));
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

    //Hien thi thong tin chi tiet dot thu
    public DotThuBean getDotThu(int idDotThu){
        DotThuBean dotThuBean = new DotThuBean();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String Query = "Select * FROM dot_thu WHERE idDotThu = " + idDotThu;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DotThuModel dotThuModel = dotThuBean.getDotThuModel();
                dotThuModel.setID(idDotThu);
                dotThuModel.setTenDotThu(rs.getString("tenDotThu"));
                dotThuModel.setLoaiPhiThu(rs.getString("loaiPhiThu"));
                dotThuModel.setNgayBatDauThu(rs.getDate("ngayBatDauThu"));
                dotThuModel.setNgayKetThucThu(rs.getDate("ngayKetThucThu"));
                dotThuModel.setSoTienTrenMotNhanKhau(rs.getInt("soTienTrenMotNhanKhau"));
                dotThuModel.setNgayTao(rs.getDate("ngayTao"));
            }
            preparedStatement.close();
            Query = "SELECT * FROM thong_tin_thu_phi INNER JOIN ho_khau ON idHoKhau = ID WHERE idDotThu = " + idDotThu;
            preparedStatement = (PreparedStatement)connection.prepareStatement(Query);
            rs = preparedStatement.executeQuery();
            List<ThongTinThuPhiBean> listThongTinThuPhiBean = new ArrayList<>();
            while(rs.next()){
                ThongTinThuPhiBean thongTinThuPhiBean = new ThongTinThuPhiBean();
                ThongTinThuPhiModel thongTinThuPhiModel = thongTinThuPhiBean.getThongTinThuPhiModel();
                thongTinThuPhiModel.setIDDotThu(idDotThu);
                thongTinThuPhiModel.setIDHoKhau(rs.getInt("idHoKhau"));
                thongTinThuPhiModel.setSoNhanKhau(rs.getInt("soNhanKhau"));
                thongTinThuPhiModel.setTongSoTien(rs.getInt("tongSoTien"));
                thongTinThuPhiModel.setNgayThu(rs.getDate("ngayThu"));
                
                HoKhauModel hoKhauModel = thongTinThuPhiBean.getHoKhauModel();
                hoKhauModel.setID(rs.getInt("ID"));
                hoKhauModel.setIdChuHo(rs.getInt("idCHuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setMaKhuVuc(rs.getString("maKhuVuc"));
                hoKhauModel.setNgayLap(rs.getDate("ngayLap"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                listThongTinThuPhiBean.add(thongTinThuPhiBean);
                }
            dotThuBean.setThongTinThuPhiBean(listThongTinThuPhiBean);
            preparedStatement.close();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());   
        }
        return dotThuBean;
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
                dotThu.setID(rs.getInt("idDotThu"));
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
