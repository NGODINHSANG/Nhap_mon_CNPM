/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controllers.ThuPhiPanelController;
import javax.swing.JFrame;
import views.ThuPhiManagerFrame.ThemDotThuMoiJFrame;
import views.ThuPhiManagerFrame.CapNhatDotThuJFrame;
import views.ThuPhiManagerFrame.XoaDotThuJFrame;
import views.ThuPhiManagerFrame.ThongKeChiTietJFrame;
/**
 *
 * @author Ngo Viet Cuong
 */
public class ThuPhiPanel extends javax.swing.JPanel {

    private JFrame parentJFrame;
    private ThuPhiPanelController controller;
    /**
     * Creates new form ThuPhiPanel
     */
    public ThuPhiPanel(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
        initComponents();
        controller = new ThuPhiPanelController(TimKiemField,jPanel1);
        controller.setParentJFrame(parentJFrame);
        controller.setData();
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
        ThemMoiBtn = new javax.swing.JButton();
        XoaBtn = new javax.swing.JButton();
        ChiTietBtn = new javax.swing.JButton();
        CapNhatBtn = new javax.swing.JButton();
        TimKiemField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ThemMoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ThemMoiBtn.setText("Thêm mới");
        ThemMoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemMoiBtnActionPerformed(evt);
            }
        });

        XoaBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        XoaBtn.setText("Xóa");
        XoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtnActionPerformed(evt);
            }
        });

        ChiTietBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ChiTietBtn.setText("Chi tiết");
        ChiTietBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChiTietBtnActionPerformed(evt);
            }
        });

        CapNhatBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CapNhatBtn.setText("Cập nhật");
        CapNhatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBtnActionPerformed(evt);
            }
        });

        TimKiemField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TimKiemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 418, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThemMoiBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhatBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChiTietBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(TimKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ThemMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CapNhatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ChiTietBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(215, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemMoiBtnActionPerformed
        ThemDotThuMoiJFrame themDotThuMoiJFrame = new ThemDotThuMoiJFrame();
        themDotThuMoiJFrame.setLocationRelativeTo(null);
        themDotThuMoiJFrame.setResizable(false);
        themDotThuMoiJFrame.setVisible(true);
    }//GEN-LAST:event_ThemMoiBtnActionPerformed

    private void XoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtnActionPerformed
        XoaDotThuJFrame xoaDotThuJFrame = new XoaDotThuJFrame();
        xoaDotThuJFrame.setLocationRelativeTo(null);
        xoaDotThuJFrame.setResizable(false);
        xoaDotThuJFrame.setVisible(true);
    }//GEN-LAST:event_XoaBtnActionPerformed

    private void ChiTietBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChiTietBtnActionPerformed
        ThongKeChiTietJFrame thongKeChiTietJFrame = new ThongKeChiTietJFrame();
        thongKeChiTietJFrame.setLocationRelativeTo(null);
        thongKeChiTietJFrame.setResizable(false);
        thongKeChiTietJFrame.setVisible(true);
    }//GEN-LAST:event_ChiTietBtnActionPerformed

    private void CapNhatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBtnActionPerformed
        CapNhatDotThuJFrame capNhatDotThuJFrame = new CapNhatDotThuJFrame();
        capNhatDotThuJFrame.setLocationRelativeTo(null);
        capNhatDotThuJFrame.setResizable(false);
        capNhatDotThuJFrame.setVisible(true);
    }//GEN-LAST:event_CapNhatBtnActionPerformed

    private void TimKiemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimKiemFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CapNhatBtn;
    private javax.swing.JButton ChiTietBtn;
    private javax.swing.JButton ThemMoiBtn;
    private javax.swing.JTextField TimKiemField;
    private javax.swing.JButton XoaBtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
