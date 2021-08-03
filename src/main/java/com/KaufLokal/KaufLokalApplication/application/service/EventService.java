package com.KaufLokal.KaufLokalApplication.application.service;
import com.KaufLokal.KaufLokalApplication.application.dto.EventDto;
import com.KaufLokal.KaufLokalApplication.application.dto.EventTypesDto;
import com.KaufLokal.KaufLokalApplication.common.execptions.event.EventIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.event.EventNotFoundByVendorException;
import com.KaufLokal.KaufLokalApplication.common.execptions.event.EventNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.repository.EventRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.VendorRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService implements IDefaultService<Event, EventDto>{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    VendorRepository vendorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<EventDto> findAll() {
        return Optional.ofNullable(mapToDto(eventRepository.findAll()))
                .orElseThrow(() -> new EventIsEmptyException("Events are empty"));
    }

    public EventDto findById(@NonNull UUID id)  {
        return mapToDto(eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event by id " + id.toString() + " was not found")));
    }

    public List<EventDto> findAllEventsByVendor(UUID id) {
        var vendor = vendorRepository.findById(id).get();
        if(ObjectUtils.isNotNull(vendor)) {
            return mapToDto(new ArrayList<>(vendor.getEvents()));
        }
        else
            throw new EventNotFoundByVendorException("Event by Vendor id " + id.toString() + " was not found");
    }

    public EventDto create(@NonNull EventDto eventDto) {
        return mapToDto(eventRepository.save(mapDtoToObject(eventDto)));
    }

    public EventDto update(EventDto eventDto) {
        var event = eventRepository.findById(eventDto.getId()).get();
        if (ObjectUtils.isNotNull(event)) {
            this.modelMapper.map(eventDto, event);
            eventRepository.save(event);
            return mapToDto(event);
        }
        else
            throw new EventNotFoundException("Event by id " + event.getId().toString() + " was not found");
    }

    public void delete(@NonNull UUID id) {
        eventRepository.delete(eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event by id " + id.toString() + " was not found")));
    }

    public List<EventDto> mapToDto(@NonNull List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();
        events.forEach(event -> eventDtos.add(mapToDto(event)));
        return eventDtos;
    }

    public EventDto mapToDto(@NonNull Event event){
        var eventDto = new EventDto();
        this.modelMapper.map(event,eventDto);
        return eventDto;
    }

    public Event mapDtoToObject(@NonNull EventDto eventDto, @NonNull Event event) {
        this.modelMapper.map(eventDto, event);
        return event;
    }

    public Event mapDtoToObject(@NonNull EventDto eventDto) {
        return mapDtoToObject(eventDto, new Event());
    }

    public List<EventTypesDto> getEventTypes() {
        List<EventTypesDto> eventTypesDtos = new ArrayList<>();
        Arrays.stream(EventTypes.values()).forEach(eventType -> {
            EventTypesDto eventTypesDto = new EventTypesDto();
            eventTypesDto.setEventTypes(eventType);
            eventTypesDtos.add(eventTypesDto);
        });
        return eventTypesDtos;
    }
}
