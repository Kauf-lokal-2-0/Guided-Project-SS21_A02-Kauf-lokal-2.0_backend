package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.NewsfeedDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Newsfeed;
import com.KaufLokal.KaufLokalApplication.domain.repository.NewsFeedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NewsfeedService implements IDefaultService<Newsfeed, NewsfeedDto>{
    
    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @Override
    public List<NewsfeedDto> findAll() {
        newsFeedRepository.findAll();
        return mapToDto(newsFeedRepository.findAll());
    }

    @Override
    public NewsfeedDto findById(UUID id) throws Exception {
        Optional<Newsfeed> newsfeedOptional = newsFeedRepository.findById(id);
        if (newsfeedOptional.isPresent())
        {
            return mapToDto(newsfeedOptional.get());
        }
        return null;
    }

    @Override
    public NewsfeedDto create(NewsfeedDto newsfeedDto) {
        return mapToDto(newsFeedRepository.save(mapDtoToObject(newsfeedDto)));
    }

    @Override
    public NewsfeedDto update(NewsfeedDto newsfeedDto) {
        Optional<Newsfeed> newsfeedOptional = newsFeedRepository.findById(newsfeedDto.getId());
        if (newsfeedOptional.isPresent())
        {
            Newsfeed newsfeed = newsfeedOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(newsfeedDto, newsfeed);
            newsFeedRepository.save(newsfeed);
            return mapToDto(newsfeed);
        }
        return newsfeedDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Newsfeed> newsfeedOptional = newsFeedRepository.findById(id);
        if (newsfeedOptional.isPresent()) {
            Newsfeed newsfeed = newsfeedOptional.get();
            newsFeedRepository.delete(newsfeed);
        }
    }

    public List<NewsfeedDto> mapToDto(List<Newsfeed> newsfeeds) {
        List<NewsfeedDto> newsfeedDtos = new ArrayList<>();
        for (Newsfeed newsfeed: newsfeeds) {
            newsfeedDtos.add(mapToDto(newsfeed));
        }
        return newsfeedDtos;
    }

    public NewsfeedDto mapToDto(Newsfeed newsfeed){
        ModelMapper modelMapper = new ModelMapper();
        NewsfeedDto newsfeedDto = new NewsfeedDto();
        modelMapper.map(newsfeed,newsfeedDto);
        return newsfeedDto;
    }

    public Newsfeed mapDtoToObject(NewsfeedDto newsfeedDto, Newsfeed newsfeed) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(newsfeedDto, newsfeed);
        return newsfeed;
    }

    public Newsfeed mapDtoToObject(NewsfeedDto newsfeedDto) {
        return mapDtoToObject(newsfeedDto, new Newsfeed());
    }
}
