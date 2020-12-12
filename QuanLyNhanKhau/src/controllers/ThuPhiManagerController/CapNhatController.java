/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiManagerController;

import Bean.ThongTinThuPhiBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.ThongTinThuPhiModel;
import services.MysqlConnection;

/**
 *
 * @author VuDinhHieu
 */
public class CapNhatController {
public boolean capNhatThongTin(ThongTinThuPhiBean thongTinThuPhiBean) throws SQLException, ClassNotFoundException{
        ThongTinThuPhiModel thongTinThuPhiModel = thongTinThuPhiBean.getThongTinThuPhiModel();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            Date ngayThu = new Date(thongTinThuPhiModel.getNgayThu().getTime());
            String query = "UPDATE thong_tin_thu_phi " 
                    + "SET tongSoTien = " + thongTinThuPhiModel.getTongSoTien()
                    +" , ngayThu = ?" //+ ngayThu
                    + " WHERE maDotThu = \"" + thongTinThuPhiModel.getMaDotThu() 
                    + "\" AND maHoKhau = \"" + thongTinThuPhiModel.getMaHoKhau()+"\"";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1, thongTinThuPhiModel.getIDDotThu());
            //preparedStatement.setInt(2, thongTinThuPhiModel.getIDHoKhau());
            //preparedStatement.setInt(3, thongTinThuPhiModel.getSoNhanKhau());
            //preparedStatement.setInt(1, thongTinThuPhiModel.getTongSoTien());
            
            preparedStatement.setDate(1, ngayThu);
            //preparedStatement.setString(3, thongTinThuPhiModel.getMaDotThu());
            //preparedStatement.setString(4, thongTinThuPhiModel.getMaHoKhau());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }
    

        public boolean checkMaHoKhau(String maHoKhau){
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thong_tin_thu_phi WHERE maHoKhau = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,maHoKhau);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
        public boolean checkMaDotThu(String maDotThu){
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thong_tin_thu_phi WHERE maDotThu = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,maDotThu);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
