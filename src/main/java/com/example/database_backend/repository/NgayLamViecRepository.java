package com.example.database_backend.repository;

import com.example.database_backend.entity.BangLuong;
import com.example.database_backend.entity.CompositeKey.BangLuongKey;
import com.example.database_backend.entity.CompositeKey.NgayLamViecKey;
import com.example.database_backend.entity.NgayLamViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface NgayLamViecRepository extends JpaRepository<NgayLamViec, NgayLamViecKey> {
    @Query(value = "CALL listngay(:dau, :cuoi, :nv)", nativeQuery = true)
    List<Object[]> listngay(@Param("dau") Date dau,
                            @Param("cuoi") Date cuoi,
                            @Param("nv") String nv
                             );
    @Query(value= "select tinhgio(:batdau,:ketthuc,:nv)",nativeQuery = true)
    List<Object[]> tinhgio(@Param("batdau") Date dau,
                           @Param("ketthuc") Date cuoi,
                           @Param("nv") String nv);
}
