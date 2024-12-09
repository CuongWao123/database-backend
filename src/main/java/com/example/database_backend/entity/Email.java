package com.example.database_backend.entity;

import com.example.database_backend.entity.CompositeKey.DiaChiKey;
import com.example.database_backend.entity.CompositeKey.EmailKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "nvemail"

)
public class Email {

    @EmbeddedId
    private EmailKey emailKey;

    @ManyToOne
    @MapsId("msnv")
    @JoinColumn(name = "msnv")
    private NhanVien nhanVien;

}
