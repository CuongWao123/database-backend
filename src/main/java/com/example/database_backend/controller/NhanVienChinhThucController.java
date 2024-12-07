package com.example.database_backend.controller;

import com.example.database_backend.entity.NhanVien;
import com.example.database_backend.repository.NhanVienChinhThucRepository;
import com.example.database_backend.repository.NhanVienRepository;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/NVCT")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class NhanVienChinhThucController {

    private NhanVienChinhThucRepository nhanVienChinhThucRepository;
    private NhanVienRepository nhanVienRepository ;
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

    @GetMapping("getallnhanvien")
    public ResponseEntity<?> getallnhanvien (){
        return new ResponseEntity<>(nhanVienRepository.findAll(), HttpStatus.OK );
    }


    @PostMapping("/them")
    public String themNhanVienChinhThuc(
            @RequestParam("msnv") String msnv,
            @RequestParam("hovaten") String hovaten,
            @RequestParam("ngaysinh") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngaysinh,
            @RequestParam("gioitinh") String gioitinh,
            @RequestParam("cccd") String cccd,
            @RequestParam("masophongban") String mspb,
            @RequestParam("bhxh") String bhxh,
            @RequestParam(value = "nguoiquanly", required = false) String nvquanly,
            @RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
            @RequestParam("chucvu") String chucvu,
            @RequestParam("lcb") BigDecimal lcb,
            @RequestParam("sogiotoithieu") Integer sogiotoithieu
    ) throws SQLException {

        Date sqlNgaysinh = Date.valueOf(ngaysinh);
        Date sqlStartDate = Date.valueOf(startdate);
        try {
            nhanVienChinhThucRepository.them_nhanvien_chinhthuc(
                    msnv, hovaten, sqlNgaysinh, gioitinh, cccd, mspb,
                    bhxh, nvquanly, sqlStartDate, chucvu, lcb, sogiotoithieu
            );
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Them thanh cong" ;
    }


    @DeleteMapping("/xoa")
    public String delete_nvchinhthuc (@RequestParam("msnv") String msnv){
        try {
            nhanVienChinhThucRepository.delete_nhanvien_chinhthuc(msnv);
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Xoa thanh cong" ;
    }

    @PutMapping("/suaten")
    public String suaten_nvchinhthuc (@RequestParam("msnv") String msnv , @RequestParam("hoten") String hoten){
        try {
            nhanVienChinhThucRepository.sua_ten_nhanvien(msnv, hoten);
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Sua thanh cong" ;
    }

}
