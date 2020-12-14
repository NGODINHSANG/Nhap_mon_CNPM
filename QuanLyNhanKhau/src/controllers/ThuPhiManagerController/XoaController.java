/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiManagerController;

import Bean.DotThuBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.DotThuModel;
import services.MysqlConnection;

/**
 *
 * @author dungg
 */
public class XoaController {
    public boolean xoaDotThu (DotThuBean dotThuBean) throws SQLException, ClassNotFoundException{
        DotThuModel dotThuModel = dotThuBean.getDotThuModel();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query1 = "DELETE FROM thong_tin_thu_phi WHERE maDotThu = ? ;";
            String query2 = "DELETE FROM dot_thu WHERE maDotThu = ?;";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setString(1, dotThuModel.getMaDotThu());
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setString(1, dotThuModel.getMaDotThu());
            preparedStatement1.execute();
            preparedStatement2.execute();
            preparedStatement1.close();
            preparedStatement2.close();
            connection.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public boolean checkMaDotThu (String maDotThu){
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
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);return false;
        }
        return false;
    }
}
