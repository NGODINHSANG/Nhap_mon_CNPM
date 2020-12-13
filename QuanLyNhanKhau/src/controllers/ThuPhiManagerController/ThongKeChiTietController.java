/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiManagerController;

import Bean.DotThuBean;
import Bean.ThongTinThuPhiBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.DotThuModel;
import services.MysqlConnection;
import models.ThongTinThuPhiModel;
import services.ThuPhiService;
import utility.TableModelThuPhi;
import views.infoViews.InfoJframe;

/**
 *
 * @author LENOVO
 */
public class ThongKeChiTietController {

    private List<ThongTinThuPhiBean> listThongTinThuPhiBean;
    private ThuPhiService thuPhiService ;
    private TableModelThuPhi tableModelThuPhi;
    private final String COLUNMS[] = {"Mã đợt thu","Mã hộ khẩu", "Số nhân khẩu","Số tiền nộp","Ngày thu"}; 
    private JPanel jpnViews;
private JTextField jtfSearch;
    private JTextField maHKjtf;
    
    public ThongKeChiTietController(JPanel panel, JTextField maHKjtfF ){
        this.thuPhiService = new ThuPhiService();
        this.listThongTinThuPhiBean = new ArrayList<>();
        this.listThongTinThuPhiBean = thuPhiService.getListThongTinThuPhi();
        this.tableModelThuPhi = new TableModelThuPhi();
        this.maHKjtf = maHKjtfF;
        this.jpnViews = panel;
        this.jtfSearch= jtfSearch;
      
    }
    public boolean checkBtn(String maHKjtf) {
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thong_tin_thu_phi WHERE maHoKhau = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,maHKjtf);
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
    
   
    public void setData(String maHK){
        //String  = null;
       // try{
       // if (this.maHKjtf.getText().trim().isEmpty()) {   
      //      maHK= maHKjtf.getText();
      //  }           
       // }catch (Exception e) {
       //     JOptionPane.showMessageDialog(maHKjtf, "Vui lòng nhập đúng kiểu dữ liệu!!", "Warring", JOptionPane.ERROR_MESSAGE);
       // }        
        this.listThongTinThuPhiBean = this.thuPhiService.getListThongTinThuPhi(maHK);
                 
        setDataTable();
    
    
    }
    public void setDataTable() {
        List<ThongTinThuPhiModel> listItem = new ArrayList<>();
        this.listThongTinThuPhiBean.forEach(thongTinThuPhi -> {
            listItem.add(thongTinThuPhi.getThongTinThuPhiModel());
        });
        DefaultTableModel model = tableModelThuPhi.setTablethongtin(listItem, COLUNMS);
        
         
         JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }   
         };
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
      
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnViews.removeAll();
        jpnViews.setLayout(new BorderLayout());
        jpnViews.add(scroll);
        jpnViews.validate();
        jpnViews.repaint();
    }

    public JTextField getmaHKjtf(){
        return maHKjtf;
    }
    public void setmaHKjtf(JTextField maHKjtf){
        this.maHKjtf = maHKjtf;
    }
};
