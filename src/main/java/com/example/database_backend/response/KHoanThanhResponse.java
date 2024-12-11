package com.example.database_backend.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KHoanThanhResponse {
    private String msnv;
    private String hoten;
    private String tong_gio_thieu;
    private Long sothangthieu;
}
