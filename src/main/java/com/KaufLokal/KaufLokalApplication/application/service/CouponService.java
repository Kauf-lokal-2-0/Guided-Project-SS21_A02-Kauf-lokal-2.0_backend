package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.MessageDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import com.KaufLokal.KaufLokalApplication.domain.model.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.repository.CouponRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouponService implements IDefaultService<Coupon, CouponDto>{

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventService eventService;

    @Override
    public List<CouponDto> findAll() {
        couponRepository.findAll();
        return mapToDto(couponRepository.findAll());
    }

    @Override
    public CouponDto findById(UUID id) {
        Optional<Coupon> couponOptional = couponRepository.findById(id);
        if (couponOptional.isPresent())
        {
            return mapToDto(couponOptional.get());
        }
        return null;
    }

    @Override
    public CouponDto create(CouponDto couponDto) {
        return mapToDto(couponRepository.save(mapDtoToObject(couponDto)));
    }

    @Override
    public CouponDto update(CouponDto couponDto) {
        Optional<Coupon> couponOptional = couponRepository.findById(couponDto.getId());
        if (couponOptional.isPresent())
        {
            Coupon product = couponOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(couponDto, product);
            couponRepository.save(product);
            return mapToDto(product);
        }
        return couponDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Coupon> couponOptional = couponRepository.findById(id);
        if (couponOptional.isPresent()) {
            Coupon coupon = couponOptional.get();
            couponRepository.delete(coupon);
        }
    }

    public List<CouponDto> mapToDto(List<Coupon> coupons) {
        List<CouponDto> couponDtos = new ArrayList<>();
        for (Coupon product: coupons) {
            couponDtos.add(mapToDto(product));
        }
        return couponDtos;
    }

    public CouponDto mapToDto(Coupon product){
        ModelMapper modelMapper = new ModelMapper();
        CouponDto couponDto = new CouponDto();
        modelMapper.map(product,couponDto);
        return couponDto;
    }

    public Coupon mapDtoToObject(CouponDto couponDto, Coupon coupon) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(couponDto, coupon);
        return coupon;
    }

    public Coupon mapDtoToObject(CouponDto couponDto) {
        return mapDtoToObject(couponDto, new Coupon());
    }
}
