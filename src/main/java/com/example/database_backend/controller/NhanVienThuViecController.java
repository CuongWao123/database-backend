package com.example.database_backend.controller;

import com.example.database_backend.repository.NhanVienThuVIecRepository;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@RequestMapping("/NVTV")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class NhanVienThuViecController {
    private NhanVienThuVIecRepository nhanVienThuVIecRepository;
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
    @PostMapping("/them")
    public ResponseEntity<?> taomoi (@RequestParam("msnv") String msnv,
                                     @RequestParam("hovaten") String hovaten,
                                     @RequestParam("ngaysinh") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngaysinh,
                                     @RequestParam("gioitinh") String gioitinh,
                                     @RequestParam("cccd") String cccd,
                                     @RequestParam("masophongban") String mspb,
                                     @RequestParam(value = "nguoiquanly1") String nvquanly,
                                     @RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
                                     @RequestParam("lcb") BigDecimal lcb,
                                     @RequestParam("sogiotoithieu") Integer sogiotoithieu)
        throws SQLException {
            Date sqlNgaysinh = Date.valueOf(ngaysinh);
            Date sqlStartDate = Date.valueOf(startdate);
            try {
                nhanVienThuVIecRepository.them_nhanvien_thuviec(msnv, hovaten, sqlNgaysinh, gioitinh, cccd, mspb, nvquanly, sqlStartDate, lcb, sogiotoithieu);
            } catch (Exception e) {
                return new ResponseEntity<>(extractErrorMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("them thanh cong",HttpStatus.OK);
        }
    @PostMapping("/chuyenviec")
    public ResponseEntity<?> chuyenviec (@RequestParam("nv") String msnv,
                                         @RequestParam("luong") BigDecimal lcb,
                                     @RequestParam("chuc") String chucvu,
                                         @RequestParam("pban") String phong,
                                     @RequestParam("loai") String loai,
                                     @RequestParam("toithieu") Integer sogiotoithieu,
                                     @RequestParam("sta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate han

                                     )
            throws SQLException {
        Date han1 = Date.valueOf(han);

        try {
            nhanVienThuVIecRepository.chuyenviec(msnv,lcb,chucvu,phong,loai,sogiotoithieu,han1);
        } catch (Exception e) {
            return new ResponseEntity<>(extractErrorMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("thao tac thanh cong",HttpStatus.OK);
    }
    @PostMapping("/lenchinhthuc")
    public ResponseEntity<?> hetthuviec (@RequestParam("nv") String msnv,
                                         @RequestParam("bhxh") String bhxh,
                                         @RequestParam("luong") BigDecimal lcb,
                                         @RequestParam("toithieu") Integer sogiotoithieu,
                                         @RequestParam("hanthuviec") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate han

    )
            throws SQLException {
        Date han1 = Date.valueOf(han);

        try {
            nhanVienThuVIecRepository.thuviec_thanh_chinhthuc(msnv,bhxh,lcb,sogiotoithieu,han1);
        } catch (Exception e) {
            return new ResponseEntity<>(extractErrorMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("thao tac thanh cong",HttpStatus.OK);
    }


}
