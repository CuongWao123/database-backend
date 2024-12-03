package com.example.database_backend.controller;

import com.example.database_backend.repository.PhongBanRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/phongban")
@RestController
@AllArgsConstructor
public class PhongBanController {

    private PhongBanRepository phongBanRepository;




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

    @GetMapping("/timphongban")
    public ResponseEntity<?> findPhongban( @RequestParam String mspb){
        return new ResponseEntity<>(phongBanRepository.findById(mspb) , HttpStatus.OK);
    }

    @GetMapping("/getAllPhongban")
    private ResponseEntity<?> getAllphongban (){
        return new ResponseEntity<>(phongBanRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/themphongban")
    private String themphongban (@RequestParam String mspb,
                                 @RequestParam String mota ,
                                 @RequestParam String ten ,
                                 @RequestParam String nvquanly)
    {
        try {
            phongBanRepository.add_phongban(
                  mspb , mota , ten , nvquanly
            );
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Them thanh cong" ;
    }

    @PutMapping("/suaphongban")
    private String suaphongban (
            @RequestParam String mspb ,
            @RequestParam String ten
    ){
        try {
            phongBanRepository.sua_phongban(
                    mspb  , ten
            );
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Sua thanh cong" ;
    }

    @DeleteMapping("/xoaphongban")
    private String xoaphongban (@RequestParam String mspb){
        try {
            phongBanRepository.xoa_phongban(mspb);
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Xoa thanh cong" ;
    }





}
