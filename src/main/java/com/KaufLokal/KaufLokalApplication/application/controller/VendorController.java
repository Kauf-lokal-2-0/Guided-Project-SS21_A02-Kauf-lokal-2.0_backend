package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.KaufLokal.KaufLokalApplication.application.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Merchant Controller")
public class VendorController {

    private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    VendorService vendorService;

    @Autowired
    RatingService ratingService;

    @Autowired
    MessageService messageService;

    @Autowired
    CouponService couponService;

    @ApiOperation(value = "Get all vendor")
    @GetMapping("/vendor")
    public ResponseEntity<List<VendorDto>> getAllMerchant() {
        logger.debug("GET: getAllMerchant");
        return new ResponseEntity<>(vendorService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get vendor by ID")
    @GetMapping("/vendor/{id}")
    public ResponseEntity<VendorDto> getMerchantById(@PathVariable UUID id)  {
        logger.debug("GET: getMerchantById");
        return new ResponseEntity<>(vendorService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new vendor")
    @PostMapping("/vendor")
    public ResponseEntity<VendorDto> createMerchant(@RequestBody VendorDto vendorDto) {
        logger.debug("POST: createMerchant");
        return new ResponseEntity<>(vendorService.create(vendorDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an vendor")
    @PutMapping("/vendor")
    public ResponseEntity<VendorDto> updateMerchant(@RequestBody VendorDto vendorDto) {
        logger.debug("PUT: updateMerchant");
        return new ResponseEntity<>(vendorService.update(vendorDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an vendor")
    @DeleteMapping("/vendor/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID id) {
        logger.debug("DELETE: deleteMerchant");
        vendorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Get all vendor")
    @GetMapping("/vendor/{id}/rating")
    public ResponseEntity<List<RatingDto>> getAllRatingsByMerchantId(@PathVariable UUID id)
    {
        VendorDto vendor = vendorService.findById(id);
        return new ResponseEntity<>(ratingService.mapToDto(new ArrayList<>(vendor.getRatings())), HttpStatus.OK);
    }

    @ApiOperation(value = "Add coupon to vendor")
    @PostMapping("/vendor/{id}/coupon")
    public ResponseEntity<VendorDto> addCoupon(@PathVariable UUID id, @RequestBody CouponDto couponDto)
    {
        VendorDto vendorDto = vendorService.addCoupon(id,couponService.create(couponDto));
        return new ResponseEntity<>(vendorDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Add message to vendor")
    @PostMapping("/vendor/{id}/message")
    public ResponseEntity<VendorDto> addMessage(@PathVariable UUID id, @RequestBody MessageDto messageDto)
    {
        VendorDto vendorDto = vendorService.addMessage(id,messageService.create(messageDto));
        return new ResponseEntity<>(vendorDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all messages")
    @GetMapping("/vendor/{id}/message")
    public ResponseEntity<List<MessageDto>> getAllMessagesByMerchantId(@PathVariable UUID id)
    {
        VendorDto vendor = vendorService.findById(id);
        return new ResponseEntity<>(messageService.mapToDto(new ArrayList<>(vendor.getMessages())), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all vendor categories")
    @GetMapping("/vendor/categories")
    public ResponseEntity<List<VendorCategoryDto>> getAllCategories() {
        logger.debug("GET: getAllMerchantCategories");
        return new ResponseEntity<>(vendorService.getCategories(), HttpStatus.OK);
    }
}
