package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.Vendor;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import com.KaufLokal.KaufLokalApplication.domain.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VendorService implements IDefaultService<Vendor, VendorDto> {

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    CouponService couponService;

    @Autowired
    EventService eventService;

    @Autowired
    MessageService messageService;

    public List<VendorDto> findAll() {
        vendorRepository.findAll();
        return mapToDto(vendorRepository.findAll());
    }

    public VendorDto findById(UUID id)  {
        Optional<Vendor> merchantOptional = vendorRepository.findById(id);
        if (merchantOptional.isPresent())
        {
            return mapToDto(merchantOptional.get());
        }
        return null;
    }

    public VendorDto create(VendorDto vendorDto) {

        return mapToDto(vendorRepository.save(mapDtoToObject(vendorDto)));
    }

    public VendorDto update(VendorDto vendorDto) {

        Optional<Vendor> merchantOptional = vendorRepository.findById(vendorDto.getId());
        if (merchantOptional.isPresent())
        {
            Vendor vendor = merchantOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(vendorDto, vendor);
            vendorRepository.save(vendor);
            return mapToDto(vendor);
        }
        return vendorDto;
    }

    public void delete(UUID id) {
        Optional<Vendor> merchantOptional = vendorRepository.findById(id);
        if (merchantOptional.isPresent()) {
            Vendor vendor = merchantOptional.get();
            vendorRepository.delete(vendor);
        }
    }

    public VendorDto addCoupon(UUID merchantId, CouponDto couponDto)
    {
        Optional<Vendor> merchantOptional = vendorRepository.findById(merchantId);
        if (merchantOptional.isPresent())
        {


            merchantOptional.get().getCoupons().add(couponService.mapDtoToObject(couponService.create(couponDto)));
            vendorRepository.save(merchantOptional.get());

            EventDto eventDto = new EventDto();
            eventDto.setEventTypes(EventTypes.COUPON);
            eventDto.setCreated(new Date());
            eventService.create(eventDto);

            return mapToDto(merchantOptional.get());
        }
        else
        {
            //TODO throw Exception.
            return null;
        }
    }


    public VendorDto addMessage(UUID merchantId, MessageDto messageDto)
    {
        Optional<Vendor> merchantOptional = vendorRepository.findById(merchantId);
        if (merchantOptional.isPresent())
        {
            merchantOptional.get().getMessages().add(messageService.mapDtoToObject(messageService.create(messageDto)));
            vendorRepository.save(merchantOptional.get());

            EventDto eventDto = new EventDto();
            eventDto.setEventTypes(EventTypes.MESSAGE);
            eventDto.setCreated(new Date());
            eventService.create(eventDto);

            return mapToDto(merchantOptional.get());
        }
        else
        {
            //TODO throw Exception.
            return null;
        }
    }

    public List<VendorDto> mapToDto(List<Vendor> vendors) {
        List<VendorDto> vendorDtos = new ArrayList<>();
        for (Vendor vendor : vendors) {
            vendorDtos.add(mapToDto(vendor));
        }
        return vendorDtos;
    }

    public VendorDto mapToDto(Vendor vendor){
        ModelMapper modelMapper = new ModelMapper();
        VendorDto vendorDto = new VendorDto();
        modelMapper.map(vendor, vendorDto);
        return vendorDto;
    }

    public Vendor mapDtoToObject(VendorDto vendorDto, Vendor vendor) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(vendorDto, vendor);
        return vendor;
    }

    public Vendor mapDtoToObject(VendorDto vendorDto) {
        return mapDtoToObject(vendorDto, new Vendor());
    }

    public List<VendorCategoryDto> getCategories()
    {
        List<VendorCategoryDto> merchantCategoriesDto = new ArrayList<>();
        for (VendorCategory vendorCategory : VendorCategory.values()) {
            VendorCategoryDto vendorCategoryDto = new VendorCategoryDto();
            vendorCategoryDto.setVendorCategory(vendorCategory);
            merchantCategoriesDto.add(vendorCategoryDto);
        }
        return merchantCategoriesDto;
    }
}
