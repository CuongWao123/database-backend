package com.example.database_backend.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SumLamThemResponse {
    private Integer month;
    private BigDecimal tong_luong_lam_them;
    private String tong_gio_lam_them;
}
