package com.example.database_backend.entity.CompositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class BangLuongKey implements Serializable {
    @Column(name = "msnv")
    private String msnv;
    @Column(name = "thang")
    private int thang;
    @Column(name = "nam")
    private int nam;
}
