package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.common.execptions.coupon.CouponIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.coupon.CouponNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.KaufLokal.KaufLokalApplication.domain.repository.CouponRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouponService implements IDefaultService<Coupon, CouponDto>{

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private VendorService vendorService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CouponDto> findAll() {
        return Optional.ofNullable(mapToDto(couponRepository.findAll()))
                .orElseThrow(() -> new CouponIsEmptyException("Coupons are empty"));
    }

    @Override
    public CouponDto findById(@NonNull UUID id) {
        return mapToDto(couponRepository.findById(id).orElseThrow(() -> new CouponNotFoundException("Coupon by id " + id.toString() + " was not found")));
    }

    @Override
    public CouponDto create(@NonNull CouponDto couponDto) {
        return mapToDto(couponRepository.save(mapDtoToObject(couponDto)));
    }

    @Override
    public CouponDto update(CouponDto couponDto) {
        var coupon = couponRepository.findById(couponDto.getId()).get();
        if (ObjectUtils.isNotNull(coupon)) {
            this.modelMapper.map(couponDto, coupon);
            couponRepository.save(coupon);
            return mapToDto(coupon);
        }
            throw new CouponNotFoundException("Coupon by id " + coupon.getId().toString() + " was not found");
    }

    @Override
    public void delete(@NonNull UUID id) {
        couponRepository.delete(couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException("Coupon by id " + id.toString() + " was not found") ));
    }

    public List<CouponDto> mapToDto(List<Coupon> coupons) {
        List<CouponDto> couponDtos = new ArrayList<>();
        coupons.forEach(coupon -> couponDtos.add(mapToDto(coupon)));
        return couponDtos;
    }

    public CouponDto mapToDto(Coupon coupon){
        var couponDto = new CouponDto();
        this.modelMapper.map(coupon,couponDto);
        vendorService.findAll().forEach(vendorDto -> vendorDto.getCoupons().forEach(couponToMap -> {
            if(couponToMap.getId().equals(coupon.getId())) {
                couponDto.setVendorId(vendorDto.getId());
            }
        }));
        return couponDto;
    }

    public Coupon mapDtoToObject(CouponDto couponDto, Coupon coupon) {
        this.modelMapper.map(couponDto, coupon);
        return coupon;
    }

    public Coupon mapDtoToObject(CouponDto couponDto) {
        return mapDtoToObject(couponDto, new Coupon());
    }
}
