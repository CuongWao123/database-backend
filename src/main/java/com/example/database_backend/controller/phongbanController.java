package com.example.database_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.database_backend.repository.PhongBanRepository;

@RequestMapping
@RestController
@AllArgsConstructor
public class phongbanController {

    private PhongBanRepository phongBanRepository ;

    @GetMapping
    private ResponseEntity<?> getAllPhongBan (){
        return new ResponseEntity<>(phongBanRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/them-phong-ban")
    private ResponseEntity<?> themphongban (
            @RequestParam("mspb")String  mspb ,
            @RequestParam("mota") String mota ,
            @RequestParam("tenphongban") String tenpb ,
            @RequestParam("quanly") String quanly
    ) {
            phongBanRepository.add_phongban(mspb,mota,tenpb,quanly);
            return new ResponseEntity<>("OK" ,HttpStatus.OK);
    }
}
