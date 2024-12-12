package com.example.database_backend.repository;

import com.example.database_backend.entity.BangLuong;
import com.example.database_backend.entity.CompositeKey.BangLuongKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BangLuongRepository extends JpaRepository<BangLuong, BangLuongKey> {
    BangLuong findBangLuongByBangLuongKey_MsnvAndBangLuongKey_ThangAndBangLuongKey_Nam(String nv,Integer thang,Integer nam);

    List<BangLuong> findBangLuongsByBangLuongKey_ThangAndBangLuongKey_Nam(Integer thang,Integer nam);

    List<BangLuong> findAllByBangLuongKey_Msnv(String msnv);

    @Query(value = "CALL tinh_luong(:msnv,:thang,:nam,:xangxe,:antrua,:hotrokhac)",nativeQuery = true)
    List<Object[]> tinh_luong(
            @Param("msnv") String msnv,
            @Param("thang") Integer thang,
            @Param("nam") Integer nam,
            @Param("xangxe")BigDecimal xangxe,
            @Param("antrua")BigDecimal antrua,
            @Param("hotrokhac")BigDecimal hotrokhac
    );
}
