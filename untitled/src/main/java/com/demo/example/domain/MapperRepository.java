package com.demo.example.domain;

import com.demo.example.dto.MYbatisDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // Mapper용으로 쓸 Repository라고 선언하는 어노테이션
    public interface MapperRepository {
        List<MYbatisDTO> AllList();
         List<MYbatisDTO> areaList();
    }
