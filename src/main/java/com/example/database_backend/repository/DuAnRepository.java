package com.example.database_backend.repository;

import com.example.database_backend.entity.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface DuAnRepository extends JpaRepository<DuAn,String> {

    @Query(value = "CALL them_duan( :p_maDA, :p_tong_von_dau_tu , :p_start_date , :p_ten_DA , :p_mota , :p_ma_phong_ban_quanly )", nativeQuery = true)
    List<Object> them_duan(@Param("p_maDA") String msnv ,
                           @Param("p_tong_von_dau_tu")BigDecimal p_tong_von_dau_tu ,
                           @Param("p_start_date")Date p_start_date ,
                           @Param("p_ten_DA") String p_ten_DA ,
                           @Param("p_mota") String p_mota ,
                           @Param("p_ma_phong_ban_quanly") String p_ma_phong_ban_quanly
                           );
    @Query(value = "CALL xoa_duan( :p_maDA )", nativeQuery = true)
    List<Object> xoa_duan(@Param("p_maDA") String msnv);


    @Query(value = "CALL sua_ten_duan( :p_maDA , :p_ten_DA )", nativeQuery = true)
    List<Object> sua_duan(@Param("p_maDA") String msnv ,
                            @Param("p_ten_DA") String p_ten_DA
    );



}
