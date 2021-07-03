package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.MessageDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import com.KaufLokal.KaufLokalApplication.domain.model.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.Message;
import com.KaufLokal.KaufLokalApplication.domain.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService implements IDefaultService<Message, MessageDto>{

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    EventService eventService;

    @Override
    public List<MessageDto> findAll() {
        messageRepository.findAll();
        return mapToDto(messageRepository.findAll());
    }

    @Override
    public MessageDto findById(UUID id) {
        Optional<Message> newsfeedOptional = messageRepository.findById(id);
        if (newsfeedOptional.isPresent())
        {
            return mapToDto(newsfeedOptional.get());
        }
        return null;
    }

    @Override
    public MessageDto create(MessageDto messageDto) {
        MessageDto messageDto1 = mapToDto(messageRepository.save(mapDtoToObject(messageDto)));
        Event event = new Event();
        event.setEventTypes(EventTypes.Copon);
        event.setCreated(new Date());
        eventService.create(eventService.mapToDto(event));
        return messageDto1;
    }

    @Override
    public MessageDto update(MessageDto messageDto) {
        Optional<Message> newsfeedOptional = messageRepository.findById(messageDto.getId());
        if (newsfeedOptional.isPresent())
        {
            Message message = newsfeedOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(messageDto, message);
            messageRepository.save(message);
            return mapToDto(message);
        }
        return messageDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Message> newsfeedOptional = messageRepository.findById(id);
        if (newsfeedOptional.isPresent()) {
            Message message = newsfeedOptional.get();
            messageRepository.delete(message);
        }
    }

    @Override
    public List<MessageDto> mapToDto(List<Message> messages) {
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message message : messages) {
            messageDtos.add(mapToDto(message));
        }
        return messageDtos;
    }

    @Override
    public MessageDto mapToDto(Message message) {
        ModelMapper modelMapper = new ModelMapper();
        MessageDto messageDto = new MessageDto();
        modelMapper.map(message, messageDto);
        return messageDto;
    }

    @Override
    public Message mapDtoToObject(MessageDto messageDto, Message message) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(messageDto, message);
        return message;
    }

    @Override
    public Message mapDtoToObject(MessageDto messageDto) {
        return mapDtoToObject(messageDto, new Message());
    }
}
