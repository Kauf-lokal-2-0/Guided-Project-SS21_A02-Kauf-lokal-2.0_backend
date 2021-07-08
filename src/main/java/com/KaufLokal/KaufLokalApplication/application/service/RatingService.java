package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.RatingDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Product;
import com.KaufLokal.KaufLokalApplication.domain.model.Rating;
import com.KaufLokal.KaufLokalApplication.domain.repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingService implements IDefaultService<Rating, RatingDto> {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<RatingDto> findAll() {
        ratingRepository.findAll();
        return mapToDto(ratingRepository.findAll());
    }

    @Override
    public RatingDto findById(UUID id)  {
        Optional<Rating> ratingOptional = ratingRepository.findById(id);
        if (ratingOptional.isPresent())
        {
            return mapToDto(ratingOptional.get());
        }
        return null;
    }

    @Override
    public RatingDto create(RatingDto dto) {
        return mapToDto(ratingRepository.save(mapDtoToObject(dto)));
    }

    @Override
    public RatingDto update(RatingDto dto) {
        Optional<Rating> optionalRating = ratingRepository.findById(dto.getId());
        if (optionalRating.isPresent())
        {
            Rating rating = optionalRating.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(dto, rating);
            ratingRepository.save(rating);
            return mapToDto(rating);
        }
        return dto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating rating = optionalRating.get();
            ratingRepository.delete(rating);
        }
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

    /**
     * @return die maximale Anzahl an Rating Objekte
     */
    public Integer getRatingCount(){
        return this.findAll().size();
    }

    /**
     *
     * @param dto Das
     * @return
     */
    public Float getArithmeticMeanRating(RatingDto dto){
        return getRatingCount() / this.getMaxRatingScore();
    }

    private float getMaxRatingScore(){
       List<RatingDto> ratings = this.findAll();
       float sum = 0f;
        for (RatingDto ratingDto : ratings) {
            sum = ratingDto.getRatingScore();
        }
        return sum;
    }






}
