/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import Bean.DotThuBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.DotThuModel;
import services.ThuPhiService;
import utility.TableModelThuPhi;
import views.infoViews.InfoJframe;

/**
 *
 * @author Ngo Viet Cuong
 */
public class ThuPhiPanelController {
    private List<DotThuBean> listDotThuBeans;
    private JTextField jtfSearch;
    private JPanel jpnView;
    private final ThuPhiService thuPhiService = new ThuPhiService();
    private final TableModelThuPhi tableModelThuPhi = new TableModelThuPhi();
    private final String COLUNMS[] = {"Mã đợt thu","Tên đợt thu", "Loại phí thu","Ngày bắt đầu thu","Ngày kết thúc thu","Số tiền trên một nhân khẩu"};  
    private JFrame parentJFrame;

    public ThuPhiPanelController(JTextField searchJtf, JPanel tableJpn) {
        this.jtfSearch = searchJtf;
        this.jpnView = tableJpn;
        this.listDotThuBeans = thuPhiService.getListDotThu();
        setData();
        initAction();
    }
    
    public void initAction() {
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText().trim();
                if (key.isEmpty()) {
                    listDotThuBeans = thuPhiService.getListDotThu();
                } else {
                    listDotThuBeans = thuPhiService.search(key);
                }
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText().trim();
                if (key.isEmpty()) {
                    listDotThuBeans = thuPhiService.getListDotThu();
                } else {
                    listDotThuBeans = thuPhiService.search(key);
                }
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText().trim();
                if (key.isEmpty()) {
                    listDotThuBeans = thuPhiService.getListDotThu();
                } else {
                    listDotThuBeans = thuPhiService.search(key);
                }
                setData();
            }
        });
    }

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
    }

    public void setParentJFrame(JFrame parentJFrame){
        this.parentJFrame = parentJFrame;
    }
    
    
    public List<DotThuBean> getList() {
        return listDotThuBeans;
    }

    public void setList(List<DotThuBean> list) {
        this.listDotThuBeans = list;
    }

    public JTextField getSearchJtf() {
        return jtfSearch;
    }

    public void setSearchJtf(JTextField searchJtf) {
        this.jtfSearch = searchJtf;
    }

    public JPanel getTableJpn() {
        return jpnView;
    }

    public void setTableJpn(JPanel tableJpn) {
        this.jpnView = tableJpn;
    }
    
    public void refreshData(){
        this.listDotThuBeans = this.thuPhiService.getListDotThu();
        setData();
    }
}
