/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;
import Bean.DotThuBean;
import Bean.ThongTinThuPhiBean;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import models.DotThuModel;
import models.ThongTinThuPhiModel;
/**
 *
 * @author Ngo Viet Cuong
 */
public class TableModelThuPhi {
    //bang cho main frame
    public DefaultTableModel setTableThuPhi(List<DotThuModel> listItem,String[] listColumn){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((DotThuModel item)-> {
                obj[0] = item.getMaDotThu();
                obj[1] = item.getTenDotThu();
                obj[2] = item.getLoaiPhiThu();
                obj[3] = item.getNgayBatDauThu().toString();
                obj[4] = item.getNgayKetThucThu().toString();
                obj[5] = item.getSoTienTrenMotNhanKhau();
                dtm.addRow(obj);
            
        });
        return dtm;
    }
    
    //bang thong tin dot thu 
    public DefaultTableModel setTableDotThu(List<ThongTinThuPhiModel> thongTin,String[] listColumn, boolean taoDanhSachThu){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        thongTin.forEach((ThongTinThuPhiModel item) -> {
            obj[0] = item.getMaDotThu();
            obj[1] = item.getMaHoKhau();
            obj[2] = Integer.toString(item.getSoNhanKhau());
            obj[3] = taoDanhSachThu?" ":Integer.toString(item.getTongSoTien());
            obj[4] = taoDanhSachThu?" ":item.getNgayThu().toString();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTablethongtin(List<ThongTinThuPhiModel> thongTin,String[] listColumn){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        thongTin.forEach((ThongTinThuPhiModel item) -> {
            obj[0] = item.getMaDotThu();
            obj[1] = item.getMaHoKhau();
            obj[2] = Integer.toString(item.getSoNhanKhau());
            obj[3] = Integer.toString(item.getTongSoTien());
            obj[4] = item.getNgayThu()==null?" ":item.getNgayThu().toString();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
