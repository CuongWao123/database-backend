package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.DiaChiKey;
import com.example.database_backend.entity.CompositeKey.SDTKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "nvsdt"
)
public class SDT {
    @EmbeddedId
    private SDTKey sdtKey;

    @ManyToOne
    @MapsId("msnv")
    @JoinColumn(name = "msnv")
    private NhanVien nhanVien;
}
