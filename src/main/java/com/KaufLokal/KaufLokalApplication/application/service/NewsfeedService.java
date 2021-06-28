package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.NewsfeedDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import com.KaufLokal.KaufLokalApplication.domain.model.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.Newsfeed;
import com.KaufLokal.KaufLokalApplication.domain.repository.NewsfeedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NewsfeedService implements IDefaultService<Newsfeed, NewsfeedDto>{

    @Autowired
    NewsfeedRepository newsfeedRepository;

    @Autowired
    EventService eventService;

    @Override
    public List<NewsfeedDto> findAll() {
        newsfeedRepository.findAll();
        return mapToDto(newsfeedRepository.findAll());
    }

    @Override
    public NewsfeedDto findById(UUID id) {
        Optional<Newsfeed> newsfeedOptional = newsfeedRepository.findById(id);
        if (newsfeedOptional.isPresent())
        {
            return mapToDto(newsfeedOptional.get());
        }
        return null;
    }

    @Override
    public NewsfeedDto create(NewsfeedDto newsfeedDto) {
        NewsfeedDto newsfeedDto1 = mapToDto(newsfeedRepository.save(mapDtoToObject(newsfeedDto)));
        Event event = new Event();
        event.setEventTypes(EventTypes.Copon);
        event.setCreated(new Date());
        eventService.create(eventService.mapToDto(event));
        return newsfeedDto1;
    }

    @Override
    public NewsfeedDto update(NewsfeedDto newsfeedDto) {
        Optional<Newsfeed> newsfeedOptional = newsfeedRepository.findById(newsfeedDto.getId());
        if (newsfeedOptional.isPresent())
        {
            Newsfeed newsfeed = newsfeedOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(newsfeedDto, newsfeed);
            newsfeedRepository.save(newsfeed);
            return mapToDto(newsfeed);
        }
        return newsfeedDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Newsfeed> newsfeedOptional = newsfeedRepository.findById(id);
        if (newsfeedOptional.isPresent()) {
            Newsfeed newsfeed = newsfeedOptional.get();
            newsfeedRepository.delete(newsfeed);
        }
    }

    @Override
    public List<NewsfeedDto> mapToDto(List<Newsfeed> newsfeeds) {
        List<NewsfeedDto> newsfeedDtos = new ArrayList<>();
        for (Newsfeed newsfeed: newsfeeds) {
            newsfeedDtos.add(mapToDto(newsfeed));
        }
        return newsfeedDtos;
    }

    @Override
    public NewsfeedDto mapToDto(Newsfeed newsfeed) {
        ModelMapper modelMapper = new ModelMapper();
        NewsfeedDto newsfeedDto = new NewsfeedDto();
        modelMapper.map(newsfeed,newsfeedDto);
        return newsfeedDto;
    }

    @Override
    public Newsfeed mapDtoToObject(NewsfeedDto newsfeedDto, Newsfeed newsfeed) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(newsfeedDto, newsfeed);
        return newsfeed;
    }

    @Override
    public Newsfeed mapDtoToObject(NewsfeedDto newsfeedDto) {
        return mapDtoToObject(newsfeedDto, new Newsfeed());
    }
}
