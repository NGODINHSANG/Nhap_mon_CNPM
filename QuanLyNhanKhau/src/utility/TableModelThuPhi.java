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
    public DefaultTableModel setTableThuPhi(List<DotThuBean> listItem,String[] listColumn){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((DotThuBean item) -> {
            obj[0] = item.getDotThuModel().getID();
            obj[1] = item.getDotThuModel().getTenDotThu();
            //obj[2] = item.getDotThuModel().getNgayBatDauThu().toString();
            //obj[3] = item.getDotThuModel().getNgayKetThucThu().toString();
            obj[2] = item.getDotThuModel().getSoTienTrenMotNhanKhau();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    //bang thong tin dot thu 
    public DefaultTableModel setTableDotThu(List<ThongTinThuPhiModel> thongTin,String[] listColumn){
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
            obj[0] = item.getIDHoKhau();
            obj[1] = item.getSoNhanKhau();
            obj[2] = item.getTongSoTien();
            obj[3] = item.getNgayThu().toString();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
