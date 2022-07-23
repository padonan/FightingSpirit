package com.example.demo.repository;

import com.example.demo.entity.DbEntity;
import com.example.demo.entity.ResponseDTO;
import com.example.demo.entity.SearchForm;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DbRepository {
    @PersistenceContext
    private EntityManager em;
    public List<DbEntity> findSearch(SearchForm searchform){
        String jpql = "select * from DbEntity r"; //기본 키워드 검색
        if (searchform.getKeyword() != null){
            jpql += " where r.title like %:Keyword%";}

        if (searchform.getAreaList() != null){
            jpql += " and r.area in :areaList";} // 키워드 검색 후 지역 선택시

        if (searchform.getCareerList() != null){
            jpql += " and r.Career in :careerList";// 경력 선택시
        }
        if (searchform.getAcademicList() != null){// 학력 선택시
            jpql += " and r.Academic in :academicList";
        }
    //파라미터 바인딩 동적으로 처리
        TypedQuery<DbEntity> query = em.createQuery(jpql, DbEntity.class)
                .setMaxResults(1000);//최대 1000건
        if (searchform.getKeyword() != null){
            query = query.setParameter("Keyword", searchform.getKeyword());
        }
        if (searchform.getAreaList() != null){
          query = query.setParameter("areaList", searchform.getAreaList());
        }
        if (searchform.getCareerList() != null){
            query = query.setParameter("careerList", searchform.getCareerList());
        }
        if (searchform.getAcademicList() != null){
            query = query.setParameter("academicList", searchform.getAcademicList());
        }
        return query.getResultList();
    }
}
