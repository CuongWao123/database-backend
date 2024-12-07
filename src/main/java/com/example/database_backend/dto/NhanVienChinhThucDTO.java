package com.example.database_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVienChinhThucDTO {
    private String msnv;           // Mã số nhân viên
    private String hoten;          // Họ và tên
    private Date ngaysinh;    // Ngày sinh
    private String gioitinh;       // Giới tính
    private String cccd;           // CCCD (Căn cước công dân)
    private String mspb;           // Mã số phòng ban
    private String bhxh;           // BHXH (Bảo hiểm xã hội)
    private String nguoiquanly ;

}
