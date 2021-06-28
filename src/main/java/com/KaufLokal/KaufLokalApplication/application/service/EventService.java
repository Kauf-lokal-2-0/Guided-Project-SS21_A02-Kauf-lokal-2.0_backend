package com.KaufLokal.KaufLokalApplication.application.service;
import com.KaufLokal.KaufLokalApplication.application.dto.EventDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import com.KaufLokal.KaufLokalApplication.domain.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService implements IDefaultService<Event, EventDto>{

    @Autowired
    EventRepository eventRepository;

    public List<EventDto> findAll() {
        eventRepository.findAll();
        return mapToDto(eventRepository.findAll());
    }

    public EventDto findById(UUID id)  {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent())
        {
            return mapToDto(eventOptional.get());
        }
        return null;
    }



    public EventDto create(EventDto eventDto) {

        return mapToDto(eventRepository.save(mapDtoToObject(eventDto)));
    }

    public EventDto update(EventDto eventDto) {

        Optional<Event> eventOptional = eventRepository.findById(eventDto.getId());
        if (eventOptional.isPresent())
        {
            Event event = eventOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(eventDto, event);
            eventRepository.save(event);
            return mapToDto(event);
        }
        return eventDto;
    }

    public void delete(UUID id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            eventRepository.delete(event);
        }
    }

    public List<EventDto> mapToDto(List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event: events) {
            eventDtos.add(mapToDto(event));
        }
        return eventDtos;
    }

    public EventDto mapToDto(Event event){
        ModelMapper modelMapper = new ModelMapper();
        EventDto eventDto = new EventDto();
        modelMapper.map(event,eventDto);
        return eventDto;
    }

    public Event mapDtoToObject(EventDto eventDto, Event event) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(eventDto, event);
        return event;
    }

    public Event mapDtoToObject(EventDto eventDto) {
        return mapDtoToObject(eventDto, new Event());
    }
}
