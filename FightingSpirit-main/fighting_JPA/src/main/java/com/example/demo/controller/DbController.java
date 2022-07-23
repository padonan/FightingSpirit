package com.example.demo.controller;

import com.example.demo.entity.SearchForm;
import com.example.demo.entity.DbEntity;
import com.example.demo.entity.ResponseDTO;
import com.example.demo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/app/")
public class DbController {

    @Autowired
    DbService dbService;

    @RequestMapping(value = "findSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findSearch(SearchForm form) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.ResponseDTO(dbService.findSearch());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

