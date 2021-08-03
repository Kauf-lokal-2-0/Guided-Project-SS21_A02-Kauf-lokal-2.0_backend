package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.RatingDto;
import com.KaufLokal.KaufLokalApplication.common.execptions.rating.RatingIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.rating.RatingNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
import com.KaufLokal.KaufLokalApplication.domain.model.Rating;
import com.KaufLokal.KaufLokalApplication.domain.repository.RatingRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingService implements IDefaultService<Rating, RatingDto> {

    @Autowired
    private RatingRepository ratingRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<RatingDto> findAll() {
      return Optional.ofNullable(mapToDto(ratingRepository.findAll()))
               .orElseThrow(() -> new RatingIsEmptyException("Ratings is empty"));
    }

    @Override
    public RatingDto findById(@NonNull UUID id)  {
        return mapToDto(ratingRepository.findById(id).orElseThrow(() -> new RatingNotFoundException("Rating by id " + id.toString()+ " was not found")));
    }

    @Override
    public RatingDto create(@NonNull RatingDto dto) {
        return mapToDto(ratingRepository.save(mapDtoToObject(dto)));
    }

    @Override
    public RatingDto update(RatingDto dto) {
        var rating = ratingRepository.findById(dto.getId()).get();
        if (ObjectUtils.isNotNull(rating)) {
            this.modelMapper.map(dto, rating);
            ratingRepository.save(rating);
            return mapToDto(rating);
        }
        throw new RatingNotFoundException("Rating by Id" + rating.getId().toString() + " was not found");
    }

    @Override
    public void delete(@NonNull UUID id) {
        ratingRepository.delete(ratingRepository.findById(id)
                .orElseThrow(() -> new RatingNotFoundException("Rating by id " + id.toString() + " was not found")));
    }

    @Override
    public List<RatingDto> mapToDto(@NonNull List<Rating> ratings) {
        List<RatingDto> ratingDtos = new ArrayList<>();
        ratings.forEach(rating -> ratingDtos.add(mapToDto(rating)));
        return ratingDtos;
    }

    @Override
    public RatingDto mapToDto(@NonNull Rating rating){
        RatingDto ratingDto = new RatingDto();
        this.modelMapper.map(rating,ratingDto);
        return ratingDto;
    }

    @Override
    public Rating mapDtoToObject(@NonNull RatingDto ratingDto, @NonNull Rating rating) {
        this.modelMapper.map(ratingDto, rating);
        return rating;
    }

    @Override
    public Rating mapDtoToObject(@NonNull RatingDto ratingDto) {
        return mapDtoToObject(ratingDto, new Rating());
    }


}






