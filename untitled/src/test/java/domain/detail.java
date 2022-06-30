package domain;
import dto.DetailResponse;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CLDB")
public class detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long ID; //식별 id
    private  String homepage; //사이트 종류
    private  String company; //회사
    private  String title; // 게시글 제목
    private  Long career; // 경력
    private  String academic; //학력
    private  String employment; //고용형태
    private  String area; //지역
    private  String period; // 기간
    private  Long board_time; // 게시글 시간
    private  String etc; //기타
    private  String url;// 이익잉여금

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
                .etc(etc)
                .url(url)
                .build();
    }
}

