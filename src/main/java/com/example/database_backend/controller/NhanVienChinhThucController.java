package com.example.database_backend.controller;

import com.example.database_backend.entity.NhanVien;
import com.example.database_backend.repository.*;
import com.example.database_backend.response.DiaChiResponse;
import com.example.database_backend.response.SumLamThemResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/NVCT")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class NhanVienChinhThucController {

    private NhanVienChinhThucRepository nhanVienChinhThucRepository;
    private NhanVienRepository nhanVienRepository ;
    private DiaChiRepository diaChiRepository;
    private SDTRepository sdtRepository;
    private EmailRepository emailRepository;
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
    @PostMapping ("/themdiachi")
    public String insertdiachi (@RequestParam ("p_msnv") String msnv ,
                                @RequestParam("p_sonha") String sonha ,
                                @RequestParam("p_tenduong") String duong ,
                                @RequestParam("p_phuong") String phuong ,
                                @RequestParam("p_tinhthanhpho") String tinh ){
        try {
            diaChiRepository.insert_into_diachi(msnv, sonha, duong, phuong, tinh);
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Them thanh cong" ;
    }
    @PutMapping ("/doidiachi")
    public String updatediachi (@RequestParam("p_msnv") String msnv ,
                                @RequestParam("p_old_sonha") String sonhacu ,
                                @RequestParam("p_old_tenduong") String duongcu ,
                                @RequestParam("p_old_phuong") String phuongcu ,
                                @RequestParam("p_old_tinhthanhpho") String tinhcu,
                                @RequestParam("p_new_sonha") String sonhamoi ,
                                @RequestParam("p_new_tenduong") String duongmoi ,
                                @RequestParam("p_new_phuong") String phuongmoi ,
                                @RequestParam("p_new_tinhthanhpho") String tinhmoi ){
        try {
            diaChiRepository.update_diachi(msnv, sonhacu, duongcu, phuongcu, tinhcu,
                    sonhamoi, duongmoi, phuongmoi, tinhmoi);
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Cap nhat thanh cong" ;
    }
    @DeleteMapping ("/xoadiachi")
    public String deletediachi (@RequestParam ("p_msnv") String msnv ,
                                @RequestParam("p_sonha") String sonha ,
                                @RequestParam("p_tenduong") String duong ,
                                @RequestParam("p_phuong") String phuong ,
                                @RequestParam("p_tinhthanhpho") String tinh ){
        try {
            diaChiRepository.delete_diachi(msnv, sonha, duong, phuong, tinh);
        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Xoa thanh cong" ;
    }
    @PostMapping ("/themsdt")
    public String insertsdt (@RequestParam ("p_msnv") String msnv ,
                                @RequestParam("p_sdt") String sdt ){
        try {sdtRepository.insert_into_sdt(msnv, sdt);

        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Them thanh cong" ;
    }
    @PutMapping ("/suasdt")
    public String updatesdt (@RequestParam ("p_msnv") String msnv ,
                             @RequestParam("p_old_sdt") String sdtcu,
                             @RequestParam("p_new_sdt") String sdtmoi){
        try {sdtRepository.update_sdt(msnv, sdtcu,sdtmoi);

        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Cap nhat thanh cong" ;
    }
    @DeleteMapping ("/xoasdt")
    public String deletesdt (@RequestParam ("p_msnv") String msnv ,
                             @RequestParam("p_sdt") String sdt ){
        try {sdtRepository.delete_sdt(msnv, sdt);

        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Xoa thanh cong" ;
    }
    @PostMapping ("/thememail")
    public String insertemail (@RequestParam ("p_msnv") String msnv ,
                               @RequestParam("p_email") String mail ){
        try {emailRepository.insert_into_email(msnv,mail);

        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Them thanh cong" ;
    }
    @PutMapping ("/suaemail")
    public String updateemail (@RequestParam ("p_msnv") String msnv ,
                               @RequestParam("p_old_email") String mailcu,
                               @RequestParam("p_new_email") String mailmoi){
        try {emailRepository.update_email(msnv,mailcu,mailmoi);

        } catch (Exception e) {
            return  extractErrorMessage(e.getMessage());
        }
        return "Cap nhat thanh cong" ;
    }
    @DeleteMapping ("/xoaemail")
    public String deleteemail (@RequestParam ("p_msnv") String msnv ,
                               @RequestParam("p_email") String mail ){
        try {emailRepository.delete_email(msnv,mail);

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

    @GetMapping("/all/email")
    public List<String> getAllEmail(
            @RequestParam("msnv") String msnv
    ){
        List<Object[]> res = emailRepository.get_all_email(msnv);
        List<String> email = new ArrayList<>();
        for (Object[] objects: res) {
            email.add((String) objects[1]);
        }
        return email;
    }

    @GetMapping("/all/diachi")
    public List<?> getAllDiaChi(
            @RequestParam("msnv") String msnv
    ){
        List<Object[]> res = diaChiRepository.get_all_diachi(msnv);
        List<DiaChiResponse> diachi = new ArrayList<>();
        for (Object[] objects: res) {
            diachi.add(DiaChiResponse.builder()
                            .sonha((String) objects[1])
                            .tenduong((String) objects[2])
                            .phuong((String) objects[3])
                            .tinhthanhpho((String) objects[4])
                    .build());
        }
        return diachi;
    }

    @GetMapping("/all/sdt")
    public List<String> getAllSdt(
            @RequestParam("msnv") String msnv
    ){
        List<Object[]> res = sdtRepository.get_all_sdt(msnv);
        List<String> sdt = new ArrayList<>();
        for (Object[] objects: res) {
            sdt.add((String) objects[1]);
        }
        return sdt;
    }
}
