package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;
import com.KaufLokal.KaufLokalApplication.domain.repository.MerchantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class MerchantService implements IDefaultService<Merchant,MerchantDto> {

    @Autowired
    MerchantRepository merchantRepository;

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

}
