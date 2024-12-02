package com.example.database_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "duan"

)
public class DuAn {
    @Id
    @Column(name ="maDA")
    private String maDA ;
    @Column(name ="tong_von_dau_tu" ,  precision = 20, scale = 2)
    private BigDecimal  vondautu ;

    @Column(name ="start_date")
    private Date start_date;

    @Column(name ="ten_DA")
    private String ten_da ;

    @Column(name ="mota")
    private String mota;

    @Column(name ="ma_phong_ban_quanly")
    private String mspb_quanly;


}
