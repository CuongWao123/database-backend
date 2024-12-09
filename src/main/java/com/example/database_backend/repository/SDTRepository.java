package com.example.database_backend.repository;

import com.example.database_backend.entity.CompositeKey.SDTKey;
import com.example.database_backend.entity.SDT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SDTRepository extends JpaRepository<SDT, SDTKey> {
    @Query(value= "CALL insert_into_nvsdt( :p_msnv,:p_sdt)", nativeQuery = true)
    List<Object[]> insert_into_sdt(@Param("p_msnv") String msnv ,
                                      @Param("p_sdt") String sdt );
    @Query(value= "CALL update_nvsdt( :p_msnv,:p_old_sdt,:p_new_sdt)", nativeQuery = true)
    List<Object[]> update_sdt(@Param("p_msnv") String msnv ,
                                   @Param("p_old_sdt") String sdtcu,
                                   @Param("p_new_sdt") String sdtmoi);
    @Query(value= "CALL delete_nvsdt( :p_msnv,:p_sdt)", nativeQuery = true)
    List<Object[]> delete_sdt(@Param("p_msnv") String msnv ,
                                   @Param("p_sdt") String sdt );
}
