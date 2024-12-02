package com.example.database_backend.repository;

import com.example.database_backend.entity.NhanVienChinhThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface NhanVienChinhThucRepository extends JpaRepository<NhanVienChinhThuc,String> {
    @Query(value = "CALL getAllnvChinhthuc()", nativeQuery = true)
    List<Object[]> getALLnhanvienchinhthuc();

    @Query(value = "CALL insert_nvchinhthuc(    :msnv,:hovaten ,:ngaysinh ,:gioitinh ,:cccd ,:masophongban," +
            ":bhxh,:nguoiquanly ,:startdate,:chucvu ,:lcb ,:sogiotoithieu  )", nativeQuery = true)
    List<Object>  them_nhanvien_chinhthuc(
            @Param("msnv") String msnv ,
            @Param("hovaten") String hovaten ,
            @Param("ngaysinh")Date ngaysinh ,
            @Param("gioitinh") String gioitinh ,
            @Param("cccd") String cccd ,
            @Param("masophongban") String mspb ,
            @Param("bhxh") String bhxh ,
            @Param("nguoiquanly") String nvquanly ,
            @Param("startdate") Date startdate ,
            @Param("chucvu") String chucvu ,
            @Param("lcb")BigDecimal lcb ,
            @Param("sogiotoithieu") Integer sotgio
            );

    @Query(value = "CALL delete_nhanvien( :msnv )", nativeQuery = true)
    List<Object>  delete_nhanvien_chinhthuc(@Param("msnv") String msnv);


    @Query(value = "CALL sua_ten_nhanvien( :p_msnv , :p_hoten_moi )", nativeQuery = true)
    List<Object>  sua_ten_nhanvien(@Param("p_msnv") String p_msnv, @Param("p_hoten_moi") String p_hoten_moi);

}
