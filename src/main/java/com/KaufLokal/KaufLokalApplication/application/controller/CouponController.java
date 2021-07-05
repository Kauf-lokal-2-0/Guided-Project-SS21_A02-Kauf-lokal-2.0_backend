package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Coupon Controller")
public class CouponController {

    private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    private CouponService couponService;

    @ApiOperation(value = "Get all coupons")
    @GetMapping("/coupon")
    public ResponseEntity<List<CouponDto>> getAllCoupons() {
        logger.debug("GET: getAllCoupons");
        return new ResponseEntity<>(couponService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get coupon by his ID")
    @GetMapping("/coupon/{id}")
    public ResponseEntity<CouponDto> getCouponById(@PathVariable UUID id)  {
        logger.debug("GET: getCouponById");
        return new ResponseEntity<>(couponService.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto couponDto) {
        logger.debug("POST: createCoupon");
        return new ResponseEntity<>(couponService.create(couponDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an coupon")
    @PutMapping("/coupon")
    public ResponseEntity<CouponDto> updateCoupon(@RequestBody CouponDto couponDto) {
        logger.debug("PUT: updateCoupon");
        return new ResponseEntity<>(couponService.update(couponDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an coupon")
    @DeleteMapping("/coupon/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable UUID id) {
        logger.debug("DELTE: deleteCoupon");
        couponService.delete(id);
        return ResponseEntity.ok().build();
    }
}
