package com.KaufLokal.KaufLokalApplication.application.services;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;
import com.KaufLokal.KaufLokalApplication.domain.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    public List<MerchantDto> getAllMerchant() {
        merchantRepository.findAll();
        return mapToDto(merchantRepository.findAll());
    }

    public MerchantDto createMerchant(MerchantDto merchantDto)
    {
        return mapToDto(merchantRepository.save(mapToObject(merchantDto)));
    }

    private Merchant mapToObject(MerchantDto merchantDto)
    {
        Merchant merchant = new Merchant();
        merchant.setName(merchantDto.getName());
        return merchant;
    }

    private List<MerchantDto> mapToDto(List<Merchant> merchants)
    {
        List<MerchantDto> merchantDtos = new ArrayList<>();
        for (Merchant merchant: merchants) {
            merchantDtos.add(mapToDto(merchant));
        }
        return merchantDtos;
    }

    private MerchantDto mapToDto(Merchant merchant){
        MerchantDto merchantDto = new MerchantDto();
        merchantDto.setId(merchant.getId());
        merchantDto.setName(merchant.getName());
        return merchantDto;
    }


}
