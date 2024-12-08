package com.example.database_backend.controller;

import com.example.database_backend.entity.CompositeKey.NgayLamViecKey;
import com.example.database_backend.entity.NgayLamViec;
import com.example.database_backend.repository.NgayLamViecRepository;
import com.example.database_backend.repository.NhanVienChinhThucRepository;
import com.example.database_backend.repository.NhanVienRepository;
import com.example.database_backend.repository.NhanVienThuVIecRepository;
import com.fasterxml.jackson.databind.annotation.NoClass;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/query")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QueryController {

    public NhanVienChinhThucRepository nhanVienChinhThucRepository ;
public NgayLamViecRepository ngayLamViecRepository;
public NhanVienRepository nhanVienRepository;
public NhanVienThuVIecRepository nhanVienThuVIecRepository;
    @GetMapping("/manhcuong1")
    public ResponseEntity<?> tim_maxluong_withinPhongban_inMonth (@RequestParam Integer t , @RequestParam Integer n , @RequestParam BigDecimal d){
        return  new ResponseEntity<>(nhanVienChinhThucRepository.tim_maxluong_withinPhongban_inMonth(t,n,d) , HttpStatus.OK) ;
    }
    @GetMapping("/viet1")
    public ResponseEntity<?> tim (){
        return  new ResponseEntity<>(ngayLamViecRepository.findAll() , HttpStatus.OK) ;
    }
    @GetMapping("/viet2")
    public ResponseEntity<?> listngay (@RequestParam("dau") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngaydau,
                                       @RequestParam("cuoi") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngaycuoi,
                                       @RequestParam("nv") String msnv){
        Date jdau = Date.valueOf(ngaydau);
        Date jcuoi = Date.valueOf(ngaycuoi);
        List <Object[]> listngay=ngayLamViecRepository.listngay(jdau,jcuoi,msnv);
        List<NgayLamViec> temp=new ArrayList<>();
        for(Object[] a:listngay) {
            String aa=a[2].toString().substring(0,4);
            NgayLamViecKey tempkey=new NgayLamViecKey((String)a[0],(Integer) a[3],(Integer)a[1],Integer.parseInt(aa));
            NgayLamViec tmp= new NgayLamViec(tempkey,nhanVienRepository.findById(msnv).get(),(String) a[4],(Timestamp) a[5],(Timestamp) a[6]);
        temp.add(tmp);}
        return  new ResponseEntity<>(temp , HttpStatus.OK) ;
    }
    @GetMapping("/thuviec")
    public ResponseEntity<?> allthuviec(){
        return  new ResponseEntity<>(nhanVienThuVIecRepository.findAll() , HttpStatus.OK) ;
    }

}
