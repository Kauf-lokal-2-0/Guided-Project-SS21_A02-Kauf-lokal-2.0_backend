package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.CouponController;
import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
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
        couponDto.setDescription("Company of Merchant");
        couponDto.setCouponCode(123456);

        ResponseEntity<CouponDto> createdCouponDto = couponController.createCoupon(couponDto);
        assertThat(createdCouponDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        CouponDto updateMerchant = createdCouponDto.getBody();
        updateMerchant.setName("New Name of Coupon");
        ResponseEntity<CouponDto> updatedMerchant = couponController.updateCoupon(updateMerchant);

        assertThat(updatedMerchant.getBody().getName()).isEqualTo(updateMerchant.getName());

        couponController.deleteCoupon(updatedMerchant.getBody().getId());

    }


}
