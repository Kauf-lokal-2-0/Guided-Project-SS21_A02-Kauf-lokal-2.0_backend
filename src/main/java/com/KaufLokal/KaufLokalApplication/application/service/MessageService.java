package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.MessageDto;
import com.KaufLokal.KaufLokalApplication.common.execptions.message.MessageIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.message.MessageNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
import com.KaufLokal.KaufLokalApplication.domain.model.Vendor;
import com.KaufLokal.KaufLokalApplication.domain.model.Message;
import com.KaufLokal.KaufLokalApplication.domain.repository.MessageRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.VendorRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService implements IDefaultService<Message, MessageDto>{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private VendorRepository vendorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<MessageDto> findAll() {
        return Optional.ofNullable(mapToDto(messageRepository.findAll()))
                .orElseThrow(() -> new MessageIsEmptyException("Messages are empty"));
    }

    @Override
    public MessageDto findById(@NonNull UUID id) {
        return mapToDto(messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message by id "+ id.toString() + " was not found")));
    }

    @Override
    public MessageDto create(@NonNull MessageDto messageDto) {
        return mapToDto(messageRepository.save(mapDtoToObject(messageDto)));
    }

    @Override
    public MessageDto update(MessageDto messageDto) {
        var messageToUpdate = messageRepository.findById(messageDto.getId()).get();
        if (ObjectUtils.isNotNull(messageToUpdate)) {
            Message message = messageToUpdate;
            this.modelMapper.map(messageDto, message);
            messageRepository.save(message);
            return mapToDto(message);
        }
        return messageDto;
    }

    @Override
    public void delete(@NonNull UUID id) {
        messageRepository.delete(messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message by id "+ id.toString() + " was not found")));
    }

    @Override
    public List<MessageDto> mapToDto(@NonNull List<Message> messages) {
        List<MessageDto> messageDtos = new ArrayList<>();
        messages.forEach(message -> messageDtos.add(mapToDto(message)));
        return messageDtos;
    }

    @Override
    public MessageDto mapToDto(@NonNull Message message) {
        var messageDto = new MessageDto();
        this.modelMapper.map(message, messageDto);
        var vendor = vendorRepository.findVendorsByMessages(message);
        messageDto.setVendorId(vendor.getId());
        return messageDto;
    }

    @Override
    public Message mapDtoToObject(@NonNull MessageDto messageDto, @NonNull Message message) {
        this.modelMapper.map(messageDto, message);
        return message;
    }

    @Override
    public Message mapDtoToObject(@NonNull MessageDto messageDto) {
        return mapDtoToObject(messageDto, new Message());
    }
}
