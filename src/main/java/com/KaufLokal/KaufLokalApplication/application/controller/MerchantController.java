package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.KaufLokal.KaufLokalApplication.application.service.*;
import java.util.List;
import java.util.UUID;

@RestController
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @GetMapping("/merchant")
    public ResponseEntity<List<MerchantDto>> getAllMerchant() {
        return new ResponseEntity<>(merchantService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/merchant/{id}")
    public ResponseEntity<MerchantDto> getMerchant(@PathVariable UUID id)  {
        return new ResponseEntity<>(merchantService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/merchant")
    public ResponseEntity<MerchantDto> createMerchant(@RequestBody MerchantDto merchantDto) {
        return new ResponseEntity<>(merchantService.create(merchantDto), HttpStatus.CREATED);
    }

    @PutMapping("/merchant")
    public ResponseEntity<MerchantDto> updateMerchant(@RequestBody MerchantDto merchantDto) {
        return new ResponseEntity<>(merchantService.update(merchantDto), HttpStatus.OK);
    }

    @DeleteMapping("/merchant/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID id) {
        merchantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
