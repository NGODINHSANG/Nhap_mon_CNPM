USE quan_ly_nhan_khau;

CREATE TABLE `dot_thu` (
	`maDotThu` varchar(100) NOT NULL,
    `tenDotThu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
	`loaiPhiThu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ngayBatDauThu` date DEFAULT NULL,
    `ngayKetThucThu` date DEFAULT NULL,
    `soTienTrenMotNhanKhau`int(11) NOT NULL
    ,`ngayTao` date DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `thong_tin_thu_phi` (
	`maDotThu` varchar(100) NOT NULL,
    `maHoKhau` varchar(100) NOT NULL,
    `soNhanKhau` int(11) DEFAULT NULL,
    `tongSoTien` int(11) DEFAULT NULL,
    `ngaythu` date DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `dot_thu`
ADD PRIMARY KEY (`maDotThu`);

ALTER TABLE `thong_tin_thu_phi`
ADD PRIMARY KEY (`maDotThu`,`maHoKhau`);

ALTER TABLE `thong_tin_thu_phi`
ADD FOREIGN KEY (`maDotThu`) REFERENCES `dot_thu`(`maDotThu`),
ADD FOREIGN KEY (`maHoKhau`) REFERENCES `ho_khau`(`maHoKhau`);


DROP TABLE `dot_thu`;
DROP TABLE `thong_tin_thu_phi`;
