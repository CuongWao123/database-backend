package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.BangChamCongKey;
import com.example.database_backend.entity.CompositeKey.NgayLamViecKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "ngaylamviec"
)
public class NgayLamViec {
    @EmbeddedId
    private NgayLamViecKey ngayLamViecKey;

    @ManyToOne
    @MapsId("msnv")
    @JoinColumn(name = "msnv")
    private NhanVien nhanVien;
    @Column(name = "trangthai")
    private String trangthai;

    @Column(name = "giovao")
    private Timestamp giovao;
    @Column(name = "giora")
    private Timestamp giora;
}
