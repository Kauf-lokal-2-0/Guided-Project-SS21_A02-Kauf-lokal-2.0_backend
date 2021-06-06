package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.KaufLokal.KaufLokalApplication.application.service.*;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Merchant Controller")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @ApiOperation(value = "Get all merchant")
    @GetMapping("/merchant")
    public ResponseEntity<List<MerchantDto>> getAllMerchant() {
        return new ResponseEntity<>(merchantService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get merchant by ID")
    @GetMapping("/merchant/{id}")
    public ResponseEntity<MerchantDto> getMerchantById(@PathVariable UUID id)  {
        return new ResponseEntity<>(merchantService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new merchant")
    @PostMapping("/merchant")
    public ResponseEntity<MerchantDto> createMerchant(@RequestBody MerchantDto merchantDto) {
        return new ResponseEntity<>(merchantService.create(merchantDto), HttpStatus.CREATED);
    }
    @ApiOperation(value = "Update an merchant")
    @PutMapping("/merchant")
    public ResponseEntity<MerchantDto> updateMerchant(@RequestBody MerchantDto merchantDto) {
        return new ResponseEntity<>(merchantService.update(merchantDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an merchant")
    @DeleteMapping("/merchant/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID id) {
        merchantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
