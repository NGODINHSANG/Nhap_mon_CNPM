use quan_ly_nhan_khau;
drop table if exists thong_tin_thu_phi;
drop table if exists dot_thu;

CREATE TABLE `dot_thu` (
	`idDotThu` int(11) NOT NULL,
    `maDotThu` varchar(10) DEFAULT NULL,
    `tenDotThu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
	`loaiPhiThu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ngayBatDauThu` date DEFAULT NULL,
    `ngayKetThucThu` date DEFAULT NULL,
    `soTienTrenMotNhanKhau`int(11) DEFAULT 0
    ,`ngayTao` date DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `thong_tin_thu_phi` (
	`maDotThu` varchar(10) NOT NULL,
    `maHoKhau` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
    `soNhanKhau` int(11) DEFAULT NULL,
    `tongSoTien` int(11) DEFAULT 0,
    `ngaythu` date DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `dot_thu`
	ADD FULLTEXT KEY maDotThu (maDotThu),
    ADD PRIMARY KEY idDotThu (idDotThu);

ALTER TABLE `thong_tin_thu_phi` 
 ADD PRIMARY KEY (maDotThu, maHoKhau);
-------------------------------------------------------------
INSERT INTO `dot_thu` (`idDotThu`, `maDotThu`, `tenDotThu`, `loaiPhiThu`, `ngayBatDauThu`, `ngayKetThucThu`, `soTienTrenMotNhanKhau`, `ngayTao`) VALUES ('1', 'DT001', 'Phí vệ sinh', 'Bắt buộc', '2020-12-08', '2020-12-15', '10000', '2020-12-07');
INSERT INTO `dot_thu` (`idDotThu`, `maDotThu`, `tenDotThu`, `loaiPhiThu`, `ngayBatDauThu`, `ngayKetThucThu`, `soTienTrenMotNhanKhau`, `ngayTao`) VALUES ('2', 'DT002', 'Quỹ khuyến học', 'Không bắt buộc', '2020-12-03', '2020-12-17', '0', '2020-12-01');

INSERT IGNORE INTO `thong_tin_thu_phi` (maDotThu, maHoKhau,soNhanKhau)
SELECT maDotThu, maHoKhau, soNhanKhau FROM
(SELECT maDotThu FROM dot_thu ) dotthu 
CROSS JOIN
(SELECT hokhau.maHoKhau,COUNT(*) soNhanKhau
	FROM ho_khau hokhau LEFT JOIN thanh_vien_cua_ho thanhvien 
		ON hOkhau.ID=thanhvien.idHoKhau
    GROUP BY hokhau.ID) tthokhau
ORDER BY dotthu.maDotThu, tthokhau.maHoKhau;
 