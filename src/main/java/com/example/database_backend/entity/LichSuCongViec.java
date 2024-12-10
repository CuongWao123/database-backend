package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.EmailKey;
import com.example.database_backend.entity.CompositeKey.LichSuCVKey;
import jakarta.persistence.*;
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
        name = "lscongviec"

)
public class LichSuCongViec {
    @EmbeddedId
    private LichSuCVKey lichSuCVKey;

    @ManyToOne
    @MapsId("msnv")
    @JoinColumn(name = "msnv")
    private NhanVien nhanVien;
    @Column(name ="startdate")
    private Date startdate ;

    @Column(name ="chucvu")
    private String chucvu;
    @Column(name ="loainv")
    private String loainv;
    @Column(name = "luongcoban")
    private BigDecimal luongcoban;
    @Column(name ="tenphongban")
    private String tenphongban;

}
