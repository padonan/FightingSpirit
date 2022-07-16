package com.demo.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class MYbatisDTO {

    private  Long ID; //식별 id

    private  String homepage; //사이트 종류

    private  String company; //회사

    private  String title; // 게시글 제목

    private  String career; // 경력

    private  String academic; //학력

    private  String employment; //고용형태

    private  String area; //지역

    private  String period; // 기간

    private  Long  board_time; // 게시글 시간

    private  Long salary; //급여
    private  String url;

    // 아래 생성자는 회원가입 때 필요한 정보만 모아놓은 생성자로 미리 만들어둡시다 :D
    public MYbatisDTO (Long ID, String homepage, String company,
   String title,String career,String academic,String employment,String area
    ,String period, Long board_time, Long salary,  String url) {
        this.ID = ID;//식별 id

        this.homepage = homepage; //사이트 종류

        this.company = company; //회사

        this.title = title; // 게시글 제목

        this.career = career; // 경력

        this.academic = academic; //학력

        this.employment = employment; //고용형태

        this.area = area; //지역

        this.period = period; // 기간

        this.board_time = board_time; // 게시글 시간

        this.salary = salary; //기타

        this.url = url;
    }


    public void setRes(Object res) {
        this.ID = ID;
    }
}



<if(true)>
    item <ID> += count
    ++count
</if>