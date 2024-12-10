package com.example.database_backend.utils;

import com.example.database_backend.entity.BangChamCong;
import com.example.database_backend.entity.CompositeKey.BangChamCongKey;
import com.example.database_backend.entity.NhanVien;
import com.example.database_backend.repository.NhanVienRepository;
import com.example.database_backend.response.BangChamCongResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BCCHour {

    private final NhanVienRepository nhanVienRepository;
    public BangChamCongResponse fromBBC(BangChamCong bcc){
        NhanVien nhanVien = nhanVienRepository.findById(bcc.getBangChamCongKey().getMsnv())
                .orElseThrow();
        return BangChamCongResponse.builder()
                .msnv(nhanVien.getMsnv())
                .hoten(nhanVien.getHoten())
                .mspb(nhanVien.getMspb())
                .thang(bcc.getBangChamCongKey().getThang())
                .nam(bcc.getBangChamCongKey().getNam())
                .sogioHienTai(SecondToHour.convertSecondsToTime(bcc.getSogioHienTai()))
                .sogioToiThieu(SecondToHour.convertSecondsToTime(bcc.getSogioToiThieu()))
                .sogioLamThem(SecondToHour.convertSecondsToTime(bcc.getSogioLamThem()))
                .build();
    }

    public List<BangChamCongResponse> fromList(List<BangChamCong> bangChamCongList){
        List<BangChamCongResponse> responses = new ArrayList<>();
        for (BangChamCong bcc: bangChamCongList){
            responses.add(fromBBC(bcc));
        }
        return responses;
    }
}
