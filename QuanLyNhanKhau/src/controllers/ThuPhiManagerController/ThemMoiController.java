/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiManagerController;

import Bean.DotThuBean;
import models.DotThuModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import services.MysqlConnection;
/**
 *
 * @author SangND
 */
public class ThemMoiController {
    public boolean ThemMoi(DotThuBean dotThuBean) throws SQLException, ClassNotFoundException {
        DotThuModel dotThuModel = dotThuBean.getDotThuModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String add = "INSERT INTO dot_thu (idDotThu, tenDotThu, loaiPhiThu, ngayBatDauThu, ngayKetThucThu, soTienTrenMotNhanKhau, ngayTao)" + "value(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1, dotThuModel.getID());
            preparedStatement.setString(2, dotThuModel.getTenDotThu());
            preparedStatement.setString(3, dotThuModel.getLoaiPhiThu());
            Date Ngaybatdauthu = new Date(dotThuModel.getNgayBatDauThu().getTime());
            Date Ngayketthucthu = new Date(dotThuModel.getNgayKetThucThu().getTime());
            preparedStatement.setDate(4, Ngaybatdauthu);
            preparedStatement.setDate(5, Ngayketthucthu);
            preparedStatement.setInt(6, dotThuModel.getSoTienTrenMotNhanKhau());
            Date NgayTao = new Date(dotThuModel.getNgayTao().getTime());
            preparedStatement.setDate(7, NgayTao);
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
    
}
