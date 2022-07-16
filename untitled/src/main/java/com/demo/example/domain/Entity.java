package com.demo.example.domain;
import com.demo.example.dto.DetailResponse;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@javax.persistence.Entity
@Table(name = "DB")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long ID; //식별 id


    private  String homepage; //사이트 종류
    private  String company; //회사
    private  String title; // 게시글 제목
    private  String career; // 경력
    private  String academic; //학력
    private  String employment; //고용형태
    private  String area; //지역
    private  String period; // 기간
    private  Long board_time; // 게시글 시간
    private  Long salary; //급여
    private  String url;// 링크


    public DetailResponse toResponse() {

        return DetailResponse.builder()
                .ID(ID)
                .homepage(homepage)
                .company(company)
                .title(title)
                .career(career)
                .academic(academic)
                .employment(employment)
                .area(area)
                .period(period)
                .board_time(board_time)
                .board_time(board_time)
                .salary(salary)
                .url(url)
                .build();
    }
}

