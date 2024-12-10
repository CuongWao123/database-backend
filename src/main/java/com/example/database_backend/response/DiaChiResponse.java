package com.example.database_backend.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaChiResponse {
    private String sonha;
    private String tenduong;
    private String phuong;
    private String tinhthanhpho;
}
