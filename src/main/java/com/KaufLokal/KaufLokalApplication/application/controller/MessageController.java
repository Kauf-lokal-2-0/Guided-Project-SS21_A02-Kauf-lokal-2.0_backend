package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.MessageDto;
import com.KaufLokal.KaufLokalApplication.application.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Message Controller")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageService messageService;

    @ApiOperation(value = "Get all messages")
    @GetMapping("/message")
    public ResponseEntity<List<MessageDto>> getAllMessages() {
        logger.debug("GET: getAllMessages");
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get message by ID")
    @GetMapping("/message/{id}")
    public ResponseEntity<MessageDto> getMessageById(@PathVariable UUID id)  {
        logger.debug("GET: getMessageById");
        return new ResponseEntity<>(messageService.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto messageDto) {
        logger.debug("POST: createMessage");
        return new ResponseEntity<>(messageService.create(messageDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an message")
    @PutMapping("/message")
    public ResponseEntity<MessageDto> updateMessage(@RequestBody MessageDto messageDto) {
        logger.debug("PUT: updateMessage");
        return new ResponseEntity<>(messageService.update(messageDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an message")
    @DeleteMapping("/message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable UUID id) {
        logger.debug("DELETE: deleteMessage");
        messageService.delete(id);
        return ResponseEntity.ok().build();
    }
}
