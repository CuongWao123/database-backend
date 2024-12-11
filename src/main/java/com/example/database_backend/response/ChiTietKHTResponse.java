package com.example.database_backend.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietKHTResponse {
    private String msnv;
    private Integer thang;
    private String toithieu;
    private String thucte;

}
