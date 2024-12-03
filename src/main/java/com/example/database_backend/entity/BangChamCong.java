package com.example.database_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "bangchamcong"

)
public class BangChamCong {

    @Id
    @Column(name = "msnv")
    private String msnv;

    @Id
    @Column(name = "thang")
    private int thang;

    @Id
    @Column(name = "nam")
    private int nam;

    @Column(name = "sogiohientai")
    private int sogioHienTai;

    @Column(name = "sogiotoithieu")
    private int sogioToiThieu;
    @Column(name = "sogiolamthem")
    private int sogioLamThem;
}