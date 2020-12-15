# Nhap_mon_CNPM
1. Để chạy chương trình cần chuẩn bị cài đặt Apache netbeans IDE 12.0, XAMPP để hỗ trợ sử dụng cơ sở dữ liệu PHPmyadmin
2. CLone project về và thêm các thư viện trong mục lib vào project
3. Chạy các file sql trên PHPmyadmin để khởi tạo CSDL
4. Cài đặt font chữ vuArial.ttf để hỗ trợ hiển thị file khi xuất ra
5. Chỉnh lại đường dẫn đến file font chữ ở file source src/utility/GeneratePDF.java ở dòng 66."Font f = new Font(BaseFont.createFont("G:\\btl\\Nhap_mon_CNPM/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));" (thay phần đường dẫn này "G:\\btl\\Nhap_mon_CNPM/vuArial.ttf" bằng đường dẫn đến file font thực khi cài đặt trên máy
6. Chạy chương trình với tài khoản quản lý nhân khẩu tk "admin" mật khẩu "1", nếu là kế toán để quản lý thu phí dùng tk "ketoan" mật khẩu "2"
