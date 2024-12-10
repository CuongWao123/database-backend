package com.example.database_backend.controller;

import com.example.database_backend.entity.BangChamCong;
import com.example.database_backend.repository.BangChamCongRepository;
import com.example.database_backend.repository.BangLuongRepository;
import com.example.database_backend.utils.BCCHour;
import com.example.database_backend.utils.SecondToHour;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/bangchamcong-bangluong")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BangChamCongController {
    private BangChamCongRepository bangChamCongRepository ;
    private BangLuongRepository bangLuongRepository;
    private final BCCHour bccHour;

    @GetMapping("/getAll")
    private ResponseEntity<?> getAllBCC(){
//        return new ResponseEntity<>(bangChamCongRepository.findAll(Sort.by(
//                Sort.Order.asc("BangChamCongKey.nam"),
//                Sort.Order.asc("BangChamCongKey.thang"),
//
//                Sort.Order.asc("BangChamCongKey.msnv"))), HttpStatus.OK);
        List<BangChamCong> bangChamCongList = bangChamCongRepository.findAll(Sort.by(
                Sort.Order.asc("BangChamCongKey.nam"),
                Sort.Order.asc("BangChamCongKey.thang"),
                Sort.Order.asc("BangChamCongKey.msnv")));
        return ResponseEntity.ok(bccHour.fromList(bangChamCongList));
    }
    @GetMapping("/allluong")
    private ResponseEntity<?> getAllBL(){
        Sort sort =Sort.by(
                Sort.Order.asc("BangLuongKey.nam"),
                Sort.Order.asc("BangLuongKey.thang"),

                Sort.Order.asc("BangLuongKey.msnv"));
        return new ResponseEntity<>(bangLuongRepository.findAll(sort), HttpStatus.OK);
    }
    @GetMapping("/bl")
    private ResponseEntity<?> getBL(@RequestParam("msnv")String msnv,
                                        @RequestParam("thang")Integer thang,
                                        @RequestParam("nam")Integer nam){
        return new ResponseEntity<>(bangLuongRepository.findBangLuongByBangLuongKey_MsnvAndBangLuongKey_ThangAndBangLuongKey_Nam(msnv, thang, nam),
                 HttpStatus.OK);
    }
    @GetMapping("/bcc")
    private ResponseEntity<?> getBCC(@RequestParam("msnv")String msnv,
                                        @RequestParam("thang")Integer thang,
                                        @RequestParam("nam")Integer nam){
//        return new ResponseEntity<>(
//                bangChamCongRepository.findBangChamCongByBangChamCongKey_MsnvAndBangChamCongKey_ThangAndBangChamCongKey_Nam(msnv, thang, nam), HttpStatus.OK);
        return ResponseEntity.ok(
                bccHour.fromBBC(bangChamCongRepository
                        .findBangChamCongByBangChamCongKey_MsnvAndBangChamCongKey_ThangAndBangChamCongKey_Nam(msnv, thang, nam)
                )
        );

    }
    @GetMapping("/listbcc")
    private ResponseEntity<?> getlistBCC(
                                     @RequestParam("thang")Integer thang,
                                     @RequestParam("nam")Integer nam){
//        return new ResponseEntity<>(
//                bangChamCongRepository.findBangChamCongByBangChamCongKey_ThangAndBangChamCongKey_Nam( thang, nam), HttpStatus.OK);
        return ResponseEntity.ok(
                bccHour.fromList(bangChamCongRepository
                        .findBangChamCongByBangChamCongKey_ThangAndBangChamCongKey_Nam( thang, nam)
                )
        );
    }
    @GetMapping("/listbl")
    private ResponseEntity<?> getlistBL(
            @RequestParam("thang")Integer thang,
            @RequestParam("nam")Integer nam){
        return new ResponseEntity<>(
                bangLuongRepository.findBangLuongsByBangLuongKey_ThangAndBangLuongKey_Nam( thang, nam), HttpStatus.OK);
    }



}
