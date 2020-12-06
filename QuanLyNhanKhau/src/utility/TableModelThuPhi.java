/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;
import Bean.DotThuBean;
import Bean.ThongTinThuPhiBean;
import java.util.List;
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
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((DotThuModel item) -> {
            obj[0] = item.getTenDotThu();
            obj[1] = item.getLoaiPhiThu();
            obj[2] = item.getNgayBatDauThu().toString();
            obj[3] = item.getNgayKetThucThu().toString();
            obj[4] = item.getSoTienTrenMotNhanKhau();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    //bang thong tin dot thu 
    public DefaultTableModel setTableDotThu(List<ThongTinThuPhiBean> thongTin,String[] listColumn){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        thongTin.forEach((ThongTinThuPhiBean item) -> {
            obj[0] = item.getHoKhauModel().getMaHoKhau();
            obj[1] = item.getThongTinThuPhiModel().getSoNhanKhau();
            obj[2] = item.getThongTinThuPhiModel().getTongSoTien();
            obj[3] = item.getThongTinThuPhiModel().getNgayThu().toString();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
