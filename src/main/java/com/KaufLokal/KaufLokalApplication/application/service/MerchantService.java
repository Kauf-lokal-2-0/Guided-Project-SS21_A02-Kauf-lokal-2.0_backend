package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.MerchantCategory;
import com.KaufLokal.KaufLokalApplication.domain.repository.MerchantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MerchantService implements IDefaultService<Merchant,MerchantDto> {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    CouponService couponService;

    @Autowired
    EventService eventService;

    @Autowired
    MessageService messageService;

    public List<MerchantDto> findAll() {
        merchantRepository.findAll();
        return mapToDto(merchantRepository.findAll());
    }

    public MerchantDto findById(UUID id)  {
        Optional<Merchant> merchantOptional = merchantRepository.findById(id);
        if (merchantOptional.isPresent())
        {
            return mapToDto(merchantOptional.get());
        }
        return null;
    }

    public MerchantDto create(MerchantDto merchantDto) {

        return mapToDto(merchantRepository.save(mapDtoToObject(merchantDto)));
    }

    public MerchantDto update(MerchantDto merchantDto) {

        Optional<Merchant> merchantOptional = merchantRepository.findById(merchantDto.getId());
        if (merchantOptional.isPresent())
        {
            Merchant merchant = merchantOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(merchantDto, merchant);
            merchantRepository.save(merchant);
            return mapToDto(merchant);
        }
        return merchantDto;
    }

    public void delete(UUID id) {
        Optional<Merchant> merchantOptional = merchantRepository.findById(id);
        if (merchantOptional.isPresent()) {
            Merchant merchant = merchantOptional.get();
            merchantRepository.delete(merchant);
        }
    }

    public MerchantDto addCoupon(UUID merchantId, CouponDto couponDto)
    {
        Optional<Merchant> merchantOptional = merchantRepository.findById(merchantId);
        if (merchantOptional.isPresent())
        {


            merchantOptional.get().getCoupons().add(couponService.mapDtoToObject(couponService.create(couponDto)));
            merchantRepository.save(merchantOptional.get());

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


    public MerchantDto addMessage(UUID merchantId, MessageDto messageDto)
    {
        Optional<Merchant> merchantOptional = merchantRepository.findById(merchantId);
        if (merchantOptional.isPresent())
        {
            merchantOptional.get().getMessages().add(messageService.mapDtoToObject(messageService.create(messageDto)));
            merchantRepository.save(merchantOptional.get());

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

    public List<MerchantDto> mapToDto(List<Merchant> merchants) {
        List<MerchantDto> merchantDtos = new ArrayList<>();
        for (Merchant merchant: merchants) {
            merchantDtos.add(mapToDto(merchant));
        }
        return merchantDtos;
    }

    public MerchantDto mapToDto(Merchant merchant){
        ModelMapper modelMapper = new ModelMapper();
        MerchantDto merchantDto = new MerchantDto();
        modelMapper.map(merchant,merchantDto);
        return merchantDto;
    }

    public Merchant mapDtoToObject(MerchantDto merchantDto, Merchant merchant) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(merchantDto, merchant);
        return merchant;
    }

    public Merchant mapDtoToObject(MerchantDto merchantDto) {
        return mapDtoToObject(merchantDto, new Merchant());
    }

    public List<MerchantCategoryDto> getCategories()
    {
        List<MerchantCategoryDto> merchantCategoriesDto = new ArrayList<>();
        for (MerchantCategory merchantCategory : MerchantCategory.values()) {
            MerchantCategoryDto merchantCategoryDto = new MerchantCategoryDto();
            merchantCategoryDto.setMerchantCategory(merchantCategory);
            merchantCategoriesDto.add(merchantCategoryDto);
        }
        return merchantCategoriesDto;
    }
}
