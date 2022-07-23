package com.example.demo.entity;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseDTO {

    private  Long ID; //식별 id

    private  String homepage; //사이트 종류

    private  String company; //회사

    private  String title; // 게시글 제목

    private  Long career; // 경력

    private  String academic; //학력

    private  String employment; //고용형태

    private  String area; //지역

    private  String period; // 기간

    private  String etc; //기타

    private  String url;//링크



    @Builder
    public void ResponseDTO(Object res) {
        this.ID = ID;//식별 id

        this.homepage = homepage; //사이트 종류

        this.company = company; //회사

        this.title = title; // 게시글 제목

        this.career = career; // 경력

        this.academic = academic; //학력

        this.employment = employment; //고용형태

        this.area = area; //지역

        this.period = period; // 기간

        this.etc = etc;

        this.url = url;

    }


}
