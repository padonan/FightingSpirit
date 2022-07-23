package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailResponse {

    private  Long ID; //식별 id

    private  String homepage; //사이트 종류

    private  String company; //회사

    private  String title; // 게시글 제목

    private  Long career; // 경력

    private  String academic; //학력

    private  String employment; //고용형태

    private  String area; //지역

    private  String period; // 기간

    private  Long  board_time; // 게시글 시간

    private  String etc; //기타

    private  String url;

}