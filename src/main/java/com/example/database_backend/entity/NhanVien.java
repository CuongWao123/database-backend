package com.example.database_backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "nhanvien"

)
public class NhanVien {
    @Id
    @Column(name = "msnv")
    private String msnv ;

    @Column(name ="hoten")
    private String hoten ;

    @Column(name ="ngaysinh")
    private Date ngaysinh;

    @Column(name ="gioitinh")
    private String gioitinh;

    @Column(name ="cccd")
    private String cccd ;

    @Column (name ="loainhanvien")
    private String loainhanvien;

    @Column(name="mspb")
    private String mspb ;

}
