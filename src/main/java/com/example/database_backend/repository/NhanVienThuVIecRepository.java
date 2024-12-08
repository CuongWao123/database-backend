package com.example.database_backend.repository;

import com.example.database_backend.entity.NhanVienThuViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface NhanVienThuVIecRepository extends JpaRepository<NhanVienThuViec,String> {
    @Query(value = "CALL insert_nvthuviec(    :msnv,:hovaten ,:ngaysinh ,:gioitinh ,:cccd ,:masophongban," +
            ":nguoiquanly1 ,:startdate,:lcb ,:sogiotoithieu  )", nativeQuery = true)
    List<Object> them_nhanvien_thuviec(
            @Param("msnv") String msnv ,
            @Param("hovaten") String hovaten ,
            @Param("ngaysinh") Date ngaysinh ,
            @Param("gioitinh") String gioitinh ,
            @Param("cccd") String cccd ,
            @Param("masophongban") String mspb ,

            @Param("nguoiquanly1") String nvquanly ,
            @Param("startdate") Date startdate ,

            @Param("lcb") BigDecimal lcb ,
            @Param("sogiotoithieu") Integer sotgio
    );
    @Query(value = "CALL thuviec_thanh_chinhthuc( :nv,:bhxh ,:luong ,:toithieu , :hanthuviec )", nativeQuery = true)
    List<Object> thuviec_thanh_chinhthuc(
            @Param("nv") String nv ,
            @Param("bhxh") String bhxh ,
            @Param("luong") BigDecimal luong ,
            @Param("toithieu") Integer sotgio,
            @Param("hanthuviec") Date han

    );
    @Query(value = "CALL chuyen_viec( :nv,:luong ,:chuc , :pban,:loai,:toithieu,:sta)", nativeQuery = true)
    List<Object> chuyenviec(
            @Param("nv") String nv ,
            @Param("luong") BigDecimal luong ,
            @Param("chuc") String chucvu ,
            @Param("pban") String phong,
            @Param("loai") String loainv,
            @Param("toithieu") Integer sotgio,
            @Param("sta") Date han

    );

}
