package com.example.database_backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "nvchinhthuc"

)
public class NhanVienChinhThuc {
    @Id
    @Column(name ="msnv")
    String name ;
    @Column(name ="bhxh")
    String bhxh ;
    @Column(name ="nguoiquanly")
    String nguoiquanly ;
}
