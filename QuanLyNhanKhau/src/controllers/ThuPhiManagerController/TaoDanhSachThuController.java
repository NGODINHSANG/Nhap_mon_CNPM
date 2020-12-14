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
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.DotThuModel;
import models.ThongTinThuPhiModel;
import services.ThuPhiService;
import utility.TableModelThuPhi;
import views.infoViews.InfoJframe;

/**
 *
 * @author VuDinhHieu
 */
public class TaoDanhSachThuController {
    private List<ThongTinThuPhiBean> listThongTinThuPhiBeans ;
    private JTextField jtfSearch;
    private JPanel jpnView;
    private final ThuPhiService thuPhiService = new ThuPhiService();
    private final TableModelThuPhi tableModelThuPhi = new TableModelThuPhi();
    private final String COLUNMS[] = {"Mã đợt thu", "Mã hộ khẩu","Số nhân khẩu","Số tiền","Ngay thu"};  
    private JFrame parentJFrame;
    
     public TaoDanhSachThuController( JPanel tableJpn, String maDotThu) {
//        this.jtfSearch = searchJtf;
        this.jpnView = tableJpn;
        this.listThongTinThuPhiBeans = thuPhiService.getListThongTinThuPhiDS(maDotThu);
        setData();

    }
    
    public void setData() {
        List<ThongTinThuPhiModel> listItem = new ArrayList<>();
        this.listThongTinThuPhiBeans.forEach(thongTinThuPhi -> {
            listItem.add(thongTinThuPhi.getThongTinThuPhiModel());
        });
        DefaultTableModel model = tableModelThuPhi.setTableDotThu(listItem, COLUNMS,true);
        
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
        /*
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    DotThuBean temp = listDotThuBeans.get(table.getSelectedRow());
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });*/
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
     
     
    /*
    public void setData() {
        List<DotThuModel> listItem = new ArrayList<>();
        this.listDotThuBeans.forEach(dotThu -> {
            listItem.add(dotThu.getDotThuModel());
        });
        DefaultTableModel model = tableModelThuPhi.setTableThuPhi(listItem, COLUNMS);
        
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
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    DotThuBean temp = listDotThuBeans.get(table.getSelectedRow());
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }*/
}
