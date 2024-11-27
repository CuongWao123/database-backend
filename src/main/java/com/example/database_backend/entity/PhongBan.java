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
        name = "phongban"

)
public class PhongBan {
    @Id
    @Column(name = "mspb", length = 9)
    private  String mspb;
    @Column(name ="mota", length = 100 )
    private String mota ;
    @Column (name = "tenphongban" , length =  30)
    private String tenphongban ;
    @Column( name ="ngaythanhlap" )
    private Date ngaythanhlap ;
    @Column(name ="soluongnhanvien")
    private Integer soluongnhanvien ;
    @Column(name = "nv_quanly")
    private String nv_quanly;
}
