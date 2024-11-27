package com.example.database_backend.repository;

import com.example.database_backend.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan,String> {

    @Query(value = "CALL THEM_PHONGBAN(:p_mspb , :p_mota ,:p_tenphongban ,:p_nv_quanly)", nativeQuery = true)
    List<Object[]> add_phongban(@Param("p_mspb") String mspb,
                                @Param("p_mota") String mota ,
                                @Param("p_tenphongban") String tenphongban ,
                                @Param("p_nv_quanly") String quanly
    );

}
