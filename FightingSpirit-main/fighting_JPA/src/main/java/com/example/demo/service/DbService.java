package com.example.demo.service;

import com.example.demo.entity.DbEntity;
import com.example.demo.entity.ResponseDTO;
import com.example.demo.entity.SearchForm;
import com.example.demo.repository.DbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbService {

    @Autowired
    DbRepository dbRepository;
    SearchForm searchForm;

   /* public List<DbEntity> findSearch() {
        List<DbEntity> aa= dbRepository.findSearch(searchForm);
        for(DbEntity obj : aa) {
            obj.getTitle();
            obj.getAcademic();
            obj.getCareer();
            obj.getArea();
            obj.getUrl();
        }
        return aa;
    }}*/






        List<DbEntity> boardEntities = dbRepository.findSearch(searchForm);
        List<ResponseDTO> boardDtoList = new ArrayList<>();

        if(boardEntities.isEmpty()) return boardDtoList;

        for(DbEntity DbEntity : boardEntities) {
            boardDtoList.add(this.convertEntityToDto(DbEntiry));
        }
    return boardDtoList;
}


private ResponseDTO convertEntityToDto(DbEntiry dbEntiry){
        return ResponseDTO.builder()
                .ID(DbEntity.getID()) //식별 id
                .homepage(DbEntity.getHomepage()) //사이트 종류
                .company(DbEntity.getCompany()) //회사
                .title(DbEntity.getTitle()) // 게시글 제목
                .career(DbEntity.getCareer()) // 경력
                .academic(DbEntity.getAcademic()) //학력
                .employment(DbEntity.getEmployment()) //고용형태
                .area(DbEntity.getArea()) //지역
                .period(DbEntity.getPeriod()) // 기간
                .salary(DbEntity.getSalary()) // 게시글 시간
                .etc(DbEntity.getEtc()) //기타
                .url(DbEntity.getUrl())
                .build();

}


