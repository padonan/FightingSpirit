package com.demo.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 생성
public class SeachDTO {

    private String[] careerList;
    private String[] areaList;
    private String[] salaryList;
    private String[] academicList;
    private String career;
    private String area;
    private long salary;
    private long salaryValue;
    private long choosesalaryValue;
    private String academic;
    private String searchWord;



}
