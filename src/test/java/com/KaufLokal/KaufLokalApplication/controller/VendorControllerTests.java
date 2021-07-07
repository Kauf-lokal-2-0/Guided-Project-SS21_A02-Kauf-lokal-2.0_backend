package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.CouponController;
import com.KaufLokal.KaufLokalApplication.application.controller.VendorController;
import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VendorDto;
import com.KaufLokal.KaufLokalApplication.application.service.CouponService;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendorControllerTests {

    @Autowired
    private VendorController vendorController;

    @Autowired
    private CouponController couponController;

    @Autowired
    CouponService couponService;

    @Test
    void testController() {

        VendorDto vendorDto = new VendorDto();
        vendorDto.setName("Name of Vendor");

        ResponseEntity<VendorDto> createdVendorDto = vendorController.createVendor(vendorDto);
        assertThat(createdVendorDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        VendorDto updateVendor = createdVendorDto.getBody();
        updateVendor.setName("New name of Vendor");
        ResponseEntity<VendorDto> updatedVendor = vendorController.updateVendor(updateVendor);

        assertThat(updatedVendor.getBody().getName()).isEqualTo(updateVendor.getName());

        //Create Coupon
        CouponDto couponDto = new CouponDto();
        couponDto.setName("Name of Coupon");
        couponDto.setDescription("Company of Vendor");
        couponDto.setCouponCode(123456);
        ResponseEntity<CouponDto> createdCouponDto = couponController.createCoupon(couponDto);
        assertThat(createdCouponDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Set<Coupon> couponSet = new HashSet<>();
        couponSet.add(couponService.mapDtoToObject(createdCouponDto.getBody()));

        updatedVendor.getBody().setCoupons(couponSet);
        ResponseEntity<VendorDto> vendorDtoWithCoupon = vendorController.updateVendor(updatedVendor.getBody());
        for (Coupon coupon: vendorDtoWithCoupon.getBody().getCoupons() ) {
            assertThat(coupon.getCouponCode()).isEqualTo(couponDto.getCouponCode());
        }



        vendorController.deleteVendor(updatedVendor.getBody().getId());




    }
}
