package com.example.demo.repository;

import com.example.demo.entity.DbEntiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbRepostitory extends JpaRepository<DbEntiry, Long> {

}
