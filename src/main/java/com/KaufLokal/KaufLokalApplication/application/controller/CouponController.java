package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;


    @GetMapping("/coupon")
    public ResponseEntity<List<CouponDto>> getAllCoupons() {
        return new ResponseEntity<>(couponService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/coupon/{id}")
    public ResponseEntity<CouponDto> getCouponById(@PathVariable UUID id)  {
        return new ResponseEntity<>(couponService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/coupon")
    public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto couponDto) {
        return new ResponseEntity<>(couponService.create(couponDto), HttpStatus.CREATED);
    }

    @PutMapping("/coupon")
    public ResponseEntity<CouponDto> updateCoupon(@RequestBody CouponDto couponDto) {
        return new ResponseEntity<>(couponService.update(couponDto), HttpStatus.OK);
    }

    @DeleteMapping("/coupon/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable UUID id) {
        couponService.delete(id);
        return ResponseEntity.ok().build();
    }
}
