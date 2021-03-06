/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiManagerController;

import Bean.DotThuBean;
import Bean.ThongTinThuPhiBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.DotThuModel;
import models.ThongTinThuPhiModel;
import services.MysqlConnection;

/**
 *
 * @author Dell
 */
public class ThemMoiController {
    public boolean themMoiDotThu(DotThuBean doThuBean) throws SQLException, ClassNotFoundException{
        DotThuModel dotThuModel = doThuBean.getDotThuModel();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT INTO dot_thu ( maDotThu, tenDotThu, loaiPhiThu, ngayBatDauThu, ngayKetThucThu, soTienTrenMotNhanKhau, ngayTao)" 
                    + "value (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,dotThuModel.getIDDotThu());
            preparedStatement.setString(1,dotThuModel.getMaDotThu());
            preparedStatement.setString(2,dotThuModel.getTenDotThu());
            preparedStatement.setString(3,dotThuModel.getLoaiPhiThu());
            Date ngayBatDau = new Date(dotThuModel.getNgayBatDauThu().getTime());
            Date ngayKetThuc = new Date(dotThuModel.getNgayKetThucThu().getTime());
            Date ngayTao = new Date (dotThuModel.getNgayTao().getTime());
            preparedStatement.setDate(4, ngayBatDau);
            preparedStatement.setDate(5, ngayKetThuc);
            preparedStatement.setInt(6, dotThuModel.getSoTienTrenMotNhanKhau());
            preparedStatement.setDate(7, ngayTao);
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
    public boolean capNhat(DotThuBean dotThuBean) throws SQLException, ClassNotFoundException{
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT IGNORE INTO `thong_tin_thu_phi` (maDotThu, maHoKhau,soNhanKhau)\n" 
                    + "SELECT maDotThu, maHoKhau, soNhanKhau FROM\n" 
                    + "(SELECT maDotThu FROM dot_thu WHERE maDotThu = '" + dotThuBean.getDotThuModel().getMaDotThu()
                    + "') dotthu \n" 
                    + "CROSS JOIN\n" 
                    + "(SELECT hokhau.maHoKhau,COUNT(*) soNhanKhau\n" 
                    + "	FROM ho_khau hokhau LEFT JOIN thanh_vien_cua_ho thanhvien \n" 
                    + "		ON hOkhau.ID=thanhvien.idHoKhau\n" 
                    + "    GROUP BY hokhau.ID) tthokhau\n" 
                    + "ORDER BY dotthu.maDotThu, tthokhau.maHoKhau;" ;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
    
    public boolean checkMaDotThu(String maDotThu){
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_thu WHERE maDotThu = ?";
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
