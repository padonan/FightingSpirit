package com.example.demo.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class SearchForm{
    private String keyword;
    private String[] areaList;
    private Long[] careerList;
    private Long[] academicList;
}
