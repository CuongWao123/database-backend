package com.example.database_backend.repository;

import com.example.database_backend.entity.CompositeKey.DiaChiKey;
import com.example.database_backend.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface DiaChiRepository extends JpaRepository<DiaChi, DiaChiKey> {
    @Query(value= "CALL insert_into_nvdiachi( :p_msnv,:p_sonha ,:p_tenduong ,:p_phuong , :p_tinhthanhpho )", nativeQuery = true)
    List<Object[]> insert_into_diachi(@Param("p_msnv") String msnv ,
                                      @Param("p_sonha") String sonha ,
                                      @Param("p_tenduong") String duong ,
                                      @Param("p_phuong") String phuong ,
                                      @Param("p_tinhthanhpho") String tinh );
    @Query(value= "CALL update_nvdiachi( :p_msnv,:p_old_sonha ,:p_old_tenduong ,:p_old_phuong , :p_old_tinhthanhpho,:p_new_sonha ,:p_new_tenduong ,:p_new_phuong , :p_new_tinhthanhpho )", nativeQuery = true)
    List<Object[]> update_diachi(@Param("p_msnv") String msnv ,
                                      @Param("p_old_sonha") String sonhacu ,
                                      @Param("p_old_tenduong") String duongcu ,
                                      @Param("p_old_phuong") String phuongcu ,
                                      @Param("p_old_tinhthanhpho") String tinhcu,
                                 @Param("p_new_sonha") String sonhamoi ,
                                 @Param("p_new_tenduong") String duongmoi ,
                                 @Param("p_new_phuong") String phuongmoi ,
                                 @Param("p_new_tinhthanhpho") String tinhmoi);
    @Query(value= "CALL delete_nvdiachi( :p_msnv,:p_sonha ,:p_tenduong ,:p_phuong , :p_tinhthanhpho )", nativeQuery = true)
    List<Object[]> delete_diachi(@Param("p_msnv") String msnv ,
                                      @Param("p_sonha") String sonha ,
                                      @Param("p_tenduong") String duong ,
                                      @Param("p_phuong") String phuong ,
                                      @Param("p_tinhthanhpho") String tinh );

}
