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
import services.MysqlConnection;
import models.ThongTinThuPhiModel;

/**
 *
 * @author LENOVO
 */
public class ThongKeChiTietController {

    public boolean checkBtn(int maHKjtf) {
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,maHKjtf);
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
