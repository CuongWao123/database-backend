package com.example.database_backend.repository;

import com.example.database_backend.entity.BangChamCong;
import com.example.database_backend.entity.CompositeKey.BangChamCongKey;
import com.example.database_backend.response.SumLamThemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BangChamCongRepository extends JpaRepository<BangChamCong, BangChamCongKey> {
    @Query(value = "CALL SUM_lam_them(:year)", nativeQuery = true)
    List<Object[]> sumLamThem(@Param("year") Integer year);
    BangChamCong findBangChamCongByBangChamCongKey_MsnvAndBangChamCongKey_ThangAndBangChamCongKey_Nam(String nv,Integer thang,Integer nam);
    List<BangChamCong>findBangChamCongByBangChamCongKey_ThangAndBangChamCongKey_Nam(Integer thang,Integer nam);

    List<BangChamCong> findAllByBangChamCongKey_Msnv(String msnv);
    @Query(value = "CALL k_hoanthanh_tren_nhieu_lan(:namm, :solan)", nativeQuery = true)
    List<Object[]> khoanthanh(@Param("namm") Integer year,
                              @Param("solan")Integer solan);

    @Query(value = "CALL nv_khong_dat_chi_tieu(:input_year, :solan)", nativeQuery = true)
    List<Object[]> chitiet_k_hoanthanh(@Param("input_year") Integer year,
                              @Param("solan")Integer solan);
}
