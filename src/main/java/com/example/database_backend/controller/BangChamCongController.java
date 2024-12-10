package com.example.database_backend.controller;

import com.example.database_backend.repository.BangChamCongRepository;
import com.example.database_backend.repository.BangLuongRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bangchamcong")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BangChamCongController {
    private BangChamCongRepository bangChamCongRepository ;
private BangLuongRepository bangLuongRepository;
    @GetMapping("/getAll")
    private ResponseEntity<?> getAllBCC(){
        return new ResponseEntity<>(bangChamCongRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/allluong")
    private ResponseEntity<?> getAllBL(){
        return new ResponseEntity<>(bangLuongRepository.findAll(), HttpStatus.OK);
    }

}
