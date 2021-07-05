package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.CouponController;
import com.KaufLokal.KaufLokalApplication.application.controller.MerchantController;
import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import com.KaufLokal.KaufLokalApplication.application.service.CouponService;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MerchantControllerTests {

    @Autowired
    private MerchantController merchantController;

    @Autowired
    private CouponController couponController;

    @Autowired
    CouponService couponService;

    @Test
    void testController() {

        MerchantDto merchantDto = new MerchantDto();
        merchantDto.setName("Name of Merchant");
        merchantDto.setCompany("Company of Merchant");

        ResponseEntity<MerchantDto> createdMerchantDto = merchantController.createMerchant(merchantDto);
        assertThat(createdMerchantDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        MerchantDto updateMerchant = createdMerchantDto.getBody();
        updateMerchant.setCompany("New Company of merchant");
        ResponseEntity<MerchantDto> updatedMerchant = merchantController.updateMerchant(updateMerchant);

        assertThat(updatedMerchant.getBody().getCompany()).isEqualTo(updateMerchant.getCompany());

        //Create Coupon
        CouponDto couponDto = new CouponDto();
        couponDto.setName("Name of Coupon");
        couponDto.setDescription("Company of Merchant");
        couponDto.setCouponCode(123456);
        ResponseEntity<CouponDto> createdCouponDto = couponController.createCoupon(couponDto);
        assertThat(createdCouponDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Set<Coupon> couponSet = new HashSet<>();
        couponSet.add(couponService.mapDtoToObject(createdCouponDto.getBody()));

        updatedMerchant.getBody().setCoupons(couponSet);
        ResponseEntity<MerchantDto> merchantDtoWithCoupon = merchantController.updateMerchant(updatedMerchant.getBody());
        for (Coupon coupon: merchantDtoWithCoupon.getBody().getCoupons() ) {
            assertThat(coupon.getCouponCode()).isEqualTo(couponDto.getCouponCode());
        }



        merchantController.deleteMerchant(updatedMerchant.getBody().getId());




    }
}
