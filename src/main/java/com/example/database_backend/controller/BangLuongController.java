package com.example.database_backend.controller;

import com.example.database_backend.entity.BangChamCong;
import com.example.database_backend.entity.BangLuong;
import com.example.database_backend.entity.NhanVien;
import com.example.database_backend.repository.BangChamCongRepository;
import com.example.database_backend.repository.BangLuongRepository;
import com.example.database_backend.repository.NhanVienRepository;
import com.example.database_backend.response.BangChamCongResponse;
import com.example.database_backend.response.BangLuongResponse;
import com.example.database_backend.utils.SecondToHour;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class BangLuongController {

    private final BangLuongRepository bangLuongRepository;

    private final BangChamCongRepository bangChamCongRepository;

    private final NhanVienRepository nhanVienRepository;

    @GetMapping("/bangluong/nhanvien/all")
    public ResponseEntity<?> getAllBangLuongByMsnv(
            @RequestParam String msnv
    ){
        NhanVien nhanVien = nhanVienRepository.findById(msnv).orElseThrow(
                () -> new RuntimeException("Khong tim thay Nhan vien")
        );
        List<BangLuong> bangLuongList = bangLuongRepository.findAllByBangLuongKey_Msnv(msnv);
        List<BangLuongResponse> responses = new ArrayList<>();

        for (BangLuong bl: bangLuongList){
            BangLuongResponse temp = BangLuongResponse.builder()
                    .msnv(msnv)
                    .hoten(nhanVien.getHoten())
                    .mspb(nhanVien.getMspb())
                    .thang(bl.getBangLuongKey().getThang())
                    .nam(bl.getBangLuongKey().getNam())
                    .luongcoban(bl.getLuongcoban())
                    .luonglamthem(bl.getLuonglamthem())
                    .bhyt(bl.getBhyt())
                    .bhxh(bl.getBhxh())
                    .antrua(bl.getAntrua())
                    .thue(bl.getThue())
                    .hotrokhac(bl.getHotrokhac())
                    .khautru(bl.getKhautru())
                    .xangxe(bl.getXangxe())
                    .luongthucte(bl.getLuongthucte())
                    .build();
            responses.add(temp);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/bangchamcong/nhanvien/all")
    public ResponseEntity<?> getAllBangChamCongByMsnv(
            @RequestParam String msnv
    ){
        NhanVien nhanVien = nhanVienRepository.findById(msnv).orElseThrow(
                () -> new RuntimeException("Khong tim thay Nhan vien")
        );
        List<BangChamCong> bangChamCongList = bangChamCongRepository.findAllByBangChamCongKey_Msnv(msnv);
        List<BangChamCongResponse> responses = new ArrayList<>();

        for (BangChamCong bcc: bangChamCongList){
            BangChamCongResponse temp = BangChamCongResponse.builder()
                    .msnv(msnv)
                    .hoten(nhanVien.getHoten())
                    .mspb(nhanVien.getMspb())
                    .thang(bcc.getBangChamCongKey().getThang())
                    .nam(bcc.getBangChamCongKey().getNam())
                    .sogioHienTai(SecondToHour.convertSecondsToTime(bcc.getSogioHienTai()))
                    .sogioToiThieu(SecondToHour.convertSecondsToTime(bcc.getSogioToiThieu()))
                    .sogioLamThem(SecondToHour.convertSecondsToTime(bcc.getSogioLamThem()))
                    .build();
            responses.add(temp);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
