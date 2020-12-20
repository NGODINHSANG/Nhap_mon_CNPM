/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.ThuPhiManagerFrame;

import Bean.DotThuBean;
import controllers.ThuPhiManagerController.XoaController;
import controllers.ThuPhiPanelController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.DotThuModel;

/**
 *
 * @author dungg
 */
public class XoaDotThuJFrame extends javax.swing.JFrame {
	//Declare
    private ThuPhiPanelController parentController;
    private JFrame parentFrame;
    private XoaController controller;
    private DotThuBean dotThuBean;
    /**
     * Creates new form XoaDotThuJFrame
     */
    public XoaDotThuJFrame() {
        initComponents();
    }
    public XoaDotThuJFrame(ThuPhiPanelController parentController,JFrame parentFrame) {
        this.parentController = parentController;
        this.parentFrame = parentFrame;
        initComponents();
        controller = new XoaController();
        setTitle("XÓA ĐỢT THU PHÍ");
        this.dotThuBean = new DotThuBean();
        this.parentFrame.setEnabled(false);
        // confirm de thuc hien dong
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
        });
    }
    
    private void close(){
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

        jLabel1 = new javax.swing.JLabel();
        maDotThu = new javax.swing.JTextField();
        huyBtn = new javax.swing.JButton();
        xacNhanBtn = new javax.swing.JButton();

        checkBtn = new javax.swing.JButton();
        availableDotThu = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mã đợt thu");

        maDotThu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maDotThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maDotThuActionPerformed(evt);
            }
        });

        huyBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        huyBtn.setText("Hủy");
        huyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyBtnActionPerformed(evt);
            }
        });

        xacNhanBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        xacNhanBtn.setText("Xác nhận");
        xacNhanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhanBtnActionPerformed(evt);
            }
        });


        checkBtn.setText("Check");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        availableDotThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N
        availableDotThu.setEnabled(false);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(huyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xacNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)

                        .addGap(6, 6, 6)
                        .addComponent(maDotThu, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(availableDotThu)
                        .addGap(28, 28, 28))))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maDotThu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(availableDotThu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xacNhanBtn)
                    .addComponent(huyBtn))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XoaDotThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XoaDotThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XoaDotThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XoaDotThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XoaDotThuJFrame().setVisible(true);
            }
        });
    }
    private boolean checkMaDotThu(){
        return !maDotThu.getText().trim().isEmpty();
    }
    
    private void maDotThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maDotThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maDotThuActionPerformed

    private void huyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyBtnActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_huyBtnActionPerformed

    private void xacNhanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhanBtnActionPerformed
        // TODO add your handling code here:
        if(this.checkMaDotThu()){
            DotThuModel tmp = this.dotThuBean.getDotThuModel();
            tmp.setMaDotThu(maDotThu.getText());
            if(controller.checkMaDotThu(this.dotThuBean.getDotThuModel().getMaDotThu())){
                JOptionPane.showMessageDialog(rootPane, "OK ! Có đợt thu này trong hệ thống.", "Check Tên Đợt Thu", JOptionPane.INFORMATION_MESSAGE);
                this.availableDotThu.setEnabled(true);
                if(JOptionPane.showConfirmDialog(rootPane, "Bạn muốn xóa đợt thu này trong hệ thống", "Xác nhận xóa đợt thu", JOptionPane.WARNING_MESSAGE) == 0){
                    try {
                        if(controller.xoaDotThu(this.dotThuBean))
                           JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Xóa Đợt Thu", JOptionPane.INFORMATION_MESSAGE) ;
                           close();
                           parentController.refreshData();
                    } catch (Exception e) {
                       System.out.println(e.getMessage());
                       JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                };
            }else{
                JOptionPane.showMessageDialog(rootPane, "Không có đợt thu này trong hệ thống.", "Check Tên Đợt Thu", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please Enter the required fields !", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_xacNhanBtnActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        if(this.checkMaDotThu()){
            if(controller.checkMaDotThu(maDotThu.getText())){
                JOptionPane.showMessageDialog(rootPane, "OK ! Có đợt thu này trong hệ thống.", "Check Tên Đợt Thu", JOptionPane.INFORMATION_MESSAGE);
                this.availableDotThu.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Không có đợt thu này trong hệ thống.", "Check Tên Đợt Thu", JOptionPane.WARNING_MESSAGE);
                this.availableDotThu.setEnabled(false);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please Enter the required fields !", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_checkBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JLabel availableDotThu;
    private javax.swing.JButton checkBtn;
    private javax.swing.JButton huyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField maDotThu;
    private javax.swing.JButton xacNhanBtn;
    // End of variables declaration//GEN-END:variables
}
