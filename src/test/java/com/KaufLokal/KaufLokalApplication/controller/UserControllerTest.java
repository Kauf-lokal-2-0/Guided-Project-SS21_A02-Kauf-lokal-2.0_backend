package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.UserController;
import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.domain.model.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    private Address address = new Address("Straße","HausNr","Ort", "PLZ","Land");

    private Set<Rating> ratings = new HashSet<>();
    private Set<Vendor> vendors = new HashSet<>();
    private Set<Coupon> coupons = new HashSet<>();
    private Set<Product> products = new HashSet<>();
    private Set<Message> messages = new HashSet<>();
    private Set<Event> events = new HashSet<>();
    private Set<String> detailImages = new HashSet<>();



    @Test
    void testController(){
        UserDto userDto = new UserDto();
        userDto.setFirstName("Name");
        userDto.setLastName("Nachname");
        userDto.setEmail("eineMail@Test.de");
        userDto.setUserScore(1);
        userDto.setProfilePicture("EINLINK");
        userDto.setAddress(address);
        ratings.add(new Rating(5.0));
        userDto.setRatings(ratings);
        vendors.add(new Vendor("EIN NAME", 1 , address, "EIN LINK", "EINE MAIL", new OpeningTime(), "EINE URL", "EINE FARBE", VendorCategory.RESTAURANT, coupons, ratings, products, messages, events,detailImages));
        //userDto.setFavoriteVendors(vendors);

        ResponseEntity<UserDto> createUserDto = userController.createUser(userDto);
        assertThat(createUserDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        UserDto updateUser = createUserDto.getBody();
        updateUser.setUserScore(1);
        ResponseEntity<UserDto> updatedUser = userController.updateUser(updateUser);

        assertThat(updatedUser.getBody().getUserScore()).isEqualTo(updateUser.getUserScore());

        userController.deleteUser(updatedUser.getBody().getId());
    }
}
