package com.example.database_backend.repository;

import com.example.database_backend.entity.CompositeKey.EmailKey;
import com.example.database_backend.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, EmailKey> {
    @Query(value= "CALL insert_into_nvemail( :p_msnv,:p_email)", nativeQuery = true)
    List<Object[]> insert_into_email(@Param("p_msnv") String msnv ,
                                   @Param("p_email") String mail );
    @Query(value= "CALL update_nvemail( :p_msnv,:p_old_email, :p_new_email)", nativeQuery = true)
    List<Object[]> update_email(@Param("p_msnv") String msnv ,
                                @Param("p_old_email") String mailcu,
                                @Param("p_new_email") String mailmoi);
    @Query(value= "CALL delete_nvemail( :p_msnv,:p_email)", nativeQuery = true)
    List<Object[]> delete_email(@Param("p_msnv") String msnv ,
                                     @Param("p_email") String mail );

    @Query(value = "SELECT * FROM nvemail WHERE msnv = :msnv",nativeQuery = true)
    List<Object[]> get_all_email(@Param("msnv") String msnv);

}
