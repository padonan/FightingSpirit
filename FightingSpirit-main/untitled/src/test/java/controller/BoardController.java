package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import dto.DetailResponse;
import dto.DetailRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService BoardService;


    private final BoardService boardService;

    @GetMapping("/main")
    public List<DetailResponse> list() {
        return BoardService.getDetailList();
    }
}
