/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiManagerController;

import Bean.ThongTinThuPhiBean;
import java.sql.Connection;
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
            String query = "INSERT INTO thong_tin_thu_phi (idDotThu, idHoKhau, soNhanKhau, tongSoTien, ngayThu)" + "value (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, thongTinThuPhiModel.getIDDotThu());
            preparedStatement.setInt(2, thongTinThuPhiModel.getIDHoKhau());
            preparedStatement.setInt(3, thongTinThuPhiModel.getSoNhanKhau());
            preparedStatement.setInt(4, thongTinThuPhiModel.getTongSoTien());
            preparedStatement.setDate(5, thongTinThuPhiModel.getNgayThu());
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
    
    public boolean checkIDDotThu (int idDotThu){
          try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_thu WHERE idDotThu = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idDotThu);
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
    
    public boolean checkIDHoKhau(int idHoKhau){
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idHoKhau);
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
