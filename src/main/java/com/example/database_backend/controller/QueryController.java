package com.example.database_backend.controller;

import com.example.database_backend.repository.NhanVienChinhThucRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/query")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QueryController {

    public NhanVienChinhThucRepository nhanVienChinhThucRepository ;

    @GetMapping("/manhcuong1")
    public ResponseEntity<?> tim_maxluong_withinPhongban_inMonth (@RequestParam Integer t , @RequestParam Integer n , @RequestParam BigDecimal d){
        return  new ResponseEntity<>(nhanVienChinhThucRepository.tim_maxluong_withinPhongban_inMonth(t,n,d) , HttpStatus.OK) ;
    }

}
