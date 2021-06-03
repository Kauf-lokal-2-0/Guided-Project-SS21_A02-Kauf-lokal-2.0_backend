package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.KaufLokal.KaufLokalApplication.application.service.*;
import java.util.List;

@RestController
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @GetMapping("/merchant")
    public ResponseEntity<List<MerchantDto>> getAllMerchant() {

        return new ResponseEntity<>(merchantService.getAllMerchant(), HttpStatus.OK);
    }

    @PostMapping("/merchant")
    public ResponseEntity<MerchantDto> addMerchant(@RequestBody MerchantDto merchantDto) {
        return new ResponseEntity<>(merchantService.createMerchant(merchantDto), HttpStatus.CREATED);
    }


}
