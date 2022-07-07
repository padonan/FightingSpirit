package com.example.demo.service;

import com.example.demo.entity.DbEntiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private DbRepository dbRepository;

    DbEntiry getDbOne() {
        Optional<DbEntiry> response = dbRepository.findById(685L);
        return response.get();
    }
}
