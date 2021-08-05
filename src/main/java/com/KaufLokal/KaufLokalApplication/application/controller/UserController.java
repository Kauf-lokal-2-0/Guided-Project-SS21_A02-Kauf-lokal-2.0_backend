package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VendorDto;
import com.KaufLokal.KaufLokalApplication.application.service.UserService;
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
@Api(value = "User Controller")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "Find all Users")
    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        logger.debug("GET: getAllUsers");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "get dummy user")
    @GetMapping("/user/dummy")
    public ResponseEntity<UserDto> getDummyUser() {
        logger.debug("GET: getDummyUser");
        return new ResponseEntity<>(userService.getDummyUser(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get user by ID")
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        logger.debug("GET: User by ID");
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new user")
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        logger.debug("POST: User");
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an User")
    @PutMapping("/user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        logger.debug("PUT: User");
        return new ResponseEntity<>(userService.update(userDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Add Coupon as Favorite")
    @PostMapping("/user/{id}/coupon")
    public ResponseEntity<UserDto> addCouponAsFavorites(@PathVariable UUID id, @RequestBody CouponDto couponDto) {
        logger.debug("POST: Add Coupon as Favorite");
        return new ResponseEntity<>(userService.addCouponAsFavorites(id,couponDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Add Coupon as Favorite")
    @PostMapping("/user/{id}/vendor")
    public ResponseEntity<UserDto> addVendorAsFavorites(@PathVariable UUID id, @RequestBody VendorDto vendorDto) {
        logger.debug("POST: Add Coupon as Favorite");
        return new ResponseEntity<>(userService.addVendorAsFavorites(id,vendorDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete an User")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(UUID id){
        logger.debug("DELETE: User");
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
