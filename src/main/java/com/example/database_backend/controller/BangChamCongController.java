package com.example.database_backend.controller;

import com.example.database_backend.repository.BangChamCongRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bangchamcong")
@RestController
@AllArgsConstructor
public class BangChamCongController {
    private BangChamCongRepository bangChamCongRepository ;

    @GetMapping("/getAll")
    private ResponseEntity<?> getAllBCC(){
        return new ResponseEntity<>(bangChamCongRepository.findAll(), HttpStatus.OK);
    }

}
