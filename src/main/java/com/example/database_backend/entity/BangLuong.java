package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.BangLuongKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "bangluong"
)
public class BangLuong {
    @EmbeddedId
    private BangLuongKey bangLuongKey;
    @Column(name = "luongcoban")
    private BigDecimal luongcoban;
    @Column(name = "luonglamthem")
    private BigDecimal luonglamthem;
    @Column(name = "xangxe")
    private BigDecimal xangxe;
    @Column(name = "antrua")
    private BigDecimal antrua;
    @Column(name = "hotrokhac")
    private BigDecimal hotrokhac;
    @Column(name = "bhxh")
    private BigDecimal bhxh;
    @Column(name = "bhyt")
    private BigDecimal bhyt;
    @Column(name = "thue")
    private BigDecimal thue;
    @Column(name = "khautru")
    private BigDecimal khautru;
    @Column(name = "luongthucte")
    private BigDecimal luongthucte;
}
