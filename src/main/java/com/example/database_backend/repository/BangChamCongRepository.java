package com.example.database_backend.repository;

import com.example.database_backend.entity.BangChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangChamCongRepository extends JpaRepository<BangChamCong, (String )> {
}