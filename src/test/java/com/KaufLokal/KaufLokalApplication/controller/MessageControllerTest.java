package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.CouponController;
import com.KaufLokal.KaufLokalApplication.application.controller.MessageController;
import com.KaufLokal.KaufLokalApplication.application.dto.MessageDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageControllerTest {

    @Autowired
    MessageController messageController;

    @Test
    void testController() {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage("Message1");

        ResponseEntity<MessageDto> createdMessageDto = messageController.createMessage(messageDto);
        assertThat(createdMessageDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        MessageDto updateVendor = createdMessageDto.getBody();
        updateVendor.setMessage("Message2");
        ResponseEntity<MessageDto> updatedVendor = messageController.updateMessage(updateVendor);

        assertThat(updatedVendor.getBody().getMessage()).isEqualTo(updateVendor.getMessage());

        messageController.deleteMessage(updatedVendor.getBody().getId());

    }
}
