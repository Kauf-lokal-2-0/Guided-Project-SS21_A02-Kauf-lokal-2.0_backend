package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.OfferDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Offer;
import com.KaufLokal.KaufLokalApplication.domain.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferService implements IDefaultService<Offer, OfferDto>{
    
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<OfferDto> findAll() {
        offerRepository.findAll();
        return mapToDto(offerRepository.findAll());
    }

    @Override
    public OfferDto findById(UUID id) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        if (offerOptional.isPresent())
        {
            return mapToDto(offerOptional.get());
        }
        return null;
    }

    @Override
    public OfferDto create(OfferDto offerDto) {
        return mapToDto(offerRepository.save(mapDtoToObject(offerDto)));
    }

    @Override
    public OfferDto update(OfferDto offerDto) {
        Optional<Offer> offerOptional = offerRepository.findById(offerDto.getId());
        if (offerOptional.isPresent())
        {
            Offer offer = offerOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(offerDto, offer);
            offerRepository.save(offer);
            return mapToDto(offer);
        }
        return offerDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        if (offerOptional.isPresent()) {
            Offer offer = offerOptional.get();
            offerRepository.delete(offer);
        }
    }

    public List<OfferDto> mapToDto(List<Offer> offers) {
        List<OfferDto> offerDtos = new ArrayList<>();
        for (Offer offer : offers) {
            offerDtos.add(mapToDto(offer));
        }
        return offerDtos;
    }

    public OfferDto mapToDto(Offer offer){
        ModelMapper modelMapper = new ModelMapper();
        OfferDto offerDto = new OfferDto();
        modelMapper.map(offer, offerDto);
        return offerDto;
    }

    public Offer mapDtoToObject(OfferDto offerDto, Offer offer) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(offerDto, offer);
        return offer;
    }

    public Offer mapDtoToObject(OfferDto offerDto) {
        return mapDtoToObject(offerDto, new Offer());
    }
}
