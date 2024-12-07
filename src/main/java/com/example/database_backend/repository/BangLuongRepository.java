package com.example.database_backend.repository;

import com.example.database_backend.entity.BangLuong;
import com.example.database_backend.entity.CompositeKey.BangLuongKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BangLuongRepository extends JpaRepository<BangLuong, BangLuongKey> {
}
