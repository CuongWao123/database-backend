package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.BangChamCongKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(
        name = "bangchamcong"
)
public class BangChamCong {

    @EmbeddedId
    private BangChamCongKey bangChamCongKey;

    @ManyToOne
    @MapsId("msnv")
    @JoinColumn(name = "msnv")
    private NhanVien nhanVien;

    @Column(name = "sogiohientai")
    private int sogioHienTai;

    @Column(name = "sogiotoithieu")
    private int sogioToiThieu;
    @Column(name = "sogiolamthem")
    private int sogioLamThem;
}