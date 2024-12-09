package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.BangChamCongKey;
import com.example.database_backend.entity.CompositeKey.DiaChiKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "nvdiachi"
)
public class DiaChi {
    @EmbeddedId
    private DiaChiKey diaChiKey;

    @ManyToOne
    @MapsId("msnv")
    @JoinColumn(name = "msnv")
    private NhanVien nhanVien;
}
