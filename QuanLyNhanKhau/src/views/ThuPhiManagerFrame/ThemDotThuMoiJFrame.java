
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.ThuPhiManagerFrame;

import Bean.DotThuBean;
import controllers.ThuPhiManagerController.ThemMoiController;
import controllers.ThuPhiPanelController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.DotThuModel;

/**
 *
 * @author SangND
 */
public class ThemDotThuMoiJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ThemDotThuMoiJFrame
     */
    private ThuPhiPanelController parentController;
    private JFrame parentFrame;
    private DotThuBean dotThuBean;
    private ThemMoiController controller;
    
    
    public ThemDotThuMoiJFrame() {
        initComponents();
    }
    
    public ThemDotThuMoiJFrame(ThuPhiPanelController parentController, JFrame parentFrame){
        this.parentController = parentController;
        initComponents();
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        this.dotThuBean = new DotThuBean();
        this.controller = new ThemMoiController();
        this.availableDotThu.setEnabled(false);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Thêm mới đợt thu");
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                if(JOptionPane.showConfirmDialog(null,"Are you sure to close ??", "Warning!!", JOptionPane.YES_NO_OPTION)==0){
                    close();
                }
            }
        });
        
    }
    
    void close(){
        this.parentFrame.setEnabled(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tenDotThu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        loaiPhi = new javax.swing.JComboBox<>();
        soTien = new javax.swing.JTextField();
        ngayBatDauThu = new com.toedter.calendar.JDateChooser();
        ngayKetThucThu = new com.toedter.calendar.JDateChooser();
        cancelBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        maDotThu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ngayTao = new com.toedter.calendar.JDateChooser();
        taoDanhSach = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        check = new javax.swing.JButton();
        availableDotThu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên đợt thu : ");

        tenDotThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenDotThuActionPerformed(evt);
            }
        });

        jLabel2.setText("Loại phí thu :");

        jLabel3.setText("Ngày bắt đầu thu :");

        jLabel4.setText("Ngày kết thúc thu :");

        jLabel5.setText("Số tiền trên một nhân khẩu :");

        loaiPhi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bắt buộc", "Không bắt buộc" }));
        loaiPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiPhiActionPerformed(evt);
            }
        });

        soTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soTienActionPerformed(evt);
            }
        });

        cancelBtn.setText("Hủy");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setText("(*)");

        jLabel7.setForeground(java.awt.Color.red);
        jLabel7.setText("(*)");

        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setText("(*)");

        jLabel9.setForeground(java.awt.Color.red);
        jLabel9.setText("(*)");

        maDotThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maDotThuActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã đợt thu:");

        taoDanhSach.setText("Tạo danh sách");
        taoDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taoDanhSachActionPerformed(evt);
            }
        });

        createBtn.setText("Thêm mới");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        jLabel12.setForeground(java.awt.Color.red);
        jLabel12.setText("(*)");

        jLabel13.setForeground(java.awt.Color.red);
        jLabel13.setText("(*)");

        jLabel14.setForeground(java.awt.Color.red);
        jLabel14.setText("(*)");

        jLabel15.setText("Ngày tạo:");

        check.setText("Check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn)
                .addGap(18, 18, 18)
                .addComponent(createBtn)
                .addGap(18, 18, 18)
                .addComponent(taoDanhSach)
                .addGap(2, 2, 2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tenDotThu)
                        .addGap(2, 2, 2))
                    .addComponent(ngayBatDauThu, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(ngayKetThucThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiPhi, javax.swing.GroupLayout.Alignment.LEADING, 0, 368, Short.MAX_VALUE)
                    .addComponent(soTien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maDotThu, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap()))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(check)
                            .addGap(4, 4, 4)))
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maDotThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenDotThu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loaiPhi)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayBatDauThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ngayKetThucThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soTien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(createBtn)
                    .addComponent(taoDanhSach))
                .addGap(24, 24, 24))
        );

        availableDotThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableDotThu)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(availableDotThu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tenDotThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenDotThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenDotThuActionPerformed

    private void soTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soTienActionPerformed

    private void loaiPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiPhiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_loaiPhiActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"Are you sure to close ??", "Warning!!", JOptionPane.YES_NO_OPTION)==0){
                    close();
                }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
         if(this.checkInForm()){
            if(!this.controller.checkMaDotThu(maDotThu.getText())){
            DotThuModel temp = this.dotThuBean.getDotThuModel();
            temp.setTenDotThu(tenDotThu.getText());
            //temp.setIDDotThu(Integer.parseInt(idDotThu.getText()));
            temp.setMaDotThu(maDotThu.getText());
            temp.setNgayBatDauThu(ngayBatDauThu.getDate());
            temp.setNgayKetThucThu(ngayKetThucThu.getDate());
            temp.setNgayTao(ngayTao.getDate());
            String tmp = loaiPhi.getSelectedIndex()== 1?"Không bắt buộc":"Bắt buộc";
            temp.setLoaiPhiThu(tmp);
            temp.setSoTienTrenMotNhanKhau(Integer.parseInt(soTien.getText()));
            try{
                if(this.controller.themMoiDotThu(this.dotThuBean)){
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                    this.controller.capNhat(this.dotThuBean);
                    close();
                    parentController.refreshData();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }}
            else {
                JOptionPane.showMessageDialog(rootPane, "Đợt thu đã có, mời kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
    }//GEN-LAST:event_createBtnActionPerformed

    private void maDotThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maDotThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maDotThuActionPerformed

    private void taoDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taoDanhSachActionPerformed
        // TODO add your handling code here:
       new TaoDanhSach(this,maDotThu.getText()).setVisible(true);
    }//GEN-LAST:event_taoDanhSachActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        if(this.checkMaDotThu()){
            if(!this.controller.checkMaDotThu(maDotThu.getText())){
            JOptionPane.showMessageDialog(rootPane, "Đợt thu chưa có","Check mã đợt thu", JOptionPane.INFORMATION_MESSAGE);
            this.availableDotThu.setEnabled(true);
            }
            else JOptionPane.showMessageDialog(rootPane, "Đợt thu đã có","Check mã đợt thu", JOptionPane.INFORMATION_MESSAGE);
        
        
        }else{
             JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_checkActionPerformed
private boolean checkMaDotThu(){
        if(maDotThu.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
 private boolean checkInForm(){
        if(this.maDotThu.getText().trim().isEmpty()
                ||this.tenDotThu.getText().trim().isEmpty()
                ||this.loaiPhi.getSelectedIndex() == -1
                ||this.soTien.getText().trim().isEmpty()
                ||this.ngayBatDauThu.getDate().toString().isEmpty()
                ||this.ngayKetThucThu.getDate().toString().isEmpty()
                ||this.ngayTao.getDate().toString().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
            return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableDotThu;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton check;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> loaiPhi;
    private javax.swing.JTextField maDotThu;
    private com.toedter.calendar.JDateChooser ngayBatDauThu;
    private com.toedter.calendar.JDateChooser ngayKetThucThu;
    private com.toedter.calendar.JDateChooser ngayTao;
    private javax.swing.JTextField soTien;
    private javax.swing.JButton taoDanhSach;
    private javax.swing.JTextField tenDotThu;
    // End of variables declaration//GEN-END:variables
}
