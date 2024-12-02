package com.example.database_backend.controller;


import com.example.database_backend.entity.DuAn;
import com.example.database_backend.repository.DuAnRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;


@RequestMapping("/duan")
@RestController
@AllArgsConstructor
public class DuAnController {
    private DuAnRepository duAnRepository;
    public static String extractErrorMessage(String exceptionMessage) {
        try {
            int start = exceptionMessage.indexOf("[", exceptionMessage.indexOf("[") + 1);
            int end = exceptionMessage.indexOf("]", start);
            if (start != -1 && end != -1) {
                return exceptionMessage.substring(start + 1, end); // Lấy nội dung giữa dấu []
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown Error";
    }

    @GetMapping("/getAllDuan")
    public ResponseEntity<?> getAllDuan (){
        return new ResponseEntity<>(duAnRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/themduan")
    public String themduan (
            @RequestParam String mada ,
            @RequestParam BigDecimal vondautu ,
            @RequestParam Date startdate ,
            @RequestParam String tenduan ,
            @RequestParam String mota ,
            @RequestParam String maphongbanquanly
            )
    {
        try {
            duAnRepository.them_duan(
                mada,vondautu ,startdate , tenduan , mota , maphongbanquanly
            );
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Them thanh cong" ;
    }

    @PutMapping("/suatenduan")
    public String sua_ten_duan (@RequestParam String mada , @RequestParam String tenduan){
        try {
            duAnRepository.sua_duan(
                    mada, tenduan
            );
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Sua thanh cong" ;
    }

    @DeleteMapping("/xoaduan")
    public String xoa_duan (@RequestParam String mada){
        try {
            duAnRepository.xoa_duan(
                    mada
            );
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Xoa thanh cong" ;
    }


}
