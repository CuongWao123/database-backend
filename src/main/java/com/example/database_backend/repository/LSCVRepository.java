package com.example.database_backend.repository;

import com.example.database_backend.entity.CompositeKey.LichSuCVKey;
import com.example.database_backend.entity.LichSuCongViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LSCVRepository extends JpaRepository<LichSuCongViec, LichSuCVKey> {
    @Query(value="CALL xem_lichsu_cv(:nv)",nativeQuery = true)
    List<Object[]> xemlichsu(@Param("nv" )String nv);
}
