package controller;

import java.util.List;
import java.util.stream.Collectors;

import dto.DetailRequest;
import dto.DetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import domain.DetailRepository;
import domain.detail;
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final DetailRepository DetailRepository;

    public List<DetailResponse> getDetailList() {

        return DetailRepository.findAll().stream()
                .map(detail::toResponse)
                .collect(Collectors.toList());
    }

    /*public static List<DetailResponse> getDetailList() {
    }
    public DetailResponse getCompanyDetail(Long homepage) {

        detail companyDetail = DetailRepository.findById(homepage)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return companyDetail.toResponse();
    }*/

    }