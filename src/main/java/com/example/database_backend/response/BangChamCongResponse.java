package com.example.database_backend.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BangChamCongResponse {
    private String msnv;
    private String hoten;
    private String mspb;
    private Integer thang;
    private Integer nam;
    private String sogioHienTai;
    private String sogioToiThieu;
    private String sogioLamThem;
}
