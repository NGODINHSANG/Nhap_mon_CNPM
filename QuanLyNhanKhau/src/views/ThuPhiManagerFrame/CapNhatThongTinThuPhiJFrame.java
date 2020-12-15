/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.ThuPhiManagerFrame ;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Bean.ThongTinThuPhiBean;
import controllers.ThuPhiManagerController.CapNhatController;
import controllers.ThuPhiPanelController;
import models.ThongTinThuPhiModel;

/**
 *
 * @author VuDinhHieu
 */
public class CapNhatThongTinThuPhiJFrame extends javax.swing.JFrame {

    /**
     * Creates new form CapNhatDotThu
     */    
    private ThuPhiPanelController parentController;
    private ThongTinThuPhiBean thongTinThuPhiBean;
    private CapNhatController controller;
    private JFrame parentFrame;
    
    public CapNhatThongTinThuPhiJFrame(){
        initComponents();
    }
    
    public CapNhatThongTinThuPhiJFrame(ThuPhiPanelController parentController,JFrame parentFrame) {
        this.parentController = parentController;
        this.parentFrame = parentFrame;
        controller = new CapNhatController();
        this.thongTinThuPhiBean = new ThongTinThuPhiBean();
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Cập nhật thông tin thu phí");
        parentFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
 }

void close() {
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
        CheckIDDotThu = new javax.swing.JButton();
        maDotThu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        maHoKhau = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        soTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ngayThu = new com.toedter.calendar.JDateChooser();
        cancel = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CheckIDHoKhau = new javax.swing.JButton();
        availableHoKhau = new javax.swing.JLabel();
        availableDotThu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(204, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        CheckIDDotThu.setBackground(new java.awt.Color(255, 255, 255));
        CheckIDDotThu.setText("Check");
        CheckIDDotThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckIDDotThuActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã đợt thu");

        jLabel2.setText("Mã hộ khẩu");

        jLabel3.setText("Số tiền");

        soTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soTienActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày thu");

        ngayThu.setBackground(new java.awt.Color(255, 255, 255));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel5.setForeground(java.awt.Color.red);
        jLabel5.setText("(*)");

        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setText("(*)");

        jLabel7.setForeground(java.awt.Color.red);
        jLabel7.setText("(*)");

        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setText("(*)");

        CheckIDHoKhau.setText("Check");
        CheckIDHoKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckIDHoKhauActionPerformed(evt);
            }
        });

        availableHoKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N
        availableHoKhau.setEnabled(false);

        availableDotThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N
        availableDotThu.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maDotThu)
                                    .addComponent(ngayThu, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(maHoKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(soTien, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckIDDotThu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckIDHoKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableHoKhau)
                    .addComponent(availableDotThu))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maDotThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CheckIDDotThu)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5))
                    .addComponent(availableDotThu))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(maHoKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CheckIDHoKhau)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(availableHoKhau)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngayThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(update))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
          if (JOptionPane.showConfirmDialog(null, "Are you sure to close this??","Confirm",JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
                
    }//GEN-LAST:event_cancelActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if(this.checkInForm()){
            if(controller.checkMaDotThu(maDotThu.getText())&&controller.checkMaHoKhau(maHoKhau.getText())){
                ThongTinThuPhiModel temp = this.thongTinThuPhiBean.getThongTinThuPhiModel();
            temp.setMaDotThu(maDotThu.getText());
            temp.setMaHoKhau(maHoKhau.getText());
            temp.setTongSoTien(Integer.parseInt(soTien.getText()));
            temp.setNgayThu(ngayThu.getDate());
            try{
                if(this.controller.capNhatThongTin(this.thongTinThuPhiBean)){
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                    if (JOptionPane.showConfirmDialog(null, "Bạn có muốn nhập tiếp??", "Cập nhật!!", JOptionPane.YES_NO_OPTION) == 0) {
                        close();
                        new CapNhatThongTinThuPhiJFrame(this.parentController,this.parentFrame);//.setLocationRelativeTo(null);
                    }   else{
                        close();
                        parentController.refreshData();
                    }
                     
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else JOptionPane.showMessageDialog(null, "Mã đợt thu hoặc mã hộ khẩu không hợp lệ!!");
                
    }
    }//GEN-LAST:event_updateActionPerformed

    private void CheckIDDotThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckIDDotThuActionPerformed
        // TODO add your handling code here:
        if(this.checkIDDotThu()){
            if(controller.checkMaDotThu(maDotThu.getText())){
            JOptionPane.showMessageDialog(rootPane, "ID đã có","Check ID", JOptionPane.INFORMATION_MESSAGE);
            this.availableDotThu.setEnabled(true);
            }
            else JOptionPane.showMessageDialog(rootPane, "ID chưa có","Check ID", JOptionPane.INFORMATION_MESSAGE);
        }
        else    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_CheckIDDotThuActionPerformed

    private void CheckIDHoKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckIDHoKhauActionPerformed
        // TODO add your handling code here:
        if(this.checkIDHoKhau()){
            if(controller.checkMaHoKhau(maHoKhau.getText())){
            JOptionPane.showMessageDialog(rootPane, "ID đã có","Check ID", JOptionPane.INFORMATION_MESSAGE);
            this.availableDotThu.setEnabled(true);
            }
            else JOptionPane.showMessageDialog(rootPane, "ID chưa có","Check ID", JOptionPane.INFORMATION_MESSAGE);
        
        }
        else    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_CheckIDHoKhauActionPerformed

    private void soTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soTienActionPerformed
    
    private boolean checkIDDotThu(){
        return !maDotThu.getText().trim().isEmpty();
    }
    
    private boolean checkIDHoKhau(){
        return !maHoKhau.getText().trim().isEmpty();
    }
    
    private boolean checkInForm(){
        if(maDotThu.getText().trim().isEmpty()
                || maHoKhau.getText().trim().isEmpty()
                || ngayThu.getDate().toString().isEmpty()
                || soTien.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
            return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckIDDotThu;
    private javax.swing.JButton CheckIDHoKhau;
    private javax.swing.JLabel availableDotThu;
    private javax.swing.JLabel availableHoKhau;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField maDotThu;
    private javax.swing.JTextField maHoKhau;
    private com.toedter.calendar.JDateChooser ngayThu;
    private javax.swing.JTextField soTien;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
