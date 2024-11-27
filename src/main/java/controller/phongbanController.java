package controller;

import entity.PhongBan;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.PhongBanRepository;

@RequestMapping
@RestController
@AllArgsConstructor
public class phongbanController {

    private PhongBanRepository phongBanRepository ;

    @GetMapping
    private ResponseEntity<?> getAllPhongBan (){
        return new ResponseEntity<>("alo", HttpStatus.OK);
    }
}
