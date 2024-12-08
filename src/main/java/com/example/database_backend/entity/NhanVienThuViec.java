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
        name = "nvthuviec"

)
public class NhanVienThuViec {
    @Id
    @Column(name = "msnv")
    private String msnv ;

    @Column(name ="startdate")
    private Date startdate ;

    @Column(name ="enddate")
    private Date enddate;
    @Column(name ="nvgiamsat")
    private String nvgiamsat;
}
