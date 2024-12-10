package com.example.database_backend.response;

import jakarta.persistence.Column;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BangLuongResponse {
    private String msnv;
    private String hoten;
    private String mspb;
    private int thang;
    private int nam;
    private BigDecimal luongcoban;
    private BigDecimal luonglamthem;
    private BigDecimal xangxe;
    private BigDecimal antrua;
    private BigDecimal hotrokhac;
    private BigDecimal bhxh;
    private BigDecimal bhyt;
    private BigDecimal thue;
    private BigDecimal khautru;
    private BigDecimal luongthucte;
}
