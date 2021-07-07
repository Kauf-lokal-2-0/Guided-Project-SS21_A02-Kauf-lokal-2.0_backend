package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.CouponController;
import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CouponControllerTests {

    @Autowired
    CouponController couponController;

    @Test
    void testController() {
        CouponDto couponDto = new CouponDto();
        couponDto.setName("Name of Coupon");
        couponDto.setDescription("Company of Vendor");
        couponDto.setCouponCode(123456);

        ResponseEntity<CouponDto> createdCouponDto = couponController.createCoupon(couponDto);
        assertThat(createdCouponDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        CouponDto updateVendor = createdCouponDto.getBody();
        updateVendor.setName("New Name of Coupon");
        ResponseEntity<CouponDto> updatedVendor = couponController.updateCoupon(updateVendor);

        assertThat(updatedVendor.getBody().getName()).isEqualTo(updateVendor.getName());

        couponController.deleteCoupon(updatedVendor.getBody().getId());

    }


}
