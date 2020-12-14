/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.ThuPhiPanel;

/**
 *
 * @author VuDinhHieu
 */
public class ThuPhiMainFrameController {
    private JFrame jfrMainThuPhi;
    private JPanel root;
    
    public ThuPhiMainFrameController(JPanel root, JFrame jfrMain){
        this.jfrMainThuPhi = jfrMain;
        this.root = root;
    }
    
    public void setView(){
        JPanel view = new JPanel();
        view = new ThuPhiPanel(this.jfrMainThuPhi);
        root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(view);
            root.validate();
            root.repaint();
            
    }
    
}
