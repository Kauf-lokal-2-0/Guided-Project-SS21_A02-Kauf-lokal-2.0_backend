package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VendorDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.KaufLokal.KaufLokalApplication.domain.model.Experience;
import com.KaufLokal.KaufLokalApplication.domain.model.User;
import com.KaufLokal.KaufLokalApplication.domain.model.Vendor;
import com.KaufLokal.KaufLokalApplication.domain.repository.ExperienceRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IDefaultService<User, UserDto>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CouponService couponService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<UserDto> findAll() {
        return mapToDto(userRepository.findAll());
    }

    @Override
    public UserDto findById(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
        {
            return mapToDto(userOptional.get());
        }
        return null;
    }

    @Override
    public UserDto create(UserDto dto) {
        return mapToDto(userRepository.save(mapDtoToObject(dto)));
    }

    @Override
    public UserDto update(UserDto dto) {
        Optional<User> userOptional = userRepository.findById(dto.getId());
        if (userOptional.isPresent())
        {
            User user = userOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(dto, user);
            userRepository.save(user);
            return mapToDto(user);
        }
        return dto;
    }

    public UserDto addCouponAsFavorites(UUID id, CouponDto couponDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
        {
            CouponDto couponDto1 = couponService.findById(couponDto.getId());
            userOptional.get().getFavoriteCoupons().add(couponService.mapDtoToObject(couponDto1));

            return update(mapToDto(userOptional.get()));
        }
        else
        {
            return null;
        }
    }

    public UserDto addVendorAsFavorites(UUID id, VendorDto vendorDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
        {
            VendorDto vendorDto1 = vendorService.findById(vendorDto.getId());
            userOptional.get().getFavoriteVendors().add(vendorService.mapDtoToObject(vendorDto1));
            return update(mapToDto(userOptional.get()));
        }
        else
        {
            return null;
        }
    }

    public User mapDtoToObject(UserDto userDto) {
        return mapDtoToObject(userDto, new User());
    }

    @Override
    public void delete(UUID id) {

    }

    public List<UserDto> mapToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users) {
            userDtos.add(mapToDto(user));
        }
        return userDtos;
    }

    public UserDto mapToDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = new UserDto();
        modelMapper.map(user,userDto);

        for (Vendor vendor: user.getFavoriteVendors()) {
            userDto.getFavoriteVendorsIDs().add(vendor.getId());
        }

        for (Coupon coupon: user.getFavoriteCoupons()) {
            userDto.getFavoriteCouponIDs().add(coupon.getId());
        }

        userDto.setExperiences(experienceRepository.findAllExperienceByUser(user));
        return userDto;
    }

    public User mapDtoToObject(UserDto userDto, User user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        return user;
    }

    public UserDto getDummyUser() {
        return mapToDto(userRepository.findByFirstName("DummyUser"));
    }

}
