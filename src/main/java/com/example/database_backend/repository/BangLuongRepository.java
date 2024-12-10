package com.example.database_backend.repository;

import com.example.database_backend.entity.BangLuong;
import com.example.database_backend.entity.CompositeKey.BangLuongKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BangLuongRepository extends JpaRepository<BangLuong, BangLuongKey> {
    BangLuong findBangLuongByBangLuongKey_MsnvAndBangLuongKey_ThangAndBangLuongKey_Nam(String nv,Integer thang,Integer nam);


    List<BangLuong> findBangLuongsByBangLuongKey_ThangAndBangLuongKey_Nam(Integer thang,Integer nam);
}
