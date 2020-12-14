/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import Bean.DotThuBean;
import Bean.ThongTinThuPhiBean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DotThuModel;
import models.ThongTinThuPhiModel;
import services.ThuPhiService;

/**
 *
 * @author VuDinhHieu
 */
public class GeneratePDF {
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    public void generatePDF(String fileName, String maDotThuSearch) {
        
        try {
            
            //JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            ThuPhiService thuPhiService = new ThuPhiService();
            List<ThongTinThuPhiBean> thongTinThuPhi = thuPhiService.getListThongTinThuPhiDS(maDotThuSearch);
            String path = "";
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x = j.showSaveDialog(j);
            
            if(x==JFileChooser.APPROVE_OPTION){
                path = j.getSelectedFile().getPath();
            }
            Document doc = new Document();
        
            Font f = new Font(BaseFont.createFont("G:\\btl\\Nhap_mon_CNPM/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            
            
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path+"\\"+fileName));
                doc.open();
                
                
                //Tạo file pdf từ jtable
                PdfPTable tbl = new PdfPTable(4);
                
                //adding header
                PdfPCell c1 = new PdfPCell (new Phrase("Mã đợt thu",f));
                tbl.addCell(c1);
                PdfPCell c2 = new PdfPCell (new Phrase("Mã hộ khẩu",f));
                tbl.addCell(c2);
                PdfPCell c3 = new PdfPCell (new Phrase("Số nhân khẩu",f));
                tbl.addCell(c3);
                PdfPCell c4 = new PdfPCell (new Phrase("Ngày thu",f));
                tbl.addCell(c4);
                thongTinThuPhi.forEach((ThongTinThuPhiBean item) -> {
                    String maDotThu = item.getThongTinThuPhiModel().getMaDotThu();
                    String maHoKhau = item.getThongTinThuPhiModel().getMaHoKhau();
                    String soNhanKhau = Integer.toString(item.getThongTinThuPhiModel().getSoNhanKhau());
                    String ngayThu = " ";
                    tbl.addCell(new Phrase(maDotThu,f));
                    tbl.addCell(new Phrase(maHoKhau,f));
                    tbl.addCell(soNhanKhau);
                    tbl.addCell(ngayThu);
                });
                doc.add(tbl);
                //doc.add(new Paragraph("Đại học bách khoa Hà Nội", f)); 
                doc.close();
            } catch (DocumentException ex) {
                Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }                       
}
