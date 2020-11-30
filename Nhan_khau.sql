CREATE DATABASE project;
USE project;
CREATE TABLE project.NhanKhau(
	Ho_ten VARCHAR(100) NOT NULL,
    Bi_danh VARCHAR(100),
    Ngay_sinh DATETIME NOT NULL,
    Noi_sinh VARCHAR(200) NOT NULL,
    Gioi_tinh VARCHAR(10) NOT NULL,
    Quoc_tich VARCHAR(50) NOT NULL,
    Nguyen_quan VARCHAR(200) NOT NULL,
    Dan_toc VARCHAR(50) NOT NULL,
    Noi_lam_viec VARCHAR(100) NOT NULL,
    Nghe_nghiep VARCHAR(100) NOT NULL,
	CMND VARCHAR(50) NOT NULL,
    Ngay_cap DATETIME NOT NULL,
    Noi_cap VARCHAR(200) NOT NULL,
    Ngay_dang_ky_thuong_tru DATETIME NOT NULL,
    Dia_chi_thuong_tru_truoc_day VARCHAR(200) NOT NULL,
    So_ho_khau VARCHAR(200) NOT NULL,
    Ngay_chuyen_di DATETIME NOT NULL,
    Noi_chuyen_den VARCHAR(200) NOT NULL,
    Ghi_chu VARCHAR(200),
    PRIMARY KEY(CMND),
    CONSTRAINT FK_NhanKhau_HoKhau FOREIGN KEY (So_ho_khau) REFERENCES HoKhau(So_ho_khau)
);

CREATE TABLE project.HoKhau(
	So_ho_khau VARCHAR(200) NOT NULL,
    Chu_ho VARCHAR(50) NOT NULL,
    Quan_he_voi_chu_ho VARCHAR(50) NOT NULL,
    So_nha VARCHAR(10) NOT NULL,
    Duong_pho VARCHAR(100) NOT NULL,
    Phuong VARCHAR(100) NOT NULL,
    Thanh_Pho VARCHAR(100) NOT NULL,
    Noi_dung_thay_doi VARCHAR(200),
    Ngay_thay_doi DATETIME,
    PRIMARY KEY(So_ho_khau)
);

CREATE TABLE project.TamVang(
	Ho_ten VARCHAR(100) NOT NULL,
    Ngay_sinh DATETIME NOT NULL,
    Gioi_tinh VARCHAR(10) NOT NULL,
    Quoc_tich VARCHAR(50) NOT NULL,
    CMND VARCHAR(50) NOT NULL,
    Ho_chieu VARCHAR(50),
    Dia_chi_thuong_tru VARCHAR(200) NOT NULL,
    Noi_den VARCHAR(200) NOT NULL,
	Ngay_chuyen_di DATETIME NOT NULL,
    Ngay_chuyen_ve DATETIME NOT NULL,
    Noi_chuyen_den VARCHAR(200) NOT NULL,
    Ly_do VARCHAR(200) NOT NULL,
    PRIMARY KEY(CMND),
    CONSTRAINT FK_TamVang_NhanKhau_CMND FOREIGN KEY (CMND) REFERENCES NhanKhau(CMND)
);

CREATE TABLE project.TamTru(
	Ho_ten VARCHAR(100) NOT NULL,
    Ngay_sinh DATETIME NOT NULL,
    CMND VARCHAR(50) NOT NULL,
    Ngay_cap DATETIME NOT NULL,
    Noi_cap VARCHAR(200) NOT NULL,
	Noi_thuong_tru_tam_tru VARCHAR(200) NOT NULL,
    Dia_chi_thuong_chu_truoc_day VARCHAR(200) NOT NULL,
    Ngay_chuyen_den DATETIME NOT NULL,
    Ngay_chuyen_di DATETIME NOT NULL,
    Ly_do VARCHAR(200) NOT NULL,
    CONSTRAINT FK_TamTru_NhanKhau_CMND FOREIGN KEY (CMND) REFERENCES NhanKhau(CMND)
);

CREATE TABLE project.CacKhoanThu(
	Khoan_thu VARCHAR(50) NOT NULL,
    Ngay_bat_dau_thu DATETIME NOT NULL,
    Ngay_ket_thuc_thu DATETIME NOT NULL,
    Bat_buoc BOOL NOT NULL,
    So_tien_can_thu_tren_mot_nhan_khau INT,
    PRIMARY KEY(Khoan_thu)
);

CREATE TABLE project.DanhSachThu(
	So_ho_khau VARCHAR(200) NOT NULL,
    Chu_ho varchar(50) not null,
	So_nha VARCHAR(10) NOT NULL,
    Duong_pho VARCHAR(100) NOT NULL,
    So_nhan_khau INT NOT NULL,
    Khoan_thu VARCHAR(50) NOT NULL,
    So_tien INT NOT NULL,
    Da_dong BOOL NOT NULL,
    Ngay_dong DATETIME NOT NULL,
    PRIMARY KEY(So_ho_khau),
    CONSTRAINT FK_DanhSachThu_CacKhoanthu FOREIGN KEY (Khoan_thu) REFERENCES CacKhoanThu(Khoan_thu),
    constraint fk_DanhSachThu_HoKhau foreign key (Chu_ho) references HoKhau(Chu_ho)
);

SELECT* FROM project.NhanKhau;
SELECT* FROM project.HoKhau;
SELECT* FROM project.TamVang;
SELECT* FROM project.TamTru;
SELECT* FROM project.CacKhoanThu;
SELECT* FROM project.DanhSachThu;


DROP TABLE IF EXISTS project.NhanKhau;
DROP TABLE IF EXISTS project.Hokhau;
DROP TABLE IF EXISTS project.TamVang;
DROP TABLE IF EXISTS project.TamTru;
DROP TABLE IF EXISTS project.CacKhoanThu;
DROP TABLE IF EXISTS project.DanhSachThu;

alter table project.hokhau add  unique key( Chu_ho);
alter table project.danhsachthu add constraint fk1_DanhSachThu_HoKhau foreign key (So_nha) references HoKhau(So_nha);
alter table project.danhsachthu add  constraint fk_So_ho_khau_DanhSachThu_HoKhau foreign key (So_ho_khau) references HoKhau(So_ho_khau);