package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.EventDto;
import com.KaufLokal.KaufLokalApplication.application.dto.RatingDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import com.KaufLokal.KaufLokalApplication.domain.model.Rating;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class RatingService implements IDefaultService<Rating, RatingDto> {

    @Override
    public List<RatingDto> findAll() {
        return null;
    }

    @Override
    public RatingDto findById(UUID id) {
        return null;
    }

    @Override
    public RatingDto create(RatingDto dto) {
        return null;
    }

    @Override
    public RatingDto update(RatingDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<RatingDto> mapToDto(List<Rating> ratings) {
        List<RatingDto> ratingDtos = new ArrayList<>();
        for (Rating rating: ratings) {
            ratingDtos.add(mapToDto(rating));
        }
        return ratingDtos;
    }

    @Override
    public RatingDto mapToDto(Rating rating){
        ModelMapper modelMapper = new ModelMapper();
        RatingDto ratingDto = new RatingDto();
        modelMapper.map(rating,ratingDto);
        return ratingDto;
    }

    @Override
    public Rating mapDtoToObject(RatingDto ratingDto, Rating rating) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(ratingDto, rating);
        return rating;
    }

    @Override
    public Rating mapDtoToObject(RatingDto ratingDto) {
        return mapDtoToObject(ratingDto, new Rating());
    }


}
