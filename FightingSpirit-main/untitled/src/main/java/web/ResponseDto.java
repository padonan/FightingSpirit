package web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ResponseDto {

    private final int ID; //식별 id
    private final String homepage; //사이트 종류
    private final String company; //회사
    private final String title; // 게시글 제목
    private final int career; // 경력
    private final String academic; //학력
    private final String employment; //고용형태
    private final String area; //지역
    private final String period; // 기간
    private final LocalDateTime  board_time; // 게시글 시간
    private final String etc; //기타
    private final String url;

}
